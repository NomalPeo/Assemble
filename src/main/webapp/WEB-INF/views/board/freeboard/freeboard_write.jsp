<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 입력</title>
<script src="../resources/js/jquery.js"></script>
<script src="../resources/js/board.js"></script>
</head>
<body>
<form method="post" onsubmit="return check();">
<table border="1">
	<tr>
		<th colspan="2">자유게시판 입력</th>
	</tr>
	
	<tr>
		<th>글쓴이</th>
		<td><input name="board_writer" id="board_writer" size="14"/></td>
	</tr>
	
	<tr>
		<th>글제목</th>
		<td><input name="board_title" id="board_title" size="36"/></td>
	</tr>
	
	<tr>
		<th>글내용</th>
		<td><textarea name="board_cont" id="board_cont" rows="10" cols="38"></textarea>
	</tr>
	
	<tr>
		<th colspan="27">
		<input type="submit" value="글입력"/>
		<input type="reset" value="취소" onclick="$('#board_writer').focus();"/>
		<input type="button" value="목록" onclick="location='freeboard_list?page=${page}';"/>
	</tr>
	
</table>
</form>
</body>
</html>