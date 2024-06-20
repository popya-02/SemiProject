package com.gonggu.mypage.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.common.AlertMethod;
import com.gonggu.mypage.model.service.MyPageServiceImpl;


@WebServlet("/purchaseReq.do")
public class PurchaseReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseReqController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		int constNo = Integer.parseInt(request.getParameter("constNum"));
		
		
		HttpSession session = request.getSession();
		String sessionCopyNum = (String)session.getAttribute("copyNum");
		String price = request.getParameter("price");
		
		MyPageServiceImpl mypageService = new MyPageServiceImpl();
		mypageService.purchaseReq(constNo);
		
		AlertMethod alert = new AlertMethod();
		
		String reusltUrl = "/MypageInfo/ChattingList.do?copyNo=" + sessionCopyNum +  "&chatpage=1";
		String reusltPrice = "요청 금액 : " + price + "";
		
		alert.returnAlert(response, "결제요청 완료!", reusltPrice, "success",reusltUrl);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
