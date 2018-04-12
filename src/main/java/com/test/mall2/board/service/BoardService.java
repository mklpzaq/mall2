package com.test.mall2.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
	
	public Map<String, Object> selectBoardList(int currentPage, int pagePerRow) {
		logger.info("selectBoardList");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Board> list = boardDao.selectBoardList(map);
		
		int total = boardDao.totalCountBoard();
		int lastPage = 0;
		if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		int pageView = 5;
		int startPage = ((currentPage-1)/5)*5+1; 
		int endPage = startPage + pageView -1; 
		if(endPage>lastPage) {
			endPage=lastPage;
		}
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put("list", list);
		returnmap.put("lastPage", lastPage);
		returnmap.put("startPage", startPage);
		returnmap.put("endPage", endPage);
		return returnmap;
	}
	
	public int insertBoard(Board board) {
		int row = boardDao.insertBoard(board);
		return row;
	}
	
	
	public Board boardView(Board board) {
				
		return boardDao.boardView(board);
	}
	
	public void deleteBoard(Board boardNo) {
		boardDao.deleteBoard(boardNo);
	}
	
	public void updateBoardForm(Board board) {
		boardDao.updateBoardForm(board);
	}
}
