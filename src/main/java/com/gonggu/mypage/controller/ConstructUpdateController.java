package com.gonggu.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDto;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/construct/updateConstruct.do")
public class ConstructUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String element = request.getParameter("element");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String addr = request.getParameter("addr");
		int range = Integer.parseInt(request.getParameter("range"));
		String estimatePrice = request.getParameter("estimatePrice");
		String sumPrice = request.getParameter("sumPrice");
		int chattingNum = Integer.parseInt(request.getParameter("chatNum"));
		
		MyPageServiceImpl constService = new MyPageServiceImpl();
		
		MyPageDto constDto = new MyPageDto(element, addr, startDate, endDate,
				range, estimatePrice, sumPrice, chattingNum);
		
		int result = constService.updateConstElement(constDto);
		
		if(result == 0) {
			response.getWriter().print("fail");
		}else {
			response.getWriter().print("success");
		}
	}

}
