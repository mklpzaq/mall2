package com.test.mall2.member.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import com.test.mall2.IndexController;
import com.test.mall2.driver.DriverDB;

@Repository
public class MemberDao {
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);	
	@Autowired
 	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.member.service.MemberMapper.";
	
	public List<Member> searchAll(String searchOption, ArrayList<String> keyword){
		
		logger.info("======searchAll========");
		List<Member> returnList;
		if(keyword.size() == 1) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			map.put("keyword", keyword.get(0));
			returnList = sqlSession.selectList(NS+"searchAll" , map);			
		}else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("searchOption", searchOption);
			
			returnList = sqlSession.selectList(NS+"searchAll" , map);
		}		
		return returnList;
	}
	
	public int deleteMember(int memberNo) {
		return sqlSession.delete(NS+"deleteMember", memberNo);
	}
	
	public int updateMember(Member member) {
		return sqlSession.update(NS+"updateMember", member);
	}
	
	public Member selecMemberForUpdate(int memberNo) {
		return sqlSession.selectOne(NS+"selectMemberForUpdate", memberNo);
	}
	
	public Member selectMemberById(Member member) {		
		return sqlSession.selectOne(NS+"selectMemberById", member);
	}

	/* 하나의  */
	public int totalCountMember() {
		return sqlSession.selectOne(NS+"totalCountMember");
	}
	
	public List<Member> selectMemberList(Map<String, Integer> map){
		return sqlSession.selectList(NS+"selectMemberList", map);
	}
	
	public int insertMember(Member member) {
		logger.info("insertMember");
		int row = sqlSession.insert(NS+"insertMember",member);
		return row;
	}	
	
}