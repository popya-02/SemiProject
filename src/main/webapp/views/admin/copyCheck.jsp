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
                                    <th>번호</th>
                                    <th>업체 명</th>
                                    <th>주소</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>집닥</td>
                                    <td>서울특별시 강남구</td>
                                    <td>
                                        <div class="check" onclick="cancle()" name="" id="cancle" style="background-color: red; float: right;" >취소</div>
                                        <div class="check" onclick="check()" name="" id="check" style="float: right;">승인</div>
                                    </td>
                                    <!-- <td><div class="check" onclick="cancle()" name="" id="cancle" style="background-color: red;">취소</div></td> -->
                                </tr>
                            </tbody>
                            
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <!-- Hero End -->

        <!-- <ul class="pagination" style="justify-content: center;">
           
            <c:choose>
                <c:when test="${pi.cpage == 1}">
                    <li class="page-item" style="margin-right: 0px"><a
                        class="page-link" href="#" aria-label="Previous"> <span
                            aria-hidden="true">&laquo;</span>
                    </a></li>
                </c:when>

                <c:otherwise>
                    <li class="page-item" style="margin-right: 0px"><a
                        class="page-link" href="//List.do?cpage=${pi.cpage-1}"
                        aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                    </a></li>
                </c:otherwise>

            </c:choose>

            <c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
                <li class="page-item" style="margin-right: 0px"><a
                    class="page-link" href="//List.do?cpage=${page}">${page}</a></li>
            </c:forEach>



            <c:choose>
                <c:when test="${pi.cpage == pi.maxPage}">
                    <li class="page-item" style="margin-right: 0px"><a
                        class="page-link" href="#" aria-label="Next"> <span
                            aria-hidden="true">&raquo;</span>
                    </a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item" style="margin-right: 0px"><a
                        class="page-link" href="/freeBoard/List.do?cpage=${pi.cpage+1}"
                        aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                    </a></li>
                </c:otherwise>
            </c:choose>

        </ul> -->

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