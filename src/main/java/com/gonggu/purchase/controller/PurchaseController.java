package com.gonggu.purchase.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDto;
import com.gonggu.purchase.model.dto.PurchaseDto;
import com.gonggu.purchase.model.service.PurchaseServiceImpl;


@WebServlet("/purchase.do")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int chattingNo = Integer.parseInt(request.getParameter("chattingNum"));
		int constNo = Integer.parseInt(request.getParameter("constructNum"));
		
		PurchaseServiceImpl myService = new PurchaseServiceImpl();
		PurchaseDto result = myService.purchaseInfo(chattingNo);
		PurchaseDto date = myService.constructInfo(chattingNo);
		
		MyPageDto mypageDto = new MyPageDto();
		mypageDto.setConstructNo(constNo);
		mypageDto.setChattingNum(chattingNo);
		
		request.setAttribute("result", result);
		request.setAttribute("date", date);
		request.setAttribute("mypageDto", mypageDto);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/etc/purchase.jsp"); 
		dispatcher.forward(request, response);
	}
}
