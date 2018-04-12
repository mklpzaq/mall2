package com.test.mall2.board.controller;

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

import com.test.mall2.board.service.Board;
import com.test.mall2.board.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	@RequestMapping(value ="/selectBoardList", method = RequestMethod.GET)
	public String selectBoardList(Model model
											, HttpSession session
											,@RequestParam(value="currentPage", defaultValue="1") int currentPage
											,@RequestParam(value="gagePerRow", required=true, defaultValue="10") int pagePerRow) {
		logger.info("pagePerRow");
	Map<String, Object> map = boardService.selectBoardList(currentPage, pagePerRow);
	model.addAttribute("list", map.get("list"));
	model.addAttribute("lastPage", map.get("lastPage"));
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("startPage", map.get("startPage"));
	model.addAttribute("endPage", map.get("endPage"));
	model.addAttribute("pagePerRow", pagePerRow);
		return "BoardList";
	}
	
	@RequestMapping(value = "/insertBoardForm", method=RequestMethod.POST)
	public String insertBoard(Board board) {
		int row = boardService.insertBoard(board);
		return "redirect:/selectBoardList";
	}
	
	
	@RequestMapping(value = "/insertBoardForm", method= RequestMethod.GET)
	public String insertBoard() {
		
		
		return "insertBoardForm";
	}
	
}
