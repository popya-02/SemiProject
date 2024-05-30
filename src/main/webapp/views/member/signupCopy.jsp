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
                                        <form action="/signupCopy/signupResult.do" method="post">
											<input type="hidden" id="businessRegistorCheck" name="businessRegistorCheck"/>
											<input type="hidden" id="confirmCheck" name="confirmCheck"/>
                                            <div class="row gy-3 overflow-hidden">
                                                <div class="col-12">
                                                    <div class="form-floating mb-0 copy-id-check">
                                                        <input type="number" class="form-control" name="copy-id" id="copy-id" required>
                                                        <label for="copy-id" class="form-label">사업자등록번호(ID)</label>
                                                        <button type="button" class="btn id-check-btn" id="businessRegistorBtn" onclick="businessRegistor()">사업장 확인</button>
                                                    </div>
                                                    <span id="copy-id-msg" class="duplicate-msg"></span>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-0">
                                                        <input type="password" class="form-control" name="password" id="password" onkeyup="effectivePwd()" required>
                                                        <label for="password" class="form-label">비밀번호</label>
                                                    </div>
                                                    <span id="password-msg" class="duplicate-msg"></span>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-0">
                                                        <input type="password" class="form-control" name="confirmPwd" id="confirmPwd" onkeyup="confirmPwdFunc()" required>
                                                        <label for="confirmPwd" class="form-label">비밀번호 확인</label>
                                                    </div>
                                                    	<span id="confirmPwd-msg" class="duplicate-msg"></span>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2">
                                                        <input type="text" class="form-control" name="name" id="name"required>
                                                        <label for="name" class="form-label">업체명</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-0">
                                                        <input type="text" class="form-control" name="ceo-name" id="ceo-name"required>
                                                        <label for="ceo-name" class="form-label">대표자명</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-0">
                                                        <input type="text" class="form-control" name="addr" id="addr"required>
                                                        <label for="addr" class="form-label">사업장 주소 (도/시/구/동)</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-0">
                                                        <input type="text" class="form-control" name="area" id="area"required>
                                                        <label for="area" class="form-label">시공지역</label>
                                                    </div>
                                                </div>
                                                <div class="col-12">
                                                    <div class="form-floating mb-2">
                                                        <input type="text" class="form-control" name="tel" id="phonnum"required>
                                                        <label for="phonnum" class="form-label">업체 전화번호</label>
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

        
    <!-- JavaScript Libraries -->
    <%@ include file="/views/common/jsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>
    <script src="/resources/js/businessRegistor.js"></script>
    <script src="/resources/js/effectiveness.js"></script>
    </body>

</html>