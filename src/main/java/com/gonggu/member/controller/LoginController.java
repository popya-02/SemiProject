	package com.gonggu.member.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.gonggu.common.AlertMethod;
import com.gonggu.member.model.dto.MemberDTO;
import com.gonggu.member.model.service.MemberServiceImpl;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		AlertMethod alert = new AlertMethod();
		
		String loginId = request.getParameter("id");
		String loginPwd = request.getParameter("password");
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberDTO hashPwd = memberService.getHashPwd(loginId);
		
		if(Objects.isNull(hashPwd)) {
			alert.returnAlert(response, "로그인 실패","아이디 또는 비밀번호가 잘못되었습니다.", "warning", ""); ///form/loginForm.do
			return;
		}else {
			if(hashPwd.getUserType() == "basicUser") {
				if(BCrypt.checkpw(loginPwd, hashPwd.getUserPwd())) {
					HttpSession session = request.getSession();
					session.setAttribute("userNum", hashPwd.getUserNum());
					session.setAttribute("userId", hashPwd.getUserId());
					session.setAttribute("userName", hashPwd.getUserName());
					session.setAttribute("userType", hashPwd.getUserType());
					
					alert.returnAlert(response, "로그인 성공","로그인되었습니다.","success", "/");
				}else {
					alert.returnAlert(response, "로그인 실패","아이디 또는 비밀번호가 잘못되었습니다.", "warning","");
					return;
				}
			}else if (hashPwd.getUserType() == "copyUser") {
				if(BCrypt.checkpw(loginPwd, hashPwd.getCopyPwd())) {
					HttpSession session = request.getSession();
					session.setAttribute("copyNum", hashPwd.getCopyNum());
					session.setAttribute("copyName", hashPwd.getCopyName());
					session.setAttribute("userType", hashPwd.getUserType());
					
					alert.returnAlert(response, "로그인 성공","로그인되었습니다.","success", "/");
					
				}else {
					alert.returnAlert(response, "로그인 실패","아이디 또는 비밀번호가 잘못되었습니다.", "warning","");
					return;
				}
			}else {
				alert.returnAlert(response, "로그인 실패","아이디 또는 비밀번호가 잘못되었습니다.", "warning","");
				return;
			}
		}
		
	}
	
}
