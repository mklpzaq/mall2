package com.test.mall2.member.controller;

import java.util.ArrayList;

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
	
	@RequestMapping(value = "/insertMemberForm", method = RequestMethod.GET)
	public String insertMemberFormController() {
		
   
		return "insertMemberForm";
	}
	
	@RequestMapping(value = "/insertMemberAction", method = RequestMethod.POST)
	public String insertMemberActionController(Member member, Model model) {
		logger.info("member" + member);
		System.out.println(member.getMemberNo());
		System.out.println(member.getMemberId());
		System.out.println(member.getMemberPw());
		//request.setAttribute("member", member);
		
		memberService.insertService(member);
		
		
		//model.addAttribute("member", member);
		
		return "redirect:/memberList";
		//return "redirect:/";
	}
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberListController(Model model) {
		
		ArrayList<Member> list = null;
		list = memberService.selectService();
		System.out.println("list : " + list);
		if(list != null) {
			for(Member member : list) {
				System.out.println(member.getMemberNo());
				System.out.println(member.getMemberId());
				System.out.println(member.getMemberPw());
			}
		}
		model.addAttribute("memberList", list);
		System.out.println("=====================");
	
		return "memberList";
	}
	
	
}
































