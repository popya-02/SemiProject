package com.gonggu.copy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.common.PageInfo;
import com.gonggu.common.Pagination;
import com.gonggu.constructExam.model.dto.ConstructDtoImpl;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;
import com.gonggu.copy.model.dto.CopyDto;
import com.gonggu.copy.model.service.CopyServiceImpl;

@WebServlet("/copy/copylist.do")
public class CopyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyListController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		CopyServiceImpl copyService = new CopyServiceImpl();
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		int copypage = Integer.parseInt(request.getParameter("copypage"));
		
		// 전체 게시글 수
		int listCount = copyService.getListCount();
		
		// 보여질 페이지 수 
		int pageLimit = 5;
		
		// 한 페이지에 보여질 게시글 수
		int boardLimit = 9;
		
		PageInfo pi = Pagination.getPageInfo(listCount, copypage, pageLimit, boardLimit);
				
		ArrayList<CopyDto> companyList = copyService.getCompanyList(pi);

		int row = listCount - (copypage - 1) * pageLimit;
		
        request.setAttribute("companyList", companyList);
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
     		
        RequestDispatcher view = request.getRequestDispatcher("/views/copy/copyList.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
