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
				
		int pagePerRow = 5;	//���������� ���� �ִ� �Խù� ��. �׷��ϱ� ������������ ���̴� ������ �Խñ��� ��. ��û���������� ���� ���� �������� ������ ������ �׳� ���ص�
		int pageView = 5; //������ �Ʒ����� �������� �����Ҽ� �ִ� �ִ� ������ ����
		
		int currentPaging = 1;
		if(currentPage != null) {
			currentPaging = Integer.parseInt(currentPage);
		}
		
		/*int starRow = (currentPaging-1)*pagePerRow;  //selectTeacher�޼��带 �����Ҷ� ������ ��������(� �Խñ��� ȭ�鿡 ù �Խñ۷� ������) ���ϴ� ����
		ArrayList<Category> arrayCategory = categoryDao.selectCategory(starRow, pagePerRow); //�Է¹��� starRow��°���� pagePerRow�� select ���ִ� query���� �����ϴ� �޼���
		
		int totalRowCount = categoryDao.categoryRowCount();  //�ѰԽù����� ���ϴ� count query�� �����ϰ� ���ϰ��� �޴� �޼���. 
		int totalPage = totalRowCount/pagePerRow; //�ѰԽù���/������������ ���� �ִ� �Խñۼ� = ��������
		
		if(totalRowCount % pagePerRow != 0) {		//�ѰԽñۼ��� ������������ ���� �ִ� �Խñۼ����� �� �������� �ֱ� ������ ����� if�� 
			totalPage++;							//�ѰԽñۼ��� ������������ ���� �մ� �Խñ۷� ������ 0���� �������� ������ ���������� �ϳ� �� ����� ���� ������ �Խñ��� �߰��� �����ش�
		}
		
		if(totalPage<currentPaging) {		//Ȥ�� �� �߸��� page ������ �Էµ������ �ڵ����� �ִ�page�� ��ȯ���ִ� if��?
			currentPaging=totalPage;
		}
								
		int startPage = ((currentPaging - 1) / 5) * 5 + 1;  //page����� ���ö� ù��° page ����
		int endPage = startPage + pageView - 1; //page����� ���ö� ������ page����
		
		if(endPage>totalPage) {		//������ page����� ���ڰ� ��page���� Ŭ�� page��ϼ��ڸ� �������������� �����ְ� �ٲٴ� if��
			endPage=totalPage;
		}*/
		
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
