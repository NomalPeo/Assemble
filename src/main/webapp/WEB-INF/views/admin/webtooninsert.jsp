<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" type="text/css"
	href="/resources/css/admin/webtooninsert.css">

<script type="text/javascript" src="/resources/js/jquery.js"></script>

</head>
<body>
	<div class="topchoice">
		<a href="/admin/adminPage">관리자페이지</a> <a href="/admin/webtooninsert">웹툰
			등록</a> <a href="/admin/boardmanager">게시물 관리</a>
	</div>

	<form method="post" action="/admin/webtooninsert1"
		enctype="multipart/form-data">

		<div class="webinsert">
			<table class="webtable">
				<tr>
					<td>제목</td>
				</tr>
				<tr>
					<td><input type="text" name="webtoon_title" id="title"
						size="40px;"></td>
				</tr>
				<tr>
					<td id="">작가</td>
				<tr>
					<td><input type="text" name="webtoon_writer" id="writer"
						size="40px;"></td>
				</tr>
				<tr>
					<td>내용</td>
				</tr>
				<tr>
					<td><textarea name="webtoon_cont" rows="20" cols="40"></textarea>
					</td>
				</tr>
				<tr>
					<td><select name="webtoon_tag1">
							<option value="전체">전체</option>
							<option value="액션">액션</option>
							<option value="코미디">코미디</option>
							<option value="로맨스">로맨스</option>
							<option value="판타지">판타지</option>
							<option value="일상">일상</option>
							<option value="SF">SF</option>
							<option value="스릴러">스릴러</option>
							<option value="공포">공포</option>
							<option value="드라마">드라마</option>
							<option value="스포츠">스포츠</option>
							<option value="무협">무협</option>
					</select> <select name="webtoon_tag2">
							<option value="전체">전체</option>
							<option value="액션">액션</option>
							<option value="코미디">코미디</option>
							<option value="로맨스">로맨스</option>
							<option value="판타지">판타지</option>
							<option value="일상">일상</option>
							<option value="SF">SF</option>
							<option value="스릴러">스릴러</option>
							<option value="공포">공포</option>
							<option value="드라마">드라마</option>
							<option value="스포츠">스포츠</option>
							<option value="무협">무협</option>
					</select></td>
				</tr>
				<tr>
					<td><select name="webtoon_complete">
							<option value="미완결">연재중</option>
							<option value="완결">완결</option>
					</select></td>
				</tr>
				<tr>
					<td><select name="webtoon_platform">
							<option value="전체">전체</option>
							<option value="네이버">네이버</option>
							<option value="카카오">카카오</option>
					</select></td>
				</tr>
				<tr>
					<td><select name="webtoon_age">
							<option value="전체이용가">전체 이용가</option>
							<option value="12">12세</option>
							<option value="15">15세</option>
							<option value="18">18세</option>
					</select></td>
				</tr>
				<tr>
					<td>썸네일<input type="file" name="webtoon_thumbnail" /><br>
						메인1<input type="file" name="webtoon_image1"><br> 메인2<input
						type="file" name="webtoon_image2"><br>메인3 <input
						type="file" name="webtoon_image3"><br>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="전송"></td>
				</tr>
			</table>
		</div>
	</form>

	</div>

</body>
</html>