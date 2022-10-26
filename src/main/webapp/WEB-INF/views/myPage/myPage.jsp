<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<!-- 상단영역 공유 -->

<div class="all-myPage">
	<div class="choice-page">
		<div class="choice-title">계정 관리</div>
		<ul>
			<li><button class="Security" type="button" id="box1">개인정보</button></li>
			<li><button class="Change-Password" type="button" id="box2">비밀번호 변경</button></li>
			<li><button class="wishlist" type="button" onclick="location='#';">찜 목록</button></li>
			<li><button class="View-post" type="button" onclick="location='#';">작성글 관리</button></li>
			<li><button class="login-history" type="button" id="box3">로그인 이력</button></li>
			<li><button class="Withdrawal" type="button" id="box4">회원 탈퇴</button></li>
		</ul>
	</div>
	<!-- ------------------------------------------------- -->
	<div class="look-page">
		<form>
			<div class="look-page-title Security-title">
				<div class="look-page-first">
					<div class="look-page-common">개인정보</div>
					<div>본 항목은 개인정보로서 다른 플레이어에게 공유되지 않습니다. 자세한 내용은 개인정보 처리방침 에서 확인해 주세요!</div>
				</div>
				<div class="look-page-second Security-content">
					<div class="Security-Information">닉네임</div>
						<input type="text"name="nickname" id="nickname" size="50" placeholder="닉네임"><br><br>
					<div class="Security-Information">아이디</div>
						<input type="text"name="ID" id="ID" size="50" placeholder="ID"><br><br>
					<div class="Security-Information">이메일</div>
						<input type="text" name="email" id="email" size="50" placeholder="Email"><br><br>
					<div class="Security-change">
						<input type="submit" value="변경사항 저장">
						<input type="reset" value="취소">
					</div>
				</div>
			</div>
		</form>
		<!--  -->
		<form>
			<div class="look-page-title Change-Password-title">
				<div class="look-page-first">
					<div class="look-page-common">비밀번호 변경</div>
					<div>주기적으로 비밀번호를 변경하면 계정 무단 로그인을 방지할 수 있습니다.</div>
				</div>
				<div class="look-page-second Change-Password-content">
					<div class="Password-Information">기존 비밀번호 </div>
						<input type="password" size="50" class="password" id="password" name="password" placeholder="기존 비밀번호" >
					<br>
					<div class="Password-Information">새 비밀번호 </div>
						<input type="password" size="50" class="password" id="password" name="password" placeholder="새 비밀번호" >
					<br>
					<div class="Password-Information">새 비밀번호 확인</div>
						<input type="password" size="50" class="password" id="password" name="password" placeholder="새 비밀번호 확인" >
						<br><br>
					<div class="password-change">
						<input type="submit" value="변경사항 저장">
						<input type="reset" value="취소">
					</div>
				</div>
			</div>
		</form>
				<!--  -->
		<div class="look-page-title login-history-title">
			<div class="look-page-first">
				<div class="look-page-common">
					최근 로그인 이력
				</div>
				<div>
					가장 최근에 로그인한 기록을 표시합니다.
				</div>
			</div>
			<div class="look-page-second login-history-content">
			
			</div>
		</div>
				<!--  -->
		<div class="look-page-title Withdrawal-title">
			<div class="look-page-first look-page-common">
				회원 탈퇴
			</div>
			<div class="look-page-second Withdrawal-content">
				<a href="users_del">
					<button name="Withdrawal" id="Withdrawal">회원 탈퇴</button>
				</a>
			</div>
		</div>
		<!-- ----------------------------------------- -->
		<footer>
		
		</footer>
	</div>
</div>
<jsp:include page="../include/footer.jsp"/>