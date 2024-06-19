package com.gonggu.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.service.MyPageServiceImpl;
import com.gonggu.purchase.model.dto.PurchaseDto;
import com.gonggu.purchase.model.service.PurchaseServiceImpl;

@WebServlet("/complete.do")
public class CompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompleteController() {
        super();
    }

	/**
	 * 주문처리 controller
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
		int chatNo = Integer.parseInt(request.getParameter("chatNo"));
		String detailAddr = request.getParameter("detailAddr");
		
		System.out.println(detailAddr);
		PurchaseDto purchaseDto = new PurchaseDto();
		
		purchaseDto.setChattingNo(chatNo);
		
		String result = purchaseService.order(purchaseDto);
		
		if ("success".equals(result)) {
            int success = purchaseService.addressUpdate(chatNo ,detailAddr);
            if (success == 1) {
            	System.out.println("asasas");
            	out.write("success");
            } else {
            	out.write("error");
            }
        } else {
        	out.write("error");
        }
	}
}
