<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">						
<meta name="viewport" content="width=device-width", initial-scale="1">				 <!-- 동작형 웹을 위한 것 -->
<link rel="stylesheet" href="css/bootstrap.css">									<!-- 외부스타일 참조 -->
<link rel="stylesheet" href="css/costom.css">

<title>타임캡슐 작성</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form method="post" action="writeAction">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">
								글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="email" class="form-control"
								placeholder="이메일 입력" name="recipient" maxlength="50"></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="글 제목" name="subject" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용"
									name="text" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
			</form>

		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>