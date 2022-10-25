<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" type="text/css"
	href="/resources/css/tagpage/tag.css">

<script type="text/javascript" src="/resources/js/jquery.js"></script>



<script type="text/javascript">

	
	function openLayer(i) {
		document.getElementById(i).style.display = "block";
	}
	
	function closeLayer(i) {
		document.getElementById(i).style.display = "none";
	}

	
	var num = 1;

	function changePic(idx) {
		if (idx) {
			if (num == 3)
				return;
			num++;
		} else {
			if (num == 1)
				return;
			num--;
		}
		var img = document.getElementById("pop-cont-image");
		img.setAttribute("src", "/resources/upload/");
	}
</script>
<%@ include file="../include/header.jsp"%>
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
								class="thumbnail">
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
					<div class="pop-title" id="pop-title"><h3>${pop.webtoon_title}</h3></div>
					<div class="pop-author">${pop.webtoon_writer} /
						${pop.webtoon_tag1} , ${pop.webtoon_tag2} /
						${pop.webtoon_platform}</div>
					<div class="pop-cont">${pop.webtoon_cont}</div>
				</div>

				<div class="pop-img">
				<img id="pop-cont-image" src="/resources/upload/${pop.webtoon_image1}">
					<div class="popup-btn">
						<a id="close-btn"
							onclick="closeLayer(<c:out value="${pop.webtoon_no}"/>)"><button>닫기</button></a>
						<div class="arrow-btn">
						
						
						<button id="next-btn" onclick="changePic(0);">
							<span id="arrow"><i class="fa-solid fa-chevron-left"
								style="font-size: 10px; color: black;"></i></span>
						</button>
						<button id="back-btn" onclick="changePic(1);">
							<span id="arrow"><i class="fa-solid fa-chevron-right"
								style="font-size: 10px; color: black;"></i></span>
						</button>
						
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
								<div id="rating">평점</div>
								<div id="user">작성자</div>
							</div>
							<div id="review-cont">내용!!!!!!!!!!!!!DDDDDDDDDD</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</c:forEach>
