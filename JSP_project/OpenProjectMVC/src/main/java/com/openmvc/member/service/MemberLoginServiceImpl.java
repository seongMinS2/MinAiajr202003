package com.openmvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.openmvc.jdbc.ConnectionProvider;
import com.openmvc.member.dao.MemberDao;
import com.openmvc.member.model.Member;
import com.openmvc.service.Service;

@org.springframework.stereotype.Service("login")
public class MemberLoginServiceImpl implements Service {

	MemberDao dao = null;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		dao = MemberDao.getInstance();
		
		String id = request.getParameter("uid");
		String pw = request.getParameter("upw");

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);

			int resultCnt = dao.loginCheck(conn, id, pw);
			
			System.out.println("성공값 : " + resultCnt);
			
			
			if (resultCnt>0) {
				
				Member loginInfo = dao.selectByMember(conn, id);
				System.out.println("맴버 객체 : " + loginInfo);
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", loginInfo);
				
			}
			
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "/WEB-INF/views/member/login.jsp";
	}

}
