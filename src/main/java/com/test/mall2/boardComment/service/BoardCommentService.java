package com.test.mall2.boardComment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {
	@Autowired
	private BoardCommentDao boardCommentDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentService.class);
	
	public int insertBoardComment(BoardComment boardComment) {
		return boardCommentDao.insertBoardComment(boardComment);
	}
}
