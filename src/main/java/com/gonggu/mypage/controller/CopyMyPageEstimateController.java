package com.gonggu.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("//mypage/copyestimate.do")
public class CopyMyPageEstimateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyMyPageEstimateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String copyNo = request.getParameter("copyno");
		String copyName = request.getParameter("copyname");
		String copyPicture = request.getParameter("picturename");
		int constructNo = Integer.parseInt(request.getParameter("constructno");
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		MyPageDtoImpl result = myService.get
	}

}
