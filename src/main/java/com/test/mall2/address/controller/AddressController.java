package com.test.mall2.address.controller;

import java.util.Map;

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
import com.test.mall2.member.service.Member;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

	
	@RequestMapping(value="/deleteAddress", method = RequestMethod.GET)
	public String updateMember(@RequestParam(value="sendNo") int addressNo){
		logger.info("deleteAddress GET");
		int result = addressService.deleteAddress(addressNo);
		return "redirect:/getAddressList";
	}
	
	@RequestMapping(value="/updateAddress", method = RequestMethod.GET)
	public String updateMember(Model model
								,@RequestParam(value="sendNo") int addressNo){
		logger.info("updateAddress GET");
		Address address = addressService.selectAddressForUpdate(addressNo);
		model.addAttribute("address", address);
		return "/updateAddressForm";
	}
	
	@RequestMapping(value="/updateAddress", method = RequestMethod.POST)
	public String updateMember(Address address){
		logger.info("updateAddress POST");
		int result = addressService.updateAddress(address);
		return "redirect:/getAddressList";
	}
	
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
		int result = addressService.insertAddress(address);
		return "redirect:/getAddressList";
	}
	
	/* searchSignal 값이 1이 넘어왔을 경우는 addressList에서 '검색버튼'을 누른 경우이다.
	 * 그리고 '검색버튼'을 누르지 않았을 겨우는 defaultValue값으로 0이 들어오게 설정하였다.
	 * searchSignal : 1 => '검색버튼'을 누름
	 * searchSignal : 0 => '검색버튼'을 누르지 아니함.
	 * 
	 * 그리고 searchWord의 defaultValue 값을 ""로 설정한 이유는 '검색버튼'을 누르지 않았을경우
	 * AddressList페이지에서 오류가 생기지 않게 하기 위해서 defaultValue값을 그렇게 설정하였다.
	 *  */
	@RequestMapping(value="/getAddressList", method=RequestMethod.GET)
	public String getAddressList(Model model
								,@RequestParam(value="currentPage", defaultValue="1") int currentPage
								,@RequestParam(value="pagePerRow", defaultValue="10", required=true) int pagePerRow
								,@RequestParam(value="searchSignal", defaultValue="0") int searchSignal
								,@RequestParam(value="searchSelect", defaultValue="") String searchSelect
								,@RequestParam(value="searchWord", defaultValue="") String searchWord) {
		logger.info("getAddressList AddressController");
		logger.info("searchSignal : " + searchSignal);
		logger.info("searchSelect : " + searchSelect);
		logger.info("searchWord : " + searchWord);
		
		Map<String, Object> map= addressService.getAddressList(currentPage, pagePerRow, searchSignal, searchSelect, searchWord);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("beginPageNumForCurrentPage", map.get("beginPageNumForCurrentPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerRow", pagePerRow);
		logger.info("list : "+ map.get("list"));
		logger.info("lastPage : "+ map.get("lastPage"));
		logger.info("beginPageNumForCurrentPage : "+ map.get("beginPageNumForCurrentPage"));
		logger.info("currentPage : "+ currentPage);
		logger.info("pagePerRow : "+ pagePerRow);	
		return "addressList";
	}
	
}

































