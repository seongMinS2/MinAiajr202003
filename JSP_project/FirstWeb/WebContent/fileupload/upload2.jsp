
<%@page import="javax.servlet.jsp.tagext.Tag"%>
<%@page import="service.ReportRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    
    ReportRegService service = ReportRegService.getInstance();
    
    int result = service.regReport(request);
   
    request.setAttribute("result", result);

    %>
    
    
    <jsp:forward page="upload_view.jsp"></jsp:forward>