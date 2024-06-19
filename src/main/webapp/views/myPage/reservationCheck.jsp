
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
		<c:when test="${sessionScope.userType == 'basicUser'}">

			<div class="reservation-list body">
				<div class="reservation-list-item">
					<img src="/img/" alt="사진">
					<!-- 사진 크기 조정 -->
					<div class="reservation-details">
						<div class="reservation-details-item">
							<strong style="width: 300px">업체명:</strong><input type="text"
								class="fixed-input" value="${result.copyName}" readonly
								style="padding-left: 10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">예약번호:</strong><input type="text"
								class="fixed-input" value="${result.constructNo}" readonly
								style="padding-left: 10px">
						</div>

						<div class="reservation-details-item">
							<strong style="width: 300px">주소:</strong><input type="text"
								class="fixed-input" value="${result.address}" readonly
								style="padding-left: 10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">시공 금액:</strong><input type="text"
								class="fixed-input" value="${result.estimatePrice} 원  " readonly
								style="padding-left: 10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">예약금액:</strong><input type="text"
								class="fixed-input" value="${result.constDeposit} 원  " readonly
								style="padding-left: 10px">
						</div>
						<%-- <div class="reservation-details-item">
							<strong>전화번호:</strong><input type="text" class="fixed-input"
								value="${result.phoneNum}" readonly>
						</div> --%>
						<div class="reservation-details-item">
							<strong style="width: 300px">시공날짜:</strong><input type="text"
								class="fixed-input" value="${result.constStartDate}  -  ${result.constEndDate}" readonly
								style="padding-left: 10px">
						</div>
					</div>

				</div>
			</div>
			<c:choose>
				<c:when test="${sessionScope.purchaseStatus == 'S'}">
					<div class="purchase-box">
						<form action="/purchase.do?chatNum=${result.chattingNum}" method="GET">
							<input type="hidden" name="chattingNum" value="${result.chattingNum}" /> 
							<input type="hidden" name="constructNum" value="${result.constructNo}" /> 
							<button class="purchase" type="submit">결제 하기</button>
						</form>
					</div>
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
			</c:choose>
		</c:when>

		<c:when test="${sessionScope.userType == 'copyUser'}">
			<div class="reservation-list body">
				<div class="reservation-list-item">
					<img src="/img/" alt="사진">
					<!-- 사진 크기 조정 -->
					<div class="reservation-details">
						<div class="reservation-details-item">
							<strong style="width: 300px">업체명 :</strong><input type="text" class="fixed-input"
								value="${result.copyName}" readonly style="padding-left:10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">예약번호 :</strong><input type="text" class="fixed-input"
								value="${result.constructNo}" readonly style="padding-left:10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px"> 주소 :</strong><input type="text" class="fixed-input"
								value="${result.address}" readonly style="padding-left:10px">
						</div> 
						<div class="reservation-details-item">
							<strong style="width: 300px">상세 주소 :</strong><input type="text" class="fixed-input"
								value="${result.constAddr}" readonly style="padding-left:10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">금액 :</strong><input type="text" class="fixed-input"
								value="${result.estimatePrice}" readonly style="padding-left:10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">전화번호 :</strong><input type="text" class="fixed-input"
								value="${result.phoneNum}" readonly style="padding-left:10px">
						</div>
						<div class="reservation-details-item">
							<strong style="width: 300px">시공 날짜 :</strong><input type="text" class="fixed-input"
								value="${result.constStartDate}  -  ${result.constEndDate}" readonly style="padding-left:10px">
						</div>
						<c:choose>
							<c:when test="${result.constStatus == 'N' && sessionScope.purchaseStatus == 'Y'}">
								<div>결제 하기</div>
							</c:when>
							<c:otherwise>
								
							</c:otherwise>
						</c:choose>
					</div>
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