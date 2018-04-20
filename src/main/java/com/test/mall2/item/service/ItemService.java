package com.test.mall2.item.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ItemService {
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

	@Autowired
	private ItemDao itemDao;
	
	
	public void deleteItem(int[] deleteCheckbox) {	
		logger.info("deleteItem");
		for(int i = 0; i<deleteCheckbox.length; i++) {
			int itemNo = deleteCheckbox[i];
			itemDao.deleteItem(itemNo);
	}
	}
	
	public int updateItem(Item item)  {	
		logger.info("updateItem");
		return itemDao.updateItem(item);
	}
	
	public Item updateItemForm(Item item) {
		logger.info("updateItemForm");
		return itemDao.updateItemForm(item);
	}
	
	public Map<String, Object> selectItemList(int currentPage, int pagePerRow, String searchOption, ArrayList<Object> keyword) {	
		logger.info("selectItemList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Item> list;
		int total;
		int beginRow = (currentPage-1)*pagePerRow; //페이지의 첫번째 행을 지정해줌
		if(keyword.size() == 1) {
			map.put("beginRow", beginRow);
			map.put("pagePerRow", pagePerRow);
			map.put("searchOption", searchOption);
			map.put("keyword", keyword.get(0));
			list = itemDao.selectItemList(map);	
			total = itemDao.totalCountItem(map);
		}else {
			map.put("beginRow", beginRow);
			map.put("pagePerRow", pagePerRow);
			map.put("searchOption", searchOption);		
			list = itemDao.selectItemList(map);
			total = itemDao.totalCountItem(map);
		}	
		
		int lastPage =0;
		if(total%pagePerRow ==0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		int pageView = 5;
		int startPage = ((currentPage-1)/5)*5+1; //페이지 목록이 새로 나올 때, 첫번째로 뜨는 페이지 숫자
		int endPage = startPage + pageView -1; //페이지 목록이 새로 나올 때, 마지막으로 뜨는 페이지 숫자
		if(endPage>lastPage) {
			endPage=lastPage;
		}
		
		Map<String, Object> returnmap = new HashMap<String, Object>();
		returnmap.put("list", list);
		returnmap.put("lastPage", lastPage);
		returnmap.put("startPage", startPage);
		returnmap.put("endPage", endPage);
		
		return returnmap;
	}
	
	public int insertItemForm(Item item) {
		logger.info("insertItemForm");
		int row = itemDao.insertItem(item);
		return row;
	}
}
	
	
