package com.gonggu.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.member.model.dto.MemberDTO;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;

@WebServlet("/signupUser/messageSend.do")
public class PhoneAuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final DefaultMessageService messageService;
	
    public PhoneAuthenticationController() {
        super();
        this.messageService = NurigoApp.INSTANCE.initialize("NCSV7MGP3SFPDTOQ", "R9O4RI7IGK8KC80ZMD0KLVLBBSFHBMGO", "https://api.coolsms.co.kr");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String checknum = "";
		
		String userPhone = request.getParameter("userPhone");
		
		checknum = randomNum();
		Message message = new Message();
		
		message.setFrom("01032445958");
		message.setTo(userPhone);
		message.setText("GONGGU 인증번호 [" + checknum + "]");
		
		this.messageService.sendOne(new SingleMessageSendingRequest(message));
		
		response.getWriter().print(checknum);
		
		System.out.println(checknum);
		
	}
	
	public String randomNum(){
		Random rd = new Random();
		
		String result = "";
		
		for(int i = 0; i < 6; i++) {
			String str = Integer.toString(rd.nextInt(9));			
			
			result += str;
		}
				
		return result;
	}

}
