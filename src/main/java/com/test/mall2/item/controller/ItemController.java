package com.test.mall2.item.controller;

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

import com.test.mall2.item.service.Item;
import com.test.mall2.item.service.ItemDao;
import com.test.mall2.item.service.ItemService;

@Controller
public class ItemController {
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
		itemService.insertItem(item);
		return "redirect:/selectItemList";
	}
	
	@RequestMapping(value = "/selectItemList", method = RequestMethod.GET)
	public String selectItemList(Model model
											,@RequestParam(value="currentPage", defaultValue="1") int currentPage
											,@RequestParam(value="pagePerRow", required=true, defaultValue="10") int pagePerRow) {
		
	Map<String, Object> map = itemService.selectItemList(currentPage,pagePerRow);
	model.addAttribute("list", map.get("list"));
	model.addAttribute("lastPage", map.get("lastPage"));
	model.addAttribute("currentPage", currentPage);
	model.addAttribute("startPage", map.get("startPage"));
	model.addAttribute("endPage", map.get("endPage"));
	model.addAttribute("pagePerRow", pagePerRow);
		return "itemList";		
	}  
	
}
