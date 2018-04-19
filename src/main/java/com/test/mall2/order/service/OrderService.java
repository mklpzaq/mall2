package com.test.mall2.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall2.member.service.Member;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public void insertOrder(Member loginMember, int itemNo) {
		
		logger.info("insertOrder");
		int loginMemberNo = loginMember.getMemberNo();
		
		Map<String, Integer> map= new HashMap<String, Integer>();
		
		map.put("loginMemberNo", loginMemberNo);
		map.put("itemNo", itemNo);
		
		orderDao.insertOrder(map);
	}
	
	public Map<String, Object> orderList(int currentPage, int pagePerRow, String searchOption, ArrayList<String> keyword) {
		logger.info("orderList");
		Map<String, Object> map = new HashMap<String, Object>();
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		List<Object> list = orderDao.selectOrderList(map);
		
		String k = (String) list.get(0);
		logger.info(k);
		
		
		int total = orderDao.totalCountBoard();
		int lastPage = 0;
		if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		int pageView = 5;
		int startPage = ((currentPage-1)/5)*5+1; 
		int endPage = startPage + pageView -1; 
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
