<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<c:if test="${loginInfo != null}">
	<h1>로그인에 성공 하였습니다.</h1>
	<%
		
	%>
	</c:if>
	
	<c:if test="${loginInfo == null}">
	<h1>실패했다 돌아가거라</h1>
	<br>
	<a href="memberLoginForm.do">로그인페이지로</a>
	</c:if>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>