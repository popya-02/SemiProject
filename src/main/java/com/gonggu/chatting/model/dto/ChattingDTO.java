package com.gonggu.chatting.model.dto;

public class ChattingDTO {
	private int chattingNum;
	private int userNum;
	private String userType;
	private String copyNum;
	private String message;
	private String chattingIndate;
	
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
	
	
}
