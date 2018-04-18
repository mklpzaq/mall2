package com.test.mall2.order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall2.board.service.Board;
import com.test.mall2.member.service.Member;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	public void insertOrder(Member loginMember, int itemNo) {
		
		int loginMemberNo = loginMember.getMemberNo();
		
		Map<String, Integer> map= new HashMap<String, Integer>();
		
		map.put("loginMemberNo", loginMemberNo);
		map.put("itemNo", itemNo);
		
		orderDao.insertOrder(map);
	}
	
	public Map orderList(int currentPage, int pagePerRow) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int beginRow = (currentPage-1)*pagePerRow;
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		Map<String, String> map2  = orderDao.selectOrderList(map);
		
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
		returnmap.put("map2", map2);
		returnmap.put("lastPage", lastPage);
		returnmap.put("startPage", startPage);
		returnmap.put("endPage", endPage);
		return returnmap;		
	}
	
	
}
