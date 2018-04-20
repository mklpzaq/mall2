package com.test.mall2.board.controller;

import java.sql.Date;
import java.util.ArrayList;
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
import com.test.mall2.boardComment.service.BoardComment;


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
	
	/* 해당 boardComment에 관한 상세한 설명이 들어있는 페이지로 이동한다.
	 * 여기에는 comment입력 form과,
	 * 해당 boardComment에 해당되는 댓글 리스트가 있다.
	 * boardView() 메서드의 매개변수인 board에는 boardNo값만이 담겨져 있고
	 * boardService.boardView() 메서드를 통해
	 * boardNo, memberId, boardTitle, boardContent, boardDate 맴버변가 모두 세팅된, 
	 * Board객체를 리턴받게 된다.
	 *  */
	@RequestMapping(value = "/boardView", method= RequestMethod.GET)
	public String boardView(Board board, Model model) {
		/* boardList.jsp에서 넘어왔을 때는 매개변수 board에는 boardNo값만 있는 상태가 된다. */
		logger.info("/boardView BoardController");
		/* boardNo, memberId, boardTitle, boardContent, boardDate 맴버변가 모두 세팅된 Board객체참조변수 boardView. */
		Board boardView = boardService.boardView(board);
		
		List<BoardComment> list = boardService.selectBoardCommentList(board);
		logger.info(list.toString());
		model.addAttribute("boardView", boardView);
		model.addAttribute("boardCommentList", list);
		
		
		//redirectAttributes.addFlashAttribute("board", board); 리다이렉트 시킬때 변수값 넣어서 넘길때 쓸수 있는 메서드
		
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
						,@RequestParam(value="keyword", defaultValue="") ArrayList<String> keyword
						,Model model) throws Exception{
		logger.info(searchOption);
		
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
