package com.gonggu.mypage.model.dto;

public class MyPageDto {
	private int UserNo;
	private String UserId;
	private String name;
	private String address;
	private String nickName;
	
	private String CopyNo;
	private String CopyName;
	private String TelNum;
	private String CopyAddr;
	private String Content;
	private String ConstructArea;
	private int ConstructNo;
	
	private int CopyPictureNo;
	private String PictureName;
	private String PicturePath;
	
	private int LikeNo;
	
	public int getLikeNo() {
		return LikeNo;
	}
	public void setLikeNo(int likeNo) {
		LikeNo = likeNo;
	}
	public int getCopyPictureNo() {
		return CopyPictureNo;
	}
	public void setCopyPictureNo(int copyPictureNo) {
		CopyPictureNo = copyPictureNo;
	}
	public String getPictureName() {
		return PictureName;
	}
	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}

	public String getPicturePath() {
		return PicturePath;
	}
	public void setPicturePath(String picturePath) {
		PicturePath = picturePath;
	}
	public int getConstructNo() {
		return ConstructNo;
	}
	public void setConstructNo(int constructNo) {
		ConstructNo = constructNo;
	}
	
	public int getUserNo() {
		return UserNo;
	}
	
	public void setUserNo(int userNo) {
		UserNo = userNo;
	}

	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCopyNo() {
		return CopyNo;
	}
	public void setCopyNo(String copyNo) {
		CopyNo = copyNo;
	}
	public String getCopyName() {
		return CopyName;
	}
	public void setCopyName(String copyName) {
		CopyName = copyName;
	}
	public String getTelNum() {
		return TelNum;
	}
	public void setTelNum(String telNum) {
		TelNum = telNum;
	}
	public String getCopyAddr() {
		return CopyAddr;
	}
	public void setCopyAddr(String copyAddr) {
		CopyAddr = copyAddr;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getConstructArea() {
		return ConstructArea;
	}
	public void setConstructArea(String constructArea) {
		ConstructArea = constructArea;
	}
	
	
}
