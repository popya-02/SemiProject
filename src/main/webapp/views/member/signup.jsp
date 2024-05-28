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
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->
        
        <section class=" p-3 p-md-4 p-xl-5 signup-margin">
            <div class="container signup-box">
                <div class="row justify-content-center">
                    <div class="col-12 col-xxl-11">
                        <div class="card border-light-subtle shadow-sm">
                            <div class="row g-0">
                                <div class="col-12 col-md-6">
                                    <h4 class="signup-title">SIGNUP</h4>
                                    <img class="img-fluid rounded-start w-100 h-100 object-fit-cover" loading="lazy" src="/resources/img/login_background.jpg" alt="login page">
                                </div>
                                <div class="col-12 col-md-6 signup-chose-box">
                                    <div class="chose-box text-center rounded-chose bg-light p-4 mb-5">
                                        <a href="/form/signupuserForm.do">
                                            <div class="featurs-icon mb-4 mx-auto">
                                                <i class="fas fa-user fa-6x fa-4x point-text"></i>
                                            </div>
                                            <div class="featurs-content text-center">
                                                <h5>개인 회원가입</h5>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="chose-box text-center rounded-chose bg-light p-4 ">
                                        <a href="/form/signupcopyForm.do">
                                            <div class="featurs-icon mb-5 mx-auto">
                                                <i class="fas fa-house-user fa-6x fa-4x point-text"></i>
                                            </div>
                                            <div class="featurs-content text-center">
                                                <h5>업체 회원가입</h5>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        

        <!-- Footer Start -->
       	<%@ include file="/views/common/footer.jsp"%>
        <!-- Copyright End -->
        
        <!-- Back to Top -->
        <a href="#" class="btn btn-point border-3 rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/lib/easing/easing.min.js"></script>
    <script src="/resources/lib/waypoints/waypoints.min.js"></script>
    <script src="/resources/lib/lightbox/js/lightbox.min.js"></script>
    <script src="/resources/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>
    </body>

</html>