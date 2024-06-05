package com.gonggu.common;

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

@WebServlet("/form/*")
public class MainFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String action = request.getPathInfo();
		String nextPage = "";
		
		if(action.equals("/loginForm.do")) {
			nextPage = "/views/member/login.jsp";
		}else if(action.equals("/signup.do")) {
			nextPage = "/views/member/signup.jsp";			
		}else if(action.equals("/signupuserForm.do")) {
			nextPage = "/views/member/signupUser.jsp";
		}else if(action.equals("/signupcopyForm.do")) {
			nextPage = "/views/member/signupCopy.jsp";
		}else if(action.equals("/constructlist.do")) {
			nextPage = "/views/constructExam/constructList.jsp";
		}else if(action.equals("/constructEnroll.do")) {
			HttpSession session = request.getSession();
			String copyNum = (String) session.getAttribute("copyNum");
			ConstructServiceImpl constructService = new ConstructServiceImpl();
			ArrayList<ConstructDtoImpl> list = constructService.getList(copyNum);
			request.setAttribute("list", list);
			nextPage = "/views/constructExam/constructEnroll.jsp";
		}		
		
		if(nextPage != null && !nextPage.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);
		}else {
			response.sendRedirect("/views/errors.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
