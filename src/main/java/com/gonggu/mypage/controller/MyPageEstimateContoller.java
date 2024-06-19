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

import com.gonggu.admin.model.service.InformationImpl;
import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagination;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/MyPageEstimate/*")
public class MyPageEstimateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageEstimateContoller() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/EstimateUser.do")) {
			int userNo = (int) session.getAttribute("userNum");

			MyPageServiceImpl myService = new MyPageServiceImpl();
			
			MyPageDtoImpl myDto = new MyPageDtoImpl();
			myDto.setUserNo(userNo);
			
			int cpage = Integer.parseInt(request.getParameter("cpage"));
			
			// 전체 게시글 수
			int listCount = myService.getUserEstimateListCount(myDto);
			
			// 보여질 페이지 수
			int pageLimit = 5;
				
			// 한페이지에 보여질 기시글 수
			int boardLimit = 5;
			
			PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
			
			// 게시글 목록 불러오기
			ArrayList<MyPageDtoImpl> list = myService.getUserEstimateList(pi, myDto);
			
			// 게시글 번호 구하기
			int row = listCount - (cpage - 1) * boardLimit;
			
			// 게시글 목록을 jsp에게 전달해주기(데이터 바인딩)
			request.setAttribute("list", list);
			request.setAttribute("row", row);
			request.setAttribute("pi", pi);
			
			nextPage = "/views/myPage/userMyPageEstimate.jsp";
			
			
		}else if(action.equals("/EstimateCopy.do")) {
			String copyNo = (String) session.getAttribute("copyNum");
	        String approve = request.getParameter("approve");
			
			MyPageServiceImpl myService = new MyPageServiceImpl();
			
			MyPageDtoImpl myDto = new MyPageDtoImpl();
			myDto.setCopyNo(copyNo);
			
			InformationImpl infoService = new InformationImpl();
			int result2 = infoService.saveCopyStatus(copyNo, approve);
			
			int cpage = Integer.parseInt(request.getParameter("cpage"));
			
			// 전체 게시글 수
			int listCount = myService.getCopyEstimateListCount(myDto);
			
			// 보여질 페이지 수
			int pageLimit = 5;
			
			// 한페이지에 보여질 기시글 수
			int boardLimit = 5;
			
			PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
			
			// 게시글 목록 불러오기
			ArrayList<MyPageDtoImpl> list = myService.getCopyEstimateList(pi, myDto);
			
			// 게시글 번호 구하기
			int row = listCount - (cpage - 1) * boardLimit;
			
			
			if (result2 == 1) {
				// 승인 성공
	            session.setAttribute("approvalStatus", "B");   
	        } else {
	        	// 실패
	            session.setAttribute("approvalStatus", "A");
	        }
			
			// 게시글 목록을 jsp에게 전달해주기(데이터 바인딩)
			request.setAttribute("list", list);
			request.setAttribute("row", row);
			request.setAttribute("pi", pi);
			
			nextPage = "/views/myPage/copyMyPageEstimate.jsp";
		}
		
		if(nextPage != null && !nextPage.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);
		}else {
			response.sendRedirect("/views/errors.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
