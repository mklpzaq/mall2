package com.test.mall2.item.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.mall2.category.controller.CategoryController;
import com.test.mall2.category.service.Category;
import com.test.mall2.item.service.Item;
import com.test.mall2.item.service.ItemService;

@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private ItemService itemService;
	
	//ItemController get호출
	@RequestMapping(value="/insertItemForm",  method = RequestMethod.GET)
	public String insertItemForm() {
		return "insertItemForm";
	}
	
	//ItmeController post호출
	@RequestMapping(value="/insertItemForm",  method = RequestMethod.POST)
	public String insertItemForm(Item item) {
		logger.info("ItemController---insertItemForm");
		itemService.insertItemForm(item);
		return "redirect:/selectItemList";
	}
	
	//selectItemList get호출
	@RequestMapping(value = "/selectItemList", method = RequestMethod.GET)
	public String selectCategoryList(Model model
											,@RequestParam(value="currentPage", defaultValue="1") int currentPage
											,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow) {
		
		logger.info("selectItemList");
		Map<String, Object> map = itemService.selectItemList(currentPage,pagePerRow);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("pagePerRow", pagePerRow);
		return "itemList";	
	}  
	
	
	//updateItemForm get
	@RequestMapping(value = "/updateItemForm", method = RequestMethod.GET)
	public String updateCategoryForm(Item item, Model model) {
		logger.info("updateItemForm-GET");
		Item itemForm = itemService.updateItemForm(item);		
		model.addAttribute("itemForm", itemForm);
		return "updateItemForm";  
	}  
	
	//updateItemForm post
	@RequestMapping(value = "/updateItemForm", method = RequestMethod.POST)
	public String updateItemForm(Item item) {
		logger.info("updateItemForm-POST");
		itemService.updateItemForm(item);		
		return "redirect:selectItemList";
	} 
	
	//deleteItem get
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public String deleteCategory(@RequestParam(value="deleteCheckbox") int[] deleteCheckbox) {
		logger.info("deleteItem");
		itemService.deleteItem(deleteCheckbox);		

		return "redirect:selectItemList";
	} 
	
}