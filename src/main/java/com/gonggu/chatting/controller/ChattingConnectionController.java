package com.gonggu.chatting.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		
		
		ChattingDTO typeResult;
		
		if(userType.equals("copyUser") ) {	// 업체유저
			String sessionCopyNum = (String) session.getAttribute("copyNum");
			
			typeResult = chattingService.getCopyType(chattingDto);
			ChattingDTO copychattingNum = chattingService.setChatnum(chattingDto);
			if(sessionCopyNum.equals(copyNum)) {	// 로그인한 업체유저의 채팅방인지
				ArrayList<ChattingDTO> list = chattingService.getList(copychattingNum.getChattingNum());
				
				request.setAttribute("list", list);
				request.setAttribute("endCheck", copychattingNum.getEndCheck());
				request.setAttribute("chattingNum", copychattingNum.getChattingNum());
				request.setAttribute("userType",userType);
				request.setAttribute("noCheck",typeResult.getUserNum());
				RequestDispatcher view = request.getRequestDispatcher("/views/etc/chatting.jsp");
				view.forward(request, response);
			}
		} else if (userType.equals("basicUser")){	// 일반 유저
			int sessionUserNum = (int) session.getAttribute("userNum");
			
			typeResult = chattingService.getUserType(chattingDto);

			
			if(sessionUserNum == userNum) {	// 로그인한 일반유저의 채팅방인지
				int result = chattingService.setChatting(chattingDto);	// 중복체크 없으면 생성
				ChattingDTO userchattingNum = chattingService.setChatnum(chattingDto);
				
				if(userchattingNum.getEndCheck() == "Y") {	// 상담 종료 여부
					response.sendRedirect("/form/constructDetail.do");
				}else {
					if(result == 0) {
						response.sendRedirect("/form/constructDetail.do");
					}else {
						
						ArrayList<ChattingDTO> list = chattingService.getList(userchattingNum.getChattingNum());
						
						request.setAttribute("list", list);
						request.setAttribute("chattingNum", userchattingNum.getChattingNum());
						request.setAttribute("userType",userType);
						request.setAttribute("noCheck",typeResult.getUserNum());
						RequestDispatcher view = request.getRequestDispatcher("/views/etc/chatting.jsp");
						view.forward(request, response);
					}
					
				}
				
			}
		}else{
			response.sendRedirect("/form/constructDetail.do");
			
			
		}
		
	}

}
