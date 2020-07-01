package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답처리 : HTML 문서를 만든다.
		
				resp.setContentType("text/html; charset=utf-8"); 
				
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("\t<head>");
				out.println("\t\t<title>서블릿 테스트</title>");
				out.println("\t</head>");
				out.println("\t<body>");
				out.println("\t\t<h1>안녕하세요. 서블릿 클래스로 응답 처리된 페이지 입니다.</h1>");
				out.println("\t\t<p>현재 시간은 : "+ new Date() +"</p>");
				
				
				out.println("\t</body>");
				out.println("</html>");
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
