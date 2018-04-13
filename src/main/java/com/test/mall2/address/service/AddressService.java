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
	
	public int getAddressList(int currentPage, int pagePerRow) {
		int beginRow = (currentPage-1)*pagePerRow;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Address> list = addressDao.selectAddressList(map);
		
		//total로 DB에 있는 전체 레코드 개수가 반환되었다.
		int total = addressDao.totalCountAddress();
		
		
		
		
		
		
		
		
		
		return 0;
	}
	
	public int insertAddress(Address address) {
		return addressDao.insertAddress(address);
	}
	
}
