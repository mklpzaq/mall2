package com.test.mall2.boardComment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall2.IndexController;
import com.test.mall2.boardComment.service.BoardComment;
import com.test.mall2.boardComment.service.BoardCommentService;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentController.class);
	
	@RequestMapping(value = "/insertBoardComment", method = RequestMethod.GET)
	public String insertBoardComment(){
		logger.info("/insertBoardComment GET boardCommentController");
		return "/index";
	}
	
	@RequestMapping(value = "/insertBoardComment", method = RequestMethod.POST)
	public String insertBoardComment(BoardComment boardComment){
		logger.info("/insertBoardComment POST boardCommentController");
		int result = boardCommentService.insertBoardComment(boardComment);
		return null;
	}
}























