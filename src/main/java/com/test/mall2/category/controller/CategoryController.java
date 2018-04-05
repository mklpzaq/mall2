package com.test.mall2.category.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.category.service.Category;
import com.test.mall2.category.service.CategoryService;
import com.test.mall2.paging.Paging;

@Controller
public class CategoryController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService categoryService;	
	
	@RequestMapping(value = "/insertCategoryForm", method = RequestMethod.GET)
	public String categoryInsertForm() {		
   
		return "insertCategoryForm";
	}
	
	@RequestMapping(value = "/insertCategoryForm", method = RequestMethod.POST)
	public String categoryInsertForm(Category category) {
		//Category category = new Category();
		//category.setCategoryName(categoryName);
		
		logger.info("categoryInsertForm");
		categoryService.insertCategoryForm(category);
   
		return "redirect:selectCategoryList";
	}
	
	@RequestMapping(value = "/selectCategoryList", method = RequestMethod.GET)
	public String selectCategoryList(Model model, HttpServletRequest request) {
		logger.info("selectCategoryList");		
		
		
		List<Category> ListCategory = categoryService.selectCategoryList();
		
		/*int currentPage = 1;
		int pagePerRow = 10;
		
		if(request.getParameter("currentPage") != null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		Paging paging = new Paging(currentPage, pagePerRow);
		
		int offset = (paging.getCurrentPage()-1)* paging.getPagePerRow();*/
		
		
		model.addAttribute("ListCategory", ListCategory);
		
		return "categoryList";
	}  
	
	/*@RequestMapping(value = "/updateCategoryForm", method = RequestMethod.GET)
	public String updateCategoryForm(@RequestParam("categoryNo") int categoryNo, Model model) {
		logger.info("updateCategoryForm");
		Category category = categoryService.updateCategoryForm(categoryNo);		
		
		model.addAttribute("category", category);
		
		return "updateCategoryForm";  
	}  
	
	@RequestMapping(value = "/updateCategoryForm", method = RequestMethod.POST)
	public String updateCategoryForm(Category category) {
		logger.info("updateCategoryForm");
		categoryService.updateCategory(category);		

		return "redirect:selectCategoryList";
	} 
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam("categoryNo") int categoryNo) {
		logger.info("deleteCategory");
		categoryService.deleteCategory(categoryNo);		

		return "redirect:selectCategoryList";
	} */
}
