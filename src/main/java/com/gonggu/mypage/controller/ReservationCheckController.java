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

import com.gonggu.mypage.model.dto.MyPageDto;
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
		
//		int userNo = Integer.parseInt(request.getParameter("userNo"));
//		int userNo = (int) session.gsetAttribute("userNum");
//		int constructNum = (int) session.getAttribute("constructNum");
		
		String copyNo = request.getParameter("copyNo");
		int constructNo = Integer.parseInt( request.getParameter("constructNum"));
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		
		/**
		 * =======user========
		 * userNo 가져와서 페이지 보여주기
		 * copyNo 으로 업체에 대한 정보 가져오고 
		 * 확인 페이지 들어기기 
		 * 어떻게? 
		 * =======copy=========
		 * copyNo 가져와서 해당 페이지 보여주기
		 * userNo으로 예약 정보 불러오기
		 * 확인페이지 들어가기
		 * controller를 두개를 만들어야되나 
		 * jsp 가 다르니까 그게 나을지도....?
		 */
		
		
		MyPageDtoImpl result = myService.reserveCheck(constructNo);
		
		
		
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/myPage/reservationCheck.jsp"); 
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
