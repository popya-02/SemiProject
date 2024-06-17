<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<link href="/resources/css/constructList.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.2/font/bootstrap-icons.min.css">
</head>
<body>
	<!-- Navbar start -->
	<%@ include file="/views/common/header.jsp"%>
	<!-- Navbar End -->

	<div class="container-fluid py-5"
		style="background-color: #223455; margin-top: 120px">
		<h1 class="text-center text-white display-6">시공예시</h1>
	</div>

	<main>

		<!-- 업체 -->
		<div class="album py-5 bg-body-tertiary">
			<div class="container">
				<c:if test="${sessionScope.userType == 'copyUser'}">
					<div class="submit-btn">
						<a href="/form/constructEnroll.do">
							<button
								class="tlrhd-btn tlrhd-border btn-sm btn-outline-secondary">등록</button>
						</a>
					</div>
				</c:if>
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<c:choose>
						<c:when test="${empty constructList}">
							<h5>등록 되어있는 업체가 없습니다.</h5>
						</c:when>
						<c:otherwise>
							<c:forEach var="construct" items="${constructList}">
								<form action="/constructExam/constructdelete.do" method="POST">
								<input type="hidden" name="examNo" value="${construct.examNo}">
								<input type="hidden" name="fileNo" value="${construct.fileNo}">
								<input type="hidden" name="fileName" value="${construct.fileName}">
								<input type="hidden" id="${construct.copyName}" name="copyNum" value="${construct.copyNum}">
								<input type="hidden" name="userNum" value="${construct.userNum}">
								<input type="hidden" name="page" value="${pi.copypage}">
									<div class="col">
										<div class="card shadow-sm">
											<a href="/constructDetail.do?examNo=${construct.examNo}" class="img-size">
											<img class="bd-placeholder-img card-img-top" src="/resources/img/${construct.fileName}" class="img-contain" fill="#55595c" />
											</a>
											<p class="djqcpaud">${construct.copyName}</p>
			
											<div class="card-body">
												<p>${construct.title}</p>
												<div class="d-flex justify-content-between align-items-center">
													<div class="btn-group">
													<c:if test="${sessionScope.copyName == construct.copyName}">
														<button type="button" class="tlrhd-border btn-sm btn-outline-secondary"
															onclick="location.href='/constructExam/constructEdit.do?examNo=${construct.examNo}'">
															수정</button>
															&nbsp;
														<button type="submit" class="tlrhd-border btn-sm btn-outline-secondary">삭제</button>
														
													</c:if>
													</div>
													<c:choose>
														<c:when test="${not empty getLike }">
															<c:set var="count" value="1" />
															<c:forEach var="item" items="${getLike}">
																<c:if test="${construct.copyNum == item.copyNum}">
																	<button type="button" name="${construct.copyName}" id="likeButton" class="likeButton bi bi-house-heart tlrhd-like border border-secondary text-primary rounded-pill clicked" onclick=""></button>
																	<c:set var="count" value="${count+1 }" />
																</c:if>
															</c:forEach>
																<c:if test="${count == 1}">
																	<button type="button" name="${construct.copyName}" id="likeButton" class="likeButton bi bi-house-heart tlrhd-like border border-secondary text-primary rounded-pill" onclick=""></button>
																</c:if>
														</c:when>
														<c:otherwise>
																<button type="button" name="${construct.copyName}" id="likeButton" class="likeButton bi bi-house-heart tlrhd-like border border-secondary text-primary rounded-pill" onclick=""></button>
														</c:otherwise>
													</c:choose>
												</div>
											</div>
										</div>
									</div>
								</form>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

	</main>

	<!-- ---------------------------------페이지네이션------------------------------------------ -->
	<div class="col-12">
		<div class="pagination d-flex justify-content-center mt-5">

			<c:choose>
				<c:when test="${pi.copypage == 1 }">
					<a href="#" class="page-n rounded">&laquo;</a>
				</c:when>
				<c:otherwise>
					<a
						href="/constructExam/constructlist.do?constructpage=${pi.copypage-1}"
						class="page-n rounded">&laquo;</a>
				</c:otherwise>
			</c:choose>

			<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
				<a href="/constructExam/constructlist.do?constructpage=${page}"
					class="page-n rounded">${page}</a>
			</c:forEach>

			<c:choose>
				<c:when test="${pi.copypage == pi.maxPage }">
					<a href="#" class="page-n rounded">&raquo;</a>
				</c:when>
				<c:otherwise>
					<a
						href="/constructExam/constructlist.do?constructpage=${pi.copypage+1}"
						class="page-n rounded">&raquo;</a>
				</c:otherwise>
			</c:choose>


		</div>
	</div>

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