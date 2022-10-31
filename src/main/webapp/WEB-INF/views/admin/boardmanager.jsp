<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/resources/js/jquery.js"></script>
<script type="text/javascript">
	function typeChange(){
		$type=$('#choose').val();
		
	}
</script>
</head>
<body>
<div>
	<button name="type" id="choose" value="1" onclick="typeChange();">
</div>
	<div>
	<c:if test="${empty bList }">
		<c:out value="게시글이 없습니다."></c:out>
	</c:if>
	<c:if test="${!empty bList }">
		<table>
			<c:forEach var="bList" items="${bList}">
				<tr>
				<td>${bList.board_no }</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	
	</div>
	
</body>
</html>