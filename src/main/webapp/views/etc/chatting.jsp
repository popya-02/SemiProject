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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		<section class=" p-3 p-md-4 p-xl-5 chat-section">
            <div class="chat-container chat-box card border-light-subtle shadow-sm">
            	<c:choose>
            		<c:when test="${userType == 'basicUser'}">
		                <h4 class="chatting-title">견적 상담 : ${copyName}</h4>
            		</c:when>
            		<c:otherwise>
		                <h4 class="chatting-title">견적 상담 : ${nickName} <small>${userId}</small></h4>
            		</c:otherwise>
            	</c:choose>
                <input type="hidden" id="chatting-num" value="${chattingNum}">
                <div class="chatting-box" id="chatting-box">
                  	<c:if test="${endCheck == 'Y'}">
               			<p class="endmsg">상담이 종료된 채팅방입니다.</p>
                  	</c:if>
                    <div class="chatting-area" id="chatting-area">
                        <!-- msg area -->
                        <c:if test="${not empty list}">
                        	<c:forEach var="item" items="${list}">
		                        <c:choose>
		                        	<c:when test="${item.userType == 'basicUser'}">
		                        		<c:choose>
		                        			<c:when test="${item.userNum == sessionScope.userNum}">
		                        				<div class="transmit-msg">
		                        					<p>${item.message}</p>
		                        				</div>
		                        			</c:when>
		                        			<c:otherwise>
		                        				<div class="receive-msg">
		                        					<p>${item.message}</p>
		                        				</div>
		                        			</c:otherwise>
		                        		</c:choose>
		                        	</c:when>
		                        	<c:when test="${item.userType == 'copyUser'}">
		                        		<c:choose>
		                        			<c:when test="${item.copyNum == sessionScope.copyNum}">
		                        				<div class="transmit-msg">
		                        					<p>${item.message}</p>
		                        				</div>
		                        			</c:when>
		                        			<c:otherwise>
		                        				<div class="receive-msg">
		                        					<p>${item.message}</p>
		                        				</div>
		                        			</c:otherwise>
		                        		</c:choose>
		                        	</c:when>
		                        	<c:otherwise>
		                        	</c:otherwise>
		                        </c:choose>
                        	</c:forEach>
                        </c:if>
                    </div>
                    <div class="input-box" id="input-box">
                        <c:choose>
                        	<c:when test="${endCheck == 'Y'}">
                        		<!-- null -->
                        	</c:when>
                        	<c:otherwise>
		                        <input class="text-input" type="text" name="transmit-msg" id="transmit-msg">
		                        <button class="btn enter-btn" id="enter-btn" onclick="submitMsg('${userType}',${noCheck})">전 송</button>
                        	</c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div>
	                <button class="btn" onclick="window.history.back()">나가기</button>
	                <c:choose>
	                	<c:when test="${endCheck == 'Y'}">
	                		<!-- null -->
	                	</c:when>
	                	<c:otherwise>
			                <button class="btn" style="float: right;" onclick="consultingEnd()">상담 종료</button>
	                	</c:otherwise>
	                </c:choose>
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
    <script src="/resources/js/submitMsg.js"></script>
    <script src="/resources/js/entermsg.js"></script>
    <script src="/resources/js/consulting.js"></script>
    
    </body>

</html>