package com.test.mall2.boardComment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.IndexController;
import com.test.mall2.boardComment.service.BoardComment;
import com.test.mall2.boardComment.service.BoardCommentService;

@Controller
public class BoardCommentController {
	@Autowired
	private BoardCommentService boardCommentService;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentController.class);
	
	@RequestMapping(value = "/updateBoardComment", method = RequestMethod.POST)
	public String updateBoardComment(BoardComment boardComment){
		logger.info("/updateBoardComment GET boardCommentController");
		logger.info(boardComment.toString());
		int result = boardCommentService.updateBoardComment(boardComment);
		return "redirect:/getBoardCommentAllList";
	}
	
	@RequestMapping(value = "/updateBoardComment", method = RequestMethod.GET)
	public String updateBoardComment(Model model
									,@RequestParam(value="sendNo") int commentNo){
		logger.info("/updateBoardComment GET boardCommentController");
		logger.info("commentNo : " + commentNo);
		BoardComment boardComment = boardCommentService.selectBoardCommentForUpdate(commentNo);
		logger.info(boardComment.toString());
		model.addAttribute("boardComment", boardComment);
		return "/updateBoardCommentForm";
	}
	
	@RequestMapping(value = "/deleteBoardComment", method = RequestMethod.GET)
	public String deleteBoardComment(@RequestParam(value="sendNo") int commentNo){
		logger.info("/deleteBoardComment GET boardCommentController");
		logger.info("commentNo : " + commentNo);
		int result = boardCommentService.deleteBoardComment(commentNo);
		return "redirect:/getBoardCommentAllList";
	}
	
	@RequestMapping(value = "/getBoardCommentAllList", method = RequestMethod.GET)
	public String getBoardCommentList(Model model){
		logger.info("/getBoardCommentAllList GET boardCommentController");
		List<BoardComment> list = boardCommentService.getBoardCommentList();
		
		model.addAttribute("list", list);
		return "boardCommentAllList";
	}
	
	@RequestMapping(value = "/insertBoardComment", method = RequestMethod.POST)
	public String insertBoardComment(BoardComment boardComment){
		logger.info("/insertBoardComment POST boardCommentController");
		logger.info(boardComment.toString());
		int result = boardCommentService.insertBoardComment(boardComment);
		
		return "redirect:/getBoardCommentAllList";
	}
}























