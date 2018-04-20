package com.test.mall2.member.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
	
	public List<Member> searchAll(String searchOption, ArrayList<String> keyword){
		
		logger.info("====searchOption=====");
		return memberDao.searchAll(searchOption,keyword);
	}
	
	public int deleteMember(int memberNo) {		
		return memberDao.deleteMember(memberNo);
	}
	
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}
	
	public Member selectMemberForUpdate(int memberNo) {
		return memberDao.selecMemberForUpdate(memberNo);		
	}
	
	public void terminateLoginSession(HttpSession session) {
		session.invalidate();
	}
	
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
		int lastPageMemberCnt = 0;
		if(0 == total){
			/* total이 0일 경우 즉, 아무것도 입력되지 않은 초기상태일경우.
			 * memberList.jsp에서 아무것도 없어도 페이지는 1페이지로 표시되어야 한다.
			 * 그렇기 때문에 DB에 아무것도 없는 상태에서는 lastPage를 1페이지로 설정한다.
			 * */
			lastPage = 1;
		}else if(total%pagePerRow == 0) {
			lastPage = total/pagePerRow;
		}else {
			lastPage = total/pagePerRow + 1;
			/* memberList.jsp에서 마지막페이지의 행을 10개로 두기 위해 (list에 들어있는 member의 수와 상관없이 두기위해) 
			 * lastPageMemberCnt값이 필요하다.
			 * */
			lastPageMemberCnt = total%pagePerRow;
		}
		//3
		//시작 페이지 정보 beginPageNumForCurrentPage
		/* 페이지 넘버를 5단위로 자를 경우 현재페이지(currentPage)에 대한 시작 페이지number를 구한다. */
		int temp = (currentPage - 1)/5;
		int beginPageNumForCurrentPage = temp * 5 + 1;
		
		
		
		//..
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("lastPageMemberCnt", lastPageMemberCnt);
		returnMap.put("beginPageNumForCurrentPage", beginPageNumForCurrentPage);
		
		
		return returnMap; 
	}
	
	public int addMember(Member member) {
		int row = memberDao.insertMember(member);
		return row;
	}	
	
	
}