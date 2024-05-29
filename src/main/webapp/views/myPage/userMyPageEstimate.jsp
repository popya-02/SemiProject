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
        <link href="/resources/css/userMyPageEstimate.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		        <h2 class="mypage_1">마이페이지</h2>
        <nav class="mypage_list">
            <ul>
                <li class="mypage_list_1"><a href="/views/myPage/userMyPageEstimate.jsp">견적/공사 내역</a></li>
                <li class="mypage_list_2"><a href="/view/myPage/userMyPageLikeCopy.jsp">관심 업체</a></li>
                <li class="mypage_list_3"><a href="/view/myPage/userMyPageInfo.jsp">정보 수정</a></li>
            </ul>
        </nav>
        <div class="mypage_list_1_detail"> 
            <p class="estimate_list">견적신청 내역</p>

            <div class="reservation-list body">
                <div class="reservation-list-header">
                    <div class="company_photo">사진</div>
                    <div class="company_name">업체 이름</div>
                    <div class="reservation_number">예약번호</div>
                </div>
                <!-- <div class="reservation-list-header">
                    <div class="reservation-photo">사진</div>
                    <div class="reservation-name">업체명</div>
                    <div class="reservation-number">예약번호</div>
                </div> -->
                
                
                <!-- <a href="naver.com">
                    <div class="reservation-list-item">
                        <img src="/resources/img/antique_picture.jpg" alt="사진">
                        <div class="company_name">업체 이름</div>
                        <div class="reservation_number">123456</div>
                    </div>
                </a>
                <div class="reservation-list-item">
                    <img src="https://via.placeholder.com/100" alt="사진">
                    <div class="company_name">업체 이름2</div>
                    <div class="reservation_number">789012</div>
                </div>
                <div class="reservation-list-item">
                    <img src="https://via.placeholder.com/100" alt="사진">
                    <div class="company_name">업체 이름3</div>
                    <div class="reservation_number">345678</div>
                </div>
                <div class="reservation-list-item">
                    <img src="https://via.placeholder.com/100" alt="사진">
                    <div class="company_name">업체 이름4</div>
                    <div class="reservation_number">346678</div>
                </div> -->

       <!--      </div>
        </div> -->
        		<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan="5" style="text-align: center !important; padding: 30px;" >등록된 글이 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="item" items="${list}">
								<tr
									onclick="location.href='/freeBoard/detail.do?boardNo=${item.boardNo}'">
									<!-- 어떤 게시글에 들어가는지 알수있음 -->
									<td scope="row">${row}</td>
									<td>${item.boardTitle}</td>
									<td>${item.memberName}</td>
									<td>${item.boardIndate}</td>
									<td>${item.boardViews}</td>
								</tr>
								<c:set var="row" value="${row-1}" />
							</c:forEach>
						</c:otherwise>
					</c:choose>
                <div class="col-12">
                    <div class="pagination d-flex justify-content-center mt-5">
                        <a href="#" class="rounded">&laquo;</a>
                        <a href="#" class="active rounded">1</a>
                        <a href="#" class="rounded">2</a>
                        <a href="#" class="rounded">3</a>
                        <a href="#" class="rounded">4</a>
                        <a href="#" class="rounded">5</a>
                        <a href="#" class="rounded">6</a>
                        <a href="#" class="rounded">&raquo;</a>
                    </div>
                </div>
                </div>
                </div>

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