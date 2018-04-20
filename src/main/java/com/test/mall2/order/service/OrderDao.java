package com.test.mall2.order.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS ="com.test.mall2.order.service.OrderMapper.";	
	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);
	
	public int insertOrder(Map<String, Integer> map) {
		logger.info("insertOrder");
		int row = sqlSession.insert(NS + "insertOrder", map);
		return row;
	}
	
	public List<Order> selectOrderList(Map<String, Object> map) {		
		logger.info("selectOrderList");
		
		return sqlSession.selectList(NS + "orderList", map);	
	}
	
	public int totalCountOrder(Map<String, Object> map) {
		
		
		return sqlSession.selectOne(NS + "totalCountOrder", map);
	}
	
	public void deleteOrder(int orderNo) {
		logger.info("Dao-deleteCategory");
		sqlSession.delete(NS+"deleteOrder", orderNo);
	}
}
