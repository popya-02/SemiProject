package com.gonggu.mypage.controller;

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
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/purchaseReq.do")
public class PurchaseReqController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PurchaseReqController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int chattingNo = Integer.parseInt(request.getParameter("chattingNum"));
		String estimatePrice = request.getParameter("estimatePrice");
		System.out.println("chat: " + chattingNo);
		System.out.println(estimatePrice);
		
		
		
		HttpSession session = request.getSession();
		String sessionCopyNum = (String)session.getAttribute("copyNum");
		
		
		ChattingServiceImpl chatService = new ChattingServiceImpl();
		
		if(sessionCopyNum.equals(sessionCopyNum)) {
			int chatpage = Integer.parseInt(request.getParameter("chatpage"));
			
			int listCount = chatService.getListCount(sessionCopyNum);
			
			int pageLimit = 5;
			
			int boardLimit = 9;
			
			PageInfo pi = Pagination.getPageInfo(listCount, chatpage, pageLimit, boardLimit);
			
			List<ChattingDTO> chattingList = chatService.getCopyChattingList(pi, sessionCopyNum);
			MyPageDtoImpl mypageDto = new  MyPageDtoImpl();
			
			
			int row = listCount - (chatpage - 1) * pageLimit;
			
			request.setAttribute("chattingList", chattingList);
			request.setAttribute("myPageDto", mypageDto);
			request.setAttribute("row", row);
			request.setAttribute("pi", pi);
		MyPageServiceImpl myService = new MyPageServiceImpl();
		int result = myService.savePurchaseStatus(chattingNo); // 0

		System.out.println("result: " + result);
		// chattingNum 에 대한 결제승인여부가 존재하면 Y
		if(result == 1) {
			session.setAttribute("purchaseStatus", "S");
			System.out.println("sucess");
//			response.sendRedirect("/MypageInfo/ChattingList.do?copyNum=" + sessionCopyNum + "&chatpage=1");
		} else {
			session.setAttribute("purchaseStatus", "F");
		}
		 response.sendRedirect("");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
