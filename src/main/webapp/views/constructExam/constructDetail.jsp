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
        <link href="/resources/css/constructDetail.css" rel="stylesheet">
        
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		    <div class="container-fluid page-header py-5" style="background-color: #223455;">
        <h1 class="text-center text-white display-6">시공예시</h1>
        <!-- <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active text-white">Shop Detail</li>
            </ol> -->
    </div>
    <!-- Single Page Header End -->


    <!-- Single Product Start -->

    <!-- 시공예시 메인 이미지 -->

    <div class="tlrhd">
        <img class="tlrhd-img img-border rounded" src="/resources/img/업체이미지1.jpeg">
    </div>
    <div class="tlrhddjqcpaud">
        <p>업체명</p>
    </div>

    <!-- 시공 nav -->
    <div class="tlrhd-nav">
        <a href="#" class="tlrhd-border border border-secondary text-primary rounded-pill px-4 py-3">공유하기</a>
        &nbsp;&nbsp;
        <a href="#" class="tlrhd-border border border-secondary text-primary rounded-pill px-4 py-3">이 스타일로 상담하기</a>
    </div>

    <!-- 상세 설명 -->
    <div class="tlrhd-content">
     스마트에디터 쓸거임
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