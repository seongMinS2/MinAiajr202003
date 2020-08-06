package com.aia.op.member.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aia.op.member.model.Member;

@Repository
public class MybatisMemberDao {
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	private String mapperPath = "com.aia.op.mybatis.mapper.MemberMapper";
	
	//clear
	public int insertMember(Member member) throws SQLException {
//		int result = 0;
//		result = sessionTemplate.update(mapperPath + ".insertMember", member);
//		return result;
		
		return sessionTemplate.update(mapperPath + ".insertMember", member);
	}
	
//	//clear
//	public int selectById(Connection conn, String id) throws SQLException {
//		
//		int resultCnt = 0;
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs;	
//		
//		try {
//			String sql = "select count(*) from project.member where uid=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				resultCnt = rs.getInt(1);
//			}
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return resultCnt;
//	}
//	
//	//clear
//	public int selectTotalCount(Connection conn) throws SQLException {
//		int resultCnt = 0;
//		
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			stmt = conn.createStatement();
//			
//			rs = stmt.executeQuery("select count(*) from project.member");
//			
//			if(rs.next()) {
//				resultCnt = rs.getInt(1);
//			}
//			
//		} finally {
//			if(stmt!=null) {
//				stmt.close();
//			}
//		} 
//		
//		return resultCnt;
//	}
//	
//	//clear
//	public List<Member> selectList(Connection conn, int startRow, int count) throws SQLException {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		List<Member> memberList = new ArrayList<Member>();
//		
//		String sql = "select * from project.member order by uname limit ?, ?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, count);
//			
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Member member = new Member();
//				member.setIdx(rs.getInt("idx"));
//				member.setUid(rs.getString("uid"));
//				member.setUpw(rs.getString("upw"));
//				member.setUname(rs.getString("uname"));
//				member.setUphoto(rs.getString("uphoto"));
//				
//				memberList.add(member);
//			}
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return memberList;
//	}
//
//	//clear
//	public int editMember(Connection conn, Member member) throws SQLException {
//		
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		
//		String sql = "update project.member set "
//				   + " upw=?, uname=?, uphoto=? "
//				   + " where idx=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, member.getUpw());
//			pstmt.setString(2, member.getUname());
//			pstmt.setString(3, member.getUphoto());
//			pstmt.setInt(4, member.getIdx());
//			
//			result = pstmt.executeUpdate();
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return result;
//	}
//	
//	//clear
//	public Member selectByIdpw(Connection conn, String uid, String pw) throws SQLException {
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs;	
//		Member member = null;
//		
//		try {
//			String sql = "select * from project.member where uid=? and upw=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, uid);
//			pstmt.setString(2, pw);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				member = new Member();
//				member.setIdx(rs.getInt("idx"));
//				member.setUid(rs.getString("uid"));
//				member.setUpw(rs.getString("upw"));
//				member.setUname(rs.getString("uname"));
//				member.setUphoto(rs.getString("uphoto"));
//			}
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return member;
//	}
//	
//	//clear
//	public List<Member> selectTotalList(Connection conn) throws SQLException {
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		List<Member> memberList = new ArrayList<Member>();
//		
//		String sql = "select * from project.member order by uname";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Member member = new Member();
//				member.setIdx(rs.getInt("idx"));
//				member.setUid(rs.getString("uid"));
//				member.setUpw(rs.getString("upw"));
//				member.setUname(rs.getString("uname"));
//				member.setUphoto(rs.getString("uphoto"));
//				
//				memberList.add(member);
//			}
//			
//		} finally {
//			if(pstmt != null) {
//				pstmt.close();
//			}
//		}
//		
//		return memberList;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
