package com.test.mall2.category.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.test.mall2.paging.Paging;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	public int insertCategoryForm(Category category) {	
		logger.info("insertCategoryForm");
		int row = categoryDao.insertCategory(category);
		return row;
	}
	
	public List<Category> selectCategoryList() {	
		logger.info("selectCategoryList");
				
		return categoryDao.selectCategoryList();
	}
	  
	public Category updateCategoryForm(Category category)  {	
		logger.info("updateCategoryForm");
				
		return categoryDao.updateCategoryForm(category); 
	}
	
	public void updateCategory(Category category)  {	
		logger.info("updateCategory");
		categoryDao.updateCategory(category);
	 
	}
	
	public void deleteCategory(Category category)  {	
		logger.info("deleteCategory");
		categoryDao.deleteCategory(category);
	 
	}

}
