package com.gonggu.constructExam.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.constructExam.model.service.ConstructServiceImpl;

@WebServlet("/constructExam/constructdelete.do")
public class ConstructDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConstructDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int examNo = Integer.parseInt(request.getParameter("examNo"));
		int fileNo = Integer.parseInt(request.getParameter("fileNo"));
		String fileName = request.getParameter("fileName");
		int page = Integer.parseInt(request.getParameter("page"));
		ConstructServiceImpl constructService = new ConstructServiceImpl();
		int result = constructService.listDelete(examNo);
        if(result == 1 && fileNo == 0) { // 업로드한 파일이 없을때
			
			response.sendRedirect("/constructExam/constructlist.do?constructpage="+page);
		} else if(result == 1 && fileNo > 0) { // 업로드한 파일이 있을때
			String uploadDiretory ="C:\\greenAcademy\\dev\\workspace\\semiProject\\SemiProject\\src\\main\\webapp\\resources\\img";
			File file = new File(uploadDiretory + "\\" + fileName);
			file.delete();
			
			int deleteResult = constructService.fileDelete(fileNo);
			response.sendRedirect("/constructExam/constructlist.do?constructpage=1&categoryNum=0");
		}
	}

}
