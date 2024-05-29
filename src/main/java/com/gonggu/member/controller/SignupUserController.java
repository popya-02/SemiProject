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

@WebServlet("/signupUser/signup.do")
public class SignupUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupUserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("password");
		String confirmPwd = request.getParameter("confirmPwd");
		String userName = request.getParameter("name");
		String userAddr = request.getParameter("addr");
		String nickName = request.getParameter("nickname");
		String userPhoneNum = request.getParameter("phonnum");
		
	}
	

}
