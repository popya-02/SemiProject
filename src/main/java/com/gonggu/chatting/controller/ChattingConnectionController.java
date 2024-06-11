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

@WebServlet("/chatting/*")
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
		String action = request.getPathInfo();
		String userType = (String)session.getAttribute("userType");
		
		if(action.equals("/connection.do")) {
			int userNum = Integer.parseInt(request.getParameter("userNum"));
			String copyNum = request.getParameter("copyNum");
			
			ChattingDTO chattingDto = new ChattingDTO();
			chattingDto.setUserNum(userNum);
			chattingDto.setCopyNum(copyNum);
			ChattingServiceImpl chattingService = new ChattingServiceImpl();
			
			
			ChattingDTO typeResult;
			
			if(userType.equals("copyUser") ) {	// 업체유저
				String sessionCopyNum = (String) session.getAttribute("copyNum");
				
				typeResult = chattingService.getCopyType(chattingDto);
				ChattingDTO copychattingSet = chattingService.setChatnum(chattingDto);
				if(sessionCopyNum.equals(copyNum)) {	// 로그인한 업체유저의 채팅방인지
					ArrayList<ChattingDTO> list = chattingService.getList(copychattingSet.getChattingNum());
					
					request.setAttribute("list", list);
					request.setAttribute("nickName", copychattingSet.getUserNickName());
					request.setAttribute("userId", copychattingSet.getUserId());
					request.setAttribute("endCheck", copychattingSet.getEndCheck());
					request.setAttribute("chattingNum", copychattingSet.getChattingNum());
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
					ChattingDTO userchattingSet = chattingService.setChatnum(chattingDto);
					
					if(userchattingSet.getEndCheck() == "Y") {	// 상담 종료 여부
						response.sendRedirect("/form/constructDetail.do");
					}else {
						if(result == 0) {
							response.sendRedirect("/form/constructDetail.do");
						}else {
							
							ArrayList<ChattingDTO> list = chattingService.getList(userchattingSet.getChattingNum());
							
							request.setAttribute("list", list);
							request.setAttribute("copyName", userchattingSet.getCopyName());
							request.setAttribute("chattingNum", userchattingSet.getChattingNum());
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
			
		}else if(action.equals("/endConnection.do")) {
			if(userType.equals("copyUser") ) {	// 업체유저
				
				int chatNum = Integer.parseInt(request.getParameter("chatNum"));
				
				ChattingServiceImpl chattingService = new ChattingServiceImpl();
				
				ChattingDTO endchattingSet = chattingService.setEndChatSet(chatNum);
				ArrayList<ChattingDTO> list = chattingService.getList(chatNum);
					
				request.setAttribute("list", list);
				request.setAttribute("nickName", endchattingSet.getUserNickName());
				request.setAttribute("userId", endchattingSet.getUserId());
				request.setAttribute("endCheck", endchattingSet.getEndCheck());
				request.setAttribute("chattingNum", chatNum);
				request.setAttribute("userType",userType);
				request.setAttribute("noCheck", endchattingSet.getUserNum());
				
				RequestDispatcher view = request.getRequestDispatcher("/views/etc/chatting.jsp");
				view.forward(request, response);
			}else {
				response.sendRedirect("/form/constructDetail.do");
			}
		}
		
	}

}
