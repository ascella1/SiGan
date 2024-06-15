
package model;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	public static void sendEmail(int postId, String recipient, String subject, String text) {
        // SMTP 서버 정보 설정
        String host = "smtp.gmail.com";
        String from = "chlwogns0108@gmail.com";
        final String username = "chlwogns0108@gmail.com";
        final String password = "ioqj hark yqsn opbd";

        // SMTP 서버 속성 설정
        //Properties -> Hashtable을 상속받는 설정파일, 시스템 속성을 사용하는 클래스
        
        //현재 JVM의 속성을 가져온 후 properties 객체에 저장
        Properties properties = System.getProperties();
        
        //SMTP서버의 호스트 이름 설정
        properties.put("mail.smtp.host", host);
        //SMTP서버의 포트번호 설정
        properties.put("mail.smtp.port", "587");
        //서버 인증을 사용할것인지, true 라면 이메일을 보내기 위해 사용자 이름, 비밀번호 요구
        properties.put("mail.smtp.auth", "true");
        //STARTTLS 명령을 통해 SMTP 연결을 암호화
        properties.put("mail.smtp.starttls.enable", "true");

        
        // 인증을 포함한 세션 생성
        //JavaMail API 를 사용하여 인증을 포함한 세션을 생성하는 방법
        //주어진 속성과 인증정보를 사용하여 새로운 이메일 세션 생성
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        	//Authenticator 클래스에서 인증정보를 제공하기 위해 오버라이드된 메소드
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
            	//javax.mail.PasswordAuthentication 객체 생성 후 사용자이름과 패스워드 반환
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });


        try {
            // 이메일 메시지 작성
        	//MimeMessage 객체 생성 -> 이메일 메시지 표현
            MimeMessage message = new MimeMessage(session);
            //이메일 발신자 설정 InternetAddress 클래스 -> 이메일 주소 나타내기 위함
            message.setFrom(new InternetAddress(from));
            //수신자 주소 추가, Message.RecipientType.TO -> 수신자의 유형을 나타냄, TO는 주 수신자
            //addRecipient 메소드는 하나이상의 수신자를 추가 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(text);
            
            // 이메일 전송
            Transport.send(message);
            System.out.println("메일 전송이 완료되었습니다.");
            System.out.println();
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    
	
}
