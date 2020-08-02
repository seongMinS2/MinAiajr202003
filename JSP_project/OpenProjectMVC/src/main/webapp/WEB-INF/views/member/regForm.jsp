<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>

<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->


<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css"> --%>

<style>
.check_ok {
	color: blue;
}

.check_not {
	color: red;
}

#idchk {
	display: none;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<div>
		<h1 class="subtitle">회원 가입</h1>
		<hr>
		<!-- enctype요게 빠지면 파일업로드가 안됨 isMultipart가 false가나옴 -->
		<form action="memberReg" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>아이디(email)</td>
					<td><input type="email" name="uid" id="uid" required>
						<span id="checkmsg"></span> <input type="checkbox" name="idchk"
						id="idchk"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="upw" required></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" required></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="회원가입" required> <input
						type="reset"></td>
				</tr>
			</table>
		</form>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script>
		$(document).ready(function() {

			$('#regForm').submit(function() {
				if (!('#idchk').prop('checked')) {
					alert('아이디 중복 체크는 필수 항목입니다.');
					$('#uid').focus();
					return false;
				}

			});

			$('#uid').focusin(function() {
				$(this).val('');
				$('#checkmsg').text('');

				$('#checkmsg').text('');
				$('#checkmsg').removeClass('check_not');
				$('#checkmsg').removeClass('check_ok');

			});
			$('#uid').focusout(function() {
				if ($(this).val().length < 1) {
					$('#checkmsg').text('아이디는 필수항목입니다');
					$('#checkmsg').addClass('check_not');
					$('#idchk').prop('checked', false);
					return false;
				}
				$.ajax({
					url : 'idCheck',
					data : {
						uid : $(this).val()
					},
					success : function(data) {
						if (data == 'Y') {
							$('#checkmsg').text('사용가능한 아이디입니다');
							$('#checkmsg').addClass('check_ok');
							$('#idchk').prop('checked', true);
						} else {
							$('#checkmsg').text('사용할 수 없는 아이디입니다');
							$('#checkmsg').removeClass('check_ok');
							$('#checkmsg').addClass('check_not');
							$('#idchk').prop('checked', false);
						}
					}
				});
			});
		});
	</script>
</body>
</html>
