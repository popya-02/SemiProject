package com.gonggu.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagnation;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/mypage/likecopy.do")
public class UserMyPageLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserMyPageLikeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int userNo = (int) session.getAttribute("userNum");
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		myDto.setUserNo(userNo);
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		// 전체 게시글 수
		int listCount = myService.getLikeListCount(myDto);
		
		// 보여질 페이지 수
		int pageLimit = 5;
		
		// 한페이지에 보여질 기시글 수
		int boardLimit = 5;
		
		PageInfo pi = Pagnation.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		// 게시글 목록 불러오기
		ArrayList<MyPageDtoImpl> likeList = myService.getLikeList(pi, myDto);

		// 게시글 번호 구하기
		int row = listCount - (cpage - 1) * boardLimit;
		
		// 게시글 목록을 jsp에게 전달해주기(데이터 바인딩)
		request.setAttribute("likeList", likeList);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/myPage/userMyPageLike.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	}
}
