package com.gonggu.chatting.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.chatting.model.service.ChattingServiceImpl;

@WebServlet("/chatting/chattinglog.do")
public class ChattingLogInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChattingLogInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int chatNum = Integer.parseInt(request.getParameter("chattingNum"));
		String userType = request.getParameter("userType");
		String message = request.getParameter("message");
		
		ChattingDTO chattingDto = new ChattingDTO();
		ChattingServiceImpl chattingService = new ChattingServiceImpl();
		
		chattingDto.setMessage(message);
		chattingDto.setUserType(userType);
		chattingDto.setChattingNum(chatNum);
		
		chattingService.insertMsg(chattingDto);
		
		
		
	}

}
