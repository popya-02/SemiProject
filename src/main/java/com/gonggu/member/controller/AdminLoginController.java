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
		
		String adminId = request.getParameter("id");
		String adminPwd = request.getParameter("password");
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		MemberDTO hashPwd = memberService.getHashPwdAdmin(adminId);
		
		if(Objects.isNull(hashPwd)) {
			returnAlert(response, "아이디 또는 비밀번호가 잘못되었습니다.", "/form/adminLogin.do");
			return;
		}else {
			if(BCrypt.checkpw(adminPwd, hashPwd.getAdminPwd())) {
				System.out.println("asd");
				HttpSession session = request.getSession();
				session.setAttribute("adminId", hashPwd.getAdminId());
				session.setAttribute("userType", hashPwd.getUserType());
				
				returnAlert(response, "로그인되었습니다.", "/");
			}else {
				returnAlert(response, "아이디 또는 비밀번호가 잘못되었습니다.", "/form/loginForm.do");
				return;
			}
		}
		
	}
	
	private void returnAlert(HttpServletResponse response, String msg, String url) throws IOException {
		response.getWriter().write("<script>"
								  +"	alert('"+ msg +"');"
  								  +"	location.href='"+ url + "';"
								  +"</script>");	// js 코드로 넘겨주기
	}

}
