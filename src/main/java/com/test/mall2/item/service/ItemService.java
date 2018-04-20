package com.test.mall2.item.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.mall2.category.service.Category;
import com.test.mall2.category.service.CategoryService;


@Service
public class ItemService {
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

	@Autowired
	private ItemDao itemDao;
	
	// 게시글 전체 목록 ItemDao.listAll메서드 호출
	public List<Item> listAll(String searchOption, ArrayList<String> keyword) throws Exception {
		return itemDao.listAll(searchOption, keyword);
	}
		
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
	
	public Map<String, Object> selectItemList(int currentPage, int pagePerRow) {	
		logger.info("selectItemList");
		Map<String, Integer> map = new HashMap<String, Integer>();
		int beginRow = (currentPage-1)*pagePerRow; //페이지의 첫번째 행을 지정해줌
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Item> list = itemDao.selectItemList(map);
		
		int total = itemDao.totalCountItem();
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
	
	
