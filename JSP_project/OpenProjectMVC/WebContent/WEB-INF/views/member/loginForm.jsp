<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="https://code.jquery.com/jquery-1.12.4"></script> -->
<style>
	td {
		margin : 15px;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<div>
		<h1>로그인</h1>
		<hr>
		<form action="memberLogin.do" method="post">
			<table>
				<tr>
					<td>아이디(이메일)</td>
					<td><input type="text" name="uid" required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="로그인">&nbsp;<button type="button" onclick="location.href='memberRegForm.do'">회원가입</button></td>
				</tr>
			</table>

		</form>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>