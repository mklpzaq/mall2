package com.test.mall2.item.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall2.category.controller.CategoryController;
import com.test.mall2.item.service.Item;
import com.test.mall2.item.service.ItemService;

@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	ItemService itemService;
	
	//ItemController get호출
	@RequestMapping(value="/insertItemForm",  method = RequestMethod.GET)
	public String insertItemForm() {
		logger.info("ItemController get호출");
		return "insertItemForm";
	}
	
	@RequestMapping(value="/insertItemForm",  method = RequestMethod.POST)
	public String insertItemForm(Item item) {
		logger.info("ItemController post호출");
		itemService.insertItem(item);
		return "redirect:/insertItemForm";
	}
	
	
}
