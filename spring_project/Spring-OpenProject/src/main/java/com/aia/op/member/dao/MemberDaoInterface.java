package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberXml;

public interface MemberDaoInterface {
	
	public Member selectByIdpw(String uid, String pw);
	
	// 전체 XML 회원 리스트
	public List<MemberXml> selectTotalListXml();

	// 회원 전체 리스트 반환
	public List<Member> selectTotalList();
	
	//idx 기반으로 검색한 회원의 정보 반환
	public Member selectByIdx(int idx);
	
	public int insertMember(Member member);
	
	//public List<Member> selectBykeyword(Map search);
	
	//전체 게시물의 개수 : 검색 포함
	public int totalCount(Map search);
	
	//전체 게시물의 List<Member>
	public List<Member> selectList(Map search);
}
