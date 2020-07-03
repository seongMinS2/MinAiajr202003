<%@page import="model.MemberInfo"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String uid = request.getParameter("uid");
	String pw = request.getParameter("pw");
	String chk = request.getParameter("remember");

	String cookieName = "uid";
	String cookiepath = request.getContextPath();

	if (chk != null) {
		response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 60 * 60 * 24 * 365));
	} else {
		response.addCookie(CookieBox.createCookie(cookieName, uid, cookiepath, 0));
	}

	boolean loginChk = false;

		// 로그인 처리 : 세션의 속성에 데이터 저장
		//session.setAttribute("memberId", uid);
		session.setAttribute("memberInfo", new MemberInfo(uid, pw));
		loginChk = true;
%>
<%
	if (loginChk) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">

<style>
</style>
</head>
<body>

	<%@ include file="/include/header.jsp"%>

	<div>
		<h1>로그인</h1>

		<hr>

		<table>
			<tr>
				<td>ID</td>
				<td><%=uid%></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><%=pw%></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<%
						if (chk != null) {
								out.println("아이디를 저장합니다.");
							} else {
								out.println("아이디를 저장하지 않습니다.");
							}
					%>
				</td>
			</tr>
		</table>



	</div>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>

<%
	} else {
%>

<script>
	alert("아이디 또는 비밀번호를 확인해주세요");
	history.go(-1);
</script>
<%
	}
%>


