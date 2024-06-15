package com.gonggu.chatting.model.dto;

public class ChattingDTO {
	private int chattingNum;
	private String chattingIndate;
	private int userNum;
	private String copyNum;
	private String message;

	private String endCheck;
	private String userType;

	private String copyName;
	private String userNickName;
	private String userId;
	private String userName;
	
	/**
	 * 예약금  
	 */
	private String estimatePrice;
	
	
	
	public int getChattingNum() {
		return chattingNum;
	}
	public void setChattingNum(int chattingNum) {
		this.chattingNum = chattingNum;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getCopyNum() {
		return copyNum;
	}
	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getChattingIndate() {
		return chattingIndate;
	}
	public void setChattingIndate(String chattingIndate) {
		this.chattingIndate = chattingIndate;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEndCheck() {
		return endCheck;
	}
	public void setEndCheck(String endCheck) {
		this.endCheck = endCheck;
	}
	public String getCopyName() {
		return copyName;
	}
	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getEstimatePrice() {
		return estimatePrice;
	}
	public void setEstimatePrice(String estimatePrice) {
		this.estimatePrice = estimatePrice;
	}
}
