package com.test.mall2.item.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	final String NS = "com.test.mall2.item.service.ItemMapper.";

	
	public int insertItem(Item item) {
		System.out.println(item.getItemName()+"<---ItemDao-insertItem");
		int row = sqlSession.insert(NS+"insertItem",item);
		return row;
	}
	
	public List<Item> selectItemList(Map<String, Integer> map) {
		return sqlSession.selectList(NS+"selectItemList", map);
	}
	
	public int totalCountItem() {
		return sqlSession.selectOne(NS+"totalCountItem");
	}
}
