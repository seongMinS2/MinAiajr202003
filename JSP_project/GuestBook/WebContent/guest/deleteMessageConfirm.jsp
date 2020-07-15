<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
		/* var form = document.getElementById('delForm'); */
		
		function check(){
			if(confirm('삭제하시겠습니까?')){
				return true;
			}e
			return false;
		}
		
</script>
<body>

	<h3>메세지를 삭제하고자 하시면 비밀번호를 입력해주세요.</h3>
	
	<form id="delForm"  onsubmit="return check();" action="deletMessage.jsp" method="post">
		비밀번호 <input type="password" name="pw">
		<input type="hidden" name="mid" value="${param.mid}">
		<input type="submit" value="삭제하기">
		
	</form>
</body>
</html>