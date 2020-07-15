<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
<style>
table td {
	/* 	padding: 10px; */
	
}

input, textarea {
	/* padding: 5px; */
	
}

div.msg_box {
	/* width: 200px;
	border: 5px solid #333;
	margin: 5px; */
	
}

form {
	/* display: none; */
	
}

.currentPage {
	/* font-size: 1.5em;
	font-weight: bold; */
	
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h3>회원 리스트 출력</h3>


	<c:if test="${not empty memberListView.memberList}">
		<table>
			<tr>
				<th>no</th>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>사진</th>
				<th>관리</th>
			</tr>
			<%-- 	${listView} --%>
			<c:forEach items="${memberListView.memberList }" var="message">
				<div class="msg_box">
				<tr>
					<td>idx ${message.idx}</td>
					<td>uid ${message.uid }</td>
					<td>upw${message.upw }</td>
					<td>uname ${message.uname }</td>
					<td><img alt="프사" src="<c:url value="${message.uphoto}"/>"></td>
					<td>regdate ${message.regdate}</td>
				</tr>
		</table>
		<%-- <a href="deleteMessageConfirm.jsp?mid=${message.mid}">삭제</a> --%>
		</div>
		</c:forEach>


		<div class="paging">
			<c:if test="${memberListView.pageTotalCount > 0}">
				<c:forEach begin="1" end="${memberListView.pageTotalCount}"
					var="num">
					<a href="memberList.do?page=${num}"
						${memberListView.currentPageNumber eq num? 'class="currentPage"':'' }>[
						${num} ]</a>

				</c:forEach>
			</c:if>
		</div>

	</c:if>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>