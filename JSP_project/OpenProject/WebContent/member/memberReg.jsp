<%@page import="model.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("remember");

	String cookieName = "uid";
	String cookiepath = request.getContextPath();


		// 로그인 처리 : 세션의 속성에 데이터 저장
		//session.setAttribute("memberId", uid);
		/* session.setAttribute("memberInfo", new MemberInfo(uid, pw)); */
		
		//어플리케이션 속성에 데이터 저장
		application.setAttribute(uid, new MemberInfo(uid, pw));
		
		//로그인 값을 uid로 갖고왔다고 햇을 시
		MemberInfo mem = application.getAttribute(uid);
		//널이 아니면 아이디가 있고 아니면 없고
		if(mem != null){
			
		}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>