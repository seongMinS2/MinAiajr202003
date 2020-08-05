package com.openmvc.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	
	//로그인 폼 이동
	String loginFormMove();
	
	//로그인
	String login(String id, String pw, HttpServletRequest request);
	
	//로그아웃
	String logout(HttpServletRequest request);
}
