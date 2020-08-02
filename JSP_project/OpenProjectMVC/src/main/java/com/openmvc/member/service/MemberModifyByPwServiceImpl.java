package com.openmvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openmvc.jdbc.ConnectionProvider;
import com.openmvc.member.dao.MemberDao;
import com.openmvc.service.Service;

@org.springframework.stereotype.Service("pwchg")
public class MemberModifyByPwServiceImpl implements Service {
	
	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		int result = 0;
		
		Connection conn = null;
		String newPw = request.getParameter("upw");
		System.out.println(newPw);
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			dao = MemberDao.getInstance();
			
			result = dao.modifyByPw(conn, newPw, idx);
			
			request.setAttribute("result", result);
			
			conn.commit();
			
			
		} catch (SQLException e) {
			System.out.println("SQLException 발생!! rollback합니다.");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
		
		
		return "/WEB-INF/views/member/modify.jsp";
	}
	
}
