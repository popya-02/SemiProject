<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
	    <%@ include file="/views/common/head.jsp"%>
        <title>GONGGU</title>
        <!-- Template Stylesheet -->
        <link href="/resources/css/style.css" rel="stylesheet">
        <link href="/resources/css/signup.css" rel="stylesheet">
        <link href="/resources/css/constructEnroll.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		<div class="page-title py-5 point-color">
        	<h2 class="text-center text-white">시공예시 등록</h2>
        </div>
        <section class="example-insert-section">
            <div class="example-div">
                <div class="copy-infor">
                    <p>업체명 : [업체명]</p>
                </div>
                <div class="copy-infor">
                    <p>작성일 : 2024-05-28</p>
                </div>
                <div>
                    <input type="text" class="example-title" placeholder="제목을 입력해주세요.">
                </div>
                <div class="smart-editor" id="smarteditor">
                    <textarea id="editorTxt" name="content" rows="4" required class="smart-editor-box"></textarea>
                </div>
                <div class="btn-box">
                    <button type="submit" class="btn editor-btn">등 록</button>
                </div>
            </div>
        </section>

        <!-- Footer Start -->
       	<%@ include file="/views/common/footer.jsp"%>
        <!-- Copyright End -->
        
        <!-- Back to Top -->
        <a href="#" class="btn btn-point border-3 rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
    <!-- JavaScript Libraries -->
    <%@ include file="/views/common/jsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>
    </body>

</html>