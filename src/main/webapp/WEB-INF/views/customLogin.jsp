<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
	<h1>Custom Login Page</h1>
	<h2>${error}</h2>
	<h2><c:out value="${logout}"/></h2>
	
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" value="admin"/>
		</div>
		
		<div>
			<input type="password" name="password" value="admin"/>
		</div>
		
		<div>
			<input type="checkbox" name="remember-me"/> Remember Me(자동로그인 기능)
			<%-- 자동 로그인 기능을 구현할 때 스프링 시큐리티에서는 네임파라미터 이름을 remember-me로 한다. --%>
		</div>
		
		<div>
			<input type="submit" value="Login" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<%--
			CSRF(Cross-site request forgery)의 특징)
			1. 스프링 시큐리티에서 post방식을 이용하는 경우 기본적으로 csrf 토큰을 이용한다.
			2. CSRF토큰이 사용되는데 '사이트간 위조방지'를 목적으로 특정한 값의 토큰을 사용하는 방식이다.
			3. CSRF토큰은 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식이다.
			4. 서버에서는 브라우저에서 데이터를 전송할 때 csrf토큰을 함께 전송한다. 
			      사용자가 post방식으로 특정한 작업을 할 때는 브라우저에서 전송한 CSRF토큰값과 서버가 보관하고 있는 토큰값을 비교한다.
			      만일 토큰값이 다르다면 로그인 작업을 처리하지 않는 방식이다.
			5. 서버에서 생성하는 토큰은 일반적으로 난수를 생성해서 해커가 난수를 찾을 수 없도록 한다.
			      사용자가 '/customLogin'을 처음 호출했을 때와 강제로 F12개발툴 세션쿠키에서  삭제시킨 세션쿠키를 삭제한 후에 다시 호출했을 때
			   CSRF 토큰값이 변경되는 것을 확인 할 수 있다. 
		 --%>
		 
	</form>
</body>
</html>