<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script
	 src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/537cf02f0b.js"
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
<link rel="stylesheet" type="text/css"
	href="/resources/css/tagpage/tag.css">

<script type="text/javascript">

$(document).ready(function() {
   $('.slider-wrap').bxSlider({
      controls : false,
      pager : false,
      auto : true,
      minSlides:1,
      maxSlides:3,
      moveSlides:1
   });
});

function openLayer(i) {
   document.getElementById(i).style.display = "block";
}

function closeLayer(i) {
   document.getElementById(i).style.display = "none";
}


</script>
</head>
<body>
	<div class="wrap">
		<header>
			<div class="header-div">
				<h2>
					<a href="main"><img src="../images/index/logo.png" width="150"
						height="65" alt="웹툰리뷰"></a>
				</h2>
				<div class="selector-menu">
					<a href="/tagpage_tag"><i class="fa-solid fa-play"></i><span>태그검색</span></a>
					<a href="#"><i class="fa-solid fa-play"></i><span>테마검색</span></a> <a
						href="#"><i class="fa-solid fa-play"></i><span>FAQ</span></a> <a
						href="/freeboard_list"><i class="fa-solid fa-play"></i><span>사사게</span></a>
					<div class="login-join" style="margin:0; padding:0;">
						<sec:authorize access="isAnonymous()">
							<a href="/users_login" class="login">로그인 </a> | <a href="join"
								class="join"> 회원가입</a>
						</sec:authorize>
						<sec:authorize access="hasAnyRole('ROLE_MEMBER')">
							<a href="user/myPage" class="login_role">마이페이지 </a> |
                    <form method="post" action="user_logout"
								class="logoutform">
								<input type="hidden" name="${_csrf.parameterName}"
									class="logout" value="${_csrf.token}" /> <input type="submit"
									value="로그아웃" />
							</form>
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
		<div class="listbox">
			<div id="subheader">
				<div id="menu">
					<form action="tagpage_tag1">
						<input type="hidden" name="webtoon_complete"
							value="${webtoon_complete}"><input type="hidden"
							name="webtoon_tag1" value="${webtoon_tag1}">
						<ul class="menu">
							<br>
							<li><a href="/tagpage_tag?webtoon_platform=전체">전체</a></li>
							<li><input type="submit" name="webtoon_platform" value="네이버"></li>
							<li><input type="submit" name="webtoon_platform" value="카카오"></li>

						</ul>
					</form>
				</div>

				<div style="clear: both;"></div>

				<div id="submenu">
					<form action="tagpage_tag1">
						<input type="hidden" name="webtoon_platform"
							value="${webtoon_platform}"><input type="hidden"
							name="webtoon_tag1" value="${webtoon_tag1}">

						<ul class="submenu">
							<li class="current"><a
								href="/tagpage_tag?webtoon_complete=전체">전체</a></li>
							<li><input type="submit" name="webtoon_complete" value="미완결"></li>
							<li><input type="submit" name="webtoon_complete" value="완결"></li>

						</ul>
					</form>
				</div>

				<div style="clear: both;"></div>

				<div id="submenutab">
					<form action="tagpage_tag1">
						<input type="hidden" name="webtoon_platform"
							value="${webtoon_platform}"><input type="hidden"
							name="webtoon_complete" value="${webtoon_complete}">
						<ul class="submenutab">
							<li class="current"><a href="/tagpage_tag?webtoon_tag1=전체">전체</a></li>
							<li><input type="submit" name="webtoon_tag1" value="판타지"></li>
							<li><input type="submit" name="webtoon_tag1" value="드라마"></li>
							<li><input type="submit" name="webtoon_tag1" value="로맨스"></li>
							<li><input type="submit" name="webtoon_tag1" value="SF"></li>
							<li><input type="submit" name="webtoon_tag1" value="액션"></li>
							<li><input type="submit" name="webtoon_tag1" value="무협"></li>
							<li><input type="submit" name="webtoon_tag1" value="스포츠"></li>
							<li><input type="submit" name="webtoon_tag1" value="코미디"></li>
							<li><input type="submit" name="webtoon_tag1" value="스릴러"></li>
							<li><input type="submit" name="webtoon_tag1" value="공포"></li>
							<li><input type="submit" name="webtoon_tag1" value="일상"></li>
						</ul>
					</form>
				</div>

				<div style="clear: both;"></div>

			</div>
			<!-- --------------------------------------------- -->


			<c:if test="${!empty wblist }">
				<div class="tag-item">
					<c:forEach var="wblist" items="${wblist}">
						<a onclick="openLayer(<c:out value="${wblist.webtoon_no}"/>)"
							value="<c:out value="${wblist.webtoon_no}"/>">
							<div class="item" id="item">
								<div class="web-img">
									<img src="/resources/upload/${wblist.webtoon_thumbnail}"
										class="thumbnail" style="width: 100%; height: 100%;">
								</div>
								<div class="web-title" id="web-title">
									<span><b><c:out value="${wblist.webtoon_title}" /></b></span>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</c:if>

			<%-- 검색폼 --%>
			<div>
				<form action="tagpage_tag" id="search">
					<select name="find_field">
						<option value="webtoon_title"
							<c:if test="${find_field=='webtoon_title'}">${'selected'}</c:if>>제목
						</option>
						<option value="webtoon_writer"
							<c:if test="${find_field=='webtoon_writer'}">${'selected'}</c:if>>작가
						</option>
					</select> <input name="find_name" id="find_name" size="14"
						value="${find_name}" /> <input type="submit" value="검색" />
				</form>
			</div>

		</div>

		<c:forEach var="pop" items="${wblist}">
			<div class="popup-layer" id="<c:out value="${pop.webtoon_no}"/>">
				<div class="popup-box">
					<div class="content-part" id="content-part">
						<div class="pop-text">
							<div class="pop-title" id="pop-title">
								<h3>${pop.webtoon_title}</h3>
							</div>
							<div class="pop-author">
								<b> 플랫폼 : &nbsp;${pop.webtoon_platform}<br>
									작가&nbsp;&nbsp;&nbsp;: &nbsp;${pop.webtoon_writer}<br>
									장르&nbsp;&nbsp;&nbsp;:&nbsp; <c:if
										test="${empty pop.webtoon_tag2}">
                        ${pop.webtoon_tag1}
                        </c:if> <c:if test="${!empty pop.webtoon_tag2}">
                        ${pop.webtoon_tag1} , ${pop.webtoon_tag2}
                        </c:if></b>
								<button class="popup-content-btn">
									<a href="/content?webtoon_thumbnail=${pop.webtoon_thumbnail}">
										<i class="xi-library-books-o"></i>
									</a>
								</button>
							</div>

							<div class="pop-cont">${pop.webtoon_cont}</div>
						</div>
						<div class="popup-btn">
							<a id="close-btn"
								onclick="closeLayer(<c:out value="${pop.webtoon_no}"/>)"> <i
								class="fa-solid fa-rectangle-xmark"></i></a>
						</div>
						<div class="total">
							<div class="slider-wrap">

								<div class="pop-img">
									<img src="resources/upload/${pop.webtoon_image1 }"
										style="height: 450px; width: 450px;">
								</div>


								<div class="pop-img">
									<img src="resources/upload/${pop.webtoon_image2 }"
										style="height: 450px; width: 450px;">
								</div>

								<div class="pop-img">
									<img src="resources/upload/${pop.webtoon_image3 }"
										style="height: 450px; width: 450px;">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>