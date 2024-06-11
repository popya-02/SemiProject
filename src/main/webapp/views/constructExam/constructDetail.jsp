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
     
    </div>


    <!-- 시공예시 메인 이미지 -->

    <div class="tlrhd">
        <img class="tlrhd-img img-border rounded" src="/resources/img/${detail.fileName}">
    </div>
    <div class="tlrhddjqcpaud">
        <p>${detail.copyName}</p>
    </div>

    <!-- 시공 nav -->
    <div class="tlrhd-nav">
        <a href="#" class="tlrhd-border border border-secondary text-primary rounded-pill px-4 py-3">공유하기</a>
        &nbsp;&nbsp;
        <c:if test="${sessionScope.userType == 'basicUser' }">
	        <a href="/chatting/connection.do?copyNum=${detail.copyNum}&userNum=${sessionScope.userNum}" class="tlrhd-border border border-secondary text-primary rounded-pill px-4 py-3">이 스타일로 상담하기</a>
        </c:if>
    </div>
<br><br>
<br>
<br>
<div class="tlrhd-ruswjr border-secondary text-primary">
시공 시작일 : ${detail.constructStartDate}
</div>
<br>
<div class="tlrhd-ruswjr border-secondary text-primary">
시공 종료일 : ${detail.constructEndDate}
  </div>
  <br>
  <div class="tlrhd-ruswjr border-secondary text-primary">
시공지 주소 : ${detail.constructAddr}
</div>
<br>
<div class="tlrhd-ruswjr border-secondary text-primary">
시공 평수 : ${detail.constructRange}평
</div>
<br>
<div class="tlrhd-ruswjr border-secondary text-primary">
시공 가격 : ${detail.constructPrice}원
</div>
<br>

        

    </div>
    <!-- 상세 설명 -->
    <div class="tlrhd-content">
    ${detail.content }
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
<!--     <script src="/resources/js/chatting.js"></script> -->
    </body>

</html>