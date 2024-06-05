package com.gonggu.common;



public class Pagnation {

	public static PageInfo getPageInfo(int listCount,
									   int cpage,
									   int pageLimit,  
									   int boardLimit) {


		int maxPage = (int)(Math.ceil((double)listCount/boardLimit));


		int startPage = (cpage-1) / pageLimit * pageLimit + 1;

		int endPage = startPage + pageLimit -1;


		if	(endPage > maxPage) {
			endPage = maxPage;
		}


		int offset = (cpage-1) * boardLimit;


		return new PageInfo(listCount, cpage, pageLimit, 
				boardLimit, maxPage, startPage, endPage, offset);
	}

}
