package com.gonggu.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}else if(action.equals("/copylist.do")) {
			nextPage = "/views/copy/copyList.jsp";
		}else if(action.equals("/copyDetail.do")) {
			nextPage = "/views/copy/copyDetail.jsp";
		}else if(action.equals("/constructEnroll.do")) {
			nextPage = "/views/constructExam/constructEnroll.jsp";
		}else if(action.equals("/constructDetail.do")) {
		nextPage = "/views/constructExam/constructDetail.jsp";
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
