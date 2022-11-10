<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" type="text/css"
	href="/resources/css/thema/thema-content.css">

<%@include file="../include/header.jsp"%>


<div class=all-page>

	<div class="thema-title">
		<h1>유저들이 찜을 많이 한 웹툰</h1>
		<br />
		<h4>ASSEMBLE유저들이 가장 많이 찜한 웹툰목록입니다.</h4>
	</div>

	<div class="content-page">
		
		<c:if test="${empty conlist2}">

			<span class="wish-msg"><c:out value="${contmsg}" /></span>
		</c:if>

		<c:if test="${!empty conlist2}">
			<c:forEach var="themacon2" items="${conlist2}" varStatus="status">

				<div class="content-box">
					<div class="content-img">
						<a class="content-a"
							href="/content?webtoon_thumbnail=${themacon2.webtoonVo.webtoon_thumbnail}"><img
							class="image"
							src="/resources/upload/${themacon2.webtoonVo.webtoon_thumbnail}"></a>
						<div class="text-hover" id="double-hover">웹툰 맛보기</div>
					</div>
					<div class="content-text">
						<a
							href="/content?webtoon_thumbnail=${themacon2.webtoonVo.webtoon_thumbnail}"><h2>${themacon2.wish_title}</h2></a>
						<br />
						<div class="tag-box">

							<div class="grade">
								평점 1.0 <i class="fa-regular fa-star"></i>
							</div>
						<a href="/tagpage_tag1?webtoon_platform=&webtoon_complete=&webtoon_tag1=${themacon4.webtoonVo.webtoon_tag1}"><button
								class="tag">${themacon4.webtoonVo.webtoon_tag1}</button></a> <a
							href="/tagpage_tag1?webtoon_platform=&webtoon_complete=&webtoon_tag1=${themacon4.webtoonVo.webtoon_tag2}"><button
								class="tag">${themacon4.webtoonVo.webtoon_tag2}</button></a>
						</div>

						<div class="text">
							<p>${themacon2.webtoonVo.webtoon_writer}
								<c:if test="${empty themacon2.webtoonVo.webtoon_tag2}">${themacon2.webtoonVo.webtoon_tag1}</c:if>
								<c:if test="${!empty themacon2.webtoonVo.webtoon_tag2}">${themacon2.webtoonVo.webtoon_tag1} , ${themacon2.webtoonVo.webtoon_tag2}</c:if>
								| ${themacon2.webtoonVo.webtoon_complete}
							</p>
							<br />
							<p>${themacon2.webtoonVo.webtoon_cont}</p>
						</div>
					</div>
				</div>

			</c:forEach>
			</c:if>
	</div>



</div>

</body>
</html>