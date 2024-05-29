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
        <link href="/resources/css/login.css" rel="stylesheet">
        <link href="/resources/css/userMyPageInfo.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		        <h2 class="mypage_1">마이페이지</h2>
        <nav class="mypage_list">
            <ul>
                <li class="mypage_list_1"><a href="">견적/공사 내역</a></li>
                <li class="mypage_list_2"><a href="">관심 업체</a></li>
                <li class="mypage_list_3"><a href="">정보 수정</a></li>
            </ul>
        </nav>
        <div class="mypage_list_3_detail">
            <div class="mypage_list_3_detail_id">
                <label for="">회원 ID</label>
                <input class="id_box" type="id" name="" id="" placeholder="">
            </div>
            <div class="mypage_list_3_detail_name">
                <label for="">회원 이름</label>
                <input class="name_box" type="name" name="" id="" placeholder="">
            </div>
            <div class="mypage_list_3_detail_nickname">
                <label for="">닉네임</label>
                <input class="nickname_box" type="name" name="" id="" placeholder="">
            </div>
            <div class="mypage_list_3_detail_address">
                <label for="">주소</label>
                <input class="address_box" type="text" name="" id="" placeholder="">
            </div>
            <div class="mypage_list_3_detail_complete">
                <a href="">저장</a>
            </div>
        </div>


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