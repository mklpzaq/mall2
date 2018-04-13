package com.test.mall2.item.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemDao itemDao;
		
	public int insertItem(Item item) {
		int row = itemDao.insertItem(item);
		return row;
	}
	
	
	public Map<String, Object> selectItemList(int currentPage, int pagePerRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int beginRow = (currentPage-1)*pagePerRow;
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

}
