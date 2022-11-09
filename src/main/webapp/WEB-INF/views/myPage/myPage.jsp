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
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="//http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/index/main.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/myPage/myPage.css" />
<script type="text/javascript"
	src="/resources/js/index/jquery.1.12.4.js"></script>
<script type="text/javascript"
	src="/resources/plugins/bxslider/js/jquery.bxslider.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/plugins/web-fonts-with-css/css/all.css" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript">
	function pwd_check() {
		const user_pwd1 = $.trim($("#password_1").val());
		const user_pwd2 = $.trim($("#password_2").val());
		const user_pwd3 = $.trim($("#password_3").val());

		if (user_pwd1 == "") {
			alert("기존 비번을 입력하세요!");
			$("#user_pwd1").val("").focus();
			return false;
		}
		if (user_pwd2 == "") {
			alert("새로운 비번을 입력하세요!");
			$("#user_pwd2").val("").focus();
			return false;
		}
		if (user_pwd3 == "") {
			alert("비밀번호를 다시 입력하세요!");
			$("#user_pwd3").val("").focus();
			return false;
		}
		if (user_pwd2 != user_pwd3) {
			alert("비번이 다릅니다!");
			$("#user_pwd2").val(""); //비번 입력박스를 초기화
			$("#user_pwd3").val("");
			$("#user_pwd2").focus();
			return false;
		}
		alert('비번번호 변경!!');
	}
</script>
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
					<a href="thema/thema.jsp"><i class="fa-solid fa-play"></i><span>테마검색</span></a>
					<a href="FAQ/FAQ.jsp"><i class="fa-solid fa-play"></i><span>FAQ</span></a>
					<a href="/freeboard_list"><i class="fa-solid fa-play"></i><span>사사게</span></a>
				</div>
				<div class="login-join">
					<sec:authorize access="isAnonymous()">
						<a href="/users_login" class="login">로그인 </a> | <a href="join"
							class="join"> 회원가입</a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_MEMBER')">
						<a href="/user/myPage" class="login_role">마이페이지 </a> |
                    <form method="post" action="/user_logout"
							class="logoutform">
							<input type="hidden" name="${_csrf.parameterName}" class="logout"
								value="${_csrf.token}" /> <input type="submit" value="로그아웃" />
						</form>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<a href="/admin/adminPage" class="login">관리자 페이지 </a> | <a
							href="/user_logout" class="join"> 로그아웃</a>
					</sec:authorize>
				</div>
			</div>
		</header>
		<div style="clear: both;"></div>



		<div class="all-myPage">
			<div class="choice-page">
				<div class="choice-title">계정 관리</div>
				<ul>
					<li><button class="Security" type="button" id="box1">개인정보</button></li>
					<li><button class="Change-Password" type="button" id="box2">비밀번호
							변경</button></li>
					<li><button class="wishlist" type="button"
							onclick="location='#';">찜 목록</button></li>
					<li><button class="View-post" type="button"
							onclick="location='#';">작성글 관리</button></li>
					<li><button class="login-history" type="button" id="box3">로그인
							이력</button></li>
					<li><button class="Withdrawal" type="button" id="box4">회원
							탈퇴</button></li>
				</ul>
			</div>
			<!-- ------------------------------------------------- -->
			<div class="look-page">
				<form action="/user/secutiry_title">
					<div class="look-page-title Security-title">
						<div class="look-page-first">
							<div class="look-page-common">개인정보</div>
							<div>본 항목은 개인정보로서 다른 플레이어에게 공유되지 않습니다. 자세한 내용은 개인정보 처리방침 에서
								확인해 주세요!</div>
						</div>
						<div class="look-page-second Security-content">
							<div class="Security-Information">닉네임 변경</div>
							<input type="text" name="user_nickname" id="nickname" size="50"
								placeholder="닉네임"><br> <br>
							<div class="Security-Information">아이디 확인</div>
							<input type="text" name="user_id" id="ID" size="50"
								placeholder="ID"><br> <br>
							<br> <br>
							<br> <br>
							<div class="Security-change">
								<input type="submit" value="변경사항 저장"> <input
									type="reset" value="취소">
							</div>
						</div>
					</div>
				</form>
				<!--  -->
				<form action="/user/PasswordChange" method="post" onsubmit="return pwd_check();">
					<div class="look-page-title Change-Password-title">
						<div class="look-page-first">
							<div class="look-page-common">비밀번호 변경</div>
							<div>주기적으로 비밀번호를 변경하면 계정 무단 로그인을 방지할 수 있습니다.</div>
						</div>
						<div class="look-page-second Change-Password-content">
							<div class="Password-Information">기존 비밀번호</div>
							<input type="password" size="50" class="password" id="password_1"
								name="password_1" placeholder="기존 비밀번호"> <br>
							<div class="Password-Information">새 비밀번호</div>
							<input type="password" size="50" class="password" id="password_2"
								name="password_2" placeholder="새 비밀번호"> <br>
							<div class="Password-Information">새 비밀번호 확인</div>
							<input type="password" size="50" class="password" id="password_3"
								name="password_3" placeholder="새 비밀번호 확인"> <br> <br>
							<div class="password-change">
								<input type="submit" value="변경사항 저장">
								<input type="reset" value="취소">
							</div>
						</div>
					</div>
				</form>
				<!--  -->
				<div class="look-page-title login-history-title">
					<div class="look-page-first">
						<div class="look-page-common">최근 로그인 이력</div>
						<div>가장 최근에 로그인한 기록을 표시합니다.</div>
					</div>
					<div class="look-page-second login-history-content"></div>
				</div>
				<!--  -->
				<div class="look-page-title Withdrawal-title">
					<div class="look-page-first look-page-common">회원 탈퇴</div>
					<div class="look-page-second Withdrawal-content">
						<a href="/user/users_del">
							<button name="Withdrawal" id="Withdrawal">회원 탈퇴</button>
						</a>
					</div>
				</div>
				<!-- ----------------------------------------- -->
				<footer> </footer>
			</div>
		</div>
		<jsp:include page="../include/footer.jsp" />