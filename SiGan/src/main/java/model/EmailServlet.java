package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequestWrapper request, HttpServletResponse response) throws ServletException, IOException {
        String targetTime = request.getParameter("targetTime");
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String text = request.getParameter("text");

        // DB 연결 정보
        String jdbcUrl = "jdbc:mysql://localhost:3306/siganDatabase?useSSL=false";
        String jdbcUser = "root";
        String jdbcPassword = "chlwogns321@";
        
        try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
            String sql = "INSERT INTO POSTTABLE (recipient, subject, text, targetTime) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, recipient);
            stmt.setString(2, subject);
            stmt.setString(3, text);
            stmt.setString(4, targetTime);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 응답 페이지로 리디렉션
        response.sendRedirect("confirmation.html");  // 성공시 리디렉션할 페이지 설정
    }
}
