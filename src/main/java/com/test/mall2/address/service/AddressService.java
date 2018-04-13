package com.test.mall2.address.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall2.member.service.MemberService;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	public Map<String, Object> getAddressList(int currentPage, int pagePerRow) {
		int beginRow = (currentPage-1)*pagePerRow;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		logger.info("currentPage :" + currentPage);
		logger.info("beginRow :" + beginRow);
		logger.info("pagePerRow :" + pagePerRow);
		List<Address> list = addressDao.selectAddressList(map);
		System.out.println("==========================");
		System.out.println("list : " + list);
		
		//total로 DB에 있는 전체 레코드 개수가 반환되었다.
		int total = addressDao.totalCountAddress();
		int lastPage = 0;
		if(0 == total) {
			lastPage = 1;
		}else if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		int temp = (currentPage - 1)/5;
		int beginPageNumForCurrentPage = temp * 5 + 1;
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("beginPageNumForCurrentPage", beginPageNumForCurrentPage);
		
		
		return returnMap;
	}
	
	public int insertAddress(Address address) {
		return addressDao.insertAddress(address);
	}
	
}
