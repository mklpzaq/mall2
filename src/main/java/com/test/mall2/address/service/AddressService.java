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
	
	public int deleteAddress(int addressNo) {
		return addressDao.deleteAddress(addressNo);
	}
	
	public int updateAddress(Address address) {
		return addressDao.updateAddress(address);
	}
	
	public Address selectAddressForUpdate(int addressNo) {
		return addressDao.selectAddressForUpdate(addressNo);
	}
	
	public Map<String, Object> getAddressList(int currentPage, int pagePerRow, int searchSignal, String searchSelect, String searchWord) {
		int beginRow = (currentPage-1)*pagePerRow;
		
		/*Map<String, Integer> map = new HashMap<String, Integer>();*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		
		/* searchSignal : 1 일경우 '검색버튼'을 누른경우가 되므로 
		 * selectAddressList() 메서드를 사용하여 list를 가져올때,
		 * searchWord와 일치하는 레코드 부분만 list에 저장하게 만들어 주어야 한다.
		 * 그러기 위해서는 searchWord 값 정보와
		 * searchSignal 정보에 따른 분기가 필요할지 모르므로 map에 넣어준다. 
		 * */
		if(1 == searchSignal) {
			map.put("searchSignal", searchSignal);
			map.put("searchSelect", searchSelect);
			map.put("searchWord", searchWord);
		}
		
		logger.info("currentPage :" + currentPage);
		logger.info("beginRow :" + beginRow);
		logger.info("pagePerRow :" + pagePerRow);
		
		
		List<Address> list = addressDao.selectAddressList(map);
		if(1 == searchSignal) {
			list = addressDao.selectSearchAddressList(map);
		}
		
		
		//total로 DB에 있는 전체 레코드 개수가 반환되었다.
		int total = addressDao.totalCountAddress();
		int lastPage = 0;
		/* DB에 address 레코드 수가 1개도 존재하지 않는 경우 == 초기상태일때, 1페이지로 나오게 lastPage를 1로 초기화 한다.*/
		if(0 == total) {
			lastPage = 1;
		}else if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		/* 페이지가 5개 단위씩 보이게 하는 계산식 */
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
