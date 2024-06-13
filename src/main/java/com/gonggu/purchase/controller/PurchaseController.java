package com.gonggu.purchase.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.purchase.model.dto.PurchaseDto;
import com.gonggu.purchase.model.service.PurchaseServiceImpl;


@WebServlet("/purchase.do")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PurchaseServiceImpl myService = new PurchaseServiceImpl();


		int chattingNo = 1;
		
		PurchaseDto result = myService.purchaseInfo(chattingNo);
		request.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/etc/purchase.jsp"); 
		dispatcher.forward(request, response);
	}
}
