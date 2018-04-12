package com.test.mall2.item.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall2.category.service.CategoryService;

@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	public int insertItem(Item item) {
		logger.info("insertItem");
		int row = itemDao.insertItem(item);
		return row;
	}

}
