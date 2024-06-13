package com.gonggu.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/purchaseReq.do")
public class PurchaseReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseReqController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int chattingNo = Integer.parseInt("chattingNum");
		int estimatePrice = Integer.parseInt("estimatePrice");
		System.out.println(chattingNo);
		System.out.println(estimatePrice);
		
		HttpSession session = request.getSession();
		
		MyPageDtoImpl myPageDto = new MyPageDtoImpl();
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		int result = myService.savePurchaseStatus(chattingNo);
		
		if(result == 1) {
			session.setAttribute("purchaseStatus", "Y");
		} else {
			session.setAttribute("purchaseStatus", "N");
		}
		
		
		
		
		
		
		
	
		
		
		
		
		
	}

}
