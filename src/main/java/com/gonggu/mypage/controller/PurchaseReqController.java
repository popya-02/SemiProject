package com.gonggu.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/purchaseReq.do")
public class PurchaseReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseReqController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int chattingNo = Integer.parseInt(request.getParameter("chattingNum"));
		String estimatePrice = request.getParameter("estimatePrice");
		System.out.println(chattingNo);
		System.out.println(estimatePrice);
		
		HttpSession session = request.getSession();
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		int result = myService.savePurchaseStatus(chattingNo); // 0
		System.out.println("asqwqw" + result);
		
		if(result == 1) {
			session.setAttribute("purchaseStatus", "Y");
			response.sendRedirect("/MypageInfo/ChattingList.do");
		} else {
			session.setAttribute("purchaseStatus", "N");
			response.sendRedirect("/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		
	
		
		
		
		
		
	}

}
