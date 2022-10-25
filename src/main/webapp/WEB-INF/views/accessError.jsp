<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta id="_csrf_header" name="_csrf_header"
	content="${_csrf.headerName}">
<meta id="_csrf" name="_csrf" content="${_csrf.token}">
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Access Denied Page</h1>

	<h2>
		<c:out value="${msg}" />
	</h2>

</body>
</html>