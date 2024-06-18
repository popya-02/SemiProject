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
		
		
		int constructNo = Integer.parseInt( request.getParameter("constructNum"));
		System.out.println("constNo: " + constructNo);
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		
		MyPageDtoImpl result = myService.reserveCheck(constructNo);
		
		
		HttpSession session = request.getSession();
		int result1 = myService.savePurchaseStatus(constructNo);
		// TODO : 눌렀을떄 작동할코드 
		
		if(result1 == 1) {
			session.setAttribute("purchaseStatus", "S");
		} else {
			session.setAttribute("purchaseStatus", "F");
		}
		
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/myPage/reservationCheck.jsp"); 
		dispatcher.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
