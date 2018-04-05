package com.test.mall2.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall2.board.service.Board;
import com.test.mall2.board.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardservice;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@RequestMapping(value = "/insertBoardForm", method=RequestMethod.POST)
	public String insertBoard(Board board) {
		int row = boardservice.insertBoard(board);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/insertBoardForm", method= RequestMethod.GET)
	public String insertBoard() {
		
		
		return "insertBoardForm";
	}
	
}
