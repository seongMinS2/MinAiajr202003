package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.mdel.Member;
import member.mdel.MemberListView;
import service.Service;

public class MemberListServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		//페이지 번호
		int pageNum = 1;
		String pageNumber = request.getParameter("page");
		if(pageNumber != null){
			pageNum = Integer.parseInt(pageNumber);
		}
		//한 페이지 표현할 갯수
		final int MEMBER_CNT_PER_PAGE = 3;
		
		
		
		Connection conn = null;
		
		List<Member> members = new ArrayList<Member>();

		MemberListView memberListView = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			// 전체행 갯수
			int memberTotalCount = dao.selectTotalCount(conn);
			int startRow = 0;
			int endRow = 0;
			if(memberTotalCount>0) {
				// 시작 행, 마지막 행
				startRow = (pageNum-1)*MEMBER_CNT_PER_PAGE;
				System.out.println("startRow : " + startRow);
				//Member 리스트
				members = dao.selectList(conn, startRow);
			}else {
				pageNum = 0;
				members = Collections.emptyList();
			}
			
			 memberListView = new MemberListView(memberTotalCount, pageNum, members, 
					 MEMBER_CNT_PER_PAGE, startRow, endRow);
			
			
			System.out.println(memberListView);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		

		request.setAttribute("memberListView", memberListView);
		
		return "/WEB-INF/views/member/memberList.jsp";
	}
	

}
