package com.test.mall2.address.service;

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
	
	public Address insertAddress() {
		
		//addressDao.insertAddress();
		
		return null;
	}
	
}
