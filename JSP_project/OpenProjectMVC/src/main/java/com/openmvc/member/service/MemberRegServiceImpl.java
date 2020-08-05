package com.openmvc.member.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.openmvc.jdbc.ConnectionProvider;
import com.openmvc.member.dao.MemberDao;
import com.openmvc.member.model.Member;
import com.openmvc.member.model.MultMember;

@Service
public class MemberRegServiceImpl {

	MemberDao dao;

	public String register(MultMember multMember,HttpServletRequest request, Model model) {
		
		Connection conn = null;
		
		int result = 0;
		
		Member member = new Member(multMember.getUid(),
				multMember.getUpw(),
				multMember.getUname()
				);
		
		try {
				
				
				MultipartFile photo = multMember.getUphoto();
				
				// 사진이 있다면 사진 파일을 물리적으로 저장하고, 없다면 기본 이미지 파일의 경로를 저장한다.
				if(photo != null && !photo.isEmpty() && photo.getSize() > 0) {
				
				//파일이름
				photo.getOriginalFilename();
				
				//파일 경로
				String path = request.getServletContext().getInitParameter("contextImagePath");
				
				//파일 절대 경로
				String realPath = request.getSession().getServletContext().getRealPath(path);
				
				// 저장할 이미지 파일의 새로운 이름 생성
				String newFileName = System.nanoTime() + "_" + photo.getOriginalFilename();
				
				// 서버의 저장소에 실제 저장
				File saveFile = new File(realPath, newFileName);
				
				photo.transferTo(saveFile);
				
				System.out.println("저장 완료 : " + newFileName);
				
				// 데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진 경로
				member.setUphoto(newFileName);
				
				} else {
					member.setUphoto("defalult.png");
				}
				conn = ConnectionProvider.getConnection();
				
				conn.setAutoCommit(false);
				
				dao = MemberDao.getInstance();
			
				result = dao.insertMember(conn, member);

				conn.commit();
				
				model.addAttribute("member", member);
				
				model.addAttribute("result", result);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return "member/reg";
	}

}
