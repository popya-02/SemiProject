package com.gonggu.search.model.dto;

public class SearchDto {
	private String CopyNo;
	private String CopyName;
	private String PictureName;
	private int ConstructNo;
	private int ExamNo;
	private String ExamTitle;
	private String ExamPictureName;
	private String ExamContent;
	private int CategoryNo;
	private String CategoryName;
	private String PicturePath;
	private String ExamPicturePath;
	private String TagRemoveContent;
	
	
	
	public String getTagRemoveContent() {
		return TagRemoveContent;
	}
	public void setTagRemoveContent(String tagRemoveContent) {
		TagRemoveContent = tagRemoveContent;
	}
	public String getPicturePath() {
		return PicturePath;
	}
	public void setPicturePath(String picturePath) {
		PicturePath = picturePath;
	}
	public String getExamPicturePath() {
		return ExamPicturePath;
	}
	public void setExamPicturePath(String examPicturePath) {
		ExamPicturePath = examPicturePath;
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
	public String getPictureName() {
		return PictureName;
	}
	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}
	public int getConstructNo() {
		return ConstructNo;
	}
	public void setConstructNo(int constructNo) {
		ConstructNo = constructNo;
	}
	public int getExamNo() {
		return ExamNo;
	}
	public void setExamNo(int examNo) {
		ExamNo = examNo;
	}
	public String getExamTitle() {
		return ExamTitle;
	}
	public void setExamTitle(String examTitle) {
		ExamTitle = examTitle;
	}
	public String getExamPictureName() {
		return ExamPictureName;
	}
	public void setExamPictureName(String examPictureName) {
		ExamPictureName = examPictureName;
	}
	public String getExamContent() {
		return ExamContent;
	}
	public void setExamContent(String examContent) {
		ExamContent = examContent;
	}
	public int getCategoryNo() {
		return CategoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		CategoryNo = categoryNo;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return "SearchDto [CopyNo=" + CopyNo + ", CopyName=" + CopyName + ", PictureName=" + PictureName
				+ ", ConstructNo=" + ConstructNo + ", ExamNo=" + ExamNo + ", ExamTitle=" + ExamTitle
				+ ", ExamPictureName=" + ExamPictureName + ", ExamContent=" + ExamContent + ", CategoryNo=" + CategoryNo
				+ ", CategoryName=" + CategoryName + "]";
	}
	
	
}
