package com.aia.rest.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.rest.model.Member;

@RestController
@RequestMapping("/rest/v1")
public class RestTestController {

	@RequestMapping("/memberlist")
	public List<Member> getList(){ 
		
		List<Member> list = new ArrayList<Member>();
		list.add(new Member(1, "cool1", "cool1@gmail", "cool1.png", new Date()));
		list.add(new Member(2, "cool2", "cool2@gmail", "cool2.png", new Date()));
		list.add(new Member(3, "cool3", "cool3@gmail", "cool3.png", new Date()));
		list.add(new Member(4, "cool4", "cool4@gmail", "cool4.png", new Date()));
		list.add(new Member(5, "cool5", "cool5@gmail", "cool5.png", new Date()));
		
		return list;
	}
	
	@RequestMapping("/memberMap")
	public Map<Integer,Member> getListMap(){
		
		Map<Integer, Member> map = new HashMap<Integer, Member>();
		map.put(1,new Member(1, "cool1", "cool1@gmail", "cool1.png", new Date()));
		map.put(2,new Member(2, "cool2", "cool2@gmail", "cool2.png", new Date()));
		map.put(3,new Member(3, "cool3", "cool3@gmail", "cool3.png", new Date()));
		map.put(4,new Member(4, "cool4", "cool4@gmail", "cool4.png", new Date()));
		map.put(5,new Member(5, "cool5", "cool5@gmail", "cool5.png", new Date()));
		
		return map;
	}
	

	// @GetMapping == @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public Member getMember() {
		Member member = new Member();
		member.setId(1);
		member.setName("son");
		member.setEmail("son@naver.com");
		member.setPhoto("default.png");
		return member;
	}
	
	

	@RequestMapping("/text") // /rest/v1/text
	public String testString() {
		return "Hello~ Restful";
	}
}
