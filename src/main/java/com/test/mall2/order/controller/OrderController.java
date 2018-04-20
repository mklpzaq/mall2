package com.test.mall2.order.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.member.service.Member;
import com.test.mall2.order.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	@RequestMapping(value ="/insertOrder", method = RequestMethod.GET)
	public String insertOrder(Model model											
											,@RequestParam(value="itemNo") int itemNo
											,HttpSession session) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		logger.info(loginMember.getMemberId());
		
		orderService.insertOrder(loginMember, itemNo);	
		return "redirect:/orderList";
	}
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
	public String deleteOrder(@RequestParam(value="deleteCheckbox") int[] deleteCheckbox) {
		logger.info("Controller-deleteCategory");
		orderService.deleteOrder(deleteCheckbox);		

		return "redirect:/orderList";
	} 
	
	@RequestMapping(value ="/orderList", method = RequestMethod.GET)
	public String orderList(Model model, HttpSession session										
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow
									,@RequestParam(value="searchOption", defaultValue="member_id") String searchOption
									,@RequestParam(value="keyword", defaultValue="") ArrayList<Object> keyword) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		Map<String, Object> map = orderService.orderList(currentPage, pagePerRow, searchOption, keyword, loginMember);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("searchOption", searchOption);
		if(keyword.size() == 1) {
			model.addAttribute("keyword", keyword.get(0));
		}else if(keyword.size() == 2) {
			model.addAttribute("keyword", keyword);
		}else{	
			model.addAttribute("keyword", "");	
		}
		
		return "orderList";
	}
	
	
}
