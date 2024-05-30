package com.gonggu.copy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gonggu.copy.model.dto.CopyDto;
import com.gonggu.copy.model.service.CopyService;
import com.gonggu.copy.model.service.CopyServiceImpl;

@WebServlet("/copyDetail.do")
public class CopyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CopyDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
