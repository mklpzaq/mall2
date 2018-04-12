package com.test.mall2.item.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	public int insertItem(Item item) {
		int row = itemDao.insertItem(item);
		return row;
	}

}
