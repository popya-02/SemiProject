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
				
				<!-- 메인이미지 업로드 -->
				
					<div class="tlrhd-img" id="container-enroll">
						<div class="image-upload" id="image-upload">

							<div class="button">
								<label for="chooseFile"> 👉 이미지 업로드 👈 </label>
							</div>
							<input type="file" id="chooseFile" name="chooseFile"
								accept="image/*" onchange="loadFile(this)">

							<div class="fileContainer">
								<div class="fileInput">
									<p>파일 명:</p>
									<p id="fileName"></p>
								</div>
								<div class="buttonContainer" id="submitButton">
									<div class="submitButton">등록</div>
								</div>
							</div>
						</div>
<!-- 
						<div class="image-show" id="image-show"></div> -->
					</div>
				
				<!--  -->
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
	<script src="/resources/js/smarteditor.js"></script>
	<script src="/resources/smarteditor2/js/HuskyEZCreator.js"></script>
<script>
var submit = document.getElementById('submitButton');
submit.onclick = showImage;     //Submit 버튼 클릭시 이미지 보여주기

function showImage() {
    var newImage = document.getElementById('image-upload').lastElementChild;

    //이미지는 화면에 나타나고
    newImage.style.visibility = "visible";

    //이미지 업로드 버튼은 숨겨진다
    document.getElementById('image-upload').style.visibility = 'hidden';

    document.getElementById('fileName').textContent = null;     //기존 파일 이름 지우기
}

function loadFile(input) {
    var file = input.files[0];	//선택된 파일 가져오기

    //미리 만들어 놓은 div에 text(파일 이름) 추가
    var name = document.getElementById('fileName');
    name.textContent = file.name;

    //새로운 이미지 div 추가
    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    //이미지 source 가져오기
    newImage.src = URL.createObjectURL(file);

   // newImage.style.width = "300x";
   //newImage.style.height = "300px";
    newImage.className = "newimg";
    
    
    newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지를 숨긴다
    newImage.style.objectFit = "contain";

    //이미지를 image-show div에 추가
    var container = document.getElementById('image-upload');
    container.appendChild(newImage);
};
</script>
</body>

</html>
