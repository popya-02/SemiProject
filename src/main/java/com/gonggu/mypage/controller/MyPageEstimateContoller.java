package com.gonggu.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.admin.model.service.InformationImpl;
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
			MyPageDtoImpl result = myService.getUserEstimate(userNo);
			
			request.setAttribute("result", result);
			
			nextPage = "/views/myPage/userMyPageEstimate.jsp";
			
			
		}else if(action.equals("/EstimateCopy.do")) {
			String copyNo = (String) session.getAttribute("copyNum");
	        String approve = request.getParameter("approve");

			
			
			MyPageServiceImpl myService = new MyPageServiceImpl();
			MyPageDtoImpl result = myService.getCopyEstimate(copyNo);
			
			InformationImpl infoService = new InformationImpl();
			int result2 = infoService.saveCopyStatus(copyNo, approve);
			
			if (result2 == 1) {
	            session.setAttribute("approvalStatus", "B");
	            System.out.println(result);
	        } else {
	            session.setAttribute("approvalStatus", "A");
	        }
			request.setAttribute("result", result);
			
			 
			nextPage = "/views/myPage/copyMyPageEstimate.jsp";
			System.out.println(nextPage);
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
