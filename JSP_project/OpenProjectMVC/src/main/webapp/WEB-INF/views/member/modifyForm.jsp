<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
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
	<c:url value=" ${member.uphoto}" />
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

	<button class="pwBtn">비밀번호 변경</button>
	<div id="modifyPw">
		<form action="memberModifyByPw" method="post">
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
	</div>

	<button class="phBtn">프로필 사진 변경</button>
	<div id="modifyPhoto">
		<form action="memberModifyByPhoto" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><input type="hidden" name="idx" value="${member.idx}"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="uphoto"
						value="${member.uphoto}"></td>
				</tr>
				<tr>
					<td>사진 변경</td>
					<td><input type="file" name="photo" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="변경" required> <input
						type="button" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>


</body>

</html>
<script>
	$('document').ready(function() {
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

		$(function() {
			$('#modifyPw').hide();
			$('#modifyPhoto').hide();
			$('.pwBtn').click(function () {
				if ($('#modifyPw').css('display') == 'none') {
					$('#modifyPw').show();
				} else {
					$('#modifyPw').hide();
				}
			});
			
			$('.phBtn').click(function () {
				if ($('#modifyPhoto').css('display') == 'none') {
					$('#modifyPhoto').show();
				} else {
					$('#modifyPhoto').hide();
				}
			});
		});
	});
</script>