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
		
		String copyNo = request.getParameter("copyNo");
        String approve = request.getParameter("approve");
        
        InformationImpl infoService = new InformationImpl();
        
        
        int result = 0;
        
        
//        String approvalStatus = infoService.getUserApprovalStatus(copyNo);
        
        infoDto.setCopyNo(copyNo);
        infoDto.setApprove(approve);
//        System.out.println("2222222 " + infoDto.getApprove());    // approve
        
//        if (approvalStatus != null && approvalStatus.equals("Y")) {
//            System.out.println("current");
//        } else {
//        }
        
        // 세션에 승인 상태 저장
//        HttpSession session = request.getSession();
//        if (infoDto.getApproveStatus() == 0) {
//            result = infoService.updateCopyApproveStatus(infoDto);
//            infoDto.setApproveStatus(1);
//            System.out.println("int approve = " + infoDto.getApproveStatus());
//        } else {
//        	System.out.println("aaaaa");
//        }
            result = infoService.updateCopyApproveStatus(infoDto);
        
        if(result == 1) {
        	response.sendRedirect("/copyCheck.do?cpage=1");
        } else {
        	response.sendRedirect("/error.jsp");
        }
	}

}
