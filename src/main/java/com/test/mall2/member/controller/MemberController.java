package com.test.mall2.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.IndexController;
import com.test.mall2.member.service.Member;
import com.test.mall2.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value="/searchMember", method = RequestMethod.POST)
	public String searchMember(@RequestParam(value="searchOption", defaultValue="all") String searchOption
								,@RequestParam(value="keyword", defaultValue="") ArrayList<String> keyword
								,Model model)  {
		
		List<Member> list = memberService.searchAll(searchOption, keyword);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		model.addAttribute("list", list);
		model.addAttribute("searchOption", searchOption);
		model.addAttribute("keyword", keyword);		
		return "memberList";
	}
	
	@RequestMapping(value="/deleteMember", method = RequestMethod.GET)
	public String deleteMember(@RequestParam(value="sendNo") int memberNo) {
		
		int result = memberService.deleteMember(memberNo);
		
		return "redirect:/getMemberList";
	}
	
	@RequestMapping(value="/updateMember", method = RequestMethod.GET)
	public String updateMember(Model model
								,@RequestParam(value="sendNo") int memberNo){
		logger.info("updateMember GET");		
		Member member = memberService.selectMemberForUpdate(memberNo);
		model.addAttribute("memberForUpdate", member);
		return "updateMemberForm";
	}
	
	@RequestMapping(value="/updateMember", method = RequestMethod.POST)
	public String updateMember(Model model, Member member){
		logger.info("/updateMember Post");
		int result = memberService.updateMember(member);
		
		return "redirect:/getMemberList";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String Logout(HttpSession session) {
		memberService.terminateLoginSession(session);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public String Loging() {
		return "login";
		
	}
	
	@RequestMapping(value = "/getLogin", method = RequestMethod.POST)
	public String Loging(Model model, Member member, HttpSession session) {
		
		Member returnMember = memberService.getMemberById(member);
		
		if(returnMember == null) {
			/* 왜 틀렸는지 다시 입력값을 로그인폼에서 보여주기 위해서 어트리부트를 한다. 그리고 포워드를 한다. */
			model.addAttribute("requestMember", member);
			return "login";
		}
		session.setAttribute("loginMember", returnMember);
		return "redirect:/index";
	}
 
	/* currentPage는 안넘어오면 1로 받는다. 그리고 자동으로 받아서 int형으로 변환시킨후, currentPage로 넘긴다.*/
	/* required=true 이렇게 하면 죽었다 깨어나도 넘어와야 된다. 안넘기면 에러를 발생시키게 한다. */
	/* @RequestParam(value="pagePerRow" 부분에서 defaultValue부분을 10으로 설정하였다.
	 * */
	@RequestMapping(value = "/getMemberList", method = RequestMethod.GET)
	public String getMemberList(Model model
								,@RequestParam(value="currentPage", defaultValue="1") int currentPage
								,@RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		Map<String, Object> map = memberService.getMemberList(currentPage, pagePerRow);
		// request.setAttribute()
		// model.addAttribute("map", map);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("lastPageMemberCnt", map.get("lastPageMemberCnt"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("beginPageNumForCurrentPage", map.get("beginPageNumForCurrentPage"));
		
		return "memberList";
	}
	
	
	@RequestMapping(value = "/insertMemberForm", method = RequestMethod.GET)
	public String insertMember() {
		
		return "insertMemberForm";
	}
	
	@RequestMapping(value = "/insertMemberForm", method = RequestMethod.POST)
	public String insertMember(Model model
								,Member member) {		
		logger.info("insertMember MemberController");		
		
		int row = memberService.addMember(member);
		logger.info(row+ " ========insertMember MemberController");		
		if (row != 1) {
			return "insertMemberForm";
		}
		
		return "redirect:/getMemberList";	
		
	
	}
	
}