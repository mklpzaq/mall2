package com.test.mall2.order.service;

import java.sql.Date;

public class Order {
	
	private int orderNo;
	private String memberId;
	private String categoryName;
	private String itemName;
	private int itemPrice;
	private Date orderDate;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", memberId=" + memberId + ", categoryName=" + categoryName + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + ", orderDate=" + orderDate + "]";
	}

}
