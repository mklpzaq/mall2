package com.test.mall2.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.test.mall2.IndexController;
import com.test.mall2.member.service.Member;
import com.test.mall2.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET)
	public String getMemberList(Model model) {
		List<Member> list = memberService.getMemberList();
		// request.setAttribute()
		model.addAttribute("memberList", list);
		return "memberList";
	}
	
	
	@RequestMapping(value = "/insertMemberForm", method = RequestMethod.GET)
	public String addMember() {
		
		return "insertMemberForm";
	}
	
	@RequestMapping(value = "/insertMemberForm", method = RequestMethod.POST)
	public String insertMember(Member member) {		
		logger.info("insertMember MemberController");
		int row = memberService.addMember(member);
		
		return "redirect:/";
	
	}
	
	
	
}