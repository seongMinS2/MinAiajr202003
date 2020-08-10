package com.aia.op.member.service;

import java.io.File;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.aia.op.member.dao.JdbcTemplateMemberDao;
import com.aia.op.member.model.Member;

@Service
public class MemberDeleteService {

	@Inject
	JdbcTemplateMemberDao dao;

	public String memberDelete(int idx, HttpServletRequest request) throws SQLException {

		int result = 0;
		String msg = null;

			Member member = dao.selectByIdx(idx);
			
			result = dao.memberDelete(idx);
			
			String photo = member.getUphoto();
			
			// 회원 정보 삭제 시 파일도 삭제
			if(photo != null && photo.length()>0 && !photo.equals("default.png")) {
				// 서버 내부의 경로
				String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");

				// 시스템의 실제(절대) 경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);
				
				// 이전 페이지를 지운다.
				// 이전 파일의 File 객체
				File oldFile = new File(realPath, member.getUphoto());

				// 파일이 존재하면
				if (oldFile.exists()) {
					// 파일을 삭제
					oldFile.delete();
				}
				
			}

			msg = result > 0 ? "정상적으로 삭제되었습니다." : "요청하신 게시물이 존재하지 않습니다.";


		return msg;

	}
} 
