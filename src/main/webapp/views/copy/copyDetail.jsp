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
        <link href="/resources/css/copyDetail.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->
        
        <div class="container-fluid page-header py-5" style="background-color: #223455;">
            <h1 class="text-center text-white display-6">업체 소개</h1>
            <!-- <ol class="breadcrumb justify-content-center mb-0">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active text-white">Shop Detail</li>
            </ol> -->
        </div>
        <!-- Single Page Header End -->

        <!-- Single Product Start -->
        <div class="container-fluid py-5 mt-5">
            <div class="container py-5">
                <div class="row g-4 mb-5">
                    <div class="col-lg-8 col-xl-9">
                        <div class="row g-4">
                            <div class="col-lg-6">
                                <div style="width: 500px; height: 400px;" class="img-border rounded" >

                                    <!-- 이미지 업로드 -->
                                    <div class="container">
                                        <div  class="image-upload" id="image-upload"  >
                                            <img class="img-border rounded" src="./img/세미이미지1.jpeg">
                                
                                        </div>
                                        
                                        
                                    </div>
                                    <!--  -->
                                </div>
                            </div>
                            <div class="col-lg-6" style="padding-left: 100px;" >
                                <h4 class="fw-bold mb-3">
                                    (주)그린인테리어
                                </h4>
                                <!-- <p class="mb-3">Category: Vegetables</p>
                                <h5 class="fw-bold mb-3">3,35 $</h5> -->
                                <div class="d-flex mb-4">
                                    <!-- <i class="fa fa-star text-secondary"></i>
                                    <i class="fa fa-star text-secondary"></i>
                                    <i class="fa fa-star text-secondary"></i>
                                    <i class="fa fa-star text-secondary"></i>
                                    <i class="fa fa-star"></i> -->
                                </div>
                                <p class="mb-4">
                                    그린인테리어는 디자인의 조건인 독창성, 심미성, 경제성, 합목적을 추가하며 인간의 삶의 질을 높이고,
                                    디자이너의 풍부한 경험과 노하우를 바탕으로 새로운 디자인 트랜드 형성에 노력할 것입니다.
                                     처음부터 끝까지 고객의 입장에서 미다스만의 전문적인 서비스를 제공할 것을 약속드립니다.
                                </p>
                                <p class="mb-4" >
                                    <p>업체 정보</p>
                                    <div>
                                    경기도 안양시 만안구 안양동 메쎄포스빌
                                    
                                    <br>
                                    010-3295-2720
                                </div>
                                </p>
                                <!-- <div class="input-group quantity mb-5" style="width: 100px;"> -->
                                   
                                </div>
                                <!-- <a href="#" class="btn border border-secondary rounded-pill px-4 py-2 mb-4 text-primary"><i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart</a> -->
                            </div>
                    
                    </div>

                <h1 class="fw-bold mb-0">업체 시공예시</h1>
                <div class="vesitable">
                    
                    <div class="owl-carousel vegetable-carousel justify-content-center">
                        <!-- ---------------------------------------------------------------------------------------------------------------------------- -->
                        <div class="border border-primary rounded position-relative vesitable-item">
                            <div class="vesitable-img">
                                <img src="img/세미이미지1.jpeg" class="img-fluid w-100 rounded-top" alt="">
                            </div>
                            
                            <div class="p-4 pb-0 rounded-bottom">
                                
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                <div class="d-flex justify-content-between flex-lg-wrap">
                                    
                                    <a href="#" class="btn border border-secondary rounded-pill px-3 py-1 mb-4 text-primary">자세히 보기</a>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------------------------------------------------------------------------------------------------------------------- -->
                        <div class="border border-primary rounded position-relative vesitable-item">
                            <div class="vesitable-img">
                                <img src="img/세미이미지1.jpeg" class="img-fluid w-100 rounded-top" alt="">
                            </div>
                            
                            <div class="p-4 pb-0 rounded-bottom">
                                
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                <div class="d-flex justify-content-between flex-lg-wrap">
                                    
                                    <a href="#" class="btn border border-secondary rounded-pill px-3 py-1 mb-4 text-primary">자세히 보기</a>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------------------------------------------------------------------------------------------------------------------- -->
                        <div class="border border-primary rounded position-relative vesitable-item">
                            <div class="vesitable-img">
                                <img src="img/세미이미지1.jpeg" class="img-fluid w-100 rounded-top" alt="">
                            </div>
                            
                            <div class="p-4 pb-0 rounded-bottom">
                                
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                <div class="d-flex justify-content-between flex-lg-wrap">
                                    
                                    <a href="#" class="btn border border-secondary rounded-pill px-3 py-1 mb-4 text-primary">자세히 보기</a>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------------------------------------------------------------------------------------------------------------------- -->
                        <div class="border border-primary rounded position-relative vesitable-item">
                            <div class="vesitable-img">
                                <img src="img/세미이미지1.jpeg" class="img-fluid w-100 rounded-top" alt="">
                            </div>
                            
                            <div class="p-4 pb-0 rounded-bottom">
                                
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                <div class="d-flex justify-content-between flex-lg-wrap">
                                    
                                    <a href="#" class="btn border border-secondary rounded-pill px-3 py-1 mb-4 text-primary">자세히 보기</a>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------------------------------------------------------------------------------------------------------------------- -->
                        <div class="border border-primary rounded position-relative vesitable-item">
                            <div class="vesitable-img">
                                <img src="img/세미이미지1.jpeg" class="img-fluid w-100 rounded-top" alt="">
                            </div>
                            
                            <div class="p-4 pb-0 rounded-bottom">
                                
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                                <div class="d-flex justify-content-between flex-lg-wrap">
                                    
                                    <a href="#" class="btn border border-secondary rounded-pill px-3 py-1 mb-4 text-primary">자세히 보기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 댓글 -->
        <div class="col-lg-12">
            <nav class="repl">
                <div class="nav nav-tabs mb-3" style="width: 1100px;">
                   
                    <div class="nav-link border-white border-bottom-0" type="button" role="tab"
                        id="nav-mission-tab" data-bs-toggle="tab" data-bs-target="#nav-mission"
                        aria-controls="nav-mission" aria-selected="false">Reviews</div>
                </div>
            </nav>
            <div class="tab-content mb-5 repl">
                <div class="tab-pane active" id="nav-about" role="tabpanel" aria-labelledby="nav-about-tab">
                    
                
                <div class="tab-pane" id="nav-mission" role="tabpanel" aria-labelledby="nav-mission-tab">

                    <div class="d-flex">
                        
                        <div class="">
                            <p class="mb-2" style="font-size: 14px;">April 12, 2024</p>
                            <div class="d-flex justify-content-between">
                                <h5>이진우</h5>
                            </div>
                            <p>데헷ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</p>
                        </div>
                    </div>

                    <div class="d-flex">
                       
                        <div class="">
                            <p class="mb-2" style="font-size: 14px;">April 12, 2024</p>
                            <div class="d-flex justify-content-between">
                                <h5>전해원</h5>
                                
                            </div>
                            <p class="text-dark">끼얗ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ</p>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        <!-- 댓글 쓰기 -->
        <form action="#" class="repl">
            <h4 class="mb-5 fw-bold">후기를 남겨주세요.</h4>
            <div class="row g-4" style="width: 1100px;">
                
                
                <div class="col-lg-12">
                    <div class="border-bottom rounded my-4">
                        <textarea name="" id="" class="form-control border-0" cols="30" rows="8" placeholder="Your Review *" spellcheck="false"></textarea>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="d-flex justify-content-between py-3 mb-5">
                        <!-- <div class="d-flex align-items-center">
                            
                        </div> -->
                        <a href="#" class="btn border border-secondary text-primary rounded-pill px-4 py-3"> 후기 남기기</a>
                    </div>
                </div>
            </div>
        </form>
        
        
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