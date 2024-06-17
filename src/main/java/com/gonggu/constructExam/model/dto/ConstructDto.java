package com.gonggu.constructExam.model.dto;

public class ConstructDto {
	private int fileNo; // 시공 사례 사진 번호
	private String filePath; // 시공 사례 사진 경로
	private String fileName; // 시공 사례 사진 이름
	private int constructList;
	private String copyNum; // 업체 번호
	private String copyName; // 업체 이름
	private String title; // 시공사례 제목
	private String content; // 시공사례 내용
	private String tagRemoveContent; // 시공사례 내용
	private String indate;  // 작성일
	private String update;  // 수정일
	private String delete;
	private int constructNo; // 시공 번호
	private int categoryNo; // 카테고리 번호
	private String constructAddr; // 시공지 주소
	private String constructRange; // 시공평수
	private String constructPrice; // 시공 가격
	private String constructStartDate; // 시공 시작일
	private String constructEndDate; // 시공 종료일
	private String category; // 카테고리
	private int examNo;
	private String deleteStatus;
	private String deleteDate;
	private String uploadDirectory;
	private int userNum;

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUploadDirectory() {
		return uploadDirectory;
	}

	public void setUploadDirectory(String uploadDirectory) {
		this.uploadDirectory = uploadDirectory;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}

	public int getConstructList() {
		return constructList;
	}

	public void setConstructList(int constructList) {
		this.constructList = constructList;
	}

	public int getExamNo() {
		return examNo;
	}

	public void setExamNo(int examNo) {
		this.examNo = examNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getConstructNo() {
		return constructNo;
	}

	public void setCopyNum(String copyNum) {
		this.copyNum = copyNum;
	}

	public void setConstructNo(int constructNo) {
		this.constructNo = constructNo;
	}

	public String getConstructStartDate() {
		return constructStartDate;
	}

	public void setConstructStartDate(String constructStartDate) {
		this.constructStartDate = constructStartDate;
	}

	public String getConstructEndDate() {
		return constructEndDate;
	}

	public void setConstructEndDate(String constructEndDate) {
		this.constructEndDate = constructEndDate;
	}

	public String getConstructAddr() {
		return constructAddr;
	}

	public void setConstructAddr(String constructAddr) {
		this.constructAddr = constructAddr;
	}

	public String getConstructRange() {
		return constructRange;
	}

	public void setConstructRange(String constructRange) {
		this.constructRange = constructRange;
	}

	public String getConstructPrice() {
		return constructPrice;
	}

	public void setConstructPrice(String constructPrice) {
		this.constructPrice = constructPrice;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCopyNum() {
		return copyNum;
	}

	public void setCopyNo(String copyNum) {
		this.copyNum = copyNum;
	}

	public String getCopyName() {
		return copyName;
	}

	public void setCopyName(String copyName) {
		this.copyName = copyName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTagRemoveContent() {
		return tagRemoveContent;
	}
	public void setTagRemoveContent(String tagRemoveContent) {
		this.tagRemoveContent = tagRemoveContent;
	}
}
