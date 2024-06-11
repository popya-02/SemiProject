package com.gonggu.purchase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.purchase.model.dto.PurchaseDto;
import com.gonggu.purchase.model.service.PurchaseServiceImpl;

@WebServlet("/complete.do")
public class CompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
		PurchaseDto dto = new PurchaseDto();
		
//	
//		int amount = Integer.parseInt(request.getParameter("amount"));
//		String userName = request.getParameter("name");
//		String goodsName = request.getParameter("goods");

		
		
		
		
		
		
		
		
	}

}
