package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import container.ContainerContext;

//백그라운드에서 이메일 가져온 후 보내는 작업
public class BackgroundTask implements Runnable {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContainerContext.class);
    SiGanDAO dao = context.getBean(SiGanDAO.class);
	
	Map<String, Boolean> sentFlags = new HashMap<>();
	
    @Override
    public void run() {
        while (true) {
        	String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			System.out.println(currentTime);
			
			//postList 가져오는 해쉬
			List<EmailInfo> emailInfos = dao.selectAllEmails();
			
			for(EmailInfo emailInfo : emailInfos) {
				String key = emailInfo.getRecipient() + emailInfo.getTargetTime();
				//sentFlags가 키를 가지고 있지 않고(Boolean이면 키를가지지 않는듯.)
				//현재 시간이 타겟타임과 일치할때 전송
				if(!sentFlags.containsKey(key) && currentTime.equals(emailInfo.getTargetTime())) {
					System.out.println("시간 일치하므로 이메일 전송.");
					System.out.println("Recipient : "+ emailInfo.getRecipient() + " targetTime : " + emailInfo.getTargetTime());
					EmailSender.sendEmail(emailInfo.getPostId(), emailInfo.getRecipient(), emailInfo.getSubject(), emailInfo.getText());
					//전송 후 중복전송을 방지하기 위해 Boolean 을 true 로 변경
					sentFlags.put(key, true);
				}
			}
        	
        	
            try {
            	// CPU 사용률을 낮추기 위한 .sleep
				Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("백그라운드 작업 중지..");
            }
        }
    }
}