<%@ page contentType="text/html; charset=UTF-8"%>
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
</body>
</html>