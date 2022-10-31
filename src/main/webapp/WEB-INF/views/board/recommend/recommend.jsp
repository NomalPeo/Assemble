<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/board/header.jsp"%>
<head>
<title>FAQ & QnA</title>
</head>
<div class="all-freeboard">
<table class="freeboard-table">
				<div class="board-title-free">
					<h1>추천게시판</h1>
				</div>
							<ul>
				<div class="board-list">
					<a href="../board/freeboard.jsp"><li>자유게시판</li></a>
					<a href="../FAQ/FAQ.jsp"><li>FAQ & QnA</li></a>
					<a href="#"><li>추천게시판</li></a>
					<a href="../notice/notice.jsp"><li>공지사항</li></a>
				</div>
			</ul>
			<div class="text-box">
					<br> 다양한 궁금사항, 불편내용, 신고, 제안, 건의 등은 <strong>FAQ 페이지</strong>에서
					모두 통합되어 운영됩니다.<br> 답변을 받으시려면 FAQ페이지에 글을 작성해 주세요. <br> <br>
					상업성광고, 저속한표현, 특정인에 대한 비방, 정치적목적이나 성향, 반복적 게시물 등은 관리자에 의해 통보없이 삭제될수
					있습니다. <br> 또한, 홈페이지를 통하여 불법유해 정보를 게시하거나 배포하면 정보통신망 이용촉진 및 정보보호
					등에 관한 법률 제74조에 의거<br> <strong>1년이하의 징역 또는 1천만원 이하의 벌금에 처해질수 있습니다.</strong>
				</div>
				
				<tr>
				<th class="title-no">NO</th>
				<th class="title-category"><select name="select" id = "select">
						<option value="">카테고리</option>
						<option value="How-to-use">추천해주세요</option>
						<option value="How-to-join">추천해드려요</option>
						<option value="Another">기타</option>
				</select></th>
				<th class="title-title">제목</th>
					<th class="title-date">작성시간</th>
				</tr>
				
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">추천해드려요</td>
					<td class="cont-title"><a href="/"> 추천해드려요.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">기타</td>
					<td class="cont-title"><a href="/">기타.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">추천해드려요</td>
					<td class="cont-title"><a href="/"> 추천해드려요.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">추천해주세요</td>
					<td class="cont-title"><a href="/"> 추천해주세요.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">기타</td>
					<td class="cont-title"><a href="/"> 기타.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">추천해주세요</td>
					<td class="cont-title"><a href="/"> 추천해주세요.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">기타</td>
					<td class="cont-title"><a href="/"> 기타.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">추천해드려요</td>
					<td class="cont-title"><a href="/"> 추천해드려요.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">기타</td>
					<td class="cont-title"><a href="/"> 기타.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">기타</td>
					<td class="cont-title"><a href="/"> 기타.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				<tr>
					<td class="cont-num">1</td>
					<td class="cont-category">추천해드려요</td>
					<td class="cont-title"><a href="/"> 추천해드려요.</a></td>
					<td class="cont-date">2022-09-23</td>
				</tr>
				
			</table>
			
			<div class="writebtn">
				<button class="btn" value="글쓰기" onclick="/">글쓰기</button>
			</div>
			

		<%-- 사이드 메뉴 --%>
		<%-- <div class="side-menu-table">
			<h3>게시판 목록</h3>
		</div>--%>

	</div>

</body>
</html>
<jsp:include page="../../include/footer.jsp" />