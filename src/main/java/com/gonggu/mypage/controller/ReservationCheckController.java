package com.gonggu.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/reserveCheck.do")
public class ReservationCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationCheckController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		System.out.println("aaaaaaaaaaa");
//		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int userNo = (int) session.getAttribute("userNum");
		String copyNo = request.getParameter("copyNo");
	 	System.out.println(userNo);
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		
		/**
		 * userNo 가져와서 페이지 보여주기
		 * copyNo 으로 업체에 대한 정보 가져오고 
		 * 확인 페이지 들어기기 
		 * 어떻게? 
		 */
		
		int result = myService.reserveCheck(userNo);
		
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/myPage/reservationCheck.jsp"); 
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
