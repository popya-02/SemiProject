package com.gonggu.constructExam.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gonggu.constructExam.model.dto.ConstructDtoImpl;
import com.gonggu.constructExam.model.service.ConstructServiceImpl;

@WebServlet("/constructExam/constructEnroll.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ConstructEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConstructEnrollController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String copyNum = request.getParameter("copyNum");
		String copyName = request.getParameter("copyName");

		int constructList =Integer.parseInt(request.getParameter("constructList"));

		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String indate = request.getParameter("indate");

		
		request.setAttribute("copyNum", copyNum);
		request.setAttribute("copyName", copyName);
		request.setAttribute("constructList", constructList);
		request.setAttribute("category", category);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("indate", indate);
		
		ConstructDtoImpl constructDto = new ConstructDtoImpl();
		constructDto.setCopyNum(copyNum);
		constructDto.setCopyName(copyName);
		constructDto.setConstructList(constructList);
		constructDto.setCategoryNo(category);
		constructDto.setTitle(title);
		constructDto.setContent(content);
		constructDto.setIndate(indate);
		
		
		
		Collection<Part> parts = request.getParts();
		int getExamNo = 0;
		String uploadDirectory = "C:\\greenAcademy\\dev\\workspace\\semiProject\\SemiProject\\src\\main\\webapp\\resources\\img";
		 File filePath = new File(uploadDirectory);
	        if (!filePath.exists()) {
	            filePath.mkdir();
	        }
	        
	        String fileName = null;
	        ConstructServiceImpl constructService = new ConstructServiceImpl();
	        int result = constructService.enroll(constructDto);
	        
	        if(result > 0) {
	        	constructService.getExamNo(constructDto);
	        }
		
		ConstructDtoImpl resultDto = constructService.getDeteil(constructDto.getExamNo());
		for (Part part : parts) {
            fileName = getFileName(part);
            if (fileName != null) {
                part.write(filePath + File.separator + fileName);
                constructDto.setUploadDirectory(uploadDirectory);
                constructDto.setFileName(fileName);
                int resultUpload = constructService.fileUpload(constructDto); // 파일 업로드
            }
        }
		if(result == 1) {
		response.sendRedirect("/constructExam/constructlist.do?constructpage=1");

	}
}
	
    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return null;
    }
}
