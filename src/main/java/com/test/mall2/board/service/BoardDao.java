package com.test.mall2.board.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.board.service.BoardMapper.";
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
	
	public List<Board> selectBoardList(Map<String, Integer> map) {
		return sqlSession.selectList(NS + "selectBoardList", map);	
	}
	public int totalCountBoard() {
		return sqlSession.selectOne(NS+"totalCountBoard"); // 결과값이 하나 이므로 selectOne 사용
	}
	
	public int insertBoard(Board board) {
		int row = sqlSession.insert(NS + "insertBoard", board);		
		return row;
	}
	
	public Board boardView(Board board) {
			
		return sqlSession.selectOne(NS + "boardView", board);	
	}
	
	public void deleteBoard(Board boardNo) {
		sqlSession.delete(NS + "deleteBoard", boardNo);	
	}
	
	public void updateBoardForm(Board board) {
		sqlSession.update(NS + "updateBoard", board);	
	}
	
	/*public List<Board> selectBoardList() {
		logger.info("selectBoardList");
		return sqlSession.selectList(NS + "selectBoardListAll");	
	}
	
	public List<Board> searchBoardListMemberId(String sv) {
		logger.info("searchBoardListMemberId");
		return sqlSession.selectList(NS + "searchBoardListMemberId", sv);	
	}
	
	public List<Board> searchBoardListBoardTitle(String sv) {
		logger.info("searchBoardListBoardTitle");
		return sqlSession.selectList(NS + "searchBoardListBoardTitle", sv);	
	}
		
	public List<Board> searchBoardListBoardDate(Map<String, Date> map) {
		logger.info("searchBoardListBoardDate");
		return sqlSession.selectList(NS + "searchBoardListBoardDate", map);	
	}*/
	
	public List<Board> listAll(String searchOption, ArrayList<String> keyword) throws Exception {
	    // 검색옵션, 키워드 맵에 저장
		logger.info(searchOption);		
		List<Board> returnList;
		if(keyword.size() == 1 ){					
		    Map<String, String> map = new HashMap<String, String>();
		    map.put("searchOption", searchOption);
		    map.put("keyword", keyword.get(0));
		    returnList = sqlSession.selectList(NS+"listAll", map);		
		}else if(keyword.size() == 2) {			
			Map<String, Object> map = new HashMap<String, Object>();
		    map.put("searchOption", searchOption);
		    map.put("keyword1", Date.valueOf(keyword.get(0)));
		    map.put("keyword2", Date.valueOf(keyword.get(1)));
		    returnList = sqlSession.selectList(NS+"listAll", map);
		}else {
			Map<String, String> map = new HashMap<String, String>();
		    map.put("searchOption", searchOption);
		    
			returnList = sqlSession.selectList(NS+"listAll", map);	
		}
		return returnList;
	}
}
