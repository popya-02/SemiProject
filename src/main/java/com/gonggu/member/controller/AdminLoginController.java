package com.gonggu.member.controller;

import java.io.IOException;
import java.util.Objects;

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

@WebServlet("/adminlogin.do")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		AlertMethod alert = new AlertMethod();
		
		String adminId = request.getParameter("id");
		String adminPwd = request.getParameter("password");
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		MemberDTO hashPwd = memberService.getHashPwdAdmin(adminId);
		
		if(Objects.isNull(hashPwd)) {
			alert.returnAlert(response, "로그인 실패","아이디 또는 비밀번호가 잘못되었습니다.", "warning","b");
			return;
		}else {
			if(BCrypt.checkpw(adminPwd, hashPwd.getAdminPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("adminId", hashPwd.getAdminId());
				session.setAttribute("userType", hashPwd.getUserType());
				
				alert.returnAlert(response, "로그인 성공","로그인되었습니다.","success", "/");
			}else {
				alert.returnAlert(response, "로그인 실패","아이디 또는 비밀번호가 잘못되었습니다.", "warning","b");
				return;
			}
		}
		
	}

}
