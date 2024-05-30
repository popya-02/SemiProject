package com.gonggu.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.admin.model.service.InformationImpl;
import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagnation;


@WebServlet("/CopyCheckController")
public class CopyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyCheckController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		String category = request.getParameter("category");
		String searchText = request.getParameter("search-text");
		
		
		InformationImpl infoService = new InformationImpl();
		
		int listCount = infoService.getListCount(category, searchText);
		
		// 보여줄 수
		int pageLimit = 5;
		
		
		// 한페이지에 보여질 게시글 
		int boardLimit = 5;
		
		
		PageInfo pi = Pagnation.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		ArrayList<InformationDto> list = infoService.copyApproveList(pi);
		
		
		infoService.copyApproveList(pi);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String approve = request.getParameter("approve");
		String cancle = request.getParameter("cancle");
		
		
		
		InformationDto infoDto = new InformationDto();

		InformationImpl infoService = new InformationImpl();
		infoService.copyApprove(infoDto);
		
	}

}

