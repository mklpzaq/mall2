package com.test.mall2.member.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.mall2.IndexController;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public void insertService(Member member) {
		memberDao.insertMember(member);
	}
	
	public ArrayList<Member> selectService(){
		ArrayList<Member> list = memberDao.selectMember();
		return list;
	}
}
