package com.gonggu.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/Mypage/copyInfo.do")
public class CopyMyPageInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyMyPageInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String copyNo = request.getParameter("copyno");
		String copyName = request.getParameter("copyname");
		String telNum = request.getParameter("telnum");
		String copyAddr = request.getParameter("copyaddr");
		String constructArea = request.getParameter("costructarea");
		String content = request.getParameter("content");
		
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		
		myDto.setCopyNo(copyNo);
		myDto.setCopyName(copyName);
		myDto.setTelNum(telNum);
		myDto.setCopyAddr(copyAddr);
		myDto.setConstructArea(constructArea);
		myDto.setContent(content);
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		int result = myService.setCopyEdit(myDto);
		
		if(result == 1) {
			response.sendRedirect("/MypageInfo/copyInfo.do?copyNo=");
		}
	}

}
