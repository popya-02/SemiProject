<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid fixed-top point-color base-shadow">
	<div class="topbar-width">
		<div class="header-home point-color">
			<a href="/" class="text-white navbar-brand">GONGGU</a>
		</div>
	</div>
	<div class="container px-0">
		<nav class="navbar navbar-light navbar-expand-xl">
			<a href="/" class="navbar-brand">
				<h4 class="point-text display-6">GONGGU</h4>
			</a>
			<div class="input-group search-wid d-flex box-right">
				<input type="search" class="form-control py-2 " placeholder="keywords" aria-describedby="search-icon-1">
				<span id="search-icon-1" class="input-group-text search-i">
					<a href="/views/etc/searchList.jsp">
						<i class="fa fa-search"></i>
					</a>
				</span>
			</div>
			<button class="navbar-toggler py-2 px-3" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
				<span class="fa fa-bars point-text"></span>
			</button>
			<div class="collapse navbar-collapse nav-menu" id="navbarCollapse">
				<div class="navbar-nav bg-white">
					<a href="/form/constructlist.do"
						class="nav-item nav-link point-text">시공예시</a> <a
						href="/copy/copylist.do?copypage=1"
						class="nav-item nav-link point-text">시공업체</a>

					<c:choose>
						<c:when test="${sessionScope.userType != null}">
							<a href="/member/logoutForm.do" class="nav-item nav-link point-text">로그아웃</a>
							<c:choose>
								<c:when test="${sessionScope.userType == 'basicUser'}">
									<a href="/MyPageEstimate/EstimateUser.do?cpage=1" class="nav-item nav-link point-text">
										<i class="fas fa-user useri-font"></i>
										<p class="nav-item nav-link my-none">마이페이지</p>
									</a>
								</c:when>
								<c:when test="${sessionScope.userType == 'copyUser'}">
									<a href="/MyPageEstimate/EstimateCopy.do?cpage=1" class="nav-item nav-link point-text">
										<i class="fas fa-user useri-font"></i>
										<p class="nav-item nav-link my-none">마이페이지</p>
									</a>
								</c:when>
								<c:when test="${sessionScope.userType == 'admin'}">
									<div class="nav-item dropdown">
										<a href="#" class="nav-link dropdown-toggle"
											data-bs-toggle="dropdown">회원관리</a>
										<div class="dropdown-menu m-0">
											<a href="/userForm.do?cpage=1&category=name&searchText=" class="dropdown-item">회원 조회</a> 
											<a href="/copyInfo.do?cpage=1&category=cu.copy_no&searchText=" class="dropdown-item">업체 조회</a> 
											<a href="/copyCheck.do?cpage=1" class="dropdown-item">업체 승인</a>
										</div>
									</div>
								</c:when>

							</c:choose>
						</c:when>
						<c:otherwise>
							<a href="/form/loginForm.do" class="nav-item nav-link point-text">로그인</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</nav>
	</div>
</div>