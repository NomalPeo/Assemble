<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비번검색</title>
<link rel="stylesheet" type="text/css" 
href="../../resources/css/pwd/pwdfind.css" />
<script src="/resources/js/jquery.js"></script>
<script>
 function pwd_check(){
    if($.trim($("#pwd_id").val()) == ""){
       alert("회원아이디를 입력하세요!");
       $("#pwd_id").val("").focus();
       return false;
    }
     if($.trim($("#pwd_name").val())==""){
        alert("회원이름을 입력하세요!");
        $("#pwd_name").val("").focus();
        return false;
     }    
 }
</script>
</head>
<body>
 <div id="pFind_wrap">
  <h2 class="pFind_title">비번찾기</h2>
  <form method="post" action="pwd_find_ok"
  onsubmit="return pwd_check();">
   <table id="pFind_t">
    <tr>
     <th>회원아이디</th>
     <td>
      <input name="pwd_id" id="pwd_id" size="14" />
     </td>
    </tr>    
    <tr>
      <th>회원이름</th>
      <td>
      <input name="pwd_name" id="pwd_name" size="14" />
      </td>    
    </tr>
   </table>
   <div id="pFind_menu">
   <input type="submit" value="찾기" />
   <input type="reset" value="취소" 
   onclick="$('#pwd_id').focus();" />
   </div>
  </form>
 </div>
</body>
</html>