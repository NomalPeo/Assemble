<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	 src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/537cf02f0b.js"
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
<script type="text/javascript"
	src="/resources/js/index/jquery.1.12.4.js"></script>
<script type="text/javascript"
	src="/resources/plugins/bxslider/js/jquery.bxslider.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/plugins/web-fonts-with-css/css/all.css" />
<script>
        $(document).ready(function () {
            $('.slider1').bxSlider({
                controls: false,
                pager: false,
                auto: true
            });

            $('.header-plus-btn').click(function () {
                $('.header-content').css('position', 'relative');
                var one = $('.header-content').css('height');

                if (one == "0px") {
                    $('.header-content').css('height', 170);
                } else {
                    $('.header-content').css('height', 0);
                }
            });

            $('.introduce-completion-content').bxSlider();
            $('.introduce-weekbest-content').bxSlider();
            $('.introduce-love-content').bxSlider();
            $('.introduce-monthbest-content').bxSlider();
        });
    </script>
</head>
<body>
	<div class="wrap">
		<header>
			<div class="header-div">
				<h2>
					<a href="#"><img src="./images/index/logo.png" width="150"
						height="65" alt="웹툰리뷰"></a>
				</h2>
				<div class="selector-menu">
					<a href="/tagpage_tag"><i class="fa-solid fa-play"></i><span>태그검색</span></a>
					<a href="#"><i class="fa-solid fa-play"></i><span>테마검색</span></a> <a
						href="#"><i class="fa-solid fa-play"></i><span>FAQ</span></a> <a
						href="/freeboard_list"><i class="fa-solid fa-play"></i><span>사사게</span></a>
				</div>
				<button class="header-plus-btn" name="header-plus-btn">
					<i class="fa-solid fa-plus"></i>
				</button>


				<div class="login-join">
					<sec:authorize access="isAnonymous()">
						<a href="/users_login" class="login">로그인 </a> | <a href="join"
							class="join"> 회원가입</a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_USER')">
						<a href="/myPage" class="login_role">마이페이지 </a> |
                    <form method="post" action="user_logout"
							class="logoutform">
							<input type="hidden" name="${_csrf.parameterName}" class="logout"
								value="${_csrf.token}" /> <input type="submit" value="로그아웃" />
						</form>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<a href="/admin/adminPage" class="login">관리자 페이지 </a> | <a href="/user_logout"
							class="join"> 회원가입</a>
					</sec:authorize>
				</div>


				<div style="clear: both;"></div>

				<div class="header-plus">
					<div class="header-content">
						<div class="header-content-bar">
							<ul>
								<li><a href="#">공지사항</a></li>
								<li><a href="#">업데이트</a></li>
								<li><a href="#">이벤트</a></li>
								<li><a href="#">개발자의 편지</a></li>
							</ul>
						</div>
						<div class="header-content-bar">
							<ul>
								<li><a href="#">장르분류</a></li>
								<li><a href="#">플랫폼 분류</a></li>
								<li><a href="#">시대분류</a></li>
								<li><a href="#">완결웹툰</a></li>
								<li><a href="#">작가분류</a></li>
							</ul>
						</div>
						<div class="header-content-bar">
							<ul>
								<li><a href="#">커뮤니티</a></li>
								<li><a href="#">소통의 장</a></li>
								<li><a href="#">내 인생 웹툰</a></li>
								<li><a href="#">갤러리</a></li>
								<li><a href="#">Q&amp;A</a></li>
							</ul>
						</div>
						<div class="header-content-bar">
							<ul>
								<li><a href="#">FAQ</a></li>
								<li><a href="#">신고센터</a></li>
								<li><a href="#">보안서비스</a></li>
								<li><a href="#">클라이언트</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</header>
		<div style="clear: both;"></div>
		<!-- ------------------------------------------------------------------ -->
		<div class="thumbnail-slider">
			<div class="slider1">
				<div class="thumbnail-inner" style="text-align: center;">
					<div style="text-align: center;">
						<a href="#"><img
							src="/resources/images/index/header-Thumbnail/이름모름.jpg"></a>
					</div>
				</div>
				<div class="thumbnail-inner">
					<div style="text-align: center;">
						<a href="#"><img
							src="/resources/images/index/header-Thumbnail/신의탑.jpg"></a>
					</div>
				</div>
				<div class="thumbnail-inner">
					<div>
						<a href="#"><img
							src="/resources/images/index/header-Thumbnail/main_image_01.jpg"></a>
					</div>
				</div>
				<div class="thumbnail-inner">
					<div>
						<a href="#"><img
							src="/resources/images/index/header-Thumbnail/main_image_02.jpg"></a>
					</div>
				</div>
				<div class="thumbnail-inner">
					<div>
						<a href="#"><img
							src="/resources/images/index/header-Thumbnail/main_image_03.jpg"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- ------------------------------------------------------------------ -->
		<div class="tag-selector">
			<a class="action-icon" href="#"></a> <a class="ghost-icon" href="#"></a>
			<a class="love-icon" href="#"></a> <a class="school-icon" href="#"></a>
			<a class="robot-icon" href="#"></a>
		</div>
		<!-- ------------------------------------------------------------------ -->
		<div class="search">
			<form>
				<input type="text"
					style="width: 600px; height: 40px; font-size: 30px; font-size: 15px;"
					placeholder="웹툰 검색"> <a href="#"><i
					class="fa-solid fa-magnifying-glass"></i></a>
			</form>
		</div>
		<!-- ------------------------------------------------------------------ -->
		<div class="monthbest">
			<span>무섭다는 공포 웹툰</span>
			<div class="introduce-monthbest-content">
				<div class="monthbest-inner">
					<c:forEach var="thriller1" items="${glist1 }" begin="0" end="5">
					<div class="inner2">
						<a href="#"><img src="/resources/upload/${thriller1.webtoon_thumbnail}"	style="width: 200px; height: 250px;"></a>
					</div>
					</c:forEach>
				</div>
				<div class="monthbest-inner">
					<c:forEach var="thriller2" items="${glist2 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img src="/resources/upload/${thriller2.webtoon_thumbnail}"	style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="monthbest-inner">
					<c:forEach var="thriller3" items="${glist3 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img src="/resources/upload/${thriller3.webtoon_thumbnail}"	style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="monthbest-inner">
					<c:forEach var="thriller4" items="${glist4 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img src="/resources/upload/${thriller4.webtoon_thumbnail}"	style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>


		<!-- ------------------------------------------------------------------ -->

		<div class="love">
			<span>사랑스러운 웹툰</span>
			<div class="introduce-love-content">
				<div class="love-inner">
					<c:forEach var="romance1" items="${wlist1 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img
								src="/resources/upload/${romance1.webtoon_thumbnail}"
								style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="love-inner">
					<c:forEach var="romance2" items="${wlist2 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img
								src="/resources/upload/${romance2.webtoon_thumbnail}"
								style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="love-inner">
					<c:forEach var="romance3" items="${wlist3 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img
								src="/resources/upload/${romance3.webtoon_thumbnail}"
								style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="love-inner">
					<c:forEach var="romance4" items="${wlist4 }" begin="0" end="5">
						<div class="inner2">
							<a href="#"><img
									src="/resources/upload/${romance4.webtoon_thumbnail}"
									style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>

			</div>
		</div>



		<!-- ------------------------------------------------------------------ -->

		<div class="completion">
			<span>재미진 액션 웹툰</span>
			<div class="introduce-completion-content">
				<div class="completion-inner">
					<c:forEach var="action" items="${alist1}">
					<div class="inner2">
						<a href="#"><img src="/resources/upload/${action.webtoon_thumbnail}"style="width: 200px; height: 250px;"></a>
					</div>
					</c:forEach>
				</div>
				<div class="completion-inner">
					<c:forEach var="action" items="${alist2}">
						<div class="inner2">
							<a href="#"><img src="/resources/upload/${action.webtoon_thumbnail}"style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="completion-inner">
					<c:forEach var="action" items="${alist3}">
						<div class="inner2">
							<a href="#"><img src="/resources/upload/${action.webtoon_thumbnail}"style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
				<div class="completion-inner">
					<c:forEach var="action" items="${alist4}">
						<div class="inner2">
							<a href="#"><img src="/resources/upload/${action.webtoon_thumbnail}"style="width: 200px; height: 250px;"></a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<!-- ------------------------------------------------------------------ -->
		<div class="weekbest">
			<span>이번주 인기웹툰</span>
			<div class="introduce-weekbest-content">
				<div class="weekbest-inner">
					<div>
						<a href="#"><img src="./images/Thumbnail/1을줄게.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/고삼무쌍.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/내남편과결혼해줘.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/김부장.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
				</div>
				<div class="completion-inner">
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/1을줄게.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/고삼무쌍.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/내남편과결혼해줘.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/김부장.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
				</div>
				<div class="completion-inner">
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/1을줄게.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/고삼무쌍.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/내남편과결혼해줘.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/김부장.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
				</div>
				<div class="completion-inner">
					<div>
						<a href="#"><img src="./images/Thumbnail/1을줄게.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/고삼무쌍.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/내남편과결혼해줘.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/김부장.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
				</div>
				<div class="completion-inner">
					<div>
						<a href="#"><img src="./images/Thumbnail/1을줄게.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/고삼무쌍.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/내남편과결혼해줘.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/김부장.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
					<div>
						<a href="#"><img src="./images/Thumbnail/나노머신.jpg"></a>
					</div>
				</div>
			</div>
		</div>
		<!-- ------------------------------------------------------------------ -->

		<!-- <div class="tour-item">
<div class="tour-title">Raft the Grand Cayon</div>
  <div class="tour-content">
     <p>

     </p>
  </div>
</div>-->
		<!-- ------------------------------------------------------------------ -->
		<div style="clear: both;"></div>
		<div class="community-write">
			<a href="#"><span class="bottom-community">다른 사용자들의 인생 웹툰
					추천</span></a> <a href="#"><span class="bottom-write">나만의 인생 웹툰 추천</span></a>
		</div>
		<!-- ------------------------------------------------------------------ -->
		<footer class="footer">
			<div class="footer-inner">
				<div id="footermenu">
					<ul>
						<li><a href="#">회사소개</a></li>
						<li><a href="#">광고/제휴문의</a></li>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">개인정보 처리방침</a></li>
						<li><a href="#">청소년보호정책</a></li>
						<li><a href="#">법적고지</a></li>
						<li><a href="#">이메일무단수집거부</a></li>
						<li><a href="#">고객센터</a></li>
					</ul>
					<br>
				</div>
				<div id="compony-introduce">
					대표이사 : 4조 | 사업자정보확인 개인정보관리 책임자 : 선지원 사업자등록번호 : 000-00-00000
					통신판매신고번호 : 강남 제 000000호<br> 본점 : 서울특별시 강남구 kgitbank 사업장 :
					서울특별시 강남구 kgitbank <br> 고객센터 : 00000-0000, sunjw222@naver.com
					이용자상담실 (문의 및 이용자 의견) : 000-000-0000<br> Copyright (C) sun All
					Rights Reserved.
				</div>
				<br> <img src="./images/index/logo.png" width="33" height="33"
					alt="logo" />
				<div class="footer-icon">
					<a href="#"><i class="fa-brands fa-facebook"></i></a> <a href="#"><i
						class="fa-brands fa-youtube"></i></a> <a href="#"><i
						class="fa-brands fa-instagram"></i></a>
				</div>
			</div>
		</footer>
	</div>
</body>
</html>