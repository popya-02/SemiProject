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
                                    <img class="img-fluid rounded-start w-100 h-100 object-fit-cover" src="/resources/img/login_background.jpg" alt="login page">
                                </div>
                            <div class="col-12 col-md-6 d-flex align-items-center justify-content-center signup-right">
                                <div class="col-12 col-lg-11 col-xl-10">
                                    <div class="card-body p-3 p-md-4 p-xl-5 signup-h">
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="mb-5">
                                                    <div class="text-center">
                                                        <a href="/" class="navbar-brand signup-center"><h4 class="point-text display-4">GONGGU</h4></a>
                                                    </div>
                                                    <!-- <h4 class="text-center">Welcome back you've been missed!</h4> -->
                                                </div>
                                            </div>
                                        </div>
                                        <form action="#!">
                                            <div class="row gy-3 overflow-hidden">
                                                <div class="col-12">
                                                    <div class="form-floating mb-2 id-check">
                                                        <input type="text" class="form-control" name="id" id="email" required>
                                                        <label for="id" class="form-label">ID</label>
                                                        <button type="button" class="btn id-check-btn">중복확인</button>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2">
                                                        <input type="password" class="form-control" name="password" id="password" required>
                                                        <label for="password" class="form-label">Password</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2">
                                                        <input type="text" class="form-control" name="name" id="name"required>
                                                        <label for="name" class="form-label">이름</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2">
                                                        <input type="text" class="form-control" name="addr" id="addr"required>
                                                        <label for="addr" class="form-label">주소 (도/시/구/동)</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2">
                                                        <input type="text" class="form-control" name="nickname" id="nickname"required>
                                                        <label for="nickname" class="form-label">별명</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2 phonnum-check">
                                                        <input type="text" class="form-control" name="phonnum" id="phonnum"required>
                                                        <label for="phonnum" class="form-label">전화번호</label>
                                                        <button for="phonnum" type="button" class="btn phonnum-check-btn">문자 발송</button>
                                                    </div>
                                                    <div class="form-floating mb-2">
                                                        <input type="text" class="form-control" name="phoncheck" id="phoncheck" required>
                                                        <label for="phoncheck" class="form-label">확인 번호 입력</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <button class="btn point-color text-white btn-lg mb-4" type="submit">SignUp</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </form> 
                                    </div>
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

        
    <!-- JavaScript Libraries -->>
    <%@ include file="/views/common/jsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>
    </body>

</html>