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
</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<div class="container-fluid py-5" style="background-color: #223455; margin-top: 120px">
		<h1 class="text-center text-white display-6">업체 목록</h1>
		<!-- <ol class="breadcrumb justify-content-center mb-0">
                
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active text-white">Shop</li>
            </ol> -->
	</div>

	<main>

		<!-- 업체 -->
		<div class="album py-5 bg-body-tertiary">
			<div class="container">
					<!-- ------------------------------------------------------------------------ -->
					<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<c:choose>
						<c:when test="${empty companyList}">
							<h5>등록 되어있는 업체가 없습니다.</h5>
						</c:when>
						<c:otherwise>
							<c:forEach var="companyList" items="${companyList}">
									<div class="col">
										<div class="card shadow-sm">
											<a href="/copyDetail.do?copyNo=${companyList.copyNo}">
												<img class="bd-placeholder-img card-img-top" width="100%"
												height="225" img
												src="/resources/img/${companyList.copyPhoto}" width="100%"
												height="100%" fill="#55595c" />
											</a>
											<p class="djqcpaud">${companyList.copyName}</p>
										</div>
									</div>
									<c:set var="row" value="${row-1}" />
							</c:forEach>
						</c:otherwise>
					</c:choose>
					<div class="card-body">
						<div class="d-flex justify-content-between align-items-center">
							<div class="btn-group"></div>
						</div>
					</div>
				</div>
			</div>

			<!-- ------------------------------------------------------------------------- -->

		</div>

	</main>

	<!-- ---------------------------------페이지네이션------------------------------------------ -->
	<div class="col-12">
		<div class="pagination d-flex justify-content-center mt-5">
		
			<c:choose>
				<c:when test="${pi.copypage == 1 }">
					<a href="#" class="page-n rounded">&laquo;</a>
				</c:when>
				<c:otherwise>
					<a href="/copy/copylist.do?copypage=${pi.copypage-1}" class="page-n rounded">&laquo;</a>
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
					<a href="/copy/copylist.do?copypage=${pi.copypage+1}" class="page-n rounded">&raquo;</a>
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
</body>

</html>