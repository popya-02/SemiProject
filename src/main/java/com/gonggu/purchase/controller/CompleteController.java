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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
		PurchaseDto dto = new PurchaseDto();
		
		HttpSession session = request.getSession(); 
		
		int chattingNo = (int)session.getAttribute("chattingNum");
		String oid = UUID.randomUUID().toString();
		String goodsName = request.getParameter("goods");
		String detailAddr = request.getParameter("detailAddr");;
		int constructPrice = Integer.parseInt(request.getParameter("price"));
		
		
		
		dto.setChattingNo(chattingNo);
		dto.setOid(oid);
		dto.setGoodsName(goodsName);
		dto.setDetailAddr(detailAddr);
		dto.setConstructPrice(constructPrice);
		
		
		String result = purchaseService.order();
		
		
		if ("success".equals(result)) {
            out.write("success");
        } else {
            out.write("error");
        }
//	
//		int amount = Integer.parseInt(request.getParameter("amount"));
//		String userName = request.getParameter("name");
//		String goodsName = request.getParameter("goods");

		
		
		
		
		
		
		
		
	}

}
