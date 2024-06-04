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
        <link href="/resources/css/purchase.css" rel="stylesheet">
        
    </head>
    <body>

        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		    <div style="margin-top: 120px; padding: 50px;">
        <div>
            <h3 class="center">결제 화면</h3>
        </div>
    </div>
    <div class="container-box container">
        <form>
            <div class="form-group">
                <label for="name">이름</label><br>
                <input type="text" id="name" value="" readonly class="readonly-input">
            </div>
            <div class="form-group">
                <label for="phone">전화번호</label><br>
                <input type="tel" id="phone" value="" readonly class="readonly-input">
            </div>
            <div class="form-group">
                <label for="company">업체명</label><br>
                <input type="text" id="company" value="" readonly class="readonly-input">
            </div>
            <div class="form-group">
                <label for="amount">결제 금액</label><br>
                <input type="number" id="amount" value="" readonly class="readonly-input">
            </div>
            <div class="form-group center-input location-box">
                <label for="location">주소</label><br>
                <input type="text" id="postcode" placeholder="우편번호">
                <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" id="address" placeholder="주소" style="width: 225px;"><br>
                <input type="text" id="detailAddress" placeholder="상세주소" required>
                <input type="text" id="extraAddress" placeholder="참고항목">
            </div>
            <div class="form-group center-input location-box">
                <label for="datepicker">날짜</label><br>
                <input type="text" id="datepicker" name="date" style="width: 225px; text-align: center; color: rgb(73, 73, 73);" value="날짜 선택" required>
            </div>  
            <button type="submit" class="btn">결제하기</button>
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
    </body>

</html>