package com.gonggu.member.model.dto;

public class MemberDTO {
	
	private int userNum;
	private String userId;
	private String userPwd;
	private String userName;
	private String userAddr;
	private String nickName;
	private String phoneNum;
	private int duplicateId;
	
	private String userType;
	
	private String copyNum;	// 사업자등록번호 id
	private String copyPwd;
	private String copyName;
	private String copyCeoName;
	private String copyAddr;
	private String copyArea;
	private String copyTelNum;
	
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCopyNum() {
		return copyNum;
	}
	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}
	public String getCopyName() {
		return copyName;
	}
	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}
	public String getCopyPwd() {
		return copyPwd;
	}
	public void setCopyPwd(String copyPwd) {
		this.copyPwd = copyPwd;
	}
	public String getCopyAddr() {
		return copyAddr;
	}
	public void setCopyAddr(String copyAddr) {
		this.copyAddr = copyAddr;
	}
	public String getCopyArea() {
		return copyArea;
	}
	public void setCopyArea(String copyArea) {
		this.copyArea = copyArea;
	}
	public String getCopyTelNum() {
		return copyTelNum;
	}
	public void setCopyTelNum(String copyTelNum) {
		this.copyTelNum = copyTelNum;
	}
	public String getCopyCeoName() {
		return copyCeoName;
	}
	public void setCopyCeoName(String copyCeoName) {
		this.copyCeoName = copyCeoName;
	}
	
	
}
