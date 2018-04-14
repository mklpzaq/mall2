package com.test.mall2.board.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.mall2.board.service.Board;
import com.test.mall2.board.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value ="/selectBoardList", method = RequestMethod.GET)
	public String selectBoardList(Model model											
											,@RequestParam(value="currentPage", defaultValue="1") int currentPage
											,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow) {
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
	
	
	@RequestMapping(value = "/boardView", method= RequestMethod.GET)
	public String boardView(Board board, Model model) {
		Board boardView = boardService.boardView(board);
		
		model.addAttribute("boardView", boardView);
		
		return "boardSangseView";
	}
	
	@RequestMapping(value = "/deleteBoard", method= RequestMethod.GET)
	public String deleteBoard(Board boardNo) {
		boardService.deleteBoard(boardNo);
		
		return "redirect:/selectBoardList";
	}
	
	@RequestMapping(value = "/updateBoardForm", method = RequestMethod.GET)
	public String updateBoardForm(Board board, Model model) {
		logger.info("updateBoardForm");
		Board boardUpdate = boardService.boardView(board);
		
		model.addAttribute("boardUpdate", boardUpdate);
		
		return "updateBoardForm";  
	} 
	
	@RequestMapping(value = "/updateBoardForm", method = RequestMethod.POST)
	public String updateBoardForm(Board board, RedirectAttributes redirectAttributes) {
		logger.info("updateBoardForm");
		boardService.updateBoardForm(board);
		
		redirectAttributes.addFlashAttribute("board", board);
				
		return "redirect:/boardView";  
	}
	
	/*@RequestMapping(value = "/searchBoardList", method = RequestMethod.POST)
	public String searchBoardList(HttpServletRequest request, Model model) {
		String sk = request.getParameter("sk");
		String sv =request.getParameter("sv");		
		@RequestParam(value="sk") String sk
		,@RequestParam(value="sv") String sv
		,@RequestParam(value="sv1") Date sv1
		,@RequestParam(value="sv2") Date sv2
		
		logger.info("searchBoardList");
		if(sv != null) {
			List<Board> list = boardService.searchBoardList(sk, sv);
			model.addAttribute("list", list);
		}else {
			Date sv1 = Date.valueOf(request.getParameter("sv1"));
			Date sv2 = Date.valueOf(request.getParameter("sv2"));
			List<Board> list = boardService.searchBoardList(sk, sv1, sv2);	
			model.addAttribute("list", list);
		}
		
		
		
		return "BoardList";  
	} */
	
	@RequestMapping(value = "/searchBoardList", method = RequestMethod.POST)
	// @RequestParam(defaultValue="") ==> 기본값 할당
	public String list(@RequestParam(value="searchOption", defaultValue="all") String searchOption
						,@RequestParam(value="keyword", defaultValue="") String keyword
						,Model model) throws Exception{
		logger.info("list");
	    List<Board> list = boardService.listAll(searchOption, keyword);
	    // 레코드의 갯수
	    //int count = boardService.countArticle(searchOption, keyword);
	    // ModelAndView - 모델과 뷰
	    //ModelAndView mav = new ModelAndView();
	    /*mav.addObject("list", list); // 데이터를 저장
	    mav.addObject("count", count);
	    mav.addObject("searchOption", searchOption);
	    mav.addObject("keyword", keyword);*/
	    // 데이터를 맵에 저장
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("list", list); // list
	    //map.put("count", count); // 레코드의 갯수
	    map.put("searchOption", searchOption); // 검색옵션
	    map.put("keyword", keyword); // 검색키워드
	    
	    //mav.addObject("map", map); // 맵에 저장된 데이터를 mav에 저장
	    //mav.setViewName("board/list"); // 뷰를 list.jsp로 설정
	    model.addAttribute("list", list);
	    model.addAttribute("searchOption", searchOption);
	    model.addAttribute("keyword", keyword);
	    return "BoardList"; // list.jsp로 List가 전달된다.
	}

	
}
