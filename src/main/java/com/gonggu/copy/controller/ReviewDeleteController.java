package com.gonggu.copy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.copy.model.dto.CopyDtoImpl;
import com.gonggu.copy.model.service.CopyServiceImpl;

@WebServlet("/ReviewDeleteController")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String copyNum =  request.getParameter("copyNum");
		System.out.println("카피넘:"+copyNum);
		System.out.println("리뷰넘:"+reviewNo);
		CopyServiceImpl copyService = new CopyServiceImpl();
		int result = copyService.reviewDelete(reviewNo);
		
        if(result == 1) {
			response.sendRedirect("copyDetail.do?copyNo="+copyNum);
		}
	}

}
