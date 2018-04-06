package com.test.mall2.category.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
	
	public Map<String, Object> selectCategoryList(int currentPage, int pagePerRow) {	
		logger.info("selectCategoryList");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int beginRow = (currentPage-1)*pagePerRow; //페이지의 첫번째 행을 지정해줌
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Category> list = categoryDao.selectCategoryList(map);
		
		int total = categoryDao.totalCountCategory();
		int lastPage =0;
		if(total%pagePerRow ==0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put("list", list);
		returnmap.put("lastPage", lastPage);
		
		return returnmap;
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
