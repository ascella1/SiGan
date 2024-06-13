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
            <form method="post" action="#">
            	<div>
	            	<input type="datetime-local" placeholder="읽을 날짜를 설정해주세요" name="targetTime" required pattern="yyyy/mm/dd/hh/mm/">
	            </div>
	            <div>
	            	<textarea rows="5" cols="30" placeholder="글 제목" name="subject" maxlength="255"></textarea>
	            </div>
	            <div>
	            	<textarea rows="10" cols="30" placeholder="글 내용" name="text" maxlength="5024"></textarea>
	            </div>
	            <div>
					<input type="submit" class="writeButton" value="작성 완료 !">
				</div>
            </form>           
        </div>
    </container>
</body>
</html>