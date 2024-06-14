package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class SiGanDAO {
	
	//DB연동시켜줄 JdbcTemplate 객체를 사용
	public JdbcTemplate jdbcTemplate;
	
	public SiGanDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<EmailInfo> selectAllEmails() {
		List<EmailInfo> posts = jdbcTemplate.
				query("SELECT * FROM POSTTABLE" ,
						(ResultSet rs, int rowNum) ->{
							EmailInfo emailInfo = new EmailInfo(
									rs.getString("recipient"),
									rs.getString("subject"),
									rs.getString("text"),
									rs.getString("targetTime"));
							emailInfo.setPostId(rs.getInt("postId"));
							return emailInfo;
						});
		return posts;
	}
	
	public void insertEmail(EmailInfo emailInfo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into POSTTABLE(recipient, subject, text, targetTime)" + 
				"values (?,?,?,?)",new String[] {"postId"});
				pstmt.setString(1, emailInfo.getRecipient());
				pstmt.setString(2, emailInfo.getSubject());
				pstmt.setString(3, emailInfo.getText());
				pstmt.setString(4, emailInfo.getTargetTime());
				return pstmt;
			}
		},keyHolder);
		Number keyValue = keyHolder.getKey();
		emailInfo.setPostId(keyValue.intValue());
	}
	
	/*
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
	}*/
}
