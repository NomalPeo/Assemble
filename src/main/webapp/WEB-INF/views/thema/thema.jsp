<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/thema/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/thema/thema.css">

<!-- 테마 추천 -->
<div class="all-thema-wrap">
	<div class="thema-wrap">

		<div class="thema-text">
			<h1>테마목록</h1>
			<h3>당신이 원하는 웹툰을 추천해 드립니다.</h3>
		</div>

		<a id="themabox-btn" href="/thema_content">
			<div class="thema-index">
				<div class="thema-items1">
					<div class="item">
						<img class="img-class" src="../images/Thumbnail/테마_테스트1.jpg">
					</div>
				</div>
				<div class="item-text">ASSEMBLE이 추천하는 웹툰!</div>
			</div>
		</a>

		<a id="themabox-btn" href="/thema_content2">
			<div class="thema-index">
				<div class="thema-items1">
					<div class="item">
						<img class="img-class" src="../images/Thumbnail/테마_테스트2.jpg">
					</div>
				</div>
				<div class="item-text">유저들이 많이 찜한 웹툰!</div>
			</div>
		</a>

		<a id="themabox-btn" href="/thema_content3">
			<div class="thema-index">
				<div class="thema-items1">
					<div class="item">
						<img class="img-class" src="../images/Thumbnail/테마_테스트3.jpg">
					</div>
				</div>
				<div class="item-text">남성 유저들이 많이 찜한 웹툰</div>
			</div>
		</a>

		<a id="themabox-btn" href="/thema_content4">
			<div class="thema-index">
				<div class="thema-items1">
					<div class="item">
						<img class="img-class" src="../images/Thumbnail/테마_테스트4.jpg">
					</div>
				</div>
				<div class="item-text">여성 유저들이 많이 찜한 웹툰</div>
			</div>
		</a>

	</div>
</div>
<%@include file="../include/footer.jsp"%>
