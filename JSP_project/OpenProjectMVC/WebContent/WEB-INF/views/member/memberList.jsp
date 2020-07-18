<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css"> --%>
<style>
table {
	padding: 15px;
}
table td {
	padding: 15px;
}

img{
	max-width: 200px;
	max-height: 200px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h3>회원 리스트 출력</h3>


	<c:if test="${not empty memberListView.memberList}">
		<table border=1>
			<tr>
				<th>no</th>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>사진</th>
				<th>생성시간</th>
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
						<td><div class = "imageTag"><img alt="프사" src="<c:url value="${message.uphoto}"/>"></div></td>
						<td>regdate ${message.regdate}</td>
						<td>
						<a href="memberModifyForm.do?id=${message.uid}&uphoto=${message.uphoto}">[수정]</a>
						<a href="memberDelete.do?idx=${message.idx}&uphoto=${message.uphoto}">[삭제]</a>
						</td> 
					</tr>

					<%-- <a href="deleteMessageConfirm.jsp?mid=${message.mid}">삭제</a> --%>
				</div>
			</c:forEach>
		</table>

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