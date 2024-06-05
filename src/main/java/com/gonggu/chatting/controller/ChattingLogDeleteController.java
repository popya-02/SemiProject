package com.gonggu.chatting.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.chatting.model.service.ChattingServiceImpl;

@WebServlet("/chatting/deleteChatLog.do")
public class ChattingLogDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChattingLogDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int chatNum = Integer.parseInt(request.getParameter("chatNum"));
		
		ChattingServiceImpl chattingService = new ChattingServiceImpl();
		
		int result = chattingService.chatLogDelete(chatNum);
		
		if(result == 0) {
			response.getWriter().print("isNotDelete");
		
		}else {
			response.getWriter().print("isDelete");
			
		}
		
	}

}
