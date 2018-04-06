package com.test.mall2.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.board.service.BoardMapper.";
	
	public List<Board> selectBoardList() {
		return sqlSession.selectList(NS + "selectBoardList");
		
	}
	
	public int insertBoard(Board board) {
		int row = sqlSession.insert(NS + "insertBoard", board);		
		return row;
	}
}
