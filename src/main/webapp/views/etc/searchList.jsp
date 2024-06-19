<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link href="/resources/css/searchList.css" rel="stylesheet">
<%@ include file="/views/common/head.jsp"%>
<title>GONGGU</title>
<!-- Template Stylesheet -->
<link href="/resources/css/style.css" rel="stylesheet">
<link href="/resources/css/login.css" rel="stylesheet">
</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<section class="search-section">
			<div class=" p-3 p-md-4 p-xl-5 search-box">
				<div>
					<h2>검색 결과</h2>
					<hr class="hr">
					<div>
						<h4>시공 예시</h4>
			 			<div class="example-result row1" >
							<c:choose>
								<c:when test="${empty searchExamList}">
									<div>
										<div style="padding: 30px;">등록된 글이 없습니다</div>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach var="item" items="${searchExamList}">
									<input type="hidden" name="categoryname" values="${item.categoryName}">
									<div class="example-div exam-margin copy-search">
										<%-- <a class="" href="/constructDetail.do?examNo=${item.examNo}"> --%>
										<img src="/resources/img/${item.examPictureName}" name="exampicturename" class="search-img">
											<div class="example-div-div">
												<div class="example-obj">
												    <h4>${item.copyName}</h4>
													<h5 style="margin-top:5px;">${item.examTitle}</h5>
												   <%--  <h4 name="categoryname">${item.categoryName}</h4> --%>
													<p class="example-div3">${item.tagRemoveContent}</p>
													<a href="/constructDetail.do?examNo=${item.examNo}" class="btn border border-secondary rounded-pill px-3 py-1 text-primary detail-link">자세히 보기</a>
												</div>
											</div>
											<!-- </a> -->
									     </div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div> 
					</div>
					<div>
						<h4 style="padding-bottom: 5px">시공 업체</h4>
						<div class="search-result-1 row1-1">
							<c:choose>
								<c:when test="${empty searchCopyList}">
									<div>
										<div style="margin-left: 15px; padding: 30px;">등록된 글이 없습니다</div>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach var="item" items="${searchCopyList}">
										<a href="/copyDetail.do?copyNo=${item.copyNo}" class="searchcopy-list" >
											<div class="rounded position-relative copy-search">
												<div class="">
													<img src="resources/img/${item.pictureName}" name="copypicturename" style="width:250px; height:250px;" class="rounded-top" alt="사진">
												</div>
												<div class="p-3 border point-border border-top-0 rounded-bottom">
													<h5 name="copyName">${item.copyName}</h5>
												</div>
											</div>
										</a>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
	</section>

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