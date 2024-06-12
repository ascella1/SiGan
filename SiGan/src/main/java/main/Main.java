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

import logic.EmailSender;
import model.EmailInfo;

public class Main {
		//데이터베이스에서 이메일 정보를 가져오는 메소드
		//가져온 후 List에 추가한 후 return 해줌
		public static List<EmailInfo> fetchEmailInfoFromDB() {
			List<EmailInfo> posts = new ArrayList<>();
			// DB 연결 정보
			String jdbcUrl = "jdbc:mysql://localhost:3306/siganDatabase?useSSL=false";
			String jdbcUser = "root";
			String jdbcPassword = "chlwogns321@";

			//DriverManager 가 아닌 DataSource 를 사용하여 커넥션 풀로 변경.
			try (java.sql.Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
					Statement stmt = conn.createStatement();
					//()안의 구문을 실행 한 후 rs 객체에 저장
					//user 구현 후 where=""절 추가해야할듯?
					ResultSet rs = stmt.executeQuery("SELECT postId, recipient, subject, text, targetTime FROM POSTTABLE")) {

				while (rs.next()) {
					int postId = rs.getInt("postId");
					String recipient = rs.getString("recipient");
					String subject = rs.getString("subject");
					String text = rs.getString("text");
					String targetTime = rs.getString("targetTime");
					posts.add(new EmailInfo(postId, recipient, subject, text, targetTime));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return posts;
		}
	
	
	
	public static void main(String[] args) {
		/*
		// 테스트를 위한 이메일 전송
		String email = "chlwogns0108@gmail.com";
		String subject = "시간 일치되어서 메일 전송";
		String text = "시간 테스트 이메일 ";

		// 테스트 시간
		String targetTime = "2024-05-28 12:21:30";
		*/
		
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
			//System.out.println(currentTime);
			
			//postList 가져오는 해쉬
			List<EmailInfo> emailInfos = fetchEmailInfoFromDB();
			
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