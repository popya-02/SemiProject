package com.gonggu.constructExam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagination;
import com.gonggu.constructExam.model.dto.ConstructDto;
import com.gonggu.constructExam.model.dto.ConstructDtoImpl;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/ExamCategory.do")
public class ConstructCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructCategoryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
        JsonObject jsonResponse = new JsonObject();
        Gson gson = new Gson();
		
        String userType = "";
        
		userType = (String)session.getAttribute("userType");
		
		
		if(userType == null) {
			userType = "";
		}
		
		System.out.println(userType);
		
		String copyName = "";
		int userNum = 0;
		if(userType.equals("copyUser")) {
			copyName = (String)session.getAttribute("copyName");
			jsonResponse.add("copyName", gson.toJsonTree(copyName));
		}else if(userType.equals("basicUser")) {
			userNum = (int)session.getAttribute("userNum");
			
		}
		
		ConstructDtoImpl constructDto = new ConstructDtoImpl();
		constructDto.setUserNum(userNum);
        
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		
		ArrayList<ConstructDtoImpl> getLike = constructService.getLike(constructDto);
		
		int categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
		
		int copypage = Integer.parseInt(request.getParameter("cPage"));
		
		int listCount = constructService.getListCategoryCount(categoryNum);
		
		int pageLimit = 5;
		
		int boardLimit = 6;
		
		PageInfo pi = Pagination.getPageInfo(listCount, copypage, pageLimit, boardLimit);
		
		List<ConstructDto> constructList = constructService.getConstructCategoryList(pi, categoryNum);
		
		int row = listCount - (copypage - 1) * pageLimit;
		List<ConstructDto> category = constructService.getCategory();
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        
        jsonResponse.add("constructList", gson.toJsonTree(constructList));
        jsonResponse.add("categoryList", gson.toJsonTree(category));
        jsonResponse.addProperty("row", row);
        jsonResponse.add("pi", gson.toJsonTree(pi));
        jsonResponse.add("userType", gson.toJsonTree(userType));
        jsonResponse.add("getLike", gson.toJsonTree(getLike));

        response.getWriter().write(jsonResponse.toString());
		
		
		
//		request.setAttribute("categoryList", category);
//        request.setAttribute("constructList", constructList);
//        request.setAttribute("row", row);
//        request.setAttribute("pi", pi);
//        
//        RequestDispatcher view = request.getRequestDispatcher("/views/constructExam/constructList.jsp");
//		view.forward(request, response);
        
	}

}
