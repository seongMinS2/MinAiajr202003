package com.openmvc.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openmvc.jdbc.ConnectionProvider;
import com.openmvc.member.dao.MemberDao;
import com.openmvc.member.model.Member;
import com.openmvc.service.Service;

@org.springframework.stereotype.Service("modify")
public class MemberModifyFormServiceImpl implements Service {

	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

//		System.out.println("받아온 id값: " + request.getParameter("id"));

		Connection conn = null;

		Member member = null;
		
		dao = MemberDao.getInstance();

		try {

			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);

			member = dao.selectByMember(conn, id);
			
			request.setAttribute("member", member);
			
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return "/WEB-INF/views/member/modifyForm.jsp";
	}
}
