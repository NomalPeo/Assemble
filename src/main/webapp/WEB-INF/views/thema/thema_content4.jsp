<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css" href="../css/thema/thema-content.css">



<!--  <script type="text/javascript">
	function openLayer(){
		document.getElementById("popup-layer").style.display = "block";
	}
	
	function closeLayer() {
	    document.getElementById("popup-layer").style.display = "none";
	}
	
	
	
var num=1;
	
	function changePic(idx){
		if(idx){
			if(num == 3) return;
			num++;
		}else{
			if(num == 1) return;
			num--;
		}
		var img = document.getElementById("manhwa");
		img.setAttribute("src", "../images/themaImages/" + num + ".jpg");
	}
</script>-->
<%@include file="../include/header.jsp"%>


<div class=all-page>

	<div class="thema-title">
		<h1>여성유저들이 찜을 많이 한 웹툰</h1>
		<h3>내용</h3>
	</div>

	<div class="content-page">
	

<c:forEach var="themacon4" items="${conlist4}" varStatus="status">

		<div class="content-box">
			<div class="content-img">
				<a class="content-a" href="/content?webtoon_thumbnail=${themacon4.webtoonVo.webtoon_thumbnail}"><img
					class="image" src="/resources/upload/${themacon4.webtoonVo.webtoon_thumbnail}"></a>
				<div class="text-hover" id="double-hover">웹툰 맛보기</div>
			</div>
			<div class="content-text">
				<a href="/content?webtoon_thumbnail=${themacon4.webtoonVo.webtoon_thumbnail}"><h2>${themacon4.wish_title}</h2></a>
				<br />
				<div class="tag-box">

					<div class="grade">평점 1.0 <i class="fa-regular fa-star"></i></div>
					<button class="tag">${themacon4.webtoonVo.webtoon_tag1}</button>
					<button class="tag">${themacon4.webtoonVo.webtoon_tag2}</button>

				</div>

				<div class="text">
					<p>${themacon4.webtoonVo.webtoon_writer} 
					<c:if test="${empty themacon4.webtoonVo.webtoon_tag2}">${themacon4.webtoonVo.webtoon_tag1}</c:if> 
                    <c:if test="${!empty themacon4.webtoonVo.webtoon_tag2}">${themacon4.webtoonVo.webtoon_tag1} , ${themacon4.webtoonVo.webtoon_tag2}</c:if> | ${themacon4.webtoonVo.webtoon_complete}</p>
					<br />
					<p>
						${themacon4.webtoonVo.webtoon_cont}
					</p>
				</div>
			</div>
		</div>

</c:forEach>

	</div>


	
</div>

<!--  <div id="popup-layer">
	<div class="popup-box">
		<img id="manhwa" src="../images/themaImages/1.jpg">
		<a id="close-btn" href="javascript:closeLayer();">
		<span id="exit"><i class="fa-solid fa-circle-xmark" style="font-size:40px; color:black;"></i></span>
		</a>
		<button id="next-btn" onclick="changePic(0);">
		<span id="arrow"><i class="fa-solid fa-chevron-left" style="font-size:80px; color:white;"></i></span>
		</button>
		<button id="back-btn" onclick="changePic(1);">
		<span id="arrow"><i class="fa-solid fa-chevron-right" style="font-size:80px; color:white;"></i></span>
		</button>
	</div>
</div>-->
<%@include file="../include/footer.jsp"%>