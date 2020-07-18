package member.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import service.Service;

public class MemberDeleteFormServiceImpl implements Service {

	MemberDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// 삭제
		// 1. 테이블 내에 데이터가 삭제되어야 함
		// 2. 물리적 경로에 업로드한 이미지 파일이 삭제되어야 함

		Connection conn = null;

		dao = MemberDao.getInstance();

		String photo = request.getParameter("uphoto");
		int idx = Integer.parseInt(request.getParameter("idx"));

		int resultCnt = 0;

		try {
			
			
		//파일 절대 경로 얻기
		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath(photo);
		
		//파일 객체 생성
		File uploadfile = new File(path);
		
		conn = ConnectionProvider.getConnection();
		
		conn.setAutoCommit(false);
		
		
		//파일이 종료상태이거나 존재 할 경우 삭제
		if (uploadfile.exists() && uploadfile.isFile()) {
			
			resultCnt = dao.deleteByMember(conn, idx);
			
			uploadfile.delete(); // 파일 삭제

			conn.commit();
		} else {
			throw new Exception();
		}
		
		
		request.setAttribute("resultCnt", resultCnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("문제가 발생했습니다. rollback!!!");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		

		return "/WEB-INF/views/member/delete.jsp";
	}
}
