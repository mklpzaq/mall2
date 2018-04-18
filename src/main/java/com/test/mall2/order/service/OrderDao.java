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
	
	public void selectOrderList(Map map) {
		
		//return sqlSession.selectList(NS + "orderList", map);		
	}
	
	public void totalCountBoard() {
		
		
		//return;
	}
}
