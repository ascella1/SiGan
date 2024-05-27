package main;

import logic.EmailSender;

public class Main {
	public static void main(String[] args) {
        // 테스트를 위한 이메일 전송
        String recipient = "chlwogns0108@gmail.com";
        String subject = "Test Subject";
        String text = "Hello, this is a test email!";
        
        EmailSender es = new EmailSender();
        
        es.sendEmail(recipient, subject, text);
    }
}
