<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include/board/header.jsp"%>
<title>공지사항</title>
</head>
<body>
		<div class="all-freeboard">
			<table class="freeboard-table">
				<div class="board-title-free">
					<h1>공지사항</h1>
				</div>
		
		<%-- 게시판 리스트 --%>
			<ul>
				<div class="board-list">
					<a href="../board/freeboard.jsp"><li>자유게시판</li></a>
					<a href="../FAQ/FAQ.jsp"><li>FAQ & QnA</li></a>
					<a href="../recommend/recommend.jsp"><li>추천게시판</li></a>
					<a href="#"><li>공지사항</li></a>
				</div>
			</ul>
			
		<%-- 자유 게시판 박스 --%>
			<div class="text-box">
					<br> 다양한 궁금사항, 불편내용, 신고, 제안, 건의 등은 <strong>FAQ 페이지</strong>에서
					모두 통합되어 운영됩니다.<br> 답변을 받으시려면 FAQ페이지에 글을 작성해 주세요. <br> <br>
					상업성광고, 저속한표현, 특정인에 대한 비방, 정치적목적이나 성향, 반복적 게시물 등은 관리자에 의해 통보없이 삭제될수
					있습니다. <br> 또한, 홈페이지를 통하여 불법유해 정보를 게시하거나 배포하면 정보통신망 이용촉진 및 정보보호
					등에 관한 법률 제74조에 의거<br> <strong>1년이하의 징역 또는 1천만원 이하의 벌금에 처해질수 있습니다.</strong>
				</div>
				
				<%--자유게시판 시작 --%>
				<tr>
					<th class="title-no">NO</th>
					<th class="title-title">제목</th>
					<th class="title-writer">글쓴이</th>
					<th class="title-date">작성시간</th>
					<th class="title-viewcon">조회수</th>
				</tr>

				<tr>
					<td class="cont-num">1</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">2</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">3</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">4</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">5</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">6</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">7</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">8</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">9</td>
					<td class="cont-cont"><a href="/"> 공지사항</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">10</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">11</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				<tr>
					<td class="cont-num">12</td>
					<td class="cont-cont"><a href="/"> 공지사항.</a></td>
					<td class="cont-writer">운영자</td>
					<td class="cont-date">2022-09-23</td>
					<td class="cont-view">100</td>
				</tr>

				
				

			</table>

			<div class="writebtn">
				<button class="btn" value="글쓰기" onclick="/">글쓰기</button>
			</div>

		

	</div>
</body>
</html>
<jsp:include page="../../include/footer.jsp" />