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
                <span id="search-icon-1" class="input-group-text search-i"><a href="./search.html"><i class="fa fa-search"></a></i></span>
            </div>
            <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars point-text"></span>
            </button>
            <div class="collapse navbar-collapse nav-menu" id="navbarCollapse">
                <div class="navbar-nav bg-white">
                    <a href="/form/constructlist.do" class="nav-item nav-link point-text">시공예시</a>
                    <a href="/form/copylist.do" class="nav-item nav-link point-text">시공업체</a>
                    <a href="/form/loginForm.do" class="nav-item nav-link point-text">로그인</a>
                    <!-- <a href="shop-detail.html" class="nav-item nav-link point-text"><i class="fas fa-user useri-font"></i><p class="nav-item nav-link my-none">마이페이지</p></a> -->
                </div>
            </div>
        </nav>
    </div>
</div>