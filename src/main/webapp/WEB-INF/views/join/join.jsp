<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="_csrf_header" content="${_csrf.headerName}">
<meta name="_csrf" content="${_csrf.token}">
<link rel="stylesheet" type="text/css"
	href="/resources/css/login&join/join.css">
<script type="text/javascript" src="/resources/js/jquery.js"></script>
<script type="text/javascript" src="/resources/js/member.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<%@include file="../include/thema/header.jsp"%>

<div class="all-page">
	<div class="join-text">
		<img src="../images/index/join_logo.png" width="80" height="45"
			alt="웹툰리뷰">회원가입
	</div>
	<div class="join-container">
		<div class="join-container-content">
			<form name="m" method="post" action="join_ok"
				onsubmit="return join_check();">
				<div class="content-box">
					<div class="title">아이디</div>
					<input type="text" name="user_id" id="user_id" size="30"
						placeholder="아이디를 입력해주세요."> <input type="button"
						value="중복확인" onclick="id_check()">
				</div>
				<span id="idcheck"></span>

				<div class="content-box">
					<div class="title">비밀번호</div>
					<input type="password" name="user_pwd" id="user_pwd" size="30"
						placeholder="비밀번호를 입력해주세요.">
				</div>

				<div class="content-box">
					<div class="title">비밀번호 확인</div>
					<input type="password" name="user_pwd2" id="user_pwd2" size="30"
						placeholder="비밀번호를 확인해주세요.">
				</div>

				<div class="content-box">
					<div class="title">이름</div>
					<input type="text" name="user_name" id="user_name" size="30"
						placeholder="이름을 입력하세요.">
				</div>

				<div class="content-box">
					<div class="title">전화번호</div>
					<select name="user_phone1" id="user_phone1" class="phone1">
						<c:forEach var="p" items="${phone}">
							<option value="${p}">${p}</option>
						</c:forEach>
					</select>
					<div class="sign">-</div>
					<input type="text" name="user_phone2" id="user_phone2" size="5">
					<div class="sign">-</div>
					<input type="text" name="user_phone3" id="user_phone3" size="5">
				</div>

				<div class="content-box">
					<div class="title">성별</div>
					<div class="radio-box">
						<div class="radio1">
							<label><input type="radio" name="user_gender"
								id="user_gender" value="1" checked /><span>남성</span></label>
						</div>
						<div class="radio1">
							<input type="radio" name="user_gender" id="user_gender" value="2"><span>여성</span>
						</div>
					</div>
				</div>

				<div class="content-box">
					<div class="title">생년월일</div>
					<input type="text" size="1" placeholder="년">
					<div class="birthday">년</div>
					<input type="text" size="1" placeholder="월">
					<div class="birthday">월</div>
					<input type="text" size="1" placeholder="일">
					<div class="birthday">일</div>
					<input type="date" name="birthday">
				</div>

				<div class="content-box">
					<div class="title">이메일</div>
					<input type="text" name="email_id" id="email_id" size="10"
						placeholder="이메일">
					<div class="sign">@</div>
					<input type="text" name="email_domain" id="eamil_domain" size="10"
						placeholder="직접입력" readonly> <select name="mail_list"
						onchange="domain_list()">
						<c:forEach var="mail" items="${email}">
							<option value="${mail}">${mail}</option>
						</c:forEach>
					</select>
				</div>

				<div class="content-box">
					<div class="title">닉네임</div>
					<input type="text" name="user_nickname" id="user_nickname"
						size="30" placeholder="닉네임을 입력하세요.">
				</div>

				<div class="joinBtn">
					<input type="submit" value="회원가입"> <input type="reset"
						value="리셋" onclick="${'#user_id'}.focus();">
				</div>
				
			</form>
		</div>
	</div>
</div>

<%@include file="../include/footer.jsp"%>