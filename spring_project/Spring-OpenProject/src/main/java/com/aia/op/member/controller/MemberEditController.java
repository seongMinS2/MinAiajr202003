package com.aia.op.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.model.MemberEditRequest;
import com.aia.op.member.service.MemberEditService;

@Controller
@RequestMapping("/member/memberEdit")
public class MemberEditController {

	@Autowired
	MemberEditService editService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String memberEditForm(
			@RequestParam("idx") int idx,
			Model model
			) throws SQLException {
		
		model.addAttribute("member", editService.getMember(idx));
		
		return "member/memberEditForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberEdit(
			MemberEditRequest editRequest ,
			HttpServletRequest request,
			Model model
			) throws IllegalStateException, IOException, SQLException {
		
		model.addAttribute("result", editService.editMember(editRequest, request));
		
		return "member/memberEdit";
	}
	
}
