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
        <link href="/resources/css/copyCheck.css" rel="stylesheet">
        
    </head>
    <body>
        <!-- Navbar start -->
	    <%@ include file="/views/common/header.jsp"%>        
        <!-- Navbar End -->

		        <div class="container-fluid py-5 mb-5 " style="margin-top: 100px;">
            <div class="container py-5">
                <div class="row g-5 align-items-center">
                    <div class="col-md-12 col-lg-7">
                        <h2 class="mb-3">업체 승인</h2>
                    </div>
                    <div >
                        <table>
                            <thead>
                                <tr>
                                    <th>업체명</th>
                                    <th>대표자명</th>
                                    <th>주소</th>
                                    <th>업체 번호</th>
                                    <th style="text-align: center;">승인 여부 </th>
                                    <th><span ></span></th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <c:choose>
									<c:when test="${empty list}">
										<tr>
											<td colspan="5" style="text-align: center; padding: 30px">승인할 업체가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${list}">
										    <tr>
										        <td>${item.copyName}</td>
										        <td>${item.ceoName}</td>
										        <td>${item.copyAddr}</td>
										        <td>${item.copyNo}</td>
										        <td style="text-align: center;">${item.approve}</td>
										        <td>
                                        			<!-- <div class="check" onclick="cancle()" name="cancle" id="cancle" style="background-color: red; float: right;" >취소</div>
                                        			<div class="check" onclick="check()" name="approve" id="check" style="float: right;">승인</div> -->
                                        			<form action="/copyApprove.do" method="post" style="display:inline;">
                                                    	<input type="hidden" name="copyNo" value="${item.copyNo}" />
                                                    	<input type="hidden" name="approve" value="approve" />
                                                    	<button type="submit" class="check" style="float: right;">승인</button>
                                                	</form>
                                                	<form action="companyServlet" method="post" style="display:inline;">
                                                    	<input type="hidden" name="companyId" value="${company.id}" />
                                                    	<input type="hidden" name="cancle" value="cancle" />
                                                    	<button type="submit" class="check" style="background-color: red; float: right;">취소</button>
                                                	</form>
                                    			</td>
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
							class="rounded page-n" href="/copyCheck.do?cpage=${pi.copypage-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:otherwise>

				</c:choose>

				<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
					<li class="page-item" style="margin-right: 0px"><a
						class="rounded page-n" href="/copyCheck.do?cpage=${page}">${page}</a></li>
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
							class="rounded page-n" href="/copyCheck.do?cpage=${pi.copypages+1}"
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
    <script src="/resources/js/copyCheck.js"></script>
    
    </body>

</html>