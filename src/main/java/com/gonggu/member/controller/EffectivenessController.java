package com.gonggu.member.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupUser/effective/*")
public class EffectivenessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EffectivenessController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getPathInfo();
		
		String userPwd = request.getParameter("pwd");

		String userName = request.getParameter("name");
		
		
		if(action.equals("/password.do")) {
			
			String pwdRegular = "^(?=.*[a-z])(?=.*\\d)(?=.*[~!@#])[a-z\\d~!@#]{8,20}$";
			Pattern pwdPattern = Pattern.compile(pwdRegular);
			Matcher pwdMatcher = pwdPattern.matcher(userPwd);
			
			if(pwdMatcher.matches()) {
				response.getWriter().printf("isMatche", userPwd);
				
			}else {
				response.getWriter().print("isNotMatche");
				
			}
			
			
		}else if(action.equals("/name.do")) {
			String nameRegular = "^[가-힣]+$";
			Pattern namePattern = Pattern.compile(nameRegular);
			Matcher nameMatcher = namePattern.matcher(userName);

			if(nameMatcher.matches()) {
				response.getWriter().print("isMatche");
				
			}else {
				response.getWriter().print("isNotMatche");
				
			}
			
		}
		
	}

}
