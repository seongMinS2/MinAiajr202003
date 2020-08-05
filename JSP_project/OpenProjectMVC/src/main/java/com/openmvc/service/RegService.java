package com.openmvc.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.openmvc.member.model.Member;

public interface RegService {
	
	//RegForm 이동
	String regFormMove();
	
	//회원가입
	String register(HttpServletRequest request, Member member, Model model);
	
	//아이디 중복체크
	String idCheck();
	
	//수정폼 이동
	String modifyForm();
	
	//비밀번호 수정
	String modifyByPw();
	
	//프로필 사진 수정
	String modifyByPhoto();
	
	//회원정보 삭제
	String deleteMember();
	
	
}
