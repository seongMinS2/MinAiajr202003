package com.aia.op.member.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.aia.op.member.dao.JdbcTemplateMemberDao;
import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberListView;

@Service
public class MemberListService {

//	@Autowired
//	MemberDao dao;

	@Inject
	JdbcTemplateMemberDao dao;

	public MemberListView getView(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// view 로 전달할 결과 데이터
		MemberListView listView = null;

		// 전체 게시물 개수 구하기
		int totalCnt = dao.selectTotalCount();

		// 한 페이지 당 노출할 게시물의 개수
		final int MEMBER_CNT_PER_PAGE = 2;

		// 현재 페이지 번호
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		if (page != null) {
			currentPageNumber = Integer.parseInt(page);
		}

		// 게시물의 첫번째 행의 index
		int startRow = 0;

		// 한 페이지에 누출할 리스트
		List<Member> memberList = null;

		if (totalCnt > 0) {
			startRow = (currentPageNumber - 1) * MEMBER_CNT_PER_PAGE;

			System.out.println(startRow);

			memberList = dao.selectList(startRow, MEMBER_CNT_PER_PAGE);
		} else {
			currentPageNumber = 0;
			memberList = Collections.emptyList();
		}

		listView = new MemberListView(totalCnt, currentPageNumber, memberList, MEMBER_CNT_PER_PAGE, startRow);

		System.out.println(listView);

		return listView;
	}

}