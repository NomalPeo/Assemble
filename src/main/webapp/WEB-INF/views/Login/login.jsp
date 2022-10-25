<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" content="${_csrf.token}">
<title></title>
<link rel="stylesheet" type="text/css"
	href="../../resources/css/login&join/login.css" />
<link rel="stylesheet" type="text/css"
	href="../../resources/css/reset.css" />
<link rel="stylesheet" type="text/css"
	href="../../resources/css/index/index.css" />
<script type="text/javascript"
	src="../../resources/js/index/jquery.1.12.4.js"></script>
<script type="text/javascript"
	src="../../resources/plugins/bxslider/js/jquery.bxslider.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../resources/plugins/web-fonts-with-css/css/all.css" />
<script>
	$(document).ready(function() {
		$('.slider').bxSlider({
			controls : false,
			pager : false,
			auto : true
		});
	});

	function login_check() {
		if ($.trim($("#id").val()) == "") {
			alert("아이디를 입력하세요!");
			$("#id").val("").focus();
			return false;
		}
		if ($.trim($("#pw").val()) == "") {
			alert("비밀번호를 입력하세요!");
			$("#pw").val("").focus();
			return false;
		}
	}//로그인 인증 유효성 검증

	//비번찾기
	function pwd_find() {
		$url = "pwd_find";//매핑주소
		window.open($url, "비번검색", "width=400px,height=300px"
				+ ",scrollbars=yes");
		//open(공지창경로,공지창이름,속성) 메서드로 폭이 300픽셀,
		//높이가 300픽셀,스크롤바가 생성되는 새로운 공지창을 만든다.
	}
</script>

</head>
<body>
	<div class="overlay"></div>
	<div class="slider">
		<div class="main_img_01"></div>
		<div class="main_img_02"></div>
		<div class="main_img_03"></div>
	</div>
	<form action="/login" method="post"
		onsubmit="return login_check();">
		<div class="login-container">
			<div class="login-text">
				<a href="../main"><img
					src="../../resources/images/index/logo.png" width="80" height="45"
					alt="웹툰리뷰"></a>로그인
			</div>
			<div class="id-class">
				<input type="text" name="login_id" id="id" tabindex="1"
					placeholder="이메일 주소 또는 계정을 입력하세요.">
			</div>

			<div class="password">
				<input type="password" name="login_pwd" id="pw" tabindex="2"
					placeholder="비밀번호를 입력하세요.">
			</div>

			<div class="save-id">
				<label><input type="checkbox" id="id-checkbox">아이디
					저장하기</label>
			</div>

			<div class="find-pw">
				<a type="password" id="login_pwd" onclick="pwd_find();"> <i
					class="fas fa-search"></i>&nbsp;비밀번호 찾기
				</a>
			</div>

			<div class="login">
				<input type="submit" value="로그인" />
			</div>

			<div>
				<div class="join">
					<a href="join"><input type="button" value="회원가입" /></a>
				</div>
			</div>
				<div>
			<input type="checkbox" name="remember-me"/> Remember Me(자동로그인 기능)
			<%-- 자동 로그인 기능을 구현할 때 스프링 시큐리티에서는 네임파라미터 이름을 remember-me로 한다. --%>
		</div>
		
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</div>
	</form>

</body>
</html>