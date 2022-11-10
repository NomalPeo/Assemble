<%@ include file="../../include/board/header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용보기 </title>
<script src="../resources/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/freeboard/freeboardCont.css">
<style type="text/css">
  /*댓글 수정 화면 */
  #modDiv{
   width:300px; height:100px;  background-color:gray; 
   position:absolute; /*절대위치 */
   top:50%; left:50%;
   margin-top:-50px; margin-left: -150px;
   padding:10px;
   z-index:1000; /* position속성이 absolute or fixed인 곳에서 사용한다. 이 속성은 요소가 겹쳐지는 순서를 제어할 수 있다. 물론,
   큰숫자일수록 앞에 나온다. */
  }
  </style>
</head>
<body>
<div class="freeboard_cont">
<h2>QnA</h2><br>
<hr>
<table border="1">
	
	<tr>
		<td class="board_title">${b.board_title}</td>
	</tr>
	
	<tr>
		<td class="board_writer">${b.board_writer} &nbsp;  |   &nbsp; ${b.board_date} </td>
		<td class="board_hit">조회 ${b.board_hit}</td>
	</tr>
	
	<tr>
		<td colspan="3" class="board_cont"><br><pre>${b.board_cont}</pre></td>
	</tr>
	
	</table>
	
	<div  class="board_btn_tr">
	<tr>
		<th class="board_btn" colspan="2">
			<input type="button" value="수정" onclick="location='qna_edit?board_no=${b.board_no}&page=${page}';"/>
			<input type="button" value="삭제" onclick="location='qna_del?board_no=${b.board_no}&page=${page}';"/>
			<input type="button" value="목록" onclick="location='qna_list?page=${page}';"/>
		</th> 
	</tr>
	</div>
	<br>
	<hr>
	<br>
	
	<!------------------------------------------------------------------------------------------------------------------------>
	<%--댓글 수정화면 --%>
	<div id="modDiv" style="display: none;">
		<%-- css display:none;에 의해서 댓글 수정화면이 안보이게 함 --%>

		<div class="modal-title"></div><%--댓글 번호 --%>
		<div>
			<textarea rows="3" cols="30" id="replytext"></textarea>
		</div>
		<div>
			<button type="button" id="replyModBtn">댓글수정</button>
			<button type="button" id="replyDelBtn">댓글삭제</button>
			<button type="button" id="closeBtn" onclick="modDivClose();"> 닫기</button>
		</div>
	</div>

	<div>
	<div class="cntreply">
	[댓글<span style="color: black; font-weight: bolder; font-size: 26px;
	border-radius: 15px; padding: 3px;">${board.replycnt}</span>]
	<br>
	</div>
		<div class="replycont">
			<textarea rows="5" cols="30" name="board_reply_cont" id="newReplyText" placeholder="댓글을 입력해주세요."></textarea>
		</div>
		<button id="replyAddBtn">등록</button>
	</div>

	<br>
	<br>
	

	<%--댓글 목록 --%>
	<div class="replylist">
	<ul id="replies"></ul>
	
	<script>
	  $board_no=${b.board_no};
	  getAllList();//댓글 목록함수를 호출
	  
	  //댓글 목록
	  function getAllList(){
		  $.getJSON("/replies/all/"+$board_no, function(data){//jQuery 비동기식 $.getJSON()함수는 GET방식으로 접근하는 json데이터
			  //를 처리, 비동기식으로 가져온 것이 성공시 data매개변수에 가져온 값을 저장
			  $str="";
		  
		      $(data).each(function(){//each()함수에 의해서 li태그 단위로 댓글개수만큼 반복
		    	  $str += "<li data-board_reply_rno='"+ this.board_reply_rno +"' class='replyLi'>"
		    	  +this.board_reply_writer  /*+this.board_reply_rno*/+"  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class='com' style='color:black;'>" 
		    	  + this.board_reply_cont +"</span>" +"  "+ this.board_regdate
	    	  +" <button>수정</button></li><br/>";
		      });
		      $('#replies').html($str);//html()함수로 문자와 태그를 함께 변경 적용
		  });
	  }//getAllList()
	  
		//댓글 추가
		$('#replyAddBtn').on('click', function() {
			$board_reply_writer = $('#newReplyWriter').val();//댓글 작성자
			$board_reply_cont = $('#newReplyText').val();//댓글 내용

			$.ajax({
				type : 'post', //method 방식
				url : '/replies/addreply', //URL 매핑주소 경로
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					board_no : $board_no, //게시판 번호
					//board_reply_writer : $board_reply_writer, //댓글 작성자
					board_reply_cont : $board_reply_cont //댓글 내용
				}),
				success : function(data) {//비동기식으로 가져오는 것이 성공시 호출되는 콜백 함수,가져온 문자는 data 매개변수에 저장
					if (data == 'SUCCESS') {
						alert('댓글이 등록되었습니다');
						location.reload();//새로 고침=>단축키 F5 역할을 함.
						getAllList();//댓글 목록함수를 호출
					}
				}
			});//jQuery 비동기식 아작스 함수
		});
	  
		//댓글 수정 화면
		$('#replies').on('click',".replyLi button",function(){
			 var reply=$(this).parent(); //this는 버튼, button의 부모요소인 li태그를 가리킴
			 $board_reply_rno = reply.attr("data-board_reply_rno");//댓글번호
			 $board_reply_cont = reply.children(".com").text();//댓글 내용
			 
			 $('.modal-title').html($board_reply_rno);//댓글번호가 표시
			 $('#replytext').val($board_reply_cont);//댓글 내용이 표시
			 $('#modDiv').show('slow');//display:none; css에 의해서 숨겨진 댓글 수정화면을 표시하게 한다.
		  });
		  
		  //댓글 수정화면 닫기
		  function modDivClose(){
			  $('#modDiv').hide('slow');
		  }
		  
		  //댓글 수정 완료
		  $('#replyModBtn').on('click',function(){
			 $board_reply_rno=$('.modal-title').html();//댓글번호
			 $board_reply_cont=$('#replytext').val();//수정할 댓글 내용
			 
			 $.ajax({
				type:'put',
				url:'/replies/'+$board_reply_rno,
				headers:{
					"Content-Type":"application/json",
					"X-HTTP-Method-Override":"PUT"
				},
				data:JSON.stringify({
					board_reply_cont:$board_reply_cont //수정할 내용
				}),
				dataType:'text',
				success:function(result){
					if(result =='SUCCESS'){
						alert('댓글이 수정되었습니다!');
						$('#modDiv').hide('slow');
						getAllList();//댓글 목록 함수 호출
					}
				}
			 });
		  });
		  
		  //댓글 삭제
		  $('#replyDelBtn').on('click',function(){
			 var board_reply_rno=$('.modal-title').html();//댓글 번호
			 
			 $.ajax({
				 type:'delete', //ReplyController.java에서 지정한 삭제 메서드 방식
				 url:'/replies/'+board_reply_rno, //삭제 URL 매핑주소
				 headers:{
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				 },
				 dataType:'text',
				 success:function(data){
					 if(data == 'SUCCESS'){
						 alert('댓글이 삭제되었습니다!');
						 $('#modDiv').hide('slow');//댓글 수정화면을 닫는다.
						 location.reload();
						 getAllList();//댓글 목록함수 호출
					 }
				 }
			 });
		  });
	</script>
	</div>
	</div>

</body>
</html>
<jsp:include page="../..//include/footer.jsp" />