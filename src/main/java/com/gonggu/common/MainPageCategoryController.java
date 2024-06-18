package com.gonggu.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.constructExam.model.dto.ConstructDto;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;

@WebServlet("")
public class MainPageCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainPageCategoryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		
		List<ConstructDto> category = constructService.getCategory();
		
		request.setAttribute("categoryList", category);
		
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
