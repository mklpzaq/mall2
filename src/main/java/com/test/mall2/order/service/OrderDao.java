package com.test.mall2.order.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

}
