package main;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import container.ContainerContext;
import model.EmailInfo;
import model.EmailSender;
import model.SiGanDAO;

//로직 확인하기 위한 테스트 파일
public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContainerContext.class);
        SiGanDAO dao = context.getBean(SiGanDAO.class);
		
		//이메일 전송 여부 확인하기 위해 Boolean 으로 확인
		Map<String, Boolean> sentFlags = new HashMap<>();
		
		
		// EmailSender es = new EmailSender(); -> static 으로 했으므로 객체 생성 필요 없음
		// EmailSender.sendEmail(recipient, subject, text);
		// 계속 현재 시간을 확인해야 하므로 while(1)
		while (true) {
			// 현재시간을 가져오는 메소드
			//ss는 간단히 테스트를 위해 추가한 것으로 추후 삭제 
			//sql에서 targetTime의 형태를 yyyy-mm-dd hh:mm 으로 수정
			String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			System.out.println(currentTime);
			
			
			
			//postList 가져오는 해쉬
			//DAO 화 한 후 fectEmail~()이 아닌 DAO.fetchEmail~()로 수정할 거 ㅅ
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
				e.printStackTrace();
			}
			
			
		}

	}

	
}