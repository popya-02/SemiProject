package com.gonggu.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gonggu.admin.model.dto.InformationDto;
import com.gonggu.admin.model.service.InformationImpl;

@WebServlet("/copyApprove.do")
public class CopyApproveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyApproveController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InformationDto infoDto = new InformationDto();
		
        int copyNo = Integer.parseInt(request.getParameter("copyNo"));
        String approve = request.getParameter("approve");
        
        InformationImpl infoService = new InformationImpl();
        
        
        // 세션에 승인 상태 저장
        HttpSession session = request.getSession();
        if ("approve".equals(approve)) {
            session.setAttribute("approvalStatus", "B");
        } else {
            session.setAttribute("approvalStatus", "A");
        }
        
        
        int result = infoService.copyApproveStatus(infoDto);
        
        if(result == 1) {
        	response.sendRedirect("/copyCheck.do");
        }
	}

}
