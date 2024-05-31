package com.gonggu.common;

public class Pagination {
	public static PageInfo getPageInfo(int listCount,
									   int copypage,
									   	int pageLimit,
									   	int boardLimit) {
		// 전체 페이지 수 
		// listCount(총 게시글 수) / boardLimit(게시글 제한 수)
		// double 은 형변환을 통해 실수를 구할 수 있도혹 하기 위해 사용
		// Math.ceil : 소수점을 올림처리하기 위한 Math메서드
		// 정수가 필요하기 때문에 int 타입으로 형변환
		// ex) listCount=101, boardLimit = 5 일 때 maxPage = 21
		int maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		
		// pagination 바의 1, 2, 3 중에 1 처럼 첫번째 페이지의 수
		//ex) cPage = 16, pageLimit = 10;
		// 1. cPage - 1 = 15
		// 2. (cpage - 1) / pageLimit => 15 / 10 => 1(몫)
		// 3. (cpage - 1) / pageLimit * pageLimit => 1 * 10 => 10
		// 4. (cpage - 1) / pageLimit * pageLimit + 1 => 11
		int startPage = (copypage - 1) / pageLimit * pageLimit + 1;
		
		// ex) startPage = 11, pageLimit = 10
		// 1. 11 + 10 => 21
		// 2. 21- 1 => 20
		int endPage = startPage + pageLimit - 1;
		
		// 끝의 페이지가 최대 페이지를 넘어가지 않게 설정
		// endPage가 10인데 11을 요청하면 다시 끝페이지로 설정
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이지를 잘라서 가져오는 단위가 됨
		// ex) cPage = 16, boardLimit = 10
		// 1. (cpage - 1) => 15
		// 2. 15 * 10 => 150
		// DB에서 가져올 떄 150번째 튜플부터 10개를 가져오겠다는 뜻
		int offSet = (copypage - 1) * boardLimit;
		
		return new PageInfo(listCount, copypage, pageLimit, boardLimit, 
							maxPage, startPage, endPage, offSet);
	}
	
}
