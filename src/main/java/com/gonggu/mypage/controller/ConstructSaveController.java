package com.gonggu.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDto;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/construct/saveConstruct.do")
public class ConstructSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructSaveController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		String element = request.getParameter("element");
		String copyNum = request.getParameter("copyNum");
		int basicNum = Integer.parseInt(request.getParameter("basicNum"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String addr = request.getParameter("addr");
		int range = Integer.parseInt(request.getParameter("range"));
		String tel = request.getParameter("tel");
		String estimatePrice = request.getParameter("estimatePrice");
		String sumPrice = request.getParameter("sumPrice");
		int chattingNum = Integer.parseInt(request.getParameter("chatNum"));
		
		MyPageServiceImpl constService = new MyPageServiceImpl();
		
		MyPageDto constDto = new MyPageDto(basicNum, copyNum, tel, element, addr, range,
				startDate, endDate, estimatePrice, sumPrice, chattingNum);
		
		int result = constService.saveConstElement(constDto);
		
		if(result == 0) {
			response.getWriter().print("fail");
		}else {
			response.getWriter().print("success");
		}
	}

}
