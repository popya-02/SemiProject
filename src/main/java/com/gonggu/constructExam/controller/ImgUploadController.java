package com.gonggu.constructExam.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileUploaderHtml5.do")
public class ImgUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImgUploadController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sFileInfo = "";
		
		//파일명 - 싱글파일업로드와 다르게 멀티파일업로드는 HEADER로 넘어옴
		String filename = request.getHeader("file-name");
		
		//확장자를소문자로 변경
		String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
		filename_ext = filename_ext.toLowerCase();
		
		// 이미지 검증 배열변수
		String[] allow_file = {"jpg","png","bmp","gif"};
		
		// 확장자 검증 반복문
		int cnt = 0;
		for(int i=0; i<allow_file.length; i++) {
			if(filename_ext.equals(allow_file[i])){
				cnt++;
			}
		}
		
		System.out.println('d');
		
		if(cnt == 0) {
			// 이미지가 아닐 때
			System.out.println('s');
			System.out.println("NOTALLOW" + filename);
		}else {
			System.out.println('a');
			// 이미지 일 때
			// 파일 기본 경로
			String defaultPath = request.getServletContext().getRealPath("/");
			
			System.out.println(defaultPath);
			//\resources\img\exam_picture
			// 파일 기본 경로 상세
			String path = defaultPath + "resources" + File.separator + "img" + File.separator + "exam_picture" + File.separator;
			
			File file = new File(path);
			if(!file.exists()) {
				file.mkdir();
			}
			
			String realfilename = UUID.randomUUID().toString() + "." + filename_ext;
			InputStream is = request.getInputStream();
			OutputStream os = new FileOutputStream(path + realfilename);
			
			int numRead;
			
			// 파일쓰기
			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			while((numRead = is.read(b,0,b.length)) != -1) {
				os.write(b,0,numRead);
			}
			if(is != null) {
				is.close();
			}
			
			os.flush();
			os.close();
			sFileInfo += "&bNewLine=true&sFileName=" + filename + "&sFileURL=" + "/resources/img/exam_picture/" + realfilename;
			response.getWriter().write(sFileInfo);
		}
		
		
		
		
		
		
	}

}
