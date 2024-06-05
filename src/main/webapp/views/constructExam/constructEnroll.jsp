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
<link href="/resources/css/constructEnroll.css" rel="stylesheet">
</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<div class="page-title py-5 point-color">
		<h2 class="text-center text-white">시공예시 등록</h2>
	</div>
	<section class="example-insert-section">
		<div class="example-div">
			<form action="/constructExam/constructEnroll.do" method="POST"
				enctype="multipart/form-data">
				<div class="copy-infor">

					<input type="hidden" name="copyNum" value="${sessionScope.copyNum}">
					<p>업체명 : ${sessionScope.copyName}</p>
				</div>
				<div class="copy-infor">
					<p>
						작성일 :	<span id="noew-time" name="indate"></span>
					</p>
				</div>
				
				<div>시공내역 :
					<select name="constructList">
						<c:forEach var="list" items="${list}">
						<option value="${list.constructNo}">시공주소지:${list.constructAddr} 시공평수:${list.constructRange} 시공가격:${list.constructPrice}</option>
						</c:forEach>
					</select>
				</div>
				
				<div>Category :
				<select name="category">
				<option value="1">Antique</option>
				<option value="2">Modern</option>
				<option value="3">Natural</option>
				<option value="4">North Europe</option>
				<option value="5">Minimal</option>
				<option value="6">Vintage</option>
			
				</select>
				</div>
				<div>
					<input type="text" id="title" name="title" class="example-title"
						placeholder="제목을 입력해주세요.">
				</div>
				<div class="smart-editor" id="smarteditor">
					<textarea id="editorTxt" name="content" rows="4"
						class="smart-editor-box"></textarea>
				</div>
				<div class="btn-box">
					<button type="submit" class="btn editor-btn" onclick="save()">등 록</button>
				</div>
			</form>
		</div>
	</section>

	<!-- Footer Start -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- Copyright End -->

	<!-- Back to Top -->
	<a href="#" class="btn btn-point border-3 rounded-circle back-to-top"><i
		class="fa fa-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<%@ include file="/views/common/jsLib.jsp"%>

	<!-- Template Javascript -->
	<script src="/resources/js/main.js"></script>
	<script src="/resources/js/nowtime.js"></script>
</body>

</html>