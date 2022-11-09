<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/admin/usermanager.css">
<script src="/resources/js/jquery.js"></script>
<script type="text/javascript">
	function delBtn(user_id) {
		
		$.ajax({
			type : 'delete', //ReplyController.java에서 지정한 삭제 메서드 방식
			url : '/admin/userDel/'+ user_id, //삭제 URL 매핑주소
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text', 
			success : function(data) {
				if (data == 'SUCCESS') {
					alert('유저 삭제 완료');
					location.reload();
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="topchoice">
		<a href="/admin/adminPage">관리자페이지</a> <a href="/admin/webtooninsert">웹툰
			등록</a> <a href="/admin/boardmanager">게시물 관리</a>
	</div>
	<div style="margin: auto; text-align: center;">
		<form action="/admin/user_manager" method="get">
			<input type="hidden" name="find_field" value="user_id"> <input
				type="text" name="find_name" size="14"> <input type="submit"
				value="검색" />
		</form>
	</div>
	<table class="user_table" border="1">
		<tr>
			<th>N</th>
			<th>ID</th>
			<th>PASSWORD</th>
			<th>GENDER</th>
			<th>NICKNAME</th>
			<th>REGDATE</th>
			<th>AUTH</th>
			<th>DEL</th>
		</tr>
		<c:forEach var="users" items="${uList }">
			<tr>
				<td>${users.user_no }</td>
				<td>${users.user_id }</td>	
				<td>${users.user_pwd }</td>
				<td>${users.user_gender }</td>
				<td>${users.user_nickname }</td>
				<td>${fn:substring(users.user_date,0,10) }</td>
				<td>${users.authList }</td>
				<td><button type="button" onclick="delBtn('${users.user_id}');">삭제</button></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8"><c:if test="${page <= 1}">
   	이전&nbsp;
  </c:if> <c:if test="${page > 1}">
					<a href="/user_manager?page=${page-1}">[이전]</a>&nbsp;
  </c:if> <%--현재 쪽번호 출력 --%> <c:forEach var="a" begin="${startpage}"
					end="${endpage}" step="1">
					<c:if test="${a == page}">
    ${a}
   </c:if>
					<c:if test="${a != page}">
						<a href="/admin/user_manager?page=${a}">${a}</a>&nbsp;
   </c:if>
				</c:forEach> <c:if test="${page >= maxpage}">
   다음
  </c:if> <c:if test="${page<maxpage}">
					<a href="/board/board_list?page=${page+1}">[다음]</a>
				</c:if></td>
		</tr>
	</table>
</body>
</html>