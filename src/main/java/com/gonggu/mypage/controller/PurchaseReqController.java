package com.gonggu.mypage.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		
		int constNo = Integer.parseInt(request.getParameter("constNum"));
		
		
		HttpSession session = request.getSession();
		String sessionCopyNum = (String)session.getAttribute("copyNum");
		
		MyPageServiceImpl mypageService = new MyPageServiceImpl();
		mypageService.purchaseReq(constNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/MypageInfo/ChattingList.do?copyNo=" + sessionCopyNum +  "&chatpage=1");
		view.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
