package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import service.Service;

public class IdCheckServiceImpl implements Service {

	MemberDao dao = null;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		String result = "N";
		
		String id = request.getParameter("uid");
		
		Connection conn = null;
		
		
		try {
			conn = ConnectionProvider.getConnection();
			
			conn.setAutoCommit(false);
			
			dao = MemberDao.getInstance();
			
			int resultCnt = dao.selectById(conn, id);
			
			if(resultCnt < 1) {
				result = "Y";
			}
			request.setAttribute("idcheck", result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
		
		return "/WEB-INF/views/member/idCheck.jsp";
	}

}
