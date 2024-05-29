package com.gonggu.member.model.dto;

public class MemberDTO {
	
	private int userNum;
	private String userId;
	private String userPwd;
	private String confirmPwd;
	private String userName;
	private String userAddr;
	private String nickName;
	private String phoneNum;
	private int duplicateId;
	private String phoneCheckNum;
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getDuplicateId() {
		return duplicateId;
	}
	public void setDuplicateId(int duplicateId) {
		this.duplicateId = duplicateId;
	}
	public String getPhoneCheckNum() {
		return phoneCheckNum;
	}
	public void setPhoneCheckNum(String phoneCheckNum) {
		this.phoneCheckNum = phoneCheckNum;
	}
	
	

}
