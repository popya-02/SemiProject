package com.gonggu.admin.model.dto;

public class InformationDto {

	
	private int userNo;
	private String userName;
	private String userId;
	private String addr;
	private String indate;
	private String phoneNum;
	
	private int constructNo;
	private int copyNo;
	private String copyName;
	private String copyStartDate;
	private String copyAddr;
	
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getConstructNo() {
		return constructNo;
	}
	public void setConstructNo(int constructNo) {
		this.constructNo = constructNo;
	}
	
	public String getCopyName() {
		return copyName;
	}
	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}
	public int getCopyNo() {
		return copyNo;
	}
	public void setCopyNo(int copyNo) {
		this.copyNo = copyNo;
	}
	public String getCopyStartDate() {
		return copyStartDate;
	}
	public void setCopyStartDate(String copyStartDate) {
		this.copyStartDate = copyStartDate;
	}
	public String getCopyAddr() {
		return copyAddr;
	}
	public void setCopyAddr(String copyAddr) {
		this.copyAddr = copyAddr;
	}

	
	
	
	 
}
