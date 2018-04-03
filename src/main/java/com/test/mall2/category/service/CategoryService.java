package com.test.mall2.category.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.test.mall2.paging.Paging;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	public void insertCategoryForm(String categoryName) {	
		logger.info("insertCategoryForm");
		categoryDao.insertCategory(categoryName);
	}
	
	public void selectCategoryList(String currentPage) {	
		logger.info("selectCategoryList");
		
		int pagePerRow = 5;	//한페이지에 받을 최대 게시물 수. 그러니까 한페이지에서 보이는 마지막 게시글의 숫. 요청페이지에서 따로 정해 받을수도 있지만 지금은 그냥 정해둠
		int pageView = 5; //페이지 아래에서 보여지고 선택할수 있는 최대 페이지 숫자
		
		int currentPaging = 1;
		if(currentPage != null) {
			currentPaging = Integer.parseInt(currentPage);
		}
		
		int starRow = (currentPaging-1)*pagePerRow;  //selectTeacher메서드를 실행할때 어디부터 시작할지(어떤 게시글이 화면에 첫 게시글로 나올지) 정하는 변수
		ArrayList<Category> arrayCategory = categoryDao.selectCategory(starRow, pagePerRow); //입력받은 starRow번째부터 pagePerRow번 select 해주는 query문을 실행하는 메서드
		
		int totalRowCount = categoryDao.categoryRowCount();  //총게시물수을 구하는 count query을 실행하고 리턴값을 받는 메서드. 
		int totalPage = totalRowCount/pagePerRow; //총게시물수/한페이지에서 볼수 있는 게시글수 = 총페이지
		
		if(totalRowCount % pagePerRow != 0) {		//총게시글수가 총페이지에서 볼수 있는 게시글수보다 더 많을수도 있기 때문에 많드는 if문 
			totalPage++;							//총게시글수가 한페이지에서 볼수 잇는 게시글로 나누어 0으로 떨어지지 않으면 총페이지를 하나 더 만들어 남는 나머지 게시글을 추가로 보여준다
		}
		
		if(totalPage<currentPaging) {		//혹시 모를 잘못된 page 정보가 입력됐을경우 자동으로 최대page로 변환해주는 if문?
			currentPaging=totalPage;
		}
								
		int startPage = ((currentPaging - 1) / 5) * 5 + 1;  //page목록이 나올때 첫번째 page 숫자
		int endPage = startPage + pageView - 1; //page목록이 나올때 마지막 page숫자
		
		if(endPage>totalPage) {		//마지막 page목록의 숫자가 총page보다 클때 page목록숫자를 총페이지까지만 보여주게 바꾸는 if문
			endPage=totalPage;
		}
		
		/*model.addAttribute("arrayCategory", arrayCategory);
		model.addAttribute("currentPaging", currentPaging);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return model;*/
	}
	  
	public Category updateCategoryForm(int categoryNo)  {	
		logger.info("updateCategoryForm");
		Category category = categoryDao.updateCategoryForm(categoryNo);
		
		return category;  
	}
	
	public void updateCategory(Category category)  {	
		logger.info("updateCategory");
		categoryDao.updateCategory(category);
	 
	}
	
	public void deleteCategory(int categoryNo)  {	
		logger.info("deleteCategory");
		categoryDao.deleteCategory(categoryNo);
	 
	}

}
