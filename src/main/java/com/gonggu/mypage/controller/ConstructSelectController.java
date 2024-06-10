package com.gonggu.mypage.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDto;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/construct/write.do")
public class ConstructSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructSelectController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		MyPageServiceImpl serviceImpl = new MyPageServiceImpl();
		
		int userNum = Integer.parseInt(request.getParameter("user-num"));
		String userName = request.getParameter("user-name");
		int chattingNum = Integer.parseInt(request.getParameter("chatNum"));
		String endCheck = request.getParameter("end-check");
		
		MyPageDto result = serviceImpl.getConstructDetail(chattingNum);
		
		if(Objects.isNull(result)) {
			
			request.setAttribute("chattingNum", chattingNum);
			request.setAttribute("userNum", userNum);
			request.setAttribute("userName", userName);
			request.setAttribute("select", "isNull");
			
			RequestDispatcher view = request.getRequestDispatcher("/views/myPage/constructWrite.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("endCheck", endCheck);
			request.setAttribute("result", result);
			request.setAttribute("select", "notNull");
			RequestDispatcher view = request.getRequestDispatcher("/views/myPage/constructWrite.jsp");
			view.forward(request, response);
			
		}
			
	}

}
