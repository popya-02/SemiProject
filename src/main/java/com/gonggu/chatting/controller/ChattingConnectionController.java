package com.gonggu.chatting.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.chatting.model.service.ChattingServiceImpl;

@WebServlet("/chatting/connection.do")
public class ChattingConnectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChattingConnectionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();

		int userNum = Integer.parseInt(request.getParameter("userNum"));
		String userType = (String)session.getAttribute("userType");
		String copyNum = request.getParameter("copyNum");
		
		ChattingDTO chattingDto = new ChattingDTO();
		chattingDto.setUserNum(userNum);
		chattingDto.setCopyNum(copyNum);
		ChattingServiceImpl chattingService = new ChattingServiceImpl();
		
		if(userType == "copyUser") {
			String sessionCopyNum = (String) session.getAttribute("copyNum");
			if(sessionCopyNum == copyNum) {
				RequestDispatcher view = request.getRequestDispatcher("/views/etc/chatting.jsp");
				view.forward(request, response);
			}
		} else if (userType == "basicUser"){
			int sessionUserNum = (int) session.getAttribute("userNum");
			
			if(sessionUserNum == userNum) {
				int result = chattingService.setChatting(chattingDto);
				
				if(result == 0) {
					response.sendRedirect("/form/constructDetail.do");
				}else {					
					RequestDispatcher view = request.getRequestDispatcher("/views/etc/chatting.jsp");
					view.forward(request, response);
				}			
				
			}
		}else{
			response.sendRedirect("/form/constructDetail.do");
			
			
		}
		
	}

}
