<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
    	<link href="/resources/css/userInfo.css" rel="stylesheet">
	    <%@ include file="/views/common/head.jsp"%>
        <title>GONGGU</title>
        
        <!-- Template Stylesheet -->
        <link href="/resources/css/style.css" rel="stylesheet">
        <!-- <link href="/resources/css/signup.css" rel="stylesheet"> -->
        
        
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->
        

		<div class="container-fluid py-5 mb-5 " style="margin-top: 100px;">
            <div class="container py-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-12 col-lg-7">
                        <a href="/userForm.do?cpage=1&category=name&searchText="><h2 class="mb-3">회원 검색</h2></a>
                        <form action="/userForm.do?cpage=${pi.copypage}" method="GET">
                        <input type="hidden" name="cpage" value="1" />
                        
                        <div class="input-group search-wid d-flex box-right" style="margin-left: 15%;">
                            <select name="category">
                                <option value="user_no">번호</option>
                                <option value="name">이름</option>
                                <option value="user_id">아이</option>
                            </select>
                            <input type="search" name="searchText" class=" inputSize form-control py-2 "  aria-describedby="search-icon-1" >
                            <!-- <span id="search-icon-1" class="input-group-text search-i">
                            <i class="fa fa-search"></i></span> -->
                            <button id="search-icon-1" class="input-group-text search-i" type="submit">
                            <i class="fa fa-search"></i></button>
                        </div>
                        </form>
                    </div>
                    <div>
                        <table>
                            <thead>
                                <tr>
                                    <th>회원 번호</th>
                                    <th>이름</th>
                                    <th>id</th>
                                    <th>주소</th>
                                </tr>
	                            </thead>
							<tbody>
								<c:choose>
									<c:when test="${empty list}">
										<tr>
											<td colspan="5" style="text-align: center; padding: 30px">등록된 회원이 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${list}">
											<tr>
												<%-- <th scope="row" style="width: 120px;">${row}</th>  --%>
												<th scope="row" style="width: 120px;">${item.userNo}</th> 
												<td>${item.userName}</td>
												<td>${item.userId}</td>
												<td>${item.addr}</td>
											</tr>
											<c:set var="row" value="${row-1}" />
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->

        <!-- 페이지네이션 -->
        <!-- <div class="col-12">
            <div class="pagination d-flex justify-content-center mt-5">
                <a href="#" class="rounded page-n">&laquo;</a>
                <a href="#" class="rounded page-n">1</a>
                <a href="#" class="rounded page-n">2</a>
                <a href="#" class="rounded page-n">3</a>
                <a href="#" class="rounded page-n">4</a>
                <a href="#" class="rounded page-n">5</a>
                <a href="#" class="rounded page-n">6</a>
                <a href="#" class="rounded page-n">&raquo;</a>
            </div>
        </div> -->
         <div class="col-12s">
            <div class="pagination d-flex justify-content-center mt-5">
        
				<!-- 왼쪽 버튼  -->
				<c:choose>
					<c:when test="${pi.copypage == 1}">
						<li class="page-item" style="margin-right: 0px"><a
							class="rounded page-n" href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
					</c:when>

					<c:otherwise>
						<li class="page-item" style="margin-right: 0px"><a
							class="rounded page-n" href="/userForm.do?cpage=${pi.copypage-1}&category=name&searchText="
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:otherwise>

				</c:choose>

				<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
					<li class="page-item" style="margin-right: 0px"><a
						class="rounded page-n" href="/userForm.do?cpage=${page}&category=name&searchText=">${page}</a></li>
				</c:forEach>



				<c:choose>
					<c:when test="${pi.copypage == pi.maxPage}">
						<li class="page-item" style="margin-right: 0px"><a
							class="rounded page-n" href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item" style="margin-right: 0px"><a
							class="rounded page-n" href="/userForm.do?cpage=${pi.copypage+1}&category=name&searchText="
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:otherwise>
				</c:choose>


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