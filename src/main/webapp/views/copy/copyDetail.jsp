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
<link href="/resources/css/copyDetail.css" rel="stylesheet">
</head>


<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<div class="container-fluid py-5" style="background-color: #223455; margin-top: 120px">
		<h1 class="text-center text-white display-6">업체 소개</h1>
	</div>


	<div class="container-fluid py-5 mt-5">
		<div class="container py-5">
			<div class="row g-4 mb-5">
				<div class="col-lg-8 col-xl-9">

					<div class="row g-4">
						<div class="col-lg-6">
							<div class="sizing img-border rounded">

								<div class="container">
									<div class="image-upload" id="image-upload">
										<c:choose>
											<c:when test="${copyDetail[0].copyPhoto == null}">
												<img class="img-border rounded img-size" src="/resources/img/img_not_found.jpg">
											</c:when>
											<c:otherwise>
												<img class="img-border rounded img-size" src="/resources/img/${copyDetail[0].copyPhoto}">
											</c:otherwise>
										</c:choose>
									</div>

								</div>
							</div>
						</div>
						<div class="col-lg-6" style="padding-left: 122px; margin-top: 40px">
							<div class="btn-box">
								<h4 class="fw-bold">${copyDetail[0].copyName}</h4>
								<c:if test="${sessionScope.userType == 'basicUser' }">
							        <a href="/chatting/connection.do?copyNum=${copyDetail[0].copyNo}&userNum=${sessionScope.userNum}" class="tlrhd-border border border-secondary text-primary rounded-pill px-3 py-2">시공 상담하기</a>
						        </c:if>							
							</div>

							<div class="d-flex mb-4">

							</div>
							<p class="mb-4">${copyDetail[0].copyContent}</p>
							<p>업체 정보</p>
							<div>
								${copyDetail[0].copyAddress} <br> ${copyDetail[0].copyNumber}
							</div>
							


						</div>
					</div>

				</div>

				<h1 class="fw-bold mb-0">업체 시공예시</h1>
				<div class="vesitable">

					<div class="owl-carousel vegetable-carousel justify-content-center">
						<!-- ---------------------------------------------------------------------------------------------------------------------------- -->
						<c:forEach var="copyDetailEx" items="${copyDetailEx}">
						<div class="border border-primary rounded position-relative vesitable-item">
							<div class="vesitable-img">
								<img src="/resources/img/${copyDetailEx.examPhoto}" class="img-fluid w-100 rounded-top" alt="">
							</div>

							<div class="p-4 pb-0 rounded-bottom">

								<p>${copyDetailEx.examTitle}</p>
								<div class="d-flex justify-content-between flex-lg-wrap">

									<a href="/constructDetail.do?examNo=${copyDetailEx.examNo}" class="btn border border-secondary rounded-pill px-3 py-1 mb-4 text-primary">자세히 보기</a>
								</div>
							</div>
						</div>
						</c:forEach>
						<!-- ---------------------------------------------------------------------------------------------------------------------------- -->
					</div>

				</div>
			</div>
		</div>
	</div>

		<!-- 후기 게시판 -->
		<div class="col-lg-12">
			<nav class="repl">
				<div class="nav nav-tabs mb-3" style="width: 1100px;">

					<div class="nav-link border-white border-bottom-0" role="tab"
						id="nav-mission-tab" data-bs-toggle="tab"
						data-bs-target="#nav-mission" aria-controls="nav-mission"
						aria-selected="false">Reviews</div>
				</div>
			</nav>
			<div class="tab-content mb-5 repl">
				<div class="tab-pane active" id="nav-about" role="tabpanel"	
					aria-labelledby="nav-about-tab">


					<div class="tab-pane" id="nav-mission" role="tabpanel"
						aria-labelledby="nav-mission-tab">
                        <c:forEach var="getReview" items="${getReview}"> 
						<div class="d-flex">

							<div class="">
								<p class="mb-2" style="font-size: 14px;">April 12, 2024</p>
								<div class="d-flex justify-content-between">
									<h5>${getReview.userId}</h5>
								</div>
								<p>${getReview.review}</p>
							</div>
						</div>
						</c:forEach>

					</div>

				</div>
			</div>
			</div>
			<!-- 후기 쓰기 -->
			<form action="/copyDetail.do" method="POST" class="repl">
				<h4 class="mb-5 fw-bold">후기를 남겨주세요.</h4>
				<div class="row g-4" style="width: 1100px;">


					<div class="col-lg-12">
						<div class="border-bottom rounded my-4">
						<input type="hidden" name="copyNo" value="${copyDetail[0].copyNo}">
						<input type="hidden" name="userNum" value="${sessionScope.userNum}">
						
							<textarea name="content" id="" class="form-control border-0" cols="30"
								rows="8" placeholder="Your Review *" spellcheck="false"></textarea>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="d-flex justify-content-between py-3 mb-5">

							<button
								class="page-n border border-secondary text-primary rounded-pill px-4 py-3"
								type="submit">후기 남기기</button>
						</div>
					</div>
				</div>
			</form>


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
</body>

</html>