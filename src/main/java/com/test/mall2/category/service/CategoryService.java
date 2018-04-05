package com.test.mall2.category.service;

import java.util.ArrayList;

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
	
	public void insertCategoryForm(Category category) {	
		logger.info("insertCategoryForm");
		categoryDao.insertCategory(category);
	}
	
	public ArrayList<Category> selectCategoryList() {	
		logger.info("selectCategoryList");
		ArrayList<Category> arrayCategory = categoryDao.selectCategory();
		
		return arrayCategory;
	}
	  
	/*public Category updateCategoryForm(int categoryNo)  {	
		logger.info("updateCategoryForm");
		Category category = categoryDao.updateCategoryForm(categoryNo);
		
		return category;  
	}
	
	public void updateCategory(Category category)  {	
		logger.info("updateCategory");
		categoryDao.updateCategory(category);
	 
	}
	
	public void deleteCategory(int categoryNo)  {	
		logger.info("deleteCategory");
		categoryDao.deleteCategory(categoryNo);
	 
	}*/

}
