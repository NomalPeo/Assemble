<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/board/header.jsp"%>
<title>자유게시판</title>
<form method="get" action="/freeboard_list">
<div class="all-freeboard">
	<table class="freeboard-table">
		<div class="board-title-free">
			<h1>자유게시판</h1>
		</div>
		<%-- 총게시물 수 
				<tr>
					<td align="left">게시물 수 : ${totalCount}<strong>개</strong>
				</tr>--%>

		<%-- 게시판 리스트 --%>
		<ul>
			<div class="board-list">
				<a href="./freeboard_list"><li>자유게시판</li></a> <a href="./qna_list"><li>FAQ
						& QnA</li></a> <a href="../recommend/recommend.jsp"><li>추천게시판</li></a> <a
					href="../notice/notice.jsp"><li>공지사항</li></a>
			</div>
		</ul>

		<%-- 자유 게시판 박스 --%>
		<div class="text-box">
			<br> 다양한 궁금사항, 불편내용, 신고, 제안, 건의 등은 <strong>FAQ 페이지</strong>에서 모두
			통합되어 운영됩니다.<br> 답변을 받으시려면 FAQ페이지에 글을 작성해 주세요. <br> <br>
			상업성광고, 저속한표현, 특정인에 대한 비방, 정치적목적이나 성향, 반복적 게시물 등은 관리자에 의해 통보없이 삭제될수
			있습니다. <br> 또한, 홈페이지를 통하여 불법유해 정보를 게시하거나 배포하면 정보통신망 이용촉진 및 정보보호
			등에 관한 법률 제74조에 의거<br> <strong>1년이하의 징역 또는 1천만원 이하의 벌금에
				처해질수 있습니다.</strong>
		</div>
			<%--검색폼 --%>
			<div id="bFind_wrap">
				<select name="find_field">
					<option value="board_title"
						<c:if test="${find_field == 'board_title'}">
   ${'selected'}</c:if>>제목</option>
					<option value="board_writer"
						<c:if test="${find_field == 'board_writer'}">
    ${'selected'}</c:if>>작성자</option>
				</select> <input name="find_name" id="find_name" size="14"
					value="${find_name}" /> <input type="submit" value="검색" />
			</div>
			<%--자유게시판 시작 --%>
		<tr>
			<th class="title-no">NO</th>
			<th class="title-title">제목</th>
			<th class="title-writer">글쓴이</th>
			<th class="title-date">작성시간</th>
			<th class="title-viewcon">조회수</th>
		</tr>

		<c:if test="${!empty list}">
			<c:forEach var="board" items="${list}">
				<tr>
					<td class="cont-num">${board.board_no}</td>
					<td class="cont-cont"><a href="/freeboard_cont?board_no=${board.board_no}&page=${page}">${board.board_title}
					<c:if test="${b.replycnt != 0}">
				    <%--3칸의 빈공백 --%> ${b.replycnt}
				   </c:if></a></td>
				    <td class="cont-writer">${board.board_writer}</td>
					<%--<td class="cont-writer">${board.board_writer}</td> --%>
					<td class="cont-date">${board.board_date}</td>
					<td class="cont-view">${board.board_hit}</td>
				</tr>
			</c:forEach>
		</c:if>

		<c:if test="${empty list}">
			<tr>
				<th colspan="5">등록된 게시물이 없습니다.</th>
			</tr>
		</c:if>
	</table>
	
	<%--페이징--%>
	<div class="paging">
	<%--검색전 페이징--%>
	<c:if test="${(empty find_field)&&(empty find_name)}">
		<c:if test="${page <= 1}">
		<%--◀이전&nbsp; --%>
		</c:if>
		<c:if test="${page > 1}">
		<a href="/freeboard_list?page=${page-1}">◀이전</a>&nbsp;
		</c:if>
		
		<%-- 쪽번호 출력 --%>
		<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
			<c:if test="${a==page}"><${a}></c:if>
			
			<c:if test="${a!=page}">
			<a href="/freeboard_list?page=${a}">${a}</a>&nbsp;&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${page>=maxpage}"><%--[다음] --%></c:if>
		<c:if test="${page<maxpage}">
		<a href="/freeboard_list?page=${page+1}">다음▶</a>
		</c:if>
	</c:if>
	
	<%-- 검색후 페이징 --%>
	<c:if test="${(!empty find_field) || (!empty find_name)}">
		<c:if test="${page <= 1}">
		[이전]&nbsp;
		</c:if>
		<c:if test="${page > 1}">
		<a href="/freeboard_list?page=${page-1}&find_field=${find_field}&find_name=${find_name}">[이전]</a>&nbsp;
		</c:if>
		
		<%-- 쪽번호 출력 --%>
		<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
			<c:if test="${a==page}"><${a}></c:if>
			
			<c:if test="${a!=page}">
				<a href="/freeboard_list?page=${a}&find_field=${find_field}&find_name=${find_name}">[${a}]</a>&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${page>=maxpage}">[다음]</c:if>
		<c:if test="${page<maxpage}">
			<a href="/freeboard_list?page=${page+1}&find_field=${find_field}&find_name=${find_name}">[다음]</a>
		</c:if>
	</c:if>
	
	</div>

<!--  
	<%-- 기존 페이징 --%>
	<div class="paging">
	<tr>
		<th  colspan="6"><c:if test="${page <= 1}">
			<%--[이전] --%>&nbsp;
		</c:if> <c:if test="${page > 1}">
				<a href="/freeboard_list?page=${page-1}">◀이전</a>&nbsp;
		</c:if> <%-- 현재 쪽번호 출력 --%> <c:forEach var="a" begin="${startpage}"
				end="${endpage}" step="1">
				<c:if test="${a == page}">
					<%-- 현재 쪽번호가 선택된 경우 --%>
				${a}&nbsp;&nbsp;
			</c:if>
				<c:if test="${a != page}">
					<%-- 현재 쪽번호가 선택되지 않은 경우 --%>
					<a href="/freeboard_list?page=${a}">${a}</a>&nbsp;&nbsp;
			</c:if>
			</c:forEach> <c:if test="${page >= maxpage}">
			<%--[다음] --%>
		</c:if> <c:if test="${page<maxpage}">
				<a href="/freeboard_list?page=${page+1}">다음▶</a>
			</c:if></th>
	</tr>
	</div>
	-->

		<div class="writebtn">
			<input class="btn" type="button" value="글쓰기"
				onclick="location='/freeboard_write?page=${page}';"/>
		</div>

		<script type="text/javascript">
		var msg = '${msg}'; 
		if (msg == 'SUCCESS') {
			alert('처리가 완료 되었습니다.');
		}
	</script>
	
<!-- -------------------------------------------------------------------------- -->
	
	
</div>

</form>

</body>
</html>
<jsp:include page="../include/footer.jsp" />