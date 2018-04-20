package com.test.mall2.item.service;


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
public class ItemDao {
	private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.mall2.item.service.ItemMapper.";

	
			
	public void deleteItem(int itemNo) {
		sqlSession.delete(NS+"deletItem", itemNo);
	}
	
	public int updateItem(Item item) {
		return sqlSession.update(NS+"updateItem", item);
	}
	
	public Item updateItemForm(Item item) {
		return sqlSession.selectOne(NS+"updateItemForm", item);
	}
	
	public int totalCountItem() {
		return sqlSession.selectOne(NS+"totalCountItem"); // 결과값이 하나 이므로 selectOne 사용
	}
	
	public List<Item> selectItemList(Map<String, Object> map) {
		return sqlSession.selectList(NS+"selectItemList", map);
	}
	
	public int insertItem(Item item) {
		int row = sqlSession.insert(NS+"insertItem",item);
		return row;
	}
		
	
}
