package com.test.mall2.address.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall2.member.service.MemberDao;

@Repository
public class AddressDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(AddressDao.class);
	final String NS ="com.test.mall2.address.service.AddressMapper.";
	
	public int deleteAddress(int addressNo) {
		return sqlSession.delete(NS+"deleteAddress", addressNo);
	}
	
	public int updateAddress(Address address) {
		return sqlSession.update(NS+"updateAddress", address);
	}
	
	public Address selectAddressForUpdate(int addressNo) {
		return sqlSession.selectOne(NS+"selectAddressForUpdate", addressNo);
	}
	
	public int totalCountAddress() {
		return sqlSession.selectOne(NS+"totalCountAddress");
	}
	
	public List<Address> selectSearchAddressList(Map<String, Object> map){
		return null;
	}
	
	public List<Address> selectAddressList(Map<String, Object> map){
		return sqlSession.selectList(NS+"selectAddressList", map);
	}
	
	public int insertAddress(Address address) {
		int row = sqlSession.insert(NS+"insertAddress", address);
		return row;
	}
}
