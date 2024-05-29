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
        <link href="/resources/css/copyMyPageInfo.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		    <h2 class="companypage_1">업체페이지</h2>
    <nav class="mypage_list">
        <ul>
            <li class="mypage_list_1"><a href="">견적/공사 내역</a></li>
            <li class="mypage_list_2"><a href="">정보 수정</a></li>
        </ul>
    </nav>
    <div class="mypage_list_3_detail">
        <div class="mypage_list_3_detail_picture" method="post" enctype="multipart/form-data"> <!-- 이미지 파일 데이터에 알맞는 enctype 설정 -->
            <div class="picture_box" id="image-show"> <!-- 이미지 띄울 공간 -->
            </div>
            <input type="file" accept="image/*" onchange="loadFile(this)">
        </div>
        <!-- <div class="mypage_list_3_detail_picture">
            <label for="">업체 사진</label><br>
            <input class="picture_box" type="name" name="" id="" placeholder="">
        </div> -->
        <div class="mypage_list_3_detail_c_id">
            <label for="">사업자등록번호</label><br>
            <input class="c_id_box" type="id" name="" id="" placeholder="">
        </div>
        <div class="mypage_list_3_detail_c_name">
            <label for="">업체 이름</label><br>
            <input class="c_name_box" type="name" name="" id="" placeholder="">
        </div>
        <div class="mypage_list_3_detail_c_number">
            <label for="">업체 번호</label><br>
            <input class="c_number_box" type="name" name="" id="" placeholder="">
        </div>
        <div class="mypage_list_3_detail_c_address">
            <label for="">업체 주소</label><br>
            <input class="c_address_box" type="name" name="" id="" placeholder="">
        </div>
        <div class="mypage_list_3_detail_construction_area">
            <label for="">시공 지역</label><br>
            <input class="construction_area_box" type="name" name="" id="" placeholder="">
        </div>
        <div class="mypage_list_3_detail_introduce">
            <label for="">소개글</label><br>
            <textarea class="introduce_box" type="text" name="" id="" placeholder=""></textarea>
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