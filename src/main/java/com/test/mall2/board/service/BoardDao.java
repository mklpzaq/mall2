package com.test.mall2.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.board.service.BoardMapper.";
	
	public int insertBoard(Board board) {
		int row = sqlSession.insert(NS + "insertBoard", board);		
		return row;
	}
}
