package com.gonggu.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.member.model.service.MemberServiceImpl;

@WebServlet("/signupCopy/copyidcheck.do")
public class BusinessRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BusinessRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String copyId = request.getParameter("copyId");
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		int result = memberService.copyIdCheck(copyId);
		
		if(result == 0) {
			response.getWriter().print("isNotDuplicate");
		}else {
			response.getWriter().print("isDuplicate");
		}
	}

}
