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

@WebServlet("/constructExam/constructlist.do")
public class ConstructListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		
		
			
		int copypage = Integer.parseInt(request.getParameter("constructpage"));
		
		int categoryNum = Integer.parseInt(request.getParameter("categoryNum"));
		
		// 전체 게시글 수
		int listCount = constructService.getListCategoryCount(categoryNum);
		
		// 보여질 페이지 수 
		int pageLimit = 5;
		
		// 한 페이지에 보여질 게시글 수
		int boardLimit = 6;
		
		PageInfo pi = Pagination.getPageInfo(listCount, copypage, pageLimit, boardLimit);
				

		List<ConstructDto> constructList = constructService.getConstructCategoryList(pi, categoryNum);

		
		int row = listCount - (copypage - 1) * pageLimit;

		List<ConstructDto> category = constructService.getCategory();
		
		request.setAttribute("categoryList", category);
		request.setAttribute("checkCategory", categoryNum);
        request.setAttribute("constructList", constructList);
        request.setAttribute("row", row);
        request.setAttribute("pi", pi);
        
        ConstructDtoImpl constructDto = new ConstructDtoImpl();
        try {
        	HttpSession session = request.getSession();
        	int userNum = (int)session.getAttribute("userNum");
        	
        	constructDto.setUserNum(userNum);
        }catch(NullPointerException e){
        	
        }
        
        ArrayList<ConstructDtoImpl> getLike = constructService.getLike(constructDto);
		request.setAttribute("getLike", getLike);
        RequestDispatcher view = request.getRequestDispatcher("/views/constructExam/constructList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
