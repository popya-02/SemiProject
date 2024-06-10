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
        <link href="/resources/css/constructWrite.css" rel="stylesheet">
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>   
        <!-- Navbar End -->
		<c:choose>
			<c:when test="${empty result}">
				<section class="construct-section">
					<div class="const-box">
						<h4 class="const-title">견적서</h4>
						<input type="hidden" id="chat-num" name="chat-num" value="${chattingNum}">
						<div class="range-div">
							<p>평수 : </p><input type="text" id="range"><p>m²</p>
						</div>
						<table class="const-table">
					        <tr>
					            <td class="header">시작일: </td><td><input type="date" id="start-date"/></td>
					            <td class="header">마감일: </td><td><input type="date" id="end-date"/></td>
					            <td class="header">사업자등록번호: </td><td><input type="text" id="copyNum" value="${sessionScope.copyNum}"/></td>
					        </tr>
					        <tr>
					            <td class="header">고객명: </td><td><input type="text" id="basic-name" name="basic-name" value="${userName}"/><input type="hidden" name="basicNum" id="basicNum" value="${userNum}"/></td>
					            <td class="header">주소: </td><td><input type="text" id="addr"/></td>
					            <td class="header">전화: </td><td><input type="text" id="tel"/></td>
					        </tr>
					        <tr>
					            <td colspan="2" class="header">견적금액 (예약금): </td><td colspan="4"><input type="text" id="estimatePrice"/></td>
					        </tr>
					    </table>
					    <p>위와 같이 견적합니다</p>
					    <table class="const-table" id="estimateTable">
					        <thead>
					            <tr>
					                <th width="25%">품명</th>
					                <th width="20%">규격</th>
					                <th width="6%">단위</th>
					                <th width="6%">수량</th>
					                <th width="16%">금액단가</th>
					                <th width="24%">총액</th>
					            </tr>
					        </thead>
					        <tbody>
					            <tr>
					                <td><input type="text" onInput="this.setAttribute('value', this.value);"/></td>
					                <td><input type="text" onInput="this.setAttribute('value', this.value);"/></td>
					                <td><input type="text" onInput="this.setAttribute('value', this.value);"/></td>
					                <td><input type="text" onInput="this.setAttribute('value', this.value);"/></td>
					                <td><input type="text" onInput="this.setAttribute('value', this.value);"/></td>
					                <td><input type="text" onInput="this.setAttribute('value', this.value);"/></td>
					            </tr>
					            <tr>
					            	<td colspan="6" class="add-td"><button type="button" onclick="addSelFunc()" class="add-btn">+</button></td>
					            </tr>
					            <tr>
					                <td colspan="5"><b>합계</b></td>
					                <td><input type="text" id="sumPrice"/></td>
					            </tr>
					        </tbody>
					    </table>
						    <button class="save-btn" onclick="saveConstruct()">저 장</button>
					</div>
				</section>
			</c:when>
			<c:otherwise>
				<section class="construct-section">
					<div class="const-box">
						<h4 class="const-title">견적서</h4>
						<input type="hidden" id="chat-num" name="chat-num" value="${result.chattingNum}">
						<div class="range-div">
							<p>평수 : </p><input type="text" id="range" value="${result.constRange}"><p>m²</p>
						</div>
						<table class="const-table">
					        <tr>
					            <td class="header">시작일: </td><td><input type="date" id="start-date" value="${result.constStartDate}"/></td>
					            <td class="header">마감일: </td><td><input type="date" id="end-date" value="${result.constEndDate}"/></td>
					            <td class="header">사업자등록번호: </td><td><input type="text" id="copyNum" value="${sessionScope.copyNum}"/></td>
					        </tr>
					        <tr>
					            <td class="header">고객명: </td><td><input type="text" id="basic-name" name="basic-name" value="${result.name}"/><input type="hidden" name="basicNum" id="basicNum" value="${userNum}"/></td>
					            <td class="header">주소: </td><td><input type="text" id="addr" value="${result.address}"/></td>
					            <td class="header">전화: </td><td><input type="text" id="tel" value="${result.telNum}"/></td>
					        </tr>
					        <tr>
					            <td colspan="2" class="header">견적금액 (예약금): </td>
					            <td colspan="4"><input type="text" id="estimatePrice" value="${result.estimatePrice}"/></td>
					        </tr>
					    </table>
					    <p>위와 같이 견적합니다</p>
					    <section>
						    ${result.constructElement}
						    <script type="text/javascript">
						    	let sumPrice = document.getElementById("sumPrice");
						    	sumPrice.value = ${result.sumPrice};
						    </script>
					    </section>
					    	<c:if test="${endCheck != 'Y'}">
							    <button class="save-btn" onclick="updateConstruct()">수 정</button>
					    	</c:if>
					</div>
				</section>
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
    <script src="/resources/js/addSel.js"></script>
    </body>

</html>