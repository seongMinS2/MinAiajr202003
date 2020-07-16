<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4"></script>
<style>
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<form action="memberReg.do" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(email)</td>
					<td><input type="email" name="uid" id="uid" value="${message.uid}" readonly="readonly" required>
						</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw" value="기본값"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" readonly="readonly"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo" value="기본값?"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="수정" required> <input
						type="reset"></td>
				</tr>
			</table>
		</form>

<h1>수정 페이지입니다.</h1>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>