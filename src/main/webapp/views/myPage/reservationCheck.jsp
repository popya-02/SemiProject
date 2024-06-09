
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="stylesheet" href="/resources/css/reserveCheck.css">
        <%@ include file="/views/common/head.jsp"%>

        <meta charset="utf-8">
        <title>회원 페이지</title>
        <link href="/resources/css/style.css" rel="stylesheet">
        
    </head>

    <body>

       

        <!-- Navbar start -->
        <%@ include file="/views/common/header.jsp"%>   
        <!-- Navbar End -->


        <nav class="navTop">
            <div>
                <h2 class="centerBox">예약확인</h2>
            </div>
        </nav>

	<c:choose>
		<c:when test="${sessionScope.userType == null}">
			<div class="reservation-list body">
				<div class="reservation-list-item">
					<img src="/img/vintage_ratro_picture.jpg" alt="사진">
					<!-- 사진 크기 조정 -->
					<div class="reservation-details">
						<div class="reservation-details-item">
							<strong>업체명:</strong><input type="text" class="fixed-input"
								value="" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>예약번호:</strong><input type="text" class="fixed-input"
								value=" 789012" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>주소:</strong><input type="text" class="fixed-input"
								value=" 서울시 강북구 " readonly>
						</div>
						<div class="reservation-details-item">
							<strong>상세주소:</strong><input type="text" class="fixed-input"
								value="어디어디 아파트 102동 2202호" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>금액:</strong><input type="text" class="fixed-input"
								value=" 150,000원" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>전화번호:</strong><input type="text" class="fixed-input"
								value="" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>날짜:</strong><input type="text" class="fixed-input"
								value=" 2024-06-02" readonly>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.userType == 'basicUser'}">

			<div class="reservation-list body">
				<div class="reservation-list-item">
					<img src="/img/vintage_ratro_picture.jpg" alt="사진">
					<!-- 사진 크기 조정 -->
					<div class="reservation-details">
						<div class="reservation-details-item">
							<strong>업체명:</strong><input type="text" class="fixed-input"
								value="" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>예약번호:</strong><input type="text" class="fixed-input"
								value=" 789012" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>주소:</strong><input type="text" class="fixed-input"
								value=" 서울시 강북구 " readonly>
						</div>
						<div class="reservation-details-item">
							<strong>상세주소:</strong><input type="text" class="fixed-input"
								value="어디어디 아파트 102동 2202호" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>금액:</strong><input type="text" class="fixed-input"
								value=" 150,000원" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>전화번호:</strong><input type="text" class="fixed-input"
								value="" readonly>
						</div>
						<div class="reservation-details-item">
							<strong>날짜:</strong><input type="text" class="fixed-input"
								value=" 2024-06-02" readonly>
						</div>
					</div>
				</div>
			</div>
		</c:when>

		<c:when test="${sessionScope.userType == 'copyUser'}">
			<div class="reservation-list body">
				<div class="reservation-list-item">
				</div>
			</div>
		</c:when>

	</c:choose>

        <%@ include file="/views/common/footer.jsp"%>
        <!-- Copyright End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
    <!-- JavaScript Libraries -->
    <%@ include file="/views/common/jsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    </body>

</html>