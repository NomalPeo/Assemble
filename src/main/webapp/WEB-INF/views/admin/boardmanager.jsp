<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery.js"></script> 
<script type="text/javascript">
	typeChange1();
	
	function typeChange1(){
		$.getJSON("/admin/boardmanager1",function(data){
			$str="";
			$str+="<tr>"
				+"<td>글번호</td>"
				+"<td>제목</td>"
				+"<td>조회수</td>"
				+"</tr>"
				+"<tr>";
			$(data).each(function(){
				$str+=
					"<tr>"
					+"<td>"+this.board_no+"</td>"
					+"<td>"+this.board_title+"</td>"
					+"<td>"+this.board_hit+"</td>"
					+"</tr>";
		});
			$('#board').html($str);
		});
	}
	
	function typeChange2(){
		$.getJSON("/admin/boardmanager2",function(data){
				$str="";
				$str+="<tr>"
					+"<td>글번호</td>"
					+"<td>제목</td>"
					+"<td>조회수</td>"
					+"</tr>"
					+"<tr>";
				$(data).each(function(){
					$str+=
						"<tr>"
						+"<td>"+this.board_no+"</td>"
						+"<td>"+this.board_title+"</td>"
						+"<td>"+this.board_hit+"</td>"
						+"</tr>";
			});
				$('#board').html($str);
		});
	}
	function typeChange3(){
		$.getJSON("/admin/boardmanager3",function(data){
				$str="";
				$str+="<tr>"
					+"<td>글번호</td>"
					+"<td>제목</td>"
					+"<td>조회수</td>"
					+"</tr>"
					+"<tr>";
				$(data).each(function(){
					$str+=
						"<tr>"
						+"<td>"+this.board_no+"</td>"
						+"<td>"+this.board_title+"</td>"
						+"<td>"+this.board_hit+"</td>"
						+"</tr>";
			});
				$('#board').html($str);
		});
	}
	function typeChange4(){
		$.getJSON("/admin/boardmanager4",function(data){
				$str="";
				$str+="<tr>"
					+"<td>글번호</td>"
					+"<td>제목</td>"
					+"<td>조회수</td>"
					+"</tr>"
					+"<tr>";
				$(data).each(function(){
						$str+=
							"<tr>"
							+"<td>"+this.board_no+"</td>"
							+"<td>"+this.board_title+"</td>"
							+"<td>"+this.board_hit+"</td>"
							+"</tr>";
				});
				$('#board').html($str);
		});
	}
</script>
<%-- --------------------------------------------------------------------- --%>
<style type="text/css">

.typeButton{
	text-align: center;
	height: 200px;
	line-height: 200px;
}
.typeButton button{
	border: none;
	border-radius:10px;
	text-decoration: none;
	padding:15px 20px;
	font-size: 20px;
}
.typeButton button:hover{
	color: red;
	cursor: pointer;
}
.boardMain{
}
#board{
	border-collapse: collapse;
	text-align: center;
	margin: auto;
	width: 500px;
}

</style>
</head>
<body>
<div class="typeButton">
	<button name="type" value="1" onclick="typeChange1();">전체</button>
	<button name="type" value="2" onclick="typeChange2();">자유게시판</button>
	<button name="type" value="3" onclick="typeChange3();">공지사항</button>
	<button name="type" value="4" onclick="typeChange4();">추천게시판</button>
	<button name="type" value="4" onclick="typeChange4();">FAQ/QNA</button>
</div>
	<div class="boardMain">
		<table id="board" border="1"></table>
	</div>
	
</body>
</html>