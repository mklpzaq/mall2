package com.test.mall2.address.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mall2.IndexController;
import com.test.mall2.address.service.Address;
import com.test.mall2.address.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	@RequestMapping(value="/insertAddress", method=RequestMethod.GET)
	public String insertAddress(Model model
								,@RequestParam(value="sendNo") int memberNo) {
		logger.info("insertAddress AddressController");
		model.addAttribute("memberNo", memberNo);
		return "insertAddressForm";
	}
	
	@RequestMapping(value="/insertAddress", method=RequestMethod.POST)
	public String insertAddress(Address address) {
		logger.info("insertAddress AddressController");
		logger.info("memberNo : " + address.getMemberNo());
		logger.info("addressContent : " + address.getAddressContent());
		
		int result = addressService.insertAddress(address);
		
		return "redirect:/getAddressList";
	}
	
	@RequestMapping(value="/getAddressList", method=RequestMethod.GET)
	public String getAddressList(Model model
								,@RequestParam(value="currentPage", defaultValue="1") int currentPage
								,@RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow) {
		logger.info("getAddressList AddressController");
		
		addressService.getAddressList(currentPage, pagePerRow);
		
		return "addressList";
	}
	
}

































