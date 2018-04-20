package com.test.mall2.item.service;

import org.springframework.stereotype.Repository;

import com.test.mall2.category.service.Category;

@Repository
public class Item {
	private int itemNo;
	private String itemName;
	private String itemPrice;
	private String categoryName;
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getCategory() {
		return categoryName;
	}
	public void setCategory(String category) {
		this.categoryName = category;
	}
	
}