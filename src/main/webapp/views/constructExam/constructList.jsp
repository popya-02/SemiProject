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
<link href="/resources/css/constructList.css" rel="stylesheet">
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
		<div class="album py-5 bg-body-tertiary">
			<div class="container" id="construct-exam-box">
				<h2 class="point-text exam-title">예시 목록</h2>
				<hr>
				<div class="exam-box">
					<div class="category-box">
						<div class="form-check radio-cate">
						  <input class="form-check-input" type="radio" name="categoryNo" id="categoryCheckid" value="0" checked>
						  <label class="form-check-label" for="categoryCheckid">
						    선택 안함
						  </label>
						</div>
						<c:forEach var="category" items="${categoryList}" varStatus="status">
							<div class="form-check radio-cate">
							  <input class="form-check-input" type="radio" name="categoryNo" id="categoryCheckid" value="${category.categoryNo}">
							  <label class="form-check-label" for="categoryCheckid">
							    ${category.category}
							  </label>
							</div>
							<c:set var="row" value="${row-1}" />
						</c:forEach>
					</div>
					<div class="exam-list-box">
						<c:if test="${sessionScope.userType == 'copyUser'}">
							<div class="submit-btn">
								<a href="/form/constructEnroll.do">
									<button
										class="tlrhd-btn tlrhd-border btn-sm btn-outline-secondary">등록</button>
								</a>
							</div>
						</c:if>
						<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3" id="exam-result-box">
							<c:choose>
								<c:when test="${empty constructList}">
									<h5 style="width: 600px;">등록 되어있는 업체가 없습니다.</h5>
								</c:when>
								<c:otherwise>
									<c:forEach var="construct" items="${constructList}">
										<form action="/constructExam/constructdelete.do" method="POST">
											<input type="hidden" name="examNo" value="${construct.examNo}">
											<input type="hidden" name="fileNo" value="${construct.fileNo}">
											<input type="hidden" name="fileName" value="${construct.fileName}">
											<input type="hidden" name="categoryNum" value="${construct.categoryNo}">
											<input type="hidden" name="page" value="${pi.copypage}">
											<div class="col">
												<div class="card shadow-sm he-min">
													<a href="/constructDetail.do?examNo=${construct.examNo}" class="img-size ">
													<img class="bd-placeholder-img card-img-top img-contain" src="/resources/img/${construct.fileName}" />
													</a>
													<p class="djqcpaud">${construct.copyName}</p>
					
													<div class="card-body">
														<p>${construct.title}</p>
														<div class="d-flex justify-content-between align-items-center">
															<div class="btn-group">
															<c:if test="${sessionScope.copyName == construct.copyName}">
																<button type="button" class="tlrhd-border btn-sm btn-outline-secondary"
																	onclick="location.href='/constructExam/constructEdit.do?examNo=${construct.examNo}'">
																	수정</button>
																	&nbsp;
																<button type="submit" class="tlrhd-border btn-sm btn-outline-secondary">삭제</button>
															</c:if>
															</div>
														</div>
													</div>
												</div>
											</div>
										</form>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>

	</main>

	<!-- ---------------------------------페이지네이션------------------------------------------ -->
	<div class="col-12">
		<div class="pagination d-flex justify-content-center mt-3" id="paginaetion-box">
			<c:choose>
				<c:when test="${pi.copypage == 1 }">
					<a onclick="checkFunc()" id="categoryNo" class="page-n rounded" >&laquo;</a>
				</c:when>
				<c:otherwise>
					<a onclick="checkFunc(1)" id="categoryNo" class="page-n rounded" >&laquo;</a>
				</c:otherwise>
			</c:choose>

			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<a class="page-n rounded" id="copypageNum" name="copypageNum">${page}</a>
			</c:forEach>

			<c:choose>
				<c:when test="${pi.copypage == pi.maxPage }">
					<a onclick="checkFunc()" id="categoryNo" class="page-n rounded" >&raquo;</a>
				</c:when>
				<c:otherwise>
					<a onclick="checkFunc(2)" id="categoryNo" class="page-n rounded" >&raquo;</a>
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
	<script src="/resources/js/category.js"></script>
	
</body>

</html>