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
        <style type="text/css">
        	html,body{
 		       	height: 100%;
 		       	background-color: #000;
        	}
        	
        	.admin-login-section{
        		width: 100%;
        		height: 100%;
        		display: flex;
        		justify-content: center;
        		align-items: center;
        	}
        	
        	.admin-box{
        		background-color: #ffffffcf;
        		width: 35%;
        		height: 55%;
        		min-width: 540px;
        		border-radius: 10px;
        	}
        </style>
    </head>
    <body>
        <section class="admin-login-section">
            <div class="col-12 col-md-6 d-flex align-items-center justify-content-center admin-box">
                <div class="col-12 col-lg-11 col-xl-10">
                    <div class="card-body p-3 p-md-4 p-xl-5">
                        <div class="row">
                            <div class="col-12">
                                <div class="mb-5">
                                    <div class="text-center">
                                        <a href="/" class="navbar-brand"><h4 class="point-text display-4">GONGGU</h4></a>
                                    </div>
                                <!-- <h4 class="text-center">Welcome back you've been missed!</h4> -->
                                </div>
                            </div>
                        </div>
                        <form action="/adminlogin.do" method="POST">
                            <div class="row gy-3 overflow-hidden">
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="text" class="form-control" name="id" id="id" placeholder="name@example.com" required>
                                        <label for="email" class="form-label">ID</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating mb-3">
                                        <input type="password" class="form-control" name="password" id="password" value="" placeholder="Password" required>
                                        <label for="password" class="form-label">Password</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="d-grid">
                                        <button class="btn point-color text-white btn-lg" type="submit">Log in now</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    <!-- JavaScript Libraries -->
    <%@ include file="/views/common/jsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="/resources/js/main.js"></script>
    </body>

</html>