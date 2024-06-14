<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="main.Main" %>
<%

%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>SiGan</title>
<link href="css/custom.css" rel="stylesheet" type="text/css">
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
    
    <container class='sort'>
        <div class='sort-div'>
            <div id='title'>
                SiGan
            </div>
            <hr>
            <div id='nowTime'>      
                ...
            </div>
            <a href="${pageContext.request.contextPath}/writeCopy">
                <div class='writeButton'>
                    작성하기
                </div>
            </a>
            <div>
                <details>
                    <summary>어떻게 하는거에요?</summary>
                    <p>
                        <li>라라라라1</li>
                        <li>라라라라2</li>
                        <li>라라라라3</li>
                    </p>
                </details>
            </div>
            <div style="margin-top:30px; font-size:10px;">
                @2024 Made By Choi
            </div>
        </div>
    </container>
</body>
</html>
