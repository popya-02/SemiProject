package com.gonggu.purchase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(); 
		
		PurchaseDto purchaseDto = of(request);
		String result = purchaseService.order(purchaseDto);
		
		if ("success".equals(result)) {
            out.write("success");
        } else {
            out.write("error");
        }		
	}

	/**
	 * 결제 후 응답받은 데이터로 DTO 생성
	 * @param request
	 * @return
	 */
	private PurchaseDto of(HttpServletRequest request) {
		int chattingNo = Integer.parseInt(request.getParameter("chattingNum"));
		String oid = UUID.randomUUID().toString();
		String goodsName = request.getParameter("goods");
		String detailAddr = request.getParameter("detailAddr");;
		int constructPrice = Integer.parseInt(request.getParameter("price"));
		
		PurchaseDto purchaseDto = PurchaseDto.of(chattingNo, oid, goodsName, detailAddr, constructPrice);
		return purchaseDto;
	}

}
