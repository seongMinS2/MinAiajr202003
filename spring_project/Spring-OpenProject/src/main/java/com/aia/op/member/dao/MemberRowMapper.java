package com.aia.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aia.op.member.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setIdx(rs.getInt("idx"));
		member.setUid(rs.getString("uid"));
		member.setUpw(rs.getString("upw"));
		member.setUname(rs.getString("uname"));
		member.setUphoto(rs.getString("uphoto"));
		return member;
	}
	
}
