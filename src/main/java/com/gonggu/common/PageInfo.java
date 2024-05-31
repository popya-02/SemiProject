package com.gonggu.common;

public class PageInfo {
	private int listCount;	// 전체 게시글 수
	private int copypage;	// 현재 페이지(currentPage)
	private int pageLimit; // 페이지 수
	private int boardLimit; // 한 페이지에 보여질 게시글 수
	
	private int maxPage;	// 전체 페이지 수
	private int startPage;	// 시작 페이지
	private int endPage;	// 끝 페이지
	
	private int offSet;

	
	
	public PageInfo(int listCount, int copypage, int pageLimit, int boardLimit, int maxPage, int startPage, int endPage,
			int offSet) {
		super();
		this.listCount = listCount;
		this.copypage = copypage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.offSet = offSet;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCopypage() {
		return copypage;
	}

	public void setCopypage(int copypage) {
		this.copypage = copypage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffSet() {
		return offSet;
	}

	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	
	
}
