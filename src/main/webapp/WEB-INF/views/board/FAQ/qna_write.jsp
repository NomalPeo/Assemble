<%@ include file="../../include/board/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 입력</title>
<script src="../resources/js/jquery.js"></script>
<script src="../resources/js/board.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/freeboard/freeboardWrite.css">
</head>
<body>
<form method="post" onsubmit="return check();" >
<div class="all-freeboard">

				<h2>질문하기</h2>
				<br><hr>
			<table class="freeboardWrite-table" border="1">

				<!-- <tr>
		<th>글쓴이</th>
		<td><input name="board_writer" id="board_writer" size="14"/></td>
	</tr> -->
				<!-- <tr>
		<th>글쓴이</th>
		<td><input name="board_writer" value="${users.user_id}" size="14"/></td>
	</tr> -->

				<tr class="board-title-tr">
					<th class="board-title">제목</th>
					<td class="board-title-td"><input name="board_title" id="board_title" size="36"
						placeholder="제목을 입력해주세요." /></td>
				</tr>

				<tr>
					<th class="board-cont">내용</th>
					<td class="board-cont-td"><textarea name="board_cont" id="board_cont" rows="10"
							cols="38" placeholder="내용을 입력해주세요."></textarea></td>
				</tr>



				
			</table>
			<div class="write-btn">
				<tr class="btn">
					<th colspan="27"><input type="submit" value="등록" /> <input
						type="reset" value="취소" onclick="$('#board_title').focus();" /> <input
						type="button" value="목록"
						onclick="location='qna_list?page=${page}';" />
				</tr>
			</div>

		</div>

</form>
</body>
</html>
<jsp:include page="../../include/footer.jsp" />