package com.test.mall2.board.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.board.service.BoardMapper.";
	
	public List<Board> selectBoardList(Map<String, Integer> map) {
		return sqlSession.selectList(NS + "selectBoardList", map);	
	}
	public int totalCountBoard() {
		return sqlSession.selectOne(NS+"totalCountCategory"); // 결과값이 하나 이므로 selectOne 사용
	}
	public int insertBoard(Board board) {
		int row = sqlSession.insert(NS + "insertBoard", board);		
		return row;
	}
}
