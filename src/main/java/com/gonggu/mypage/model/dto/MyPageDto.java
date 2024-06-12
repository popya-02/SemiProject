package com.gonggu.mypage.model.dto;

public class MyPageDto {
	private int UserNo;
	private String UserId;
	private String name;
	private String address;
	private String nickName;
	private String phoneNum;
	
	private String CopyNo;
	private String CopyName;	
	private String TelNum;		// const tel
	private String CopyAddr;	// const addr
	private String Content;		
	private String ConstructArea;
	private int ConstructNo;
	
	
	private int CopyPictureNo;
	private String PictureName;
	private String PicturePath;
	
	// 견적서 요소 추가
	private String constructElement;
	private String constAddr;
	private String constStartDate;
	private String constEndDate;
	private int constRange;
	private String estimatePrice;
	private String sumPrice;
	private int chattingNum;
	private String constStatus;
	
	public MyPageDto() {
		super();
	}
	
	
	public MyPageDto(int userNo, String copyNo, String telNum, String constructElement, String constAddr,
			int constRange, String constStartDate, String constEndDate, String estimatePrice, String sumPrice, int chattingNum) {
		super();
		this.UserNo = userNo;
		this.CopyNo = copyNo;
		this.TelNum = telNum;
		this.constructElement = constructElement;
		this.constAddr = constAddr;
		this.constRange = constRange;
		this.constStartDate = constStartDate;
		this.constEndDate = constEndDate;
		this.estimatePrice = estimatePrice;
		this.sumPrice = sumPrice;
		this.chattingNum = chattingNum;
	}
	
	
	
	public MyPageDto(String constructElement, String constAddr, String constStartDate, String constEndDate,
			int constRange, String estimatePrice, String sumPrice, int chattingNum) {
		super();
		this.constructElement = constructElement;
		this.constAddr = constAddr;
		this.constStartDate = constStartDate;
		this.constEndDate = constEndDate;
		this.constRange = constRange;
		this.estimatePrice = estimatePrice;
		this.sumPrice = sumPrice;
		this.chattingNum = chattingNum;
	}


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
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
	
	public String getConstructElement() {
		return constructElement;
	}

	public void setConstructElement(String constructElement) {
		this.constructElement = constructElement;
	}
	public String getConstStartDate() {
		return constStartDate;
	}
	public void setConstStartDate(String constStartDate) {
		this.constStartDate = constStartDate;
	}
	public String getConstEndDate() {
		return constEndDate;
	}
	public void setConstEndDate(String constEndDate) {
		this.constEndDate = constEndDate;
	}
	public String getEstimatePrice() {
		return estimatePrice;
	}
	public void setEstimatePrice(String estimatePrice) {
		this.estimatePrice = estimatePrice;
	}
	public String getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getConstAddr() {
		return constAddr;
	}
	public void setConstAddr(String constAddr) {
		this.constAddr = constAddr;
	}

	public int getConstRange() {
		return constRange;
	}

	public void setConstRange(int constRange) {
		this.constRange = constRange;
	}

	public int getChattingNum() {
		return chattingNum;
	}

	public void setChattingNum(int chattingNum) {
		this.chattingNum = chattingNum;
	}


	public String getConstStatus() {
		return constStatus;
	}


	public void setConstStatus(String constStatus) {
		this.constStatus = constStatus;
	}


	
}
