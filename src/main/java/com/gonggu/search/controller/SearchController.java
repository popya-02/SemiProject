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

@WebServlet("/SearchForm.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		SearchServiceImpl searService = new SearchServiceImpl();
		
		SearchDtoImpl searDto = new SearchDtoImpl();
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String category = request.getParameter("category");
		String searchText = request.getParameter("search-text");
		
		// 전체 게시글 수
		int listCount = searService.getConstSearchListCount(category, searchText);
		searService.getCopySearchListCount(category, searchText);
				
		// 보여줄 수
		int pageLimit = 5;
				
		// 한페이지에 보여질 게시글 
		int boardLimit = 8;
		
		PageInfo pi = Pagnation.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		ArrayList<SearchDtoImpl> constlist = searService.getConstSearchList(pi, category, searchText);
		ArrayList<SearchDtoImpl> copylist = searService.getCopySearchList(pi, category, searchText);
		
		// 게시글 번호 구하기 
		int row = listCount - (cpage-1) * boardLimit; 
		
		request.setAttribute("constlist" , constlist);
		request.setAttribute("copylist" , copylist);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/etc/searchList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
