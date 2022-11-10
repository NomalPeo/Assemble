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
	href="/resources/css/myPage/wish.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/tagpage/tag.css">
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
							class="join"> 회원가입</a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_MEMBER')">
						<a href="/user/myPage" class="login_role">마이페이지 </a> | <a
							href="/user_logout" class="join"> 로그아웃</a>
                    
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
						<a href="/admin/adminPage" class="login">관리자 페이지 </a> | <a
							href="/user_logout" class="join"> 로그아웃</a>
					</sec:authorize>
				</div>
			</div>
		</header>
		<div style="clear: both;"></div>



		<div class="list-box">
			<form name="t" method="post" action="/content_ok">

				<div class="ContentSeriesSection">
					<div class="ContentTitleSection">
						<span class="Text-ContentTitleSection">찜목록</span>
						<c:if test="${empty w_list}">

							<span class="wish-msg"><c:out value="${wishmsg}" /></span>
						</c:if>
						<div class="wish-item">
							<c:forEach var="ws" items="${w_list}">

								<div class="wish_list">
									<div class="wish_listimage">
										<div class="wish-item2" id="item">
											<div class="wish-web-img">
												<a href="/content?webtoon_thumbnail=${ws.wish_thumbnail}"
													type="submit" value="${ws.wish_thumbnail}"
													class="wish_thumbnail"> <img
													src="/resources/upload/${ws.wish_thumbnail}"
													class="thumbnail" alt="썸네일"
													style="width: 100%; height: 100%;"></a>
											</div>

										</div>

										<div class="wish-web-title" id="web-title">
											<div class="Text-PosterViewItem1">

												<span><c:out value="${ws.wish_title}" /></span>
											</div>
											<div class="Metadata-PosterViewItem">
												<div class="BadgesWithSpace"></div>
												<div class="TextsWithSeparator-Metadata">
													<span class="Text">연재중</span> <img alt="메타데이터 구분점"
														src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxMCAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iNSIgY3k9IjgiIHI9IjEiIGZpbGw9ImJsYWNrIiBmaWxsLW9wYWNpdHk9IjAuMjUiLz4KPC9zdmc+Cg=="
														class="Separator"> <span class="Text"> 액션 </span> <img
														alt="메타데이터 구분점"
														src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxMCAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iNSIgY3k9IjgiIHI9IjEiIGZpbGw9ImJsYWNrIiBmaWxsLW9wYWNpdHk9IjAuMjUiLz4KPC9zdmc+Cg=="
														class="Separator">

												</div>
												<div class="wish_btn">
													<input type="button" value="삭제"
														onclick="location='wish_del?wish_title=${ws.wish_title}';" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>


			</form>

		</div>
	</div>
</body>
</html>
