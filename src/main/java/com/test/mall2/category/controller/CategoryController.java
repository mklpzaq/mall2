package com.test.mall2.category.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.category.service.Category;
import com.test.mall2.category.service.CategoryService;


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
	public String selectCategoryList(Model model
											, HttpSession session
											,@RequestParam(value="currentPage", defaultValue="1") int currentPage
											,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow) {
		
		logger.info("pagePerRow");
	Map<String, Object> map = categoryService.selectCategoryList(currentPage,pagePerRow);
	model.addAttribute("list", map.get("list"));
	model.addAttribute("lastPage", map.get("lastPage"));
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("startPage", map.get("startPage"));
	model.addAttribute("endPage", map.get("endPage"));
	model.addAttribute("pagePerRow", pagePerRow);
		return "categoryList";
		
		
	}  
	
	@RequestMapping(value = "/updateCategoryForm", method = RequestMethod.GET)
	public String updateCategoryForm(Category category, Model model) {
		logger.info("updateCategoryForm");
		Category categoryForm = categoryService.updateCategoryForm(category);		
		
		model.addAttribute("categoryForm", categoryForm);
		
		return "updateCategoryForm";  
	}  
	
	@RequestMapping(value = "/updateCategoryForm", method = RequestMethod.POST)
	public String updateCategoryForm(Category category) {
		logger.info("updateCategoryForm");
		categoryService.updateCategory(category);		

		return "redirect:selectCategoryList";
	} 
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public String deleteCategory(Category category) {
		logger.info("deleteCategory");
		categoryService.deleteCategory(category);		

		return "redirect:selectCategoryList";
	} 
}
