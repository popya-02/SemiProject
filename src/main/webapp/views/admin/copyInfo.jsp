<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
    	<link href="/resources/css/copyInfo.css" rel="stylesheet">
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
                        <a  href="/copyInfo.do?cpage=1&category=cu.copy_no&searchText="><h2 class="mb-3">업체 검색</h2></a>
                        <form action="/copyInfo.do?cpage=${pi.copypage}" method="GET">
                        <input type="hidden" name="cpage" value="1" />
                        <div class="input-group search-wid d-flex box-right" style="margin-left: 15%;">
                            <select name="category" id="">
                                <option value="cu.copy_name">업체명</option>
                                <option value="cu.copy_no">업체번호</option>
                                <option value="cd.copy_addr">주소</option>
                            </select>
                            <input type="search" name="searchText" class=" inputSize form-control py-2 "  aria-describedby="search-icon-1">
                           <button id="search-icon-1" class="input-group-text search-i" type="submit">
                            <i class="fa fa-search"></i></button>
                        </div>
                        </form>
                    </div>
                    <div>
                        <table>
                            <thead>
                                <tr>
                                    <th>업체명</th>
                                    <th>대표자명</th>
                                    <th>주소</th>
                                    <th>업체 번호</th>
                                    <th>승인 여부 </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
									<c:when test="${empty list}">
										<tr>
											<td colspan="5" style="text-align: center; padding: 30px">등록된 업체가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${list}">
											<tr>
												<td>${item.copyName}</td>
												<td>${item.ceoName}</td>
												<td>${item.copyAddr}</td>
												<td>${item.copyNo}</td>
												<td>${item.approve}</td>
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
        		
        <div class="col-12">
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
							class="rounded page-n" href="/copyInfo.do?cpage=${pi.copypage-1}&category=cu.copy_no&searchText="
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:otherwise>

				</c:choose>

				<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
					<li class="page-item" style="margin-right: 0px"><a
						class="rounded page-n" href="/copyInfo.do?cpage=${page}&category=cu.copy_no&searchText=">${page}</a></li>
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
							class="rounded page-n" href="/copyInfo.do?cpage=${pi.copypage+1}&category=cu.copy_no&searchText="
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