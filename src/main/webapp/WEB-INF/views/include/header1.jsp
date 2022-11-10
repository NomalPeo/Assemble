<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/5712e214cc.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="//http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/index/main.css">
<script type="text/javascript"
	src="/resources/js/index/jquery.1.12.4.js"></script>
<script type="text/javascript"
	src="/resources/plugins/bxslider/js/jquery.bxslider.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/plugins/web-fonts-with-css/css/all.css" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>

</head>
<body>
	<div class="wrap">
		<header>
			<div class="header-div">
				<h2>
					<a href="/main"><img src="../images/index/logo.png" width="150"
						height="65" alt="웹툰리뷰"></a>
				</h2>
				<div class="selector-menu">
					<a href="/tagpage_tag"><i class="fa-solid fa-play"></i><span>태그검색</span></a>
					<a href="/thema"><i class="fa-solid fa-play"></i><span>테마검색</span></a>
					<a href="/qna_list"><i class="fa-solid fa-play"></i><span>FAQ</span></a>
					<a href="/freeboard_list"><i class="fa-solid fa-play"></i><span>사사게</span></a>
				</div>
				<div class="login-join">
					<sec:authorize access="isAnonymous()">
						<a href="/users_login" class="login">로그인 </a> | <a href="join"
							class="/join"> 회원가입</a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_MEMBER')">
						<a href="/user/myPage" class="login_role">마이페이지 </a> |<a
							href="/user_logout" class="join"> 로그아웃</a>

					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<a href="/admin/adminPage" class="login">관리자 페이지 </a> | <a
							href="/user_logout" class="join"> 로그아웃</a>
					</sec:authorize>
				</div>
				<div style="clear: both;"></div>
			</div>
		</header>
		<div style="clear: both;"></div>