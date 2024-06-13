<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>새로 작성하기</title>
<link href="css/custom.css" rel="stylesheet" type="text/css">

</head>
<body>
	<container class='sort'>
        <div class='sort-div'>
            <div id="title">새로 작성하기</div>
            <hr>
            <form method="post" action="EmailServlet">
            	<div>
            		<a> 읽을 날짜 지정</a>
            		<br>
	            	<input type="datetime-local" style="border-radius:5px;"
	            	placeholder="읽을 날짜를 설정해주세요" name="targetTime" required pattern="yyyy/mm/dd/hh/mm/">
	            </div>
	            <div>
	            	<a>전달받을 이메일 설정</a>
	            	<textarea rows="1" cols="30" placeholder="전달받을 이메일을 입력해주세요" name="recipient" maxlength="255"></textarea>
	            </div>
	            <div>
	            	<a>글 제목 입력</a>
	            	<textarea rows="2" cols="30" placeholder="글 제목을 입력해주세요" name="subject" maxlength="255"></textarea>
	            </div>
	            <div>
	            	<a>글 내용 입력</a>
	            	<textarea rows="15" cols="30" placeholder="글 내용을 입력해주세요(5024자 이내)" name="text" maxlength="5024"></textarea>
	            </div>
	            <div>
					<input id="btn" type="submit" class="writeButton" value="작성 완료 !">
				</div>
            </form>           
        </div>
    </container>
</body>
</html>