<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4"></script>
<style>
img {
	width: 150px;
	height: 150px;
}

#success {
	color: blue;
}

#danger {
	color: red;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<table>
		<tr>
			<td>아이디(email): ${member.uid}</td>
		</tr>
		<tr>
		<tr>
			<td>이름: ${member.uname}</td>
		</tr>

		<tr>
			<td>사진: <img alt="프사" src="<c:url value="${member.uphoto}" />">
			</td>
		</tr>
	</table>
	<form action="memberModifyByPw.do" method="post">
		<table>
			<tr>
				<td>비밀번호변경</td>
				<td><input type="password" id="pw" name="upw" required></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="pwChk" name="upwChk" required></td>
				<td>
					<div id="success">비밀번호가 일치합니다.</div>
					<div id="danger">비밀번호가 일치하지 않습니다.</div>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="idx" value="${member.idx }"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" id="pwSubmit" value="변경" required>
					<input type="button" value="취소"></td>
			</tr>
		</table>
	</form>
	<form action="memberModifyByPhoto.do" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td><input type="hidden" name="idx" value="${member.idx}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="uphoto" value="${member.uphoto}"></td>
			</tr>
			<tr>
				<td>변경할 사진</td>
				<td><input type="file" name="photo" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="변경" required> <input
					type="button" value="취소"></td>
			</tr>
		</table>
	</form>

	<h1>수정 페이지입니다.</h1>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>


</body>
</html>
<script>
	$(function() {
		$("#success").hide();
		$("#danger").hide();
		$("input").keyup(function() {
			var pwd1 = $("#pw").val();
			var pwd2 = $("#pwChk").val();
			if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#success").show();
					$("#danger").hide();
					$("#pwSubmit").removeAttr("disabled");
				} else {
					$("#success").hide();
					$("#danger").show();
					$("#pwSubmit").attr("disabled", "disabled");
				}
			}
		});
	});
</script>