package com.test.mall2.category.service;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.test.mall2.category.service.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	final String NS = "com.test.mall2.category.service.CategoryMapper.";
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
		
	public int insertCategory(Category category) {
		logger.debug("insertCategory");
		int row = sqlsession.insert(NS+"insertCategory", category);	
		return row;
	}
	
	public List<Category> selectCategoryList(Map<String, Integer> map) {
		return sqlsession.selectList(NS+"selectCategoryList", map);
	}
	
	public int totalCountCategory() {
		return sqlsession.selectOne(NS+"totalCountCategory"); // 결과값이 하나 이므로 selectOne 사용
	}
	
	public Category updateCategoryForm(Category category){
				
		return sqlsession.selectOne(NS+"updateCategoryForm", category);
	}
	
	public void updateCategory(Category category) {
		
		sqlsession.update(NS+"updateCategory", category);
	}
	
	public void deleteCategory(Category category) {
		
		sqlsession.delete(NS+"deleteCategory", category);
	}
	
}
