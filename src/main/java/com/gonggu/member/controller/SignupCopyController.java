package com.gonggu.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.gonggu.member.model.dto.MemberDTO;
import com.gonggu.member.model.service.MemberServiceImpl;

@WebServlet("/signupCopy/signupResult.do")
public class SignupCopyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupCopyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String businessRegistorCheck = request.getParameter("businessRegistorCheck");
		String confirmCheck = request.getParameter("confirmCheck");
		
		String copyId = request.getParameter("copy-id");
		String copyPwd = request.getParameter("password");
		String copyName = request.getParameter("name");
		String copyAddr = request.getParameter("addr");
		String copyArea = request.getParameter("area");
		String copyTel = request.getParameter("tel");
		String copyCeoName = request.getParameter("ceo-name");
		
		String salt = BCrypt.gensalt(12);
		String hashPassword = BCrypt.hashpw(copyPwd, salt);
		
		if(businessRegistorCheck.equals("unavailable")){
			returnAlert(response, "사업자등록번호 인증을 완료해주세요.", "/form/signupcopyForm.do");
			return;
			
		}else if(confirmCheck.equals("unavailable")) {
			returnAlert(response, "비밀번호재확인란을 올바르게 입력해주세요.", "/form/signupcopyForm.do");
			return;
		}else {
			MemberDTO memberDto = new MemberDTO();
			memberDto.setCopyNum(copyId);
			memberDto.setCopyPwd(hashPassword);
			memberDto.setCopyName(copyName);
			memberDto.setCopyAddr(copyAddr);
			memberDto.setCopyArea(copyArea);
			memberDto.setCopyTelNum(copyTel);
			memberDto.setCopyCeoName(copyCeoName);
			
			MemberServiceImpl memberService = new MemberServiceImpl();
			
			int result = memberService.signupCopy(memberDto);
			
			if(result == 1) {
				//성공
				returnAlert(response, "회원가입이 완료되었습니다. 관리자의 승인을 기다려주세요.", "/");
			}else{
				// 실패
				returnAlert(response, "회원가입 실패", "/form/signupcopyForm.do");
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
