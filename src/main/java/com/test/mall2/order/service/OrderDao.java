package com.test.mall2.order.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.order.service.OrderMapper.";
	
	public int insertOrder(Map map) {
		int row = sqlSession.insert(NS + "insertOrder", map);
		return row;
	}
	
	public Map<String, String> selectOrderList(Map map) {
		Map<String, String> map2 = null;
		sqlSession.selectList(NS + "orderList", map);
		
		return map2;	
	}
	
	public int totalCountBoard() {
		int x = 0;
		
		return x;
	}
}
