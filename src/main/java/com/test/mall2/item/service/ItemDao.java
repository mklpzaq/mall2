package com.test.mall2.item.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall2.category.service.CategoryService;

@Repository
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.mall2.item.service.ItemMapper.";

	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	public int insertItem(Item item) {
		logger.debug("insertItem");
		int row =sqlSession.insert(NS+"insertItem", item);
		return row;
	}
}
