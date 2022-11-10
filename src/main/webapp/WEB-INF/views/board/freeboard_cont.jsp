<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용보기 </title>
</head>
<body>
<table border="1">
	<tr>
		<th colspan="2">게시물 내용</th>
	</tr>
	
	<tr>
		<th>제목</th> <td>${b.board_title}</td>
	</tr>
	
	<tr>
		<th>글쓴이</th> <td>${b.board_writer}</td>
	</tr>
	
	<tr>
		<th>내용</th> <td>${b.board_cont}</td>
	</tr>
	
	<tr>
		<th>조회수</th> <td>${b.board_hit}</td>
	</tr>
	
	<tr>
		<th colspan="2">
			<input type="button" value="수정" onclick="location='freeboard_edit?board_no=${b.board_no}&page=${page}';"/>
			<input type="button" value="삭제" onclick="location='freeboard_del?board_no=${b.board_no}&page=${page}';"/>
			<input type="button" value="목록" onclick="location='freeboard_list?page=${page}';"/>
		</th> 
	</tr>
	</table>
	<hr>
	
		<!-- 댓글 목록 -->
		
		댓글출력1
		<hr>
		댓글출력2
		<hr>
		댓글출력3
		<hr>
<c:if test="${!empty list}">
			<c:forEach var="board" items="${list}">
				<tr>
					<td class="cont-num">${reply.board_reply_bno}</td>
					<td class="cont-writer">${reply.board_reply_writer}</td>
					<td class="cont-cont">${reply.board_reply_cont}</td>
					<td class="cont-date">${reply.board_regdate}</td>
				</tr>
			</c:forEach>
		</c:if>

		<c:if test="${empty list}">
			<tr>
				<th colspan="5">등록된 댓글이 없습니다.</th>
			</tr>
		</c:if>

	<!-- 댓글 입력창 -->
	<div class="freeboard_reply">
		<form method="post" action="/reply/write">
			<p>
				<label>작성자</label> <input type="text" name="board_reply_writer" />
			</p>

			<textarea name="board_reply_cont" rows="5" cols="80"
				id="board_reply_cont" placeholder="댓글을 작성해주세요."></textarea>
			<br>
			<button type="submit" id="btnReply">댓글 작성</button>
		</form>
	</div>

</body>
</html>