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

@WebServlet("/constructExam/constructEdit.do")
public class ConstructEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructEditController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int examNo = Integer.parseInt(request.getParameter("examNo"));
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		ConstructDtoImpl getEdit = constructService.getDeteil(examNo);
		request.setAttribute("getEdit", getEdit);
		//"/constructExam/constructEdit.do?examNo="+examNo
		RequestDispatcher view = request.getRequestDispatcher("/views/constructExam/constructEdit.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int examNo = Integer.parseInt(request.getParameter("examNo"));

		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
//		System.out.println("1111111 :"+content);
		
		ConstructDtoImpl constructDto = new ConstructDtoImpl();

		String tagRemove = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
        String nbspPattern = "&nbsp;";
		
        String removeContentTag = content.replaceAll(tagRemove, "");
      	String resultContent  = removeContentTag.replace(nbspPattern, "");
      	
		constructDto.setExamNo(examNo); // const_exam
		constructDto.setCategoryNo(categoryNo);  // const_exam
		constructDto.setTitle(title); // const_exam
		constructDto.setContent(content); // const_exam
		constructDto.setTagRemoveContent(resultContent); // const_exam
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		int result = constructService.setEdit(constructDto);
//		System.out.println("22222222 : "+constructDto.getContent());
		
		if(result == 1) {
			response.sendRedirect("/constructExam/constructEdit.do?examNo="+examNo);
		}
		
	}

}
