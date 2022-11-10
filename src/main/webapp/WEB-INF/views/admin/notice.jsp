<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/admin/notice.css">
</head>
<body>
	<div class="topchoice">
		<a href="/admin/adminPage">관리자페이지</a> <a href="/admin/webtooninsert">웹툰
			등록</a> <a href="/admin/boardmanager">게시물 관리</a>
	</div>
	<div class="whale">
		<form class="total-form" action="/admin/noticeWrite">
			<table class="total" >
				<tr>
					<th>제목</th>
					<td><input name="board_title" id="input" type="text" size="80" placeholder="제목을 입력해주세요."></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="board_cont" id="text" rows="40" cols="80" placeholder="내용을 입력해주세요."></textarea></td>
				</tr>
				<tr style="border:none;">
					<td id="submit" colspan="2" style="border:none;">
					<input type="submit" value="저장">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>