package com.gonggu.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.admin.model.service.InformationImpl;
import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagnation;


@WebServlet("/copyCheck.do")
public class CopyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyCheckController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
InformationImpl infoService = new InformationImpl();
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String category = request.getParameter("category");
		String searchText = request.getParameter("search-text");
		
		// 전체 게시글 수
		int listCount = infoService.copyApproveListCount(category, searchText);
				
		// 보여줄 수
		int pageLimit = 5;
				
				
		// 한페이지에 보여질 게시글 
		int boardLimit = 8;
		
		PageInfo pi = Pagnation.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		ArrayList<InformationDto> list = infoService.copyApproveList(pi, category, searchText);
		
		
		// 게시글 번호 구하기 
		int row = listCount - (cpage-1) * boardLimit; 
		
		// 게시물 목록 jsp에게 전달해주기
				request.setAttribute("list" , list);
				request.setAttribute("row", row);
				request.setAttribute("pi", pi);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/copyCheck.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

