<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/tagpage/tag.css">

<%@ include file="../include/header.jsp"%>

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

<div id="subheader">
	<div id="menu">
		<ul class="menu">
			<li class="current"><a href="#">HOME</a></li>
			<li><a href="#">네이버</a></li>
			<li><a href="#">카카오</a></li>

		</ul>
	</div>


	<div style="clear: both;"></div>

	<div id="submenu">
		<ul class="submenu">
			<li class="current"><a href="#">all</a></li>
			<li><a href="#">미완결</a></li>
			<li><a href="#">완결</a></li>

		</ul>
	</div>

	<div style="clear: both;"></div>

	<div id="submenutab">
		<ul class="submenutab">
			<li class="current"><a href="#">all</a></li>
			<li><a href="#">판타지</a></li>
			<li><a href="#">드라마</a></li>
			<li><a href="#">로맨스</a></li>
			<li><a href="#">액션</a></li>
			<li><a href="#">무협</a></li>
			<li><a href="#">개그</a></li>
			<li><a href="#">스릴러</a></li>
			<li><a href="#">일상</a></li>
		</ul>
	</div>
	<div style="clear: both;"></div>

</div>


<h1>태그검색</h1>
<div class="listbox">
	<h2>태그리스트</h2>
	<form name="t" method="get" action="webtoon_list">

		<div class="tag-item">
			<c:forEach var="wblist" items="${wblist}">
				<a onclick="openLayer(<c:out value="${wblist.webtoon_no}"/>)"
					value="<c:out value="${wblist.webtoon_no}"/>">
					<div class="item" id="item">
						<div class="web-img">
							<img src="/resources/upload/${wblist.webtoon_thumbnail}"
								style="width: 250px; height: 300px;" class="thumbnail">
						</div>
						<div class="web-title" id="web-title">
							<span><c:out value="${wblist.webtoon_title}" /></span>
						</div>
					</div>
				</a>
			</c:forEach>
		</div>
	</form>
</div>

<c:forEach var="pop" items="${wblist}">
	<div class="popup-layer" id="<c:out value="${pop.webtoon_no}"/>">
		<div class="popup-box">
			<div class="content-part" id="content-part">
				<div class="pop-text">
					<div class="pop-title" id="pop-title">
						<h3>${pop.webtoon_title}</h3>
					</div>
					<div class="pop-author">${pop.webtoon_writer}/
						${pop.webtoon_tag1} , ${pop.webtoon_tag2} /
						${pop.webtoon_platform}</div>
					<div class="pop-cont">${pop.webtoon_cont}</div>
				</div>
				<div class="popup-btn">
					<a id="close-btn"
						onclick="closeLayer(<c:out value="${pop.webtoon_no}"/>)"><i
						class="fa-solid fa-rectangle-xmark"></i></a>
				</div>
				<div class="total">
					<div class="slider-wrap">

						<div class="pop-img">
							<img src="resources/upload/${pop.webtoon_image1 }" style="height:300px; width:300px;"/>
						</div>
						<div class="pop-img">
							<img src="resources/upload/${pop.webtoon_image2 }" style="height:300px; width:300px;"/>
						</div>
						<div class="pop-img">
							<img src="resources/upload/${pop.webtoon_image3 }" style="height:300px; width:300px;"/>
						</div>
					</div>
				</div>
			</div>

			<div class="review-part">
				<h3 class="review-title">리뷰</h3>
				<div class="review-wrap">

					<div id="review-list">
						<div class="review">
							<div class="review-user-part">
								<div id="rating">
									<i class="fa-regular fa-star"></i>&nbsp;0.5
								</div>
								<div id="user">
									<i class="fa-solid fa-user-secret"></i>&nbsp;jhj931012s
								</div>
							</div>
							<div id="review-cont">1부만 보셈 뒤에부턴 개망함</div>
							<div class="review-user-part">
								<div id="rating">
									<i class="fa-regular fa-star"></i>&nbsp;0.5
								</div>
								<div id="user">
									<i class="fa-solid fa-user-secret"></i>&nbsp;kgitbank123
								</div>
							</div>
							<div id="review-cont">웹툰경력 40년차인 내가 봐도 노잼인듯 ㅉㅉ</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>




