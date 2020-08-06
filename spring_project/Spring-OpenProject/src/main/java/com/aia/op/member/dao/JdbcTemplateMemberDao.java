package com.aia.op.member.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aia.op.member.model.Member;

@Repository
public class JdbcTemplateMemberDao {

	@Inject
	JdbcTemplate jdbcTemplate;

	public int selectTotalCount() throws SQLException {

//		int resultCnt = 0;
//		String sql = "select count(*) from project.member";
//		resultCnt = jdbcTemplate.queryForObject(sql, Integer.class);
//		return resultCnt;
		return jdbcTemplate.queryForObject("select count(*) from project.member", Integer.class);
	}

	public List<Member> selectTotalList() throws SQLException {
//		List<Member> memberList = new ArrayList<Member>();
//		String sql = "select * from project.member order by uname";
//		memberList = jdbcTemplate.query(sql, new MemberRowMapper());

		return jdbcTemplate.query("select * from project.member order by uname", new MemberRowMapper());
	}

	public List<Member> selectList(int startRow, int count) throws SQLException {

//		List<Member> memberList = new ArrayList<Member>();
//		String sql = "select * from project.member order by uname limit ?, ?";
//		memberList = jdbcTemplate.query(sql, new Object[] {startRow, count}, new MemberRowMapper());
//		return memberList;

		return jdbcTemplate.query("select * from project.member order by uname limit ?, ?",
				new Object[] { startRow, count }, new MemberRowMapper());
	}

	public int insertMember(Member member) throws SQLException {
//		int resultCnt = 0;
//		String sql = "INSERT INTO project.member (uid, upw, uname, uphoto ) VALUES (?,?,?,?)";
//		resultCnt = jdbcTemplate.update(sql,member.getUid(), member.getUpw(), member.getUname(), member.getUphoto());
//		return resultCnt;

		return jdbcTemplate.update("INSERT INTO project.member (uid, upw, uname, uphoto ) VALUES (?,?,?,?)",
				member.getUid(), member.getUpw(), member.getUname(), member.getUphoto());
	}

	public int selectById(String id) throws SQLException {
//	int resultCnt = 0;
//	String sql = "select count(*) from project.member where uid=?";
//	resultCnt = jdbcTemplate.queryForObject(sql, Integer.class);
//	return resultCnt;

		return jdbcTemplate.queryForObject("select count(*) from project.member where uid=?", Integer.class,id);
	}

	public int memberDelete(int idx) throws SQLException {
//		int result = 0;
//		String sql = "delete from project.member where idx=?";
//		jdbcTemplate.update(sql,idx);
//		return result;

		return jdbcTemplate.update("delete from project.member where idx=?", idx);
	}

	public Member selectByIdx(int idx) throws SQLException {
//		Member member = null;
//		String sql = "select * from project.member where idx=?";
//		member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), idx);
//		return member;

		return jdbcTemplate.queryForObject("select * from project.member where idx=?", new MemberRowMapper(), idx);
	}

	public int editMember(Member member) throws SQLException {
//		int result = 0;
//		String sql = "update project.member set "
//				   + " upw=?, uname=?, uphoto=? "
//				   + " where idx=?";
//		result = jdbcTemplate.update(sql, member.getUpw(),member.getUname(),member.getUphoto(),member.getIdx());
//		return result;

		return jdbcTemplate.update("update project.member set upw=?, uname=?, uphoto=? where idx=?", member.getUpw(),
				member.getUname(), member.getUphoto(), member.getIdx());
	}

	public Member selectByIdpw(String uid, String pw) throws SQLException {

		Member member = null;
		String sql = "select * from project.member where uid=? and upw=?";
		member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(), uid, pw);
		
		return member;
	}

}
