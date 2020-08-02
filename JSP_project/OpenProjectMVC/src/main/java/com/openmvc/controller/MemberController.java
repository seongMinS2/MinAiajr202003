package com.openmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openmvc.service.Service;

@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	

	
	@RequestMapping(value="memberRegForm")
	public String regForm() {
		
		//회원가입 페이지 이동
		
		return "member/regForm";
	}
	

	
	@RequestMapping(value="memberLoginForm")
	public String memberLoginForm() {
		
		//로그인 폼 이동
		//loginForm.jsp
		
		return "member/loginForm";
	}
	
	@RequestMapping(value="mypage")
	public String memberMypage() {
		
		//my page 이동
		
		return "member/mypage";
	}
	
	
	
	
	/*
	 * @RequestMapping(value="memberLogin", method = RequestMethod.POST) public
	 * String memberLogin(@RequestParam("uid") String uid,
	 * 
	 * @RequestParam("upw") String upw, HttpServletRequest request) {
	 * 
	 * login.getViewPage(request, uid, upw);
	 *  
	 * return "member/login"; }
	 */


	
	@Autowired
	Service reg;
	
	@RequestMapping(value = "memberReg", method = RequestMethod.POST)
	public String memberReg(HttpServletRequest request, HttpServletResponse response) {
		
		//reg
		
		reg.getViewPage(request, response);
		
		return "member/reg";
	}
	
	@Autowired
	Service logout;
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		//logout
		
		logout.getViewPage(request, response);
		
		return "member/logout";
	}
	
	@Autowired
	Service memList;
	
	@RequestMapping(value="memberList")
	public String memberList(HttpServletRequest request, HttpServletResponse response) {
		
		//memberList
		
		memList.getViewPage(request, response);
		
		return "member/memberList";
	}
	
	@Autowired
	Service modify;
	
	@RequestMapping(value = "memberModifyForm")
	public String memberModifyForm(HttpServletRequest request, HttpServletResponse response) {
		
		//수정 페이지 이동
		
		modify.getViewPage(request, response);
		
		return "member/modifyForm";
	}
	
	@Autowired
	Service login;
	
	@RequestMapping(value="memberLogin", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, HttpServletResponse response) {
		
		//login
		
		login.getViewPage(request, response);
		
		return "member/login";
	}
	

	@Autowired
	Service pwchg;
	
	@RequestMapping(value = "memberModifyByPw", method = RequestMethod.POST)
	public String modifyByPw(HttpServletRequest request, HttpServletResponse response) {
		
		//pw modify
		
		pwchg.getViewPage(request, response);
		
		return "member/modify";
	}
	
	
	@Autowired
	Service photochg;
	
	@RequestMapping(value = "memberModifyByPhoto", method = RequestMethod.POST)
	public String modifyByPhoto(HttpServletRequest request, HttpServletResponse response) {
		
		//photo modify
		
		photochg.getViewPage(request, response);
		
		return "member/modify";
	}
	
	@Autowired
	Service delete;
	@RequestMapping(value = "memberDelete")
	public String deleteMember(HttpServletRequest request, HttpServletResponse response) {
		
		//delete member
		
		delete.getViewPage(request, response);
		
		return "member/delete";
	}
	

}
