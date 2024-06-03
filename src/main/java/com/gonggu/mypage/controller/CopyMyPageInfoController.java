package com.gonggu.mypage.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.gonggu.mypage.model.dto.MyPageDtoImpl;
import com.gonggu.mypage.model.service.MyPageServiceImpl;

@WebServlet("/mypage/copyinfo.do")
public class CopyMyPageInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyMyPageInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String copyNo = request.getParameter("copyno");
		String copyName = request.getParameter("copyname");
		String telNum = request.getParameter("telnum");
		String copyAddr = request.getParameter("copyaddr");
		String constructArea = request.getParameter("constructarea");
		String content = request.getParameter("content");
		
		MyPageDtoImpl myDto = new MyPageDtoImpl();
		myDto.setCopyNo(copyNo);
		myDto.setCopyName(copyName);
		myDto.setTelNum(telNum);
		myDto.setCopyAddr(copyAddr);
		myDto.setConstructArea(constructArea);
		myDto.setContent(content);
		
		// 파일 업로드
		Collection<Part> parts = request.getParts();
		String uploadDirectory = "C:\\dev\\File\\semiProject\\SemiProject\\src\\main\\webapp\\resources\\img";

		// 파일 업로드 디렉토리가 존재하지않으면 생성
		File PicturePath = new File(uploadDirectory);
		if (!PicturePath.exists()) {
			PicturePath.mkdirs();
		}

		String PictureName = null;
		
		MyPageServiceImpl myService = new MyPageServiceImpl();
		int result = myService.setCopyEdit(myDto);
		
		for(Part part : parts) {
			PictureName = getPictureName(part);
			if(PictureName != null) {
				System.out.println(PicturePath + File.separator + PictureName);
				part.write(PicturePath + File.separator + PictureName);
				
				myDto.setPicturePath(uploadDirectory);
				myDto.setPictureName(PictureName);
				
				int resultUpload = myService.pictureUpload(myDto);
			}
		}
		
		if(result == 1) {
			response.sendRedirect("/MypageInfo/copyInfo.do?copyNo="+copyNo);
		}
	}
	
	 private String getPictureName(Part part) {
	        String contentDisposition = part.getHeader("content-disposition");
	        
	        System.out.println(contentDisposition);
	        
	        String[] tokens = contentDisposition.split(";");
	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	                return token.substring(token.indexOf('=') + 2, token.length() - 1);
	            }
	        }
	        return null;
	    }
	

}
