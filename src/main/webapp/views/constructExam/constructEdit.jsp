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
		<h2 class="text-center text-white">시공예시 수정</h2>
	</div>
	<section class="example-insert-section">
		<div class="example-div">
			<form action="/constructExam/constructEdit.do" method="POST"
				enctype="multipart/form-data">
				<div class="copy-infor">

					<input type="hidden" name="copyNum" value="${getEdit.copyNum}">
					<input type="hidden" name="examNo" value="${getEdit.examNo}">
					<p>업체명 : ${getEdit.copyName}</p>
				</div>
				<div class="copy-infor">
					<p>
						작성일 :	<span id="noew-time" name="indate"></span>
					</p>
				</div>
				
				<div>시공내역
				<br>
				시공 시작일 : 
				${getEdit.constructStartDate}
				<br>
				시공 종료일 : 
				${getEdit.constructEndDate}
				<br>
				시공 주소 : 
				${getEdit.constructAddr}
				<br>
				시공 평수 : 
				${getEdit.constructRange}
				<br>
				시공 가격 : 
				${getEdit.constructPrice}
						
					
				</div>
				
				<div>Category : ${getEdit.category}
				<select name="categoryNo">
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
						value="${getEdit.title}">
				</div>
				<div class="smart-editor" id="smarteditor">
					<textarea id="editorTxt" name="content" rows="4"
						class="smart-editor-box">${getEdit.content}</textarea>
				</div>
				<div class="btn-box">
					<button type="submit" class="btn editor-btn">수 정</button>`````````````````````````````````````````````
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