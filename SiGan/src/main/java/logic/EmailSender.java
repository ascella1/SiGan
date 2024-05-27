
package logic;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
	public static void sendEmail(String recipient, String subject, String text) {
        // SMTP 서버 정보 설정
        String host = "smtp.gmail.com";
        String from = "chlwogns0108@gmail.com";
        final String username = "chlwogns0108@gmail.com";
        final String password = "ioqj hark yqsn opbd";

        // SMTP 서버 속성 설정
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // 인증을 포함한 세션 생성
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {
            // 이메일 메시지 작성
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(text);

            // 이메일 전송
            Transport.send(message);
            System.out.println("메일 전송이 완료되었습니다.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    
	
}
