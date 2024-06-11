package com.gonggu.copy.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.copy.model.dto.CopyDto;
import com.gonggu.copy.model.dto.CopyDtoImpl;
import com.gonggu.copy.model.service.CopyService;
import com.gonggu.copy.model.service.CopyServiceImpl;

@WebServlet("/copyDetail.do")
public class CopyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CopyDetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String copyNo = request.getParameter("copyNo");

		CopyService copyService = new CopyServiceImpl();
		ArrayList<CopyDto> copyDetail = copyService.getCopyDetail(copyNo);
		ArrayList<CopyDto> getReview = copyService.getReview(copyNo);
//		System.out.println("aaaa"+copyDetail.size());
		request.setAttribute("copyDetail", copyDetail);
		request.setAttribute("getReview", getReview);
		request.getRequestDispatcher("/views/copy/copyDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String content = request.getParameter("content");
		String copyNo = request.getParameter("copyNo");
		HttpSession session = request.getSession();
		int userNum = (int) session.getAttribute("userNum");
		
	    CopyDtoImpl copyDto = new CopyDtoImpl();
	    copyDto.setReview(content);
	    copyDto.setCopyNo(copyNo);
	    copyDto.setUserNum(userNum);
		
	    CopyService copyService = new CopyServiceImpl();
	    int result = copyService.reviewUpload(copyDto);
	    
		ArrayList<CopyDto> copyDetail = copyService.getCopyDetail(copyNo);
		ArrayList<CopyDto> getReview = copyService.getReview(copyNo);
		
		
		request.setAttribute("copyDetail", copyDetail);
		request.setAttribute("getReview", getReview);
		request.getRequestDispatcher("/views/copy/copyDetail.jsp").forward(request, response);

	    

	}

}
