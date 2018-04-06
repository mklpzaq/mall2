package com.test.mall2.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Member getMemberById(Member member) {
		return memberDao.selectMemberById(member);
		
	}
	
	/* 맵에 넣어할 값이 List와 int이다,,  이럴 경우 모든 형을 받을 수 있는 Object형으로 넣어둔다. (다형성) */
	public Map<String, Object> getMemberList(int currentPage, int pagePerRow){
		//1
		Map<String, Integer> map = new HashMap<String, Integer>();
		//커런트 페이지, 페이지포로우를 가지고 beginRow를 뽑아내는 코드를 만들어야 한다.
		// currentPage, pagePerRow -> beginRow 알고리즘 설계 -> 코드
		int beginRow = (currentPage-1)*pagePerRow;
	
		
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Member> list =  memberDao.selectMemberList(map);
		//2
		int total = memberDao.totalCountMember();
		// total이라는 정보, pagePerRow정보를 가지고 -> lastPage를 구하는 알고리즘이 필요.
		int lastPage = 0;
		if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
		}
		
		
		//..
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		
		return returnMap; 
	}
	
	public int addMember(Member member) {
		int row = memberDao.insertMember(member);
		return row;
	}
	
	
}