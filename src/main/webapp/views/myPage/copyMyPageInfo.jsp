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
            <li class="mypage_list_1"><a href="/MyPageEstimate/EstimateCopy.do?cpage=1">견적/공사 내역</a></li>
            <li class="mypage_list_1"><a href="/MypageInfo/ChattingList.do?copyNo=${sessionScope.copyNum}&chatpage=1">견적 상담 채팅</a></li>
            <li class="mypage_list_1"><a href="/MypageInfo/copyInfo.do?copyNo=${sessionScope.copyNum}">정보 수정</a></li>
        </ul>
    </nav>
    <div class="mypage_list_3_detail">
     <form action="/mypage/copyinfo.do"  method="Post" enctype="multipart/form-data" class="copy-detail-form">
     	<input type="hidden" name="copyno" value="${result.copyNo }">
     	<input type="hidden" name="copyname" value="${result.copyName }">
        <div class="picture_box" id="image-show"> <!-- 이미지 띄울 공간 -->
        
        <c:if test="${result.pictureName != null }">
        <img alt="" src="/resources/img/${result.pictureName }" id="img-id" style="width:100%; height:100%; objectFit: cover;" >
        </c:if>
        
        </div>
        <input type="file" name="picture" accept="image/*" onchange="loadFile(this)">
        <!-- <div class="mypage_list_3_detail_picture">
            <label for="">업체 사진</label><br>
            <input class="picture_box" type="name" name="" id="" placeholder="">
        </div> -->
        <div class="info-div-box">
	        
	        <div class="mypage_list_3_detail_c_id">
	            <label for="">사업자등록번호</label><br>
	            <input class="c_id_box" type="text" id="" value="${result.copyNo}" disabled>
	        </div>
	        <div class="mypage_list_3_detail_c_name">
	            <label for="">업체 이름</label><br>
	            <input class="c_name_box" type="text" id="" value="${result.copyName}" disabled>
	        </div>
	        <div class="mypage_list_3_detail_c_number">
	            <label for="">업체 전화번호</label><br>
	            <input class="c_number_box" type="text" name="telnum" id="" value="${result.telNum}">
	        </div>
	        <div class="mypage_list_3_detail_construction_area">
	            <label for="">시공 지역</label><br>
	            <input class="construction_area_box" type="text" name="constructarea" id="" value="${result.constructArea}">
	        </div>
	        <div class="mypage_list_3_detail_c_address">
	            <label for="">업체 주소</label><br>
	            <input class="c_address_box" type="text" name="copyaddr" id="" value="${result.copyAddr}">
	        </div>
	        <div class="mypage_list_3_detail_introduce">
	            <label for="">소개글</label><br>
	            <textarea class="introduce_box" type="text" name="content" id="">${result.content}</textarea>
	        </div>
	        <div class="mypage_list_3_detail_complete">
	            <button type="submit">저장</button>
	        </div>
       </div>
      </form>
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
    
    <!-- 사진 넣는 Javascript -->
   <%--  <script src="/resources/js></script> --%>
    </body>
    
    <script>
        function loadFile(input) {
            let file = input.files[0]; // 선택된 파일 가져오기

            let newImage = document.createElement("img"); //새 이미지 추가

            //이미지 source 가져오기
            newImage.src = URL.createObjectURL(file);
            newImage.id = "img-id"
            newImage.style.width = "100%";
            newImage.style.height = "100%";
            newImage.style.objectFit = "cover";

            //이미지를 image-show div에 추가
            let container = document.getElementById('image-show');
            container.innerHTML = '';
            container.appendChild(newImage);
        }
    </script>

</html>
