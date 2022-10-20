<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비번찾기 결과</title>
<link rel="stylesheet" type="text/css" 
href="../../resources/css/pwd/pwdfind.css" />
</head>
<body>
 <div id="pOK_wrap">
  <h2 class="pOK_title">비번검색 결과</h2>
  <table id="pOK_t">
   <tr>
    <th>임시비번</th>
    <td>${ran_pwd}</td>
   </tr>
   <tr>
   <th colspan="2">
    (*임시비번은 로그인 후 수정하세요!)
   </th>   
   </tr>
  </table> 
  <div id="pOK_menu">
  <input type="button" value="닫기" onclick="self.close();"/>
  <%-- 자바스크립트에서 self.close();는 내자신 공지창을 닫는
  다. --%>  
  </div>
 </div>
</body>
</html>