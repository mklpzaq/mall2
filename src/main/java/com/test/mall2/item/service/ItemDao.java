package com.test.mall2.item.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall2.category.controller.CategoryController;
import com.test.mall2.category.service.Category;

@Repository
public class ItemDao {
	private static final Logger logger = LoggerFactory.getLogger(ItemDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.mall2.item.service.ItemMapper.";

	
	public int insertItem(Item item) {
		logger.info("insertItem");
		int row = sqlSession.insert(NS+"insertItem",item);
		return row;
	}
	
	public List<Category> selectItemList(Map<String, Integer> map) {
		return sqlSession.selectList(NS+"selectItemList", map);
	}
	
	public int totalCountItem() {
		return sqlSession.selectOne(NS+"totalCountItem"); // 결과값이 하나 이므로 selectOne 사용
	}
	
	public Item updateItemForm(Item item) {
		logger.info("updateItemForm");
		return sqlSession.selectOne(NS+"updateItemForm", item);
	}
	
	public int updateItem(Item item) {
		logger.info("updateItem");
		return sqlSession.update(NS+"updateItem", item);
	}
	public void deleteItem(int itemNo) {
		logger.info("deleteItem");
		sqlSession.delete(NS+"deletItem", itemNo);
	}
}
