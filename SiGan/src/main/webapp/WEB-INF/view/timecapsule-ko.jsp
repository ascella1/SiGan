<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>타임 캡슐</title>
<link href="TimecapsuleCss.css" rel="stylesheet" type="text/css">
<script>
	function nowTime(){
		let today = new Date();
		let nowMonth = today.getMonth();
		let nowDate = today.getDate();
		let nowHours = today.getHours();
		let nowMin = today.getMinutes();
		let nowSecond = today.getSeconds();

		document.querySelector("#nowTime").innerHTML = nowMonth + 1 +"월 " + nowDate +"일 "+
		nowHours + "시 " + nowMin +"분 " + nowSecond + "초";
		
		
	}
	window.onload = function(){
		nowTime();
	}
	function init(){
		setInterval(nowTime, 1000);
	}
	init();
</script>
</head>
<body>
	<%
		String userEmail = null;
		if(session.getAttribute("userEmail") != null){
			userEmail = (String)session.getAttribute("userEmail");
		}
	%>
	
	<container class='sort'>
        <div class='sort-div'>
            <div id='title'>
               	Time Capsule
            </div>
            <hr>
            <div id='nowTime'>		
 				...
            </div>
            <a href='write.jsp'>   
                <div class='select'>
                    새로 작성하기
                </div>
            </a>
            <a href='#'>
                <div class='select'>
                    남은 시간 확인하기
                </div>
            </a>
            <%
            	if(userEmail == null){
            %>
            <a href="login.jsp">
                <div style="margin-top:2px">
                   로그인 및 회원가입
                </div>
            </a>
            <%
            	}else{
            %>
            <a href="logout.jsp">
                <div style="margin-top:2px">
                   로그아웃
                </div>
            </a>
            <%
            	}
            %>
            <div style="margin-top:30px; font-size:10px;">
                @2023 Made By Choi
            </div>
        </div>
    </container>
</body>
</html>