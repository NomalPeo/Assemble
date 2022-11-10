<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
   href="/resources/css/admin/cont.css">
<script src="/resources/js/jquery.js"></script> 
<script type="text/javascript">
   $board_no = ${bc.board_no};
   boardReply();
   function boardReply(){
      $.getJSON("/admin/boardReply/"+$board_no,function(data){
         $str="";
         $str+="<tr>"
            +"<td colspan='2'>"
            +"댓글입력"
            +"</td>"
            +"<td colspan='3'>"
            +"</td>"
            +"</tr>"
            +"<tr>"
            +"<td></td>"
            +"<td colspan='3'>"
            +"<textarea rows='4' cols='85' name='replytext' id='replyText'></textarea>"
            +"</td>"
            +"<td>"
            +"<button id='replyAdd' type='button' onclick='replyAdd();'>확인</button>"
            +"</td>"
            +"</tr>";
            
         $str+="<tr>"
         +"<th>N</th>"
         +"<th>작성자</th>"
         +"<th colspan='2'>내용</th>"
         +"<th>작성날짜</th>"
         +"</tr>";
         $(data).each(function(){
            $str+="<tr>"
               +"<td id='delRno'>"+this.board_reply_rno+"</td>"
               +"<td>"+this.board_reply_writer+"</td>"
               +"<td colspan='2'>"+this.board_reply_cont+"</td>"
               +"<td>"+this.board_regdate+"&nbsp;<button type='button' id='delBtn' onclick='adminDel();'>삭제</button></td>"
               +"</tr>";       
         });
         $('#boardReply').html($str);
      });   
   }
   function replyAdd(){
      $replytext = $('#replyText').val();
      $.ajax({
         type:'post',
         url:'/admin/replyAdd1',
          headers:{
               "Content-Type":"application/json",
               "X-HTTP-Method-Override":"POST"
              },
         dataType:'text',
         data:JSON.stringify({
            board_reply_cont:$replytext,
            board_reply_bno:$board_no 
         }),
         success:function(data){
            if(data=='SUCCESS'){
               alert('댓글추가');
               location.reload();
            }
         }
      });
   }
   
   
   function adminDel(){
         $board_rno = $('#delRno').html();
       $.ajax({
          type:'delete', //ReplyController.java에서 지정한 삭제 메서드 방식
          url:'/admin/boardDel/'+$board_rno, //삭제 URL 매핑주소
          headers:{
            "Content-Type" : "application/json",
            "X-HTTP-Method-Override" : "DELETE"
          },
          dataType:'text',
          success:function(data){
             if(data == 'SUCCESS'){
                alert('댓글이 삭제되었습니다!');
                location.reload();
             }
          }
       });
    }
</script>
</head>
<body>
   <div class="pageAll">
      <div class="topchoice">
         <a href="/admin/adminPage">관리자페이지</a> 
         <a href="/admin/webtooninsert">웹툰
            등록</a>
             <a href="/admin/boardmanager">게시물 관리</a>
      </div>
      <div class="type">
         <c:out value="${type }"></c:out>
      </div>
      <div class="contTitle">
         <c:out value="${bc.board_title }"></c:out>
      </div>
      <div class="writerdate">
         <div>
            <div class="contWriter">
               <c:out value="${bc.board_writer }"></c:out>
            </div>
            <div class="contDate">
               <c:out value="${bc.board_date }"></c:out>
            </div>
         </div>
         <div class="contHit">
            <span>조회수</span>: &nbsp;
            <c:out value="${bc.board_hit }"></c:out>
         </div>
      </div>
      <div class="contContent">
         <c:out value="${bc.board_cont }"></c:out>
      </div>
   </div>
   <table id="boardReply"></table>
</body>
</html>