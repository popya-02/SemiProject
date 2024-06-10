<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
	    <%@ include file="/views/common/head.jsp"%>
        <title>GONGGU</title>
        <link href="/resources/css/searchList.css" rel="stylesheet">
        <!-- Template Stylesheet -->
        <link href="/resources/css/style.css" rel="stylesheet">
        <link href="/resources/css/login.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		       <section class="search-section">
		        <form action="/SearchForm.do" method="Get">
            <div class=" p-3 p-md-4 p-xl-5 search-box">
                <div>
                    <h2>검색 결과</h2>
                    <hr class="hr">
                    <div>
                        <h4>시공 예시</h4>
                        <div class="example-result">
                            <div class="example-div">
                                <img src="./img/natural_picture.jpg" class="search-img">
                                <div class="example-box">
                                    <div class="example-obj">
                                        <h5>예시 제목</h5>
                                        <p class="example-content">예시 내용 40자 정도example-contentexample-contentexample-contentexample-contentexample-content example-contentasdfqwerasdfqwerasdfqwerasdfqwerasdfqwerasdfqwer....</p>
                                    </div>
                                </div>
                            </div>
                            <div class="example-div">
                                <img src="./img/natural_picture.jpg" class="search-img">
                                <div class="example-box">
                                    <div class="example-obj">
                                        <h5>예시 제목</h5>
                                        <p class="example-content">예시 내용 40자 정도example-contentexample-contentexample-contentexample-contentexample-content example-contentasdfqwerasdfqwerasdfqwerasdfqwerasdfqwerasdfqwer....</p>
                                    </div>
                                </div>
                            </div>
                            <div class="example-div">
                                <img src="./img/natural_picture.jpg" class="search-img">
                                <div class="example-box">
                                    <div class="example-obj">
                                        <h5>예시 제목</h5>
                                        <p class="example-content">예시 내용 40자 정도example-contentexample-contentexample-contentexample-contentexample-content example-contentasdfqwerasdfqwerasdfqwerasdfqwerasdfqwerasdfqwer....</p>
                                    </div>
                                </div>
                            </div>
                            <div class="example-div">
                                <img src="./img/natural_picture.jpg" class="search-img">
                                <div class="example-box">
                                    <div class="example-obj">
                                        <h5>예시 제목</h5>
                                        <p class="example-content">예시 내용 40자 정도example-contentexample-contentexample-contentexample-contentexample-content example-contentasdfqwerasdfqwerasdfqwerasdfqwerasdfqwerasdfqwer....</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                        <h4>업체</h4>
                        <div class="search-result row">
                            <div class="col-md-4 col-lg-3 inte-pama">
                                <div class="rounded position-relative copy-search">
                                    <div class="">
                                        <img src="img/antique_picture.jpg" class="img-fluid w-100 rounded-top" alt="앤틱">
                                    </div>
                                    <div class="p-3 border point-border border-top-0 rounded-bottom">
                                        <h5>업체 1</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-lg-3 inte-pama">
                                <div id="tab-1" class="rounded position-relative copy-search">
                                    <div class="">
                                        <img src="img/antique_picture.jpg" class="img-fluid w-100 rounded-top" alt="앤틱">
                                    </div>
                                    <div class="p-3 border point-border border-top-0 rounded-bottom">
                                        <h5>업체 2</h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           </form>
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