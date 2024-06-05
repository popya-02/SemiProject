package com.gonggu.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagination;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/mypage/likecopy.do")
public class UserMyPageLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserMyPageLike() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		int likeNo = Integer.parseInt(request.getParameter("likeno"));
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		String category = request.getParameter("category");

		MyPageServiceImpl myService = new MyPageServiceImpl();
		MyPageDtoImpl result = myService.getLikeCopy(likeNo);

		// 전체 게시글 수
		int listCount = myService.getLikeListCount(category);

		// 보여질 페이지 수
		int pageLimit = 5;

		// 한페이지에 보여질 기시글 수
		int boardLimit = 5;

		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);

		// 게시글 목록 불러오기
		ArrayList<MyPageDtoImpl> list = myService.getlikeList(pi, category);

		// 게시글 번호 구하기
		int row = listCount - (cpage - 1) * boardLimit;

		// 출력확인용
//				for(FreeDtoImpl item : list) {
//					System.out.println(item.getBoardTitle());
//				}

		// 게시글 목록을 jsp에게 전달해주기(데이터 바인딩)
		request.setAttribute("list", list);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);

		RequestDispatcher view = request.getRequestDispatcher("/views/myPage/userMyPageLike.jsp");
		view.forward(request, response);

//	    if(result == 1) {
//			response.sendRedirect("/mypage/likecopy.do?likeNo="+likeNo);
	}
}
