package com.gonggu.chatting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.chatting.model.dto.ChattingDTO;
import com.gonggu.chatting.model.service.ChattingServiceImpl;
import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagination;
import com.gonggu.mypage.model.dto.MyPageDtoImpl;

@WebServlet("/MypageInfo/ChattingList.do")
public class CopyChattingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyChattingListController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String copyNum = request.getParameter("copyNo");
		
		HttpSession session = request.getSession();
		String sessionCopyNum = (String)session.getAttribute("copyNum");
		
		ChattingServiceImpl chatService = new ChattingServiceImpl();
		
		if(copyNum.equals(sessionCopyNum)) {
			int chatpage = Integer.parseInt(request.getParameter("chatpage"));
			
			int listCount = chatService.getListCount(sessionCopyNum);
			
			int pageLimit = 5;
			
			int boardLimit = 9;
			
			PageInfo pi = Pagination.getPageInfo(listCount, chatpage, pageLimit, boardLimit);
			
			List<ChattingDTO> chattingList = chatService.getCopyChattingList(pi, sessionCopyNum);
			MyPageDtoImpl mypageDto = new  MyPageDtoImpl();
			
			System.out.println(mypageDto.getEstimatePrice());
			
			int row = listCount - (chatpage - 1) * pageLimit;
			
			request.setAttribute("chattingList", chattingList);
			request.setAttribute("myPageDto", mypageDto);
			request.setAttribute("row", row);
			request.setAttribute("pi", pi);
			
			RequestDispatcher view = request.getRequestDispatcher("/views/myPage/copyMyPageChatting.jsp");
			view.forward(request, response);
			
		}else {
			
		}
		
		
	}

}
