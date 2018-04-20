package com.test.mall2.item.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.board.service.Board;
import com.test.mall2.category.service.Category;
import com.test.mall2.category.service.CategoryService;
import com.test.mall2.item.service.Item;
import com.test.mall2.item.service.ItemService;

@Controller
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired private ItemService itemService;
	@Autowired private CategoryService categoryService;
	
	//ItemController get호출
	//category의 모은 리스트를 가져와야 item의 리스트와 조인할 수 있다.
	@RequestMapping(value="/insertItemForm",  method = RequestMethod.GET)
	public String insertItemForm(Model model) {
		List<Category> list = categoryService.selectCategoryAllList();
		model.addAttribute("list", list);
		return "insertItemForm";
	}
	
	//ItmeController post호출
	@RequestMapping(value="/insertItemForm",  method = RequestMethod.POST)
	public String insertItemForm(Item item) {
		logger.info("insertItemForm");
		int row = itemService.insertItemForm(item);
		return "redirect:/selectItemList";
	}
	
	//selectItemList get호출
	@RequestMapping(value = "/selectItemList", method = RequestMethod.GET)
	public String selectItemList(Model model
											,@RequestParam(value="currentPage", defaultValue="1") int currentPage
											,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow
											,@RequestParam(value="searchOption", defaultValue="member_id") String searchOption
											,@RequestParam(value="keyword", defaultValue="") ArrayList<Object> keyword) {
		
		Map<String, Object> map = itemService.selectItemList(currentPage, pagePerRow, searchOption, keyword);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("keyword", "");	
		
		return "itemList";	
}
	//updateItemForm get
	@RequestMapping(value = "/updateItemForm", method = RequestMethod.GET)
	public String updateItemForm(Item item, Model model) {
		logger.info("updateItemForm-GET");
		List<Category> list = categoryService.selectCategoryAllList();
		Item itemForm = itemService.updateItemForm(item);
		model.addAttribute("list", list);
		model.addAttribute("itemForm", itemForm);
		return "updateItemForm";  
	}  
	
	//updateItemForm post
	@RequestMapping(value = "/updateItemForm", method = RequestMethod.POST)
	public String updateItemForm(Item item) {
		logger.info("updateItemForm-POST");
		itemService.updateItem(item);		
		return "redirect:/selectItemList";
	} 
	
	//deleteItem get
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public String deleteItem(@RequestParam(value="deleteCheckbox") int[] deleteCheckbox) {
		logger.info("deleteItem");
		itemService.deleteItem(deleteCheckbox);		

		return "redirect:/selectItemList";
	} 
	
	
	
	@RequestMapping(value ="/searchItemList", method = RequestMethod.GET)
	public String searchItemList(Model model											
									,@RequestParam(value="currentPage", defaultValue="1") int currentPage
									,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow
									,@RequestParam(value="searchOption", defaultValue="member_id") String searchOption
									,@RequestParam(value="keyword", defaultValue="") ArrayList<Object> keyword) {
		
		Map<String, Object> map = itemService.selectItemList(currentPage, pagePerRow, searchOption, keyword);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("pagePerRow", pagePerRow);
		model.addAttribute("searchOption", searchOption);
		if(keyword.size() == 1) {
			model.addAttribute("keyword", keyword.get(0));
		}else if(keyword.size() == 2) {
			model.addAttribute("keyword", keyword);
		}else{	
			model.addAttribute("keyword", "");	
		}
		
		return "itemList";
	}
	

}