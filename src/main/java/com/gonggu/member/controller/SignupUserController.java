package com.gonggu.member.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.gonggu.common.AlertMethod;
import com.gonggu.member.model.dto.MemberDTO;
import com.gonggu.member.model.service.MemberServiceImpl;

@WebServlet("/signupUser/signupResult.do")
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
		
		AlertMethod alert = new AlertMethod();
		
		String duplicate = request.getParameter("duplicateCheck");
		String authenticate = request.getParameter("authenticationCheck");
		String confirmCheck = request.getParameter("confirmCheck");
		String effectiveNameCheck = request.getParameter("effectiveNameCheck");
		
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("password");
		String userName = request.getParameter("name");
		String userAddr = request.getParameter("addr");
		String nickName = request.getParameter("nickname");
		String userPhoneNum = request.getParameter("phonnum");
		
		String salt = BCrypt.gensalt(12);
		String hashPassword = BCrypt.hashpw(userPwd, salt);
		
		// 비밀번호, id, 이름, 번호 유효성 검사
		if(duplicate.equals("unavailable") || 
				authenticate.equals("unavailable") || 
				confirmCheck.equals("unavailable") || 
				effectiveNameCheck.equals("unavailable")) {
			alert.returnAlert(response, "회원가입 실패", "인증 및 빈칸을 올바르게 입력해주세요.", "warning", "");
			return;
		}
		
		MemberDTO memberDto = new MemberDTO();
		memberDto.setUserId(userId);
		memberDto.setUserPwd(hashPassword);
		memberDto.setUserName(userName);
		memberDto.setUserAddr(userAddr);
		memberDto.setNickName(nickName);
		memberDto.setPhoneNum(userPhoneNum);
		

		
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.signupUser(memberDto);
		
		if(result == 1) {
			//성공
			alert.returnAlert(response, "회원가입 성공", "회원가입이 완료되었습니다.", "success",  "/");
		}else{
			// 실패
			alert.returnAlert(response, "회원가입 실패", "", "warning", "");
		}
		
	}

}
