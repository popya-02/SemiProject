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
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

        <!-- Hero Start -->
        <div class="container-fluid py-4 mb-5 hero-header">
            <div class="container py-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-12 col-lg-7">
                        <h5 class="mb-2 text-body">공간을 꾸미다</h5>
                        <h1 class="mb-4 display-3 point-text">GONGGU<br>with you<br>in your space</h1>
                    </div>
                    <div class="col-md-12 col-lg-5">
                        <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active rounded">
                                    <img src="resources/img/modern_picture.jpg" class="img-fluid w-100 h-100 rounded" alt="First slide">
                                </div>
                                <div class="carousel-item rounded">
                                    <img src="resources/img/natural_picture.jpg" class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->


        <!-- Featurs Section Start -->
        <div class="container-fluid featurs py-4">
            <div class="container py-3">
                <div class="row g-4">
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle point-color mb-5 mx-auto">
                                <i class="fas fa-book fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>시공 예시</h5>
                                <p class="mb-0">다양한 시공 사례들</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle point-color mb-5 mx-auto">
                                <i class="fas fa-home fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>다양한 업체</h5>
                                <p class="mb-0">다양한 스타일의 업체</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle point-color mb-5 mx-auto">
                                <i class="fas fa-search fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>견적 알아보기</h5>
                                <p class="mb-0">1대1 채팅을 통한 견적상담</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square rounded-circle point-color mb-5 mx-auto">
                                <i class="fas fa-user-shield fa-3x text-white"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>안심 인증</h5>
                                <p class="mb-0">업체인증으로 안전한 거래</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featurs Section End -->


        <!-- Fruits Shop Start-->
        <div class="container-fluid fruite py-4">
            <div class="container py-3">
                <div class="tab-class text-center">
                    <div class="row g-4">
                        <div class="col-lg-4 text-start">
                            <h1>Interior Category</h1>
                        </div>
                    </div>
                    <div class="tab-content">
                        <div id="tab-1" class="tab-pane fade show p-4 active">
                            <div class="row g-4">
                            	<c:forEach var="category" items="${categoryList}">
                            		<div class="col-md-6 col-lg-4 inte-pama">
	                                    <div class="rounded position-relative picture-item" onclick="location.href='/constructExam/constructlist.do?constructpage=1&categoryNum=${category.categoryNo}'">
	                                        <div class="fruite-img">
	                                            <img src="resources/img/${category.categoryPictureName}" class="img-fluid w-100 rounded-top" alt="${category.category}"/>
	                                        </div>
	                                        <div class="p-4 border point-border border-top-0 rounded-bottom">
	                                            <h4>${category.category}</h4>
	                                        </div>
	                                    </div>
	                                </div>
                            	</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>      
            </div>
        </div>
        <!-- Banner Section Start-->
        <div class="container-fluid banner bottom-img my-5">
            <div class="container py-5">
                <div class="row g-4 align-items-center">
                    <h1 class="fw-normal display-6 text-white font-style-1">시공에 힘들이지 않아도</h1>
                    <p class="display-5 point-text mb-4 font-style-2">200% 만족하는 인테리어!</p>
                </div>
            </div>
        </div>
        
        <!-- Banner Section End -->

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