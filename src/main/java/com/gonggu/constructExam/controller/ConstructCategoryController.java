package com.gonggu.constructExam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagination;
import com.gonggu.constructExam.model.dto.ConstructDto;
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
		
		ConstructServiceImpl consturctService = new ConstructServiceImpl();
		
		int categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
		
		int copypage = Integer.parseInt(request.getParameter("cPage"));
		
		int listCount = consturctService.getListCategoryCount(categoryNum);
		
		int pageLimit = 5;
		
		int boardLimit = 6;
		
		PageInfo pi = Pagination.getPageInfo(listCount, copypage, pageLimit, boardLimit);
		
		List<ConstructDto> constructList = consturctService.getConstructCategoryList(pi, categoryNum);
		
		int row = listCount - (copypage - 1) * pageLimit;
		List<ConstructDto> category = consturctService.getCategory();
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject jsonResponse = new JsonObject();
        Gson gson = new Gson();
        
        jsonResponse.add("constructList", gson.toJsonTree(constructList));
        jsonResponse.add("categoryList", gson.toJsonTree(category));
        jsonResponse.addProperty("row", row);
        request.setAttribute("pi", pi);
        jsonResponse.add("pi", gson.toJsonTree(pi));

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
