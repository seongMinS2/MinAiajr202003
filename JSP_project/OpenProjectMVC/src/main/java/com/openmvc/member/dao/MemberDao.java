package com.openmvc.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.openmvc.member.model.Member;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		
		return dao;
	}

	// 회원 정보 저장
	public int insertMember(Connection conn, Member member) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member (uid,upw,uname,uphoto) VALUES (?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphoto());

			resultCnt = pstmt.executeUpdate();
		} finally {

			if (pstmt != null)
				pstmt.close();

		}
		return resultCnt;

	}

	// 회원 정보 셀렉트

	public Member selectByMember(Connection conn, String id) throws SQLException {

		Member member = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from project.member where uid=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new Member(rs.getInt("idx"), rs.getString("uid"), rs.getString("upw"), rs.getString("uname"),
						rs.getString("uphoto"), rs.getDate("regdate"));
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return member;
	}

	// ID 체크
	public int selectById(Connection conn, String id) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		ResultSet rs;

		String sql = "select count(*) from project.member where uid=?";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return resultCnt;
	}

	// 회원 테이블 삭제
	public int deleteByMember(Connection conn, int idx) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "DELETE FROM project.member WHERE idx = ?";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx);

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return resultCnt;
	}
	
	// 회원 프로필 사진 수정
	public int modifyByPhoto(Connection conn, int idx, String photo) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;

		String sql = "UPDATE project.member SET uphoto = ? WHERE idx = ?";

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, photo);
			pstmt.setInt(2, idx);

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return resultCnt;
	}
	
	//회원 비밀번호 수정
	public int modifyByPw(Connection conn, String pw, int idx) throws SQLException {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE project.member SET upw = ? WHERE idx = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pw);
			pstmt.setInt(2, idx);
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null)
				pstmt.close();
		}
		
		
		return resultCnt;
	}

	// LoginCheck
	public int loginCheck(Connection conn, String id, String pw) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;

		ResultSet rs;

		String sql = "select uid, upw from project.member where uid=? and upw=?";
		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next())
				resultCnt = 1;

		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return resultCnt;
	}

	public List<Member> selectList(Connection conn, int startRow) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Member> list = new ArrayList();

		try {

			String sql = "select * from project.member limit ?, 3";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member member = new Member(rs.getInt("idx"), rs.getString("uid"), rs.getString("upw"),
						rs.getString("uname"), rs.getString("uphoto"), rs.getDate("regdate"));
				list.add(member);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}

		return list;

	}

	public int selectTotalCount(Connection conn) throws SQLException {

		int resultCnt = 0;

		Statement stmt = null;

		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from project.member";

			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}

		return resultCnt;
	}

}
