<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:include page="../include/header.jsp" />


<div class="whale">
	<div class="webtitle">
		<span>웹툰 저장</span>
	</div>
	<div class="webinsert">
		<form method="post" action="webinsert3" enctype="multipart/form-data">
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
							<option value="1">연재중</option>
							<option value="2">완결</option>
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
					<td>썸네일<input type="file" name="webtoon_thumbnail" /><br>
						메인1<input type="file" name="webtoon_image1"><br> 메인2<input
						type="file" name="webtoon_image2"><br>메인3 <input
						type="file" name="webtoon_image3"><br>
					</td>
				</tr>
			</table>
			<input type="submit" value="전송">
		</form>
	</div>





</div>













<jsp:include page="../include/footer.jsp" />