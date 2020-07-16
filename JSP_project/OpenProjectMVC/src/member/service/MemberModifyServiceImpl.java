package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.mdel.Member;
import service.Service;

public class MemberModifyServiceImpl implements Service{
	
	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("uid");
		String pw = request.getParameter("upw");
		String name = request.getParameter("uname");
		String photo = request.getParameter("photo");
		
		Member member = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return "/WEB-INF/views/member/modify.jsp";
	}
}
