 package com.gonggu.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/mypage/usermypageinfo.do")
public class UserMyPageInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserMyPageInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userno"));
		String userId = request.getParameter("userid");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String addr = request.getParameter("addr");
		
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		myDto.setUserNo(userNo);;
		myDto.setUserId(userId);
		myDto.setName(name);
		myDto.setNickName(nickname);
		myDto.setAddress(addr);
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		int result = myService.setUserEdit(myDto);
		//request.setAttribute("result", result);
//		
//		RequestDispatcher view = request.getRequestDispatcher("/mypage/usermypageinfo.do?userNo="+userNo);
//		view.forward(request, response);
//		
		if(result == 1) {
			response.sendRedirect("/MypageInfo/userInfo.do?userNo="+userNo);
		}
	}

}
