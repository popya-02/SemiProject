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
<link href="/resources/css/copyList.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.2/font/bootstrap-icons.min.css">
</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->
	
	<div class="banner-box banner">
		<div class="padding-area1"></div>
		<div id="carouselId" class="carousel slide position-relative img-banner" data-bs-ride="carousel">
	        <div class="carousel-inner banner-size " role="listbox">
	            <div class="carousel-item active">
	                <img src="/resources/img/banner_modern_ing.jpg" class="img-fluid w-100 h-100" alt="First slide">
	            </div>
	            <div class="carousel-item">
	                <img src="/resources/img/banner_vintage_ing.jpg" class="img-fluid w-100 h-100" alt="Second slide">
	            </div>
	        </div>
	    </div>
   		<div class="padding-area2"></div>
    </div>

	<main>

		<!-- 업체 -->
		<div class="album py-5 bg-body-tertiary exam-list-box">
			<div class="container">
			<h2 class="point-text" style="z-index: 2;">업체 목록</h2>
			<hr>

				<!-- ------------------------------------------------------------------------ -->

				<c:choose>
					<c:when test="${empty companyList}">
						<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
							<h5>등록 되어있는 업체가 없습니다.</h5>
						</c:when>
						
					<c:otherwise>
						<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3"
							scope="row">
							<c:forEach var="companyList" items="${companyList}">
							<input type="hidden" id="${companyList.copyName}" name="copyNum" value="${companyList.copyNum}">
								<div class="col">
									<div class="card shadow-sm" >
										<a href="/copyDetail.do?copyNo=${companyList.copyNum}" class="img-size">
											<c:choose>
												<c:when test="${companyList.copyPhoto == null }">
													<img class="bd-placeholder-img card-img-top img-contain"
														src="/resources/img/imgnone.png" alt="업체 이미지"/>
												</c:when>
												<c:otherwise>
													<img class="bd-placeholder-img card-img-top img-contain"
														src="/resources/img/${companyList.copyPhoto}" alt="업체 이미지"/>
												</c:otherwise>
											</c:choose>
										</a>
										<p class="djqcpaud">${companyList.copyName}</p>
										<c:if test="${sessionScope.userType == 'basicUser' }">
											<c:choose>
												<c:when test="${not empty getLike }">
													<c:set var="count" value="1" />
													<c:forEach var="item" items="${getLike}">
														<c:if test="${companyList.copyNum == item.copyNum}">
															<button type="button" name="${companyList.copyName}" id="likeButton" class="likeButton bi bi-house-heart tlrhd-like border border-secondary text-primary rounded-pill clicked" onclick=""></button>
															<c:set var="count" value="${count+1 }" />
														</c:if>
													</c:forEach>
														<c:if test="${count == 1}">
															<button type="button" name="${companyList.copyName}" id="likeButton" class="likeButton bi bi-house-heart tlrhd-like border border-secondary text-primary rounded-pill" onclick=""></button>
														</c:if>
												</c:when>
												<c:otherwise>
														<button type="button" name="${companyList.copyName}" id="likeButton" class="likeButton bi bi-house-heart tlrhd-like border border-secondary text-primary rounded-pill" onclick=""></button>
												</c:otherwise>
											</c:choose>
										</c:if>
									</div>
								</div>
								<c:set var="row" value="${row-1}" />
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
				
				<div class="card-body">
					<div class="d-flex justify-content-between align-items-center">
						<div class="btn-group"></div>
					</div>
				</div>
			</div>
		</div>
	</main>


	<!-- ------------------------------------------------------------------------- -->




	<!-- ---------------------------------페이지네이션------------------------------------------ -->
	<div class="col-12">
		<div class="pagination d-flex justify-content-center mt-5">

			<c:choose>
				<c:when test="${pi.copypage == 1 }">
					<a href="#" class="page-n rounded">&laquo;</a>
				</c:when>
				<c:otherwise>
					<a href="/copy/copylist.do?copypage=${pi.copypage-1}"
						class="page-n rounded">&laquo;</a>
				</c:otherwise>
			</c:choose>

			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<a href="/copy/copylist.do?copypage=${page}" class="page-n rounded">${page}</a>
			</c:forEach>

			<c:choose>
				<c:when test="${pi.copypage == pi.maxPage }">
					<a href="#" class="page-n rounded">&raquo;</a>
				</c:when>
				<c:otherwise>
					<a href="/copy/copylist.do?copypage=${pi.copypage+1}"
						class="page-n rounded">&raquo;</a>
				</c:otherwise>
			</c:choose>


		</div>
	</div>


	<!-- Footer Start -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- Copyright End -->

	<!-- Back to Top -->
	<a href="#" class="btn btn-point border-3 rounded-circle back-to-top"><i
		class="fa fa-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<%@ include file="/views/common/jsLib.jsp"%>

	<!-- Template Javascript -->
	<script src="/resources/js/main.js"></script>
	<script src="/resources/js/likeCopy.js"></script>
</body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</html>