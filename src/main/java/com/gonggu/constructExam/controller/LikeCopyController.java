package com.gonggu.constructExam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.constructExam.model.dto.ConstructDtoImpl;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;

@WebServlet("/LikeCopyController")
public class LikeCopyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LikeCopyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String copyNum = request.getParameter("copyNum");
		HttpSession session = request.getSession();
		int userNum = (int) session.getAttribute("userNum");
		
		ConstructDtoImpl constructDto = new ConstructDtoImpl();
		constructDto.setCopyNum(copyNum);
		constructDto.setUserNum(userNum);
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		int result = constructService.selectLike(constructDto);
		if(result == 0) { 
			//0일때 성공(추가) 1일때 실패(삭제)
			constructService.insertLike(constructDto);
			response.getWriter().write("liked");
		} else if(result == 1) {
			constructService.deleteLike(constructDto);
			response.getWriter().write("unliked");
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
}
}