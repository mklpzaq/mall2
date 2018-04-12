package com.test.mall2.item.service;

import org.springframework.stereotype.Repository;

import com.test.mall2.category.service.Category;

@Repository
public class Item {
	private int itemNo;
	private int categoryNo;
	private String itemName;
	private String itemPrice;
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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
	
	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", categoryNo=" + categoryNo + ", itemName=" + itemName + ", itemPrice="
				+ itemPrice + "]";
	}
	
}
