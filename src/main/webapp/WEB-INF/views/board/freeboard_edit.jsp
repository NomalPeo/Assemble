<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
<script src="../resources/js/jquery.js"></script><%-- jQuery라이브러리 경로 --%>
<script src="../resources/js/board.js"></script><%-- jQuery&javascript유효성 검증 파일 경로 --%>
</head>
<body>
<form method="post" action="freeboard_edit_ok?board_no=${b.board_no}&page=${page}" onsubmit="return check();">
<%-- 액션 속성값? bno=번호&page=쪽번호 2개의 파라미터 값이 get으로 전달됨. --%>
<%-- action 속성을 지정하지 않으면 이전 매핑주소가 액션 매핑주소가 된다. 같은 매핑주소는 method방식인 get or post로 구분한다. --%>
<table border="1">
	<tr>
		<th colspan="2">자유게시판 수정</th>
	</tr>
	
	<tr>
		<th>글쓴이</th>
		<td><input name="board_writer" id="board_writer" size="14" value="${b.board_writer}"/></td>
		<%--type속성을 생략하면 기본값 text이다. --%>
	</tr>
	
	<tr>
		<th>글제목</th>
		<td><input name="board_title" id="board_title" size="36" value="${b.board_title}"/></td>
	</tr>
	
	<tr>
		<th>글내용</th>
		<td><textarea name="board_cont" id="board_cont" rows="10" cols="38" value="101">${b.board_cont}</textarea></td>
		<%-- 여러줄을 입력하는 textarea에서는  --%>
	</tr>
	
	<tr>
		<th colspan="27">
		<input type="submit" value="글수정"/>
		<input type="reset" value="취소" onclick="$('#board_writer').focus();"/>
		<input type="button" value="목록" onclick="location='freeboard_list?page=${page}';"/>
	</tr>
</table>
</form>
</body>
</html>