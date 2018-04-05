package com.test.mall2.category.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.mall2.driver.DriverDB;
import com.test.mall2.category.service.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	final String SN = "com.test.mall2.category.service.CategoryMapper.";
	PreparedStatement preparedstatement;
	Connection connection;
	ResultSet resultset;
	
	
		
	public void insertCategory(Category category) {
		sqlsession.insert(SN+"insertCategory", category);		
	}
	
	public ArrayList<Category> selectCategory() {
		ArrayList<Category> arrayCategory = new ArrayList<Category>();	
		try {
			connection = DriverDB.driverConnection();
			
			preparedstatement = connection.prepareStatement("select * from category");			
			resultset = preparedstatement.executeQuery();
			
		
			
			while(resultset.next()) {
				Category category = new Category();
				category.setCategoryNo(resultset.getInt("category_no"));
				System.out.println(category.getCategoryNo()+"<-------selectCategory");
				category.setCategoryName(resultset.getString("category_name"));
				System.out.println(category.getCategoryName()+"<-------selectCategory");				
				arrayCategory.add(category);
				System.out.println(arrayCategory+"<----------arrayCategory");
			}
			return arrayCategory;
		}catch (SQLException ex) {
			ex.getStackTrace();
			System.out.println(ex.getMessage());	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			//if(resultset != null) try {resultset.close();} catch(SQLException ex) {}
			if(preparedstatement == null) try {preparedstatement.close();} catch(SQLException ex) {}
			if(connection == null) try {connection.close();} catch(SQLException ex) {}
		}
		return null;	
	}
	
	public int categoryRowCount() {
		//teacher���̺� �ִ� �ѰԽù��� select�ϰ� select�� ���ڸ�ŭ count�� �ް� �� count�� return���ִ� �޼����̴�
		//GetTeacherListController.java Ŭ���� ����� ȣ��Ǹ� �Էµ����ʹ� ����
		int Count = 0; //qurey������ Count���ڸ� ���� int�� ���� Count����
				
		try {
			connection = DriverDB.driverConnection();
			preparedstatement = connection.prepareStatement("select count(*) as count from category");	//teacher���̺��� select�ϰ� �� ���ڸ�								
			resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
			Count = resultset.getInt("count");
			}
			return Count;
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}		
		return 0;
	}
	
	
	/*public Category updateCategoryForm(int categoryNo){
		
		try {
			connection = DriverDB.driverConnection();
		preparedstatement = connection.prepareStatement("select * from category WHERE category_no=?");
		preparedstatement.setInt(1, categoryNo);
		resultset = preparedstatement.executeQuery();
		
		if(resultset.next()) {
			category = new Category();
			category.setCategoryNo(resultset.getInt("category_no"));
			category.setCategoryName(resultset.getString("category_name"));
		} 
			return category ;
			
		} catch (ClassNotFoundException classEX) {			
			classEX.printStackTrace();
		} catch (SQLException sqlEX) {			
			sqlEX.printStackTrace();
		} finally {
			if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
			if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
		}
		
		return null;
	}
	
	public void updateCategory(Category category) {
		try {
			connection = DriverDB.driverConnection();
			preparedstatement = connection.prepareStatement("UPDATE category SET category_name=? WHERE category_no=?");
			preparedstatement.setString(1, category.getCategoryName());
			preparedstatement.setInt(2, category.getCategoryNo());
			
			preparedstatement.executeUpdate();
			
			} catch (ClassNotFoundException classEX) {			
				classEX.printStackTrace();
			} catch (SQLException sqlEX) {			
				sqlEX.printStackTrace();
			} finally {
				if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
				if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
			}
	}
	
	public void deleteCategory(int categoryNo) {
		try {
			connection = DriverDB.driverConnection();
			preparedstatement = connection.prepareStatement("DELETE FROM category WHERE category_no=?");
			preparedstatement.setInt(1, categoryNo);
			preparedstatement.executeUpdate();
			
			} catch (ClassNotFoundException classEX) {			
				classEX.printStackTrace();
			} catch (SQLException sqlEX) {			
				sqlEX.printStackTrace();
			} finally {
				if(preparedstatement != null) try{preparedstatement.close();} catch(SQLException sqlEX) {}
				if(connection != null) try{connection.close();} catch(SQLException sqlEX) {}			
			}
	}*/
	
}
