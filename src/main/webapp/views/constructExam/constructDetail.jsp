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
<link href="/resources/css/constructDetail.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.2/font/bootstrap-icons.min.css">

<!-- 카카오 JavaScript SDK -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
	// 카카오 SDK를 초기화합니다.
	Kakao.init('0cc54fea96db079fd01e5734f4b07be1'); // 'YOUR_KAKAO_APP_KEY'를 실제 카카오 JavaScript 키로 대체하세요.

	function shareKakao() {
		Kakao.Link
				.sendDefault({
					objectType : 'feed',
					content : {
						title : '${detail.copyName}',
						description : '${detail.content}',
						imageUrl : 'http://yourdomain.com/resources/img/${detail.fileName}', // 실제 이미지 URL로 대체하세요.
						link : {

							webUrl : 'http://yourdomain.com/detailPage' // 실제 페이지 URL로 대체하세요.
						}
					},
					buttons : [ {
						title : '웹으로 보기',
						link : {

							webUrl : 'http://yourdomain.com/detailPage' // 실제 페이지 URL로 대체하세요.
						}
					} ]
				});
	}
</script>



</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<div class="container-fluid page-header py-5"
		style="background-color: #223455;">
		<h1 class="text-center text-white display-6">시공예시</h1>

	</div>


	<!-- 시공예시 메인 이미지 -->

	<div class="tlrhd">
		<img class="tlrhd-img img-border rounded"
			src="/resources/img/${detail.fileName}">
	</div>
	<div class="tlrhddjqcpaud">
		<p>${detail.copyName}</p>
	</div>
	<!-- 시공 nav -->
	<div class="tlrhd-nav">

		<a href=""
			class="tlrhd-border border border-secondary text-primary rounded-pill px-4 py-3"
			onclick="shareKakao()">공유하기</a> &nbsp;&nbsp;
		<c:if test="${sessionScope.userType == 'basicUser' }">
			<a
				href="/chatting/connection.do?copyNum=${detail.copyNum}&userNum=${sessionScope.userNum}"
				class="tlrhd-border border border-secondary text-primary rounded-pill px-4 py-3">이
				스타일로 상담하기</a>
		</c:if>
	</div>

<div>
<input type="hidden" id="${detail.copyName}" name="copyNum" value="${detail.copyNum}">
	<c:choose>
		<c:when test="${not empty getLike }">
			<c:set var="count" value="1" />
			<c:forEach var="item" items="${getLike}">
				<c:if test="${detail.copyNum == item.copyNum}">
					<button type="button" name="${detail.copyName}"
						id="likeButton"
						class="likeButton bi bi-house-heart tlrhd-liked border border-secondary text-primary rounded-pill clicked"
						onclick=""></button>
					<c:set var="count" value="${count+1 }" />
				</c:if>
			</c:forEach>
			<c:if test="${count == 1}">
				<button type="button" name="${detail.copyName}" id="likeButton"
					class="likeButton bi bi-house-heart tlrhd-liked border border-secondary text-primary rounded-pill"
					onclick=""></button>
			</c:if>
		</c:when>
		<c:otherwise>
			<button type="button" name="${detail.copyName}" id="likeButton"
				class="likeButton bi bi-house-heart tlrhd-liked border border-secondary text-primary rounded-pill"
				onclick=""></button>
		</c:otherwise>
	</c:choose>
</div>
	<br>
	<br>
	<br>
	<div class="tlrhd-ruswjr border-secondary text-primary"> 시공 시작일 :
		${detail.constructStartDate}</div>
	<br>
	<div class="tlrhd-ruswjr border-secondary text-primary"> 시공 종료일 :
		${detail.constructEndDate}</div>
	<br>
	<div class="tlrhd-ruswjr border-secondary text-primary"> 시공지 주소 :
		${detail.constructAddr}</div>
	<br>
	<div class="tlrhd-ruswjr border-secondary text-primary"> 시공 평수 :
		${detail.constructRange}평</div>
	<br>
	<div class="tlrhd-ruswjr border-secondary text-primary"> 시공 가격 :
		${detail.constructPrice}원</div>
	<br>
	<div class="tlrhd-ruswjr border-secondary text-primary"> 카테고리 :
		${detail.category}</div>


	</div>
	<!-- 상세 설명 -->
	<div class="tlrhd-content">${detail.content}</div>

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
	<!--     <script src="/resources/js/chatting.js"></script> -->
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // 페이지 로드 시 로컬 스토리지에서 상태 읽기
    $(document).ready(function() {
        const button = $('.likeButton');
        /* const isClicked = localStorage.getItem('likeButtonClicked') === 'true';
        if (isClicked) {
        	console.log("a")
        	console.log(button);
            button.addClass('clicked');
        } */

        // 버튼 클릭 시 Ajax 요청
        button.click(function() {
            const isClicked = $(this).hasClass('clicked');
            const myBtn = this; // 클릭이 발생한 버튼
            const myBtnCopy = myBtn.name; // 클릭이 발생한 버튼의 name
            const copyBtnList = document.getElementsByName(myBtnCopy);
            const copyNum = document.getElementById(myBtnCopy).value; // 예시로 examNo를 하드코딩하거나 실제 동적으로 설정하는 방법으로 변경해야 합니다.
            $.ajax({
                type: 'GET',
                url: '/LikeCopyController',
                
                data: {
                    copyNum: copyNum,
                    isClicked: !isClicked
                },
                success: function(response) {
                    if (response === 'liked') {
                        alert('관심 업체에 등록되었습니다.');
                        for(var i=0; i<copyBtnList.length; i++){                       	
                        copyBtnList[i].classList.add("clicked");
                        }
                        /* myBtn.classList.add("clicked"); */
                       /*  button.addClass('clicked'); */
                        localStorage.setItem('likeButtonClicked', 'true');
                    } else if (response === 'unliked') {
                        alert('관심 업체에서 제거되었습니다.');
                        for(var i=0; i<copyBtnList.length; i++){                       	
                            copyBtnList[i].classList.remove("clicked");
                            }
                        /* myBtn.classList.remove("clicked"); */
;

/*                         button.removeClass('clicked'); */
                        localStorage.setItem('likeButtonClicked', 'false');
                    } else {
                        alert('처리 중 오류가 발생했습니다.');
                    }
                
                },
                error: function(xhr, status, error) {
                    console.error('요청 실패: ' + status + ', ' + error);
                    alert('서버 오류로 인해 요청을 처리할 수 없습니다.');
                }
            });
        });
    });
</script>
</html>