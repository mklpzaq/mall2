package com.test.mall2.address.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mall2.IndexController;
import com.test.mall2.address.service.Address;
import com.test.mall2.address.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@RequestMapping(value="/insertAddress", method=RequestMethod.GET)
	public String insertAddress() {
		
		logger.info("insertAddress AddressController");
		
		//Address address = addressService.insertAddress();
		
		return "redirect:/";
	}
}
