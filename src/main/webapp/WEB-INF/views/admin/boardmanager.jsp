<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/admin/boardmanager.css">
<script src="/resources/js/jquery.js"></script>
<script type="text/javascript">
	typeChange5();
	function typeChange5() {
		$.getJSON(
						"/admin/boardmanager5",
						function(data) {
							$str = "";
							$str += "<tr class='headers'>" + "<th>글번호</th>"
									+ "<th>제목</th>" + "<th>조회수</th>" + "</tr>";
							$(data)
									.each(
											function() {
												$str += "<tr>"
														+ "<td>"
														+ this.board_no
														+ "</td>"
														+ "<td class='board_title'><a href='boardCorriger/"+this.board_no+"'>"
														+ this.board_title
														+ "</a></td>" + "<td>"
														+ this.board_hit
														+ "</td>" + "</tr>";
											});
							$('#board').html($str);
						});
	}

	function typeChange1() {
		$.getJSON(
						"/admin/boardmanager1",
						function(data) {
							$str = "";
							$str += "<tr class='headers'>" + "<th>글번호</th>"
									+ "<th>제목</th>" + "<th>조회수</tdh>" + "</tr>";
							$(data)
									.each(
											function() {
												$str += "<tr>"
														+ "<td>"
														+ this.board_no
														+ "</td>"
														+ "<td class='board_title'><a href='boardCorriger/"+this.board_no+"'>"
														+ this.board_title
														+ "</a></td>" + "<td>"
														+ this.board_hit
														+ "</td>" + "</tr>";
											});
							$('#board').html($str);
						});
	}

	function typeChange2() {
		$.getJSON(
						"/admin/boardmanager2",
						function(data) {
							$str = "";
							$str += "<tr class='headers'>" + "<th>글번호</th>"
									+ "<th>제목</th>" + "<th>조회수</tdh>" + "</tr>";
							$(data)
									.each(
											function() {
												$str += "<tr>"
														+ "<td>"
														+ this.board_no
														+ "</td>"
														+ "<td class='board_title'><a href='boardCorriger/"+this.board_no+"'>"
														+ this.board_title
														+ "</a></td>" + "<td>"
														+ this.board_hit
														+ "</td>" + "</tr>";
											});
							$('#board').html($str);
						});
	}
	function typeChange3() {
		$.getJSON(
						"/admin/boardmanager3",
						function(data) {
							$str = "";
							$str += "<tr class='headers'>" + "<th>글번호</th>"
									+ "<th>제목</th>" + "<th>조회수</tdh>" + "</tr>";
							$(data)
									.each(
											function() {
												$str += "<tr>"
														+ "<td>"
														+ this.board_no
														+ "</td>"
														+ "<td class='board_title'><a href='boardCorriger/"+this.board_no+"'>"
														+ this.board_title
														+ "</a></td>" + "<td>"
														+ this.board_hit
														+ "</td>" + "</tr>";
											});
							$('#board').html($str);
						});
	}
	function typeChange4() {
		$.getJSON(
						"/admin/boardmanager4",
						function(data) {
							$str = "";
							$str += "<tr class='headers'>" + "<th>글번호</th>"
									+ "<th>제목</th>" + "<th>조회수</tdh>" + "</tr>";
							$(data)
									.each(
											function() {
												$str += "<tr>"
														+ "<td>"
														+ this.board_no
														+ "</td>"
														+ "<td class='board_title'><a href='boardCorriger/"+this.board_no+"'>"
														+ this.board_title
														+ "</a></td>" + "<td>"
														+ this.board_hit
														+ "</td>" + "</tr>";
											});
							$('#board').html($str);
						});
	}
</script>
</head>
<body>
	<div class="topchoice">
		<a href="/admin/adminPage">관리자페이지</a> <a href="/admin/webtooninsert">웹툰
			등록</a> <a href="/admin/boardmanager">게시물 관리</a>
	</div>
	<div class="all">
		<div class="typeButton">
			<button name="type" id="5" value="5" onclick="typeChange5();">전체</button>
			<button name="type" id="1" value="1" onclick="typeChange1();">자유게시판</button>
			<button name="type" id="2" value="2" onclick="typeChange2();">FAQ/QNA</button>
			<button name="type" id="3" value="3" onclick="typeChange3();">추천게시판</button>
			<button name="type" id="4" value="4" onclick="typeChange4();">공지사항</button>
		</div>
		<div class="boardMain">
			<table id="board"></table>
		</div>
	</div>
</body>
</html>