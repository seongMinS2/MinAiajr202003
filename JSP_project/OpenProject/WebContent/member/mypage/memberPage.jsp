<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 


/*     String mId = (String)session.getAttribute("memberId"); */
   MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");



   if(memberInfo==null){
      /* response.sendRedirect("sessionLoginForm.jsp"); */
      %>
      <script>
      alert('사용자 전용 페이지 입니다. \n 로그인 해주세요'); 
      location.href = '../loginForm.jsp';
      </script>
      <% 
   }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원페이지</h1>
</body>
</html>