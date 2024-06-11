package com.gonggu.constructExam.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.constructExam.model.dto.ConstructDtoImpl;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;

@WebServlet("/constructDetail.do")
public class ConstructDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int examNo = Integer.parseInt(request.getParameter("examNo"));
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		
		ConstructDtoImpl detail = constructService.getDeteil(examNo);
		
		
		request.setAttribute("detail", detail);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/constructExam/constructDetail.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
