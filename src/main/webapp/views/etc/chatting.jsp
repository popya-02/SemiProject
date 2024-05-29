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
        <link href="/resources/css/chatting.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		        <section class=" p-3 p-md-4 p-xl-5 chat-section">
            <div class="chat-container chat-box card border-light-subtle shadow-sm">
                <h4 class="chatting-title">견적 상담 : (업체명)</h4>
                <div class="chatting-box">
                    <div class="chatting-area">
                        <div class="receive-msg">
                            <p>수신 메세지</p>
                        </div>
                        <div class="transmit-msg">
                            <p>송신메세지</p>
                        </div>
                    </div>
                    <div class="input-box">
                        <input class="text-input" type="text" name="transmit-msg" id="transmit-msg">
                        <button class="btn enter-btn">전 송</button>
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
    </body>

</html>