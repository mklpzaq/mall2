package com.test.mall2.board.service;

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
	
	public Board selectBoardList() {
		logger.info("selectBoardList");
		return null;
	}
	
	public int insertBoard(Board board) {
		int row = boardDao.insertBoard(board);
		return row;
	}
	
}
