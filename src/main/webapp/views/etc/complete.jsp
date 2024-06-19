<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        
        <link rel="stylesheet" href="/resources/css/reserveCheck.css"> 
        <%@ include file="/views/common/head.jsp"%>
        <title>GONGGU</title>
        <!-- Template Stylesheet -->
    	
    	
        <link href="/resources/css/style.css" rel="stylesheet">
        <link href="/resources/css/signup.css" rel="stylesheet">
        
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    	 <script type="text/javascript"	 src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript"	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
    	<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> -->
    	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    </head>
    <body>

        <!-- Spinner Start -->
        <!-- <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
            <div class="spinner-grow text-primary" role="status"></div>
        </div> -->
        <!-- Spinner End -->


        <!-- Navbar start -->
        <%@ include file="/views/common/header.jsp"%>     
        <!-- Navbar End -->


        


        <nav style="height: 180px;">
            
        </nav>
        <div class="reservation-list body">
            <div class="reservation-list-item">
                <div>
                    <h1 style="text-align: center; margin-bottom: 30px;">결제 완료</h1><br>
                    <div style="background-color: #223455; width: 300px; padding: 10px; border-radius: 10px;">
                        <a href="/"><h4 style="text-align: center; color: #fff;" >홈페이지로 돌아가기</h4></a>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="/views/common/footer.jsp"%>

        
        <!-- Copyright End -->

        
        
    
        <!-- Back to Top -->
        <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

        
    <!-- JavaScript Libraries -->
    <%@ include file="/views/common/purchaseJsLib.jsp"%>

    <!-- Template Javascript -->
    <script src="js/main.js">
        
    </script>
    </body>

</html>