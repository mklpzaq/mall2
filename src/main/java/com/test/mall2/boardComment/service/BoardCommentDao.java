package com.test.mall2.boardComment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCommentDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(BoardCommentDao.class);
	final String NS ="com.test.mall2.boardComment.service.BoardCommentMapper.";
	
	public int insertBoardComment(BoardComment boardComment) {
		logger.info("insertBoardComment BoardCommentDao");
		return sqlSession.insert(NS+"insertBoardComment", boardComment);
	}
}
