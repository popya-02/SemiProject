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
import com.gonggu.search.model.service.SearchServiceImpl;

@WebServlet("/SearchForm.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		SearchServiceImpl searService = new SearchServiceImpl();
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String category = request.getParameter("category");
		String searchText = request.getParameter("search-text");
		
		// 전체 게시글 수
		int listCount = searService.getSearchListCount(category, searchText);
				
		// 보여줄 수
		int pageLimit = 5;
				
				
		// 한페이지에 보여질 게시글 
		int boardLimit = 8;
		
		PageInfo pi = Pagnation.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		ArrayList<SearchDto> list = searService.getSearchList(pi, category, searchText);
		
		// 게시글 번호 구하기 
		int row = listCount - (cpage-1) * boardLimit; 
		
		request.setAttribute("list" , list);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/etc/searchList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
