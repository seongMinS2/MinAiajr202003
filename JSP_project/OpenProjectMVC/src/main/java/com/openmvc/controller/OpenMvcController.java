package com.openmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OpenMvcController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		//홈화면가기
		//indx.jsp
		return "index";
	}
}
	
