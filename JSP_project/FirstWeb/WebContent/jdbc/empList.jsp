<%@page import="dao.EmpDao"%>
<%@page import="guestbook.jdbc.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Emp"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMP LIST</title>
<style>

	table{
		width: 80%;
	}
	
	table td{
		padding: 10px;
	}
</style>
</head>
<body>

	
	<%
		//1. 드라이버 로드
		//2. Connection 생성
		//3. Statment
		//4. ResultSet
		//5. close()

		//1. 데이터베이스 로드
		//Class.forName("oracle.jdbc.driver.OracleDriver");

		 Connection conn = null;
		/* Statement stmt = null;
		ResultSet rs = null; */

		List<Emp> empList = new ArrayList<>();

		/* //DB Connection 정보
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pw = "tiger"; */

			//2. Connection 생성
			conn = ConnectionProvider.getConnection();
			
			empList = EmpDao.getInstance().getEmpList(conn);
			
			request.setAttribute("empList", empList);
			
		/* 	/* String sql = "select * from emp order by ename desc";

			System.out.println(conn);
			// 3. Statement 생성
			stmt = conn.createStatement();

			//4. select 의 결과를 담음
			rs = stmt.executeQuery(sql);

			//결과 출력
			
			
			while (rs.next()) {

				empList.add(
						new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getInt("sal"), rs.getString("job")));
			} */
	/* 	} catch (Exception ex) {
			ex.printStackTrace();
			// 예외처리
		} finally {
			rs.close();
			stmt.close();
			conn.close();  
		}  */
	
	%>
	
	<jsp:forward page="empList_view.jsp" />


	
</body>
</html>