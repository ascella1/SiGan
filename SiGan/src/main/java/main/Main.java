package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import logic.EmailSender;

public class Main {
	public static void main(String[] args) {
        // 테스트를 위한 이메일 전송
        String recipient = "chlwogns0108@gmail.com";
        String subject = "시간 일치되어서 메일 전송";
        String text = "시간 테스트 이메일 ";
        
        //테스트 시간
        String targetTime = "2024-05-28 12:21:30";
        
        //EmailSender es = new EmailSender(); -> static 으로 했으므로 객체 생성 필요 없음
        //EmailSender.sendEmail(recipient, subject, text);
        
        
        //계속 현재 시간을 확인해야 하므로 while(1)
        while(true) {
        	//현재시간을 가져오는 메소드
        	String currentTime =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
        			format(new Date());
        	//현재시간의 문자열과 테스트시간의 문자열이 일치하는지 확인
        	System.out.println(currentTime);
        	if(currentTime.equals(targetTime)) {
        		System.out.println("시간 일치");
        		//시간 일치하므로 메일 전송
        		EmailSender.sendEmail(recipient, subject, text);
        	}
        	try {
        		//CPU 사용률을 낮추기 위한 .sleep
        		Thread.sleep(1000);
        	}catch(InterruptedException e){
        		e.printStackTrace();
        	}
        }
        
        
    }
}
