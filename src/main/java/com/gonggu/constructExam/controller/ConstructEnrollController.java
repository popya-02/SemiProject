package com.gonggu.constructExam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.constructExam.model.dto.ConstructDtoImpl;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;

@WebServlet("/constructExam/constructEnroll.do")
public class ConstructEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConstructEnrollController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String copyNum = request.getParameter("copyNum");
		String copyName = request.getParameter("copyName");

		int constructList =Integer.parseInt(request.getParameter("constructList"));

		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String indate = request.getParameter("indate");

		
		request.setAttribute("copyNum", copyNum);
		request.setAttribute("copyName", copyName);
		request.setAttribute("constructList", constructList);
		request.setAttribute("category", category);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("indate", indate);
		
		ConstructDtoImpl constructDto = new ConstructDtoImpl();
		constructDto.setCopyNum(copyNum);
		constructDto.setCopyName(copyName);
		constructDto.setConstructList(constructList);
		constructDto.setCategoryNo(category);
		constructDto.setTitle(title);
		constructDto.setContent(content);
		constructDto.setIndate(indate);
		
		
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		
		int result = constructService.enroll(constructDto);
		
		
		response.sendRedirect("/constructExam/constructlist.do?constructpage=1");

	}
}
