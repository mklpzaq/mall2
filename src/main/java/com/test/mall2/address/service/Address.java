package com.test.mall2.address.service;

public class Address {
	private int addressNo;
	private int memberNo;
	private String addressContent;
	
	public int getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getAddressContent() {
		return addressContent;
	}
	public void setAddressContent(String addressContent) {
		this.addressContent = addressContent;
	}
	@Override
	public String toString() {
		return "Address [addressNo=" + addressNo + ", memberNo=" + memberNo + ", addressContent=" + addressContent + "]";
	}
}
