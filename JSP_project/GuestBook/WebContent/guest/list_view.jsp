<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table td {
	padding: 10px;
}

input, textarea {
	padding: 5px;
}

div.msg_box {
	width: 200px;
	border: 5px solid #333;
	margin: 5px;
}

form {
	/* display: none; */
}

.currentPage{
	font-size: 1.5em;
	font-weight: bold;
	
}

</style>
</head>
<body>

	<h3>방명록 글쓰기</h3>
	<hr>
	<form action="messageWrite.jsp" method="post">
		<table>
			<tr>
				<td><label for="uname">이름</label></td>
				<td><input type="text" id="uname" name="uname" required></td>
			</tr>
			<tr>
				<td><label for="pw">암호</label></td>
				<td><input type="password" id="pw" name="pw" required></td>
			</tr>
			<tr>
				<td><label for="message">메세지</label></td>
				<td><textarea rows="10" cols="20" id="message" name="message"
						required></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="글쓰기"><input
					type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
	<hr>
	<c:if test="${not empty listView.messageList}">
		<%-- 	${listView} --%>
		<c:forEach items="${listView.messageList }" var="message">
			<div class="msg_box">
				게시물 번호 ${message.mid}<br> 작성자 ${message.uname } <br> 메시지
				${message.message } <br> <a href="deleteMessageConfirm.jsp?mid=${message.mid}">삭제</a>
			</div>
		</c:forEach>
	
	
	<div class="paging">
		<c:if test="${listView.pageTotalCount > 0}">
			<c:forEach begin="1" end="${listView.pageTotalCount}" var="num">
				<a href="list.jsp?page=${num}" ${listView.currentPageNumber eq num? 'class="currentPage"':'' }>[ ${num} ]</a>

			</c:forEach>
		</c:if>
	</div>
	
	</c:if>



</body>
</html>