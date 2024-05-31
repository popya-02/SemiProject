package com.gonggu.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/MypageInfo/*")
public class MyPageInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPageInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/copyInfo.do")) {
            String userNo = request.getParameter("userNo");
			
			MyPageServiceImpl myService = new MyPageServiceImpl();
			MyPageDtoImpl result = myService.getEditForm(userNo);
			
			request.setAttribute("result", result);
			nextPage = "/views/myPage/copyMyPageInfo.jsp";
			
		}else if(action.equals("/userInfo.do")) {
			String userNo = request.getParameter("userNo");
			
			MyPageServiceImpl myService = new MyPageServiceImpl();
			MyPageDtoImpl result = myService.getEditForm(userNo);
			
			request.setAttribute("result", result);
			nextPage = "/views/myPage/userMyPageInfo.jsp";
			
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
