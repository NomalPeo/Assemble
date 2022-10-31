<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://kit.fontawesome.com/5712e214cc.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="//http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/index/main.css">
<link rel="stylesheet" type="text/css" href="/resources/css/insert/webtooninsert.css">
<script type="text/javascript" src="/resources/js/index/jquery.1.12.4.js"></script>
<script type="text/javascript"
	src="/resources/plugins/bxslider/js/jquery.bxslider.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/plugins/web-fonts-with-css/css/all.css" />
<script type="text/javascript" src="/resources/js/jquery.js"></script>

</head>
<body>
	<div class="wrap">
		<header>
			<div class="header-div">
				<h2>
					<a href="main"><img src="../images/index/logo.png"
						width="150" height="65" alt="웹툰리뷰"></a>
				</h2>
				<div class="selector-menu">
					<a href="tagpage_tag"><i class="fa-solid fa-play"></i><span>태그검색</span></a> 
					<a href="thema/thema.jsp"><i class="fa-solid fa-play"></i><span>테마검색</span></a> 
					<a href="FAQ/FAQ.jsp"><i class="fa-solid fa-play"></i><span>FAQ</span></a> 
					<a href="freeboard_list"><i class="fa-solid fa-play"></i><span>사사게</span></a>
				</div>
				<div class="login-join">
					<a href="../Login/login.jsp" class="login">로그인  </a>  |  <a href="../join/join.jsp" class="join">  회원가입</a>
				</div>
				<div style="clear: both;"></div>
			</div>
		</header>
		<div style="clear: both;"></div>

			<!-- --------------------------------------------------------------------------- -->
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
							<td><select name="webtoon_age">
								<option value="전체이용가">전체 이용가</option>
								<option value="12">12세</option>
								<option value="15">15세</option>
								<option value="18">18세</option>
							</select></td>
						</tr>
						<tr>
							<td>썸네일<input type="file" name="webtoon_thumbnail" /><br>
								메인1<input type="file" name="webtoon_image1"><br>
								메인2<input type="file" name="webtoon_image2"><br>메인3
								<input type="file" name="webtoon_image3"><br>
							</td>
						</tr>
						<tr>
						<td> <input type="submit" value="전송"></td>
						</tr>
					</table>
				</div>
			</form>

		</div>
		<jsp:include page="../include/footer.jsp" />