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
        <link href="/resources/css/copyMyPageChatting.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>   
        <!-- Navbar End -->

		        <h2 class="mypage_1">업체페이지</h2>
		        <c:choose>
			<c:when test="${sessionScope.approvalStatus == 'B'}">
				 <nav class="mypage_list">
            <ul>
                <li class="mypage_list_1"><a href="/views/myPage/copyMyPageEstimate.jsp">견적/공사 내역</a></li>
                <li class="mypage_list_2"><a href="/MypageInfo/ChattingList.do?copyNo=${sessionScope.copyNum}&chatpage=1">견적 상담 채팅</a></li>
                <li class="mypage_list_2"><a href="/MypageInfo/copyInfo.do?copyNo=${sessionScope.copyNum}">정보 수정</a></li>
            </ul>
        </nav>
        <div class="mypage_list_1_detail"> 
            <p class="estimate_list">견적 상담 채팅목록</p>

            <div class="reservation-list body">
                <div class="reservation-list-header">
                    <div class="user_name">상담자명</div>
                    <div class="reservation_number">상담 시작일</div>
                    <div class="reservation_number">종료 여부</div>
                    <div class="reservation_number">결제 여부</div>
                    <div class="reservation_number"></div>
                </div>
                <!-- <div class="reservation-list-header">
                    <div class="reservation-photo">사진</div>
                    <div class="reservation-name">업체명</div>
                    <div class="reservation-number">예약번호</div>
                </div> -->
                <c:choose>
                	<c:when test="${empty chattingList}">
                		<p>진행중인 상담이 없습니다.</p>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="item" items="${chattingList}">
	                		<div class="reservation-list-item">
			                	<form action="/construct/write.do?chatNum=${item.chattingNum}" method="POST" class="list-form">
			                		<input type="hidden" value="${item.userNum}" name="user-num">
			                		<input type="hidden" value="${item.userName}" name="user-name">
			                		<input type="hidden" value="${item.endCheck}" name="end-check">
				                    <div class="user_name" id="user-name" onclick="location.href='/chatting/connection.do?copyNum=${sessionScope.copyNum}&userNum=${item.userNum}'">${item.userName}</div>
				                    <div class="reservation_number" onclick="location.href='/chatting/connection.do?copyNum=${sessionScope.copyNum}&userNum=${item.userNum}'">${item.chattingIndate}</div>
				                    <div class="reservation_number" onclick="location.href='/chatting/connection.do?copyNum=${sessionScope.copyNum}&userNum=${item.userNum}'">
				                    	<c:choose>
				                    		<c:when test="${item.endCheck == 'Y'}">
				                    			<input type="hidden" value="${item.endCheck}" name="endCheck">
				                    			종료
				                    		</c:when>
				                    		<c:otherwise>
				                    			<input type="hidden" value="${item.endCheck}" name="endCheck">
				                    			진행중
				                    		</c:otherwise>
				                    	</c:choose>
				                    </div>
				                    <div class="reservation_number">
					                    <button type="button" class="construct-btn">결제 요청</button>
				                    </div>
				                    <c:choose>
				                    	<c:when test="${item.endCheck == 'Y'}">
						                    <div class="reservation_number">
							                    <button class="construct-btn">견적서 확인</button>
						                    </div>
				                    	</c:when>
				                    	<c:otherwise>
						                    <div class="reservation_number">
							                    <button class="construct-btn">견적서 작성</button>
						                    </div>
				                    	</c:otherwise>
				                    </c:choose>
			                    </form>
			                </div>
                			<c:set var="row" value="${row-1}"/>
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
                
            </div>
			<div class="col-12">
				<div class="pagination d-flex justify-content-center mt-5">
				
					<c:choose>
						<c:when test="${pi.copypage == 1 }">
							<a href="#" class="page-n rounded">&laquo;</a>
						</c:when>
						<c:otherwise>
							<a href="/MypageInfo/ChattingList.do?copyNo=${sessionScope.copyNum}&chatpage=${pi.copypage-1}" class="page-n rounded">&laquo;</a>
						</c:otherwise>
					</c:choose>
					
					<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
						<a href="/MypageInfo/ChattingList.do?copyNo=${sessionScope.copyNum}&chatpage=${page}" class="page-n rounded">${page}</a>
					</c:forEach>
					
					<c:choose>
						<c:when test="${pi.copypage == pi.maxPage }">
							<a href="#" class="page-n rounded">&raquo;</a>
						</c:when>
						<c:otherwise>
							<a href="/MypageInfo/ChattingList.do?copyNo=${sessionScope.copyNum}&chatpage=${pi.copypage+1}" class="page-n rounded">&raquo;</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
       	</div>
			</c:when>
			<c:otherwise>
				<div>
					<h3 style="text-align: center; margin: 100px;"  >업체 승인 요청 대기 중입니다...</h3>
				</div>
			</c:otherwise>
		</c:choose>
        

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