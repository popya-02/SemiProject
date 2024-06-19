package com.gonggu.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagnation;
import com.gonggu.search.model.dto.SearchDto;
import com.gonggu.search.model.dto.SearchDtoImpl;
import com.gonggu.search.model.service.SearchServiceImpl;

@WebServlet("/searchForm.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SearchServiceImpl searchService = new SearchServiceImpl();
		
		String searchText = request.getParameter("searchtext");
		
		if (searchText != null && !searchText.trim().isEmpty()) {
		ArrayList<SearchDto> searchExamList	= searchService.getSearchExamList(searchText);
		ArrayList<SearchDto> searchCopyList	= searchService.getSearchCopyList(searchText);
		
		request.setAttribute("searchExamList", searchExamList);
		request.setAttribute("searchCopyList", searchCopyList);		
	
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/views/etc/searchList.jsp");
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
