package com.gonggu.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;

@WebServlet("/UserMyPageLike")
public class UserMyPageLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserMyPageLike() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int likeNo = Integer.parseInt(request.getParameter("likeno"));
//		int constructNo = Integer.parseInt(request.getParameter("constructno"));
//		String pictureName = request.getParameter("picturename");
//		String copyName = request.getParameter("copyname");
		
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		myDto.setLikeNo(likeNo);
	}

}
