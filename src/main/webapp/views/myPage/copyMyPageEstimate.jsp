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
<link href="/resources/css/copyMyPageEstimate.css" rel="stylesheet">
</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<h2 class="mypage_1">업체페이지</h2>
	<c:choose>
		<c:when test="${sessionScope.approvalStatus == 'B'}">
			<nav class="mypage_list">
				<ul>
					<li class="mypage_list_1"><a href="/MyPageEstimate/EstimateCopy.do?cpage=1">견적/공사 내역</a></li>
					<li class="mypage_list_2"><a href="/MypageInfo/copyInfo.do?copyNo=${sessionScope.copyNum}">정보 수정</a></li>
				</ul>
			</nav>
			<div class="mypage_list_1_detail">
				<form action="/MyPageEstimate/EstimateCopy.do?cpage=${pi.copypage }" method="Get">
					<input type="hidden" name="cpage" value="1">
					<p class="estimate_list">견적/공사 내역</p>

					<div class="reservation-list body">
						<div class="reservation-list-header">
							<div class="user_name" name="userName">고객 이름</div>
							<div class="user_name" name="phoneNum">고객 번호</div>
							<div class="reservation_number" name="constructNo">예약 번호</div>
						</div>
						<c:choose>
							<c:when test="${empty list}">
								<div>
									<div colspan="5" style="text-align: center !important; padding: 30px;">등록된 글이 없습니다</div>
								</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${list}">
									<a class="reservation-list-item" href="/copyDetail.do?copyNo=${item.copyNo}"> <!-- 어떤 게시글에 들어가는지 알수있음 -->
										<div class="company_name">${item.name}</div>
										<div class="company_name">${item.phoneNum}</div>
										<div class="reservation_number">${item.constructNo}</div>
									</a>
									<c:set var="row" value="${row-1}" />
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<h3 style="text-align: center; margin: 100px;">업체 승인 요청 대기 중입니다...</h3>
			</div>
		</c:otherwise>
	</c:choose>

	<!-- 페이지네이션 -->
	<div class="col-12">
		<div class="pagination d-flex justify-content-center mt-5">

			<!-- 왼쪽 버튼  -->
			<c:choose>
				<c:when test="${pi.copypage == 1}">
					<li class="page-item" style="margin-right: 0px"><a class="rounded page-n" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:when>

				<c:otherwise>
					<li class="page-item" style="margin-right: 0px"><a class="rounded page-n" href="/MyPageEstimate/EstimateCopy.do?cpage=${pi.copypage-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:otherwise>

			</c:choose>

			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<li class="page-item" style="margin-right: 0px"><a class="rounded page-n" href="/MyPageEstimate/EstimateCopy.do?cpage=${page}">${page}</a></li>
			</c:forEach>



			<c:choose>
				<c:when test="${pi.copypage == pi.maxPage}">
					<li class="page-item" style="margin-right: 0px"><a class="rounded page-n" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item" style="margin-right: 0px"><a class="rounded page-n" href="/MyPageEstimate/EstimateCopy.do?cpage=${pi.copypage+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:otherwise>
			</c:choose>
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