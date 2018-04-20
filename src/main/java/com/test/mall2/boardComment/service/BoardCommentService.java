package com.test.mall2.boardComment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardCommentService {
	@Autowired
	private BoardCommentDao boardCommentDao;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentService.class);
	
	public int updateBoardComment(BoardComment boardComment) {
		return boardCommentDao.updateBoardComment(boardComment);
	}
	
	public BoardComment selectBoardCommentForUpdate(int commentNo) {
		return boardCommentDao.selectBoardCommentForUpdate(commentNo);
	}
	
	public int deleteBoardComment(int commentNo) {
		return boardCommentDao.deleteBoardComment(commentNo);
	}
	
	public List<BoardComment> getBoardCommentList() {
		return boardCommentDao.getBoardCommentList();
	}
	
	public int insertBoardComment(BoardComment boardComment) {
		return boardCommentDao.insertBoardComment(boardComment);
	}
}
