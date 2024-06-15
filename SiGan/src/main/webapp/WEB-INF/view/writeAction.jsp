<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.EmailInfo"%>
<%@ page import="model.SiGanDAO"%>
<%@ page import="javax.sql.DataSource"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext"%>
<%@ page import="container.ContainerContext"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Write Action</title>
</head>
<body>
	<%
	// 폼 데이터 받아오기
	String recipient = request.getParameter("recipient");
	String subject = request.getParameter("subject");
	String text = request.getParameter("text");
	String targetTime = request.getParameter("targetTime");
	targetTime = targetTime.replace("T", " ") + ":01";
	/*
	String userEmail = null;
			String bbsReadDate = request.getParameter("bbsReadDate");//읽을날짜를 가져와서 
			//bbsReadDate에 저장하는 것
			String date = bbsReadDate.replace("T", " ");//T가 같이 저장되는것을 없애는 것
	*/

	// 데이터베이스에 저장할 EmailInfo 객체 생성
	EmailInfo emailInfo = new EmailInfo(recipient, subject, text, targetTime);

	// Spring ApplicationContext에서 SiGanDAO 가져오기
	ApplicationContext context = new AnnotationConfigApplicationContext(ContainerContext.class);
	SiGanDAO dao = context.getBean(SiGanDAO.class);
	
	// 데이터베이스에 이메일 정보 삽입
	dao.insertEmail(emailInfo);
	
	if(emailInfo.getSubject() == null || emailInfo.getText() == null || emailInfo.getRecipient() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안된 사항이 있습니다')");
		script.println("history.back()");
		script.println("</script>");
	}else{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('작성완료!')");
			
			script.println("</script>");	
	}
	
	%>
	<script>
		location.href = '<%= request.getContextPath()%>/index';
	</script>
	
	
</body>
</html>