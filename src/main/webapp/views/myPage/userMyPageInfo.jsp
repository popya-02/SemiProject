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
                <li class="mypage_list_1"><a href="/MyPageEstimate/EstimateUser.do?cpage=1">견적/공사 내역</a></li>
                <li class="mypage_list_1"><a href="/mypage/likecopy.do?cpage=1">관심 업체</a></li>
                <li class="mypage_list_1"><a href="/MypageInfo/userInfo.do?userNo=${sessionScope.userNum}">정보 수정</a></li>
            </ul>
        </nav>
        <div class="mypage_list_3_detail">
       		<p>ID와 이름은 수정할 수 없습니다.</p>
        	<div class="info-detail-box">
		         <form action="/mypage/usermypageinfo.do" method="Post" class="form-box">
					<input type="hidden" name="userno" value="${result.userNo }">
		            <div class="mypage_list_3_detail_id">
		                <label for="" class="detail-label">회원 ID</label>
		                <input class="id_box" type="text" name="userid" id="" placeholder="" value="${result.userId }" disabled >
		            </div>
		            <div class="mypage_list_3_detail_name">
		                <label for="" class="detail-label">회원 이름</label>
		                <input class="name_box" type="text" name="name" id="" placeholder="" value="${result.name }" disabled >
		            </div>
		            <div class="mypage_list_3_detail_nickname">
		                <label for="" class="detail-label">닉네임</label>
		                <input class="nickname_box" type="text" name="nickname" id="" placeholder="" value="${result.nickName }" >
		            </div>
		            <div class="mypage_list_3_detail_address">
		                <label for="" class="detail-label">주소</label>
		                <input class="address_box" type="text" name="addr" id="" placeholder="" value="${result.address }" >
		            </div>
		            <div class="mypage_list_3_detail_complete ">
		                <button type="submit" >저장</button>
		            </div>
		         </form>
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