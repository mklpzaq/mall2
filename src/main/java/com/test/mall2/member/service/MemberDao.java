package com.test.mall2.member.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public int insertMember(Member member) {
		logger.info("insertMember");
		int row = sqlSession.insert(NS+"insertMember",member);
		return row;
	}
}