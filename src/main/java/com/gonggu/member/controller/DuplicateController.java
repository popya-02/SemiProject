package com.gonggu.member.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.member.model.dto.MemberDTO;
import com.gonggu.member.model.service.MemberServiceImpl;

@WebServlet("/signupUser/idcheck.do")
public class DuplicateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuplicateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		
		// id 유효성 검사 영문자로 시작하는 영문자 또는 숫자 6~20자
		String idPattern = "^[a-z][a-z0-9]{5,19}$";
		Pattern pattern = Pattern.compile(idPattern);
		Matcher idMatcher = pattern.matcher(userId);
		if(idMatcher.matches()) {
			MemberServiceImpl memberService = new MemberServiceImpl();
			
			int result = memberService.idCheck(userId);
			
			if(result == 0) {
				response.getWriter().print("isNotDuplicate");
				
			}else {
				response.getWriter().print("isDuplicate");
			}
			
		}else {
			response.getWriter().print("isNotPolicy");
		}
		
	}

}
