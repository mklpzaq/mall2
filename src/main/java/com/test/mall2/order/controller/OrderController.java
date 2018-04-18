package com.test.mall2.order.controller;

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
	public String selectBoardList(Model model											
											,@RequestParam(value="itemNo") int itemNo
											,@RequestParam(value="loginMember") Member loginMember) {
		logger.info(loginMember.getMemberId());
	/*Map<String, Object> map = boardService.selectBoardList(currentPage, pagePerRow);
	model.addAttribute("list", map.get("list"));
	model.addAttribute("lastPage", map.get("lastPage"));
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("startPage", map.get("startPage"));
	model.addAttribute("endPage", map.get("endPage"));
	model.addAttribute("pagePerRow", pagePerRow);*/
		return "BoardList";
	}
	
	
}
