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
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<h1>결과</h1>
	<br>
	
	<c:if test="${resultCnt == 0 }">
	<h3>프로필 사진 수정 실패!!!</h3>
	</c:if>
	
	<c:if test="${resultCnt == 1 }">
	<h3>프로필 사진 수정 성공!!</h3>
	</c:if>
	
	<c:if test="${result == 0 }">
	<h3>비밀번호 수정 실패!!!</h3>
	</c:if>
	
	<c:if test="${result == 1 }">
	<h3>비밀번호 수정 성공!!</h3>
	</c:if>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	
</body>
</html>