<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" type="text/css"
   href="/resources/css/myPage/wish.css">

<script type="text/javascript" src="/resources/js/jquery.js">

</script>



<%@ include file="../include/header.jsp"%>
<div class="listbox">
   <form name="t" method="post" action="/content_ok">

      <div class="ContentSeriesSection">
         <div class="ContentTitleSection">
            <span class="Text-ContentTitleSection">찜목록</span>
            <c:if test="${empty w_list}">

               <span class="wish-msg"><c:out value="${wishmsg}" /></span>
            </c:if>
            <div class="tag-item">
               <c:forEach var="ws" items="${w_list}">

                  <div class="wish_list">
                     <div class="wish_listimage">
                        <div class="item" id="item">
                           <div class="web-img">
                              <a href="/content?webtoon_thumbnail=${ws.wish_thumbnail}"
                                 type="submit" value="${ws.wish_thumbnail}"
                                 class="wish_thumbnail"> <img
                                 src="/resources/upload/${ws.wish_thumbnail}"
                                 class="thumbnail" alt="썸네일"
                                 style="width: 100%; height: 100%;"></a>
                           </div>

                        </div>

                        <div class="web-title" id="web-title">
                           <div class="Text-PosterViewItem1">

                              <span><c:out value="${ws.wish_title}" /></span>
                           </div>
                           <div class="Metadata-PosterViewItem">
                              <div class="BadgesWithSpace"></div>
                              <div class="TextsWithSeparator-Metadata">
                                 <span class="Text">연재중</span> <img alt="메타데이터 구분점"
                                    src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxMCAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iNSIgY3k9IjgiIHI9IjEiIGZpbGw9ImJsYWNrIiBmaWxsLW9wYWNpdHk9IjAuMjUiLz4KPC9zdmc+Cg=="
                                    class="Separator"> <span class="Text"> 액션 </span> <img
                                    alt="메타데이터 구분점"
                                    src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxMCAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iNSIgY3k9IjgiIHI9IjEiIGZpbGw9ImJsYWNrIiBmaWxsLW9wYWNpdHk9IjAuMjUiLz4KPC9zdmc+Cg=="
                                    class="Separator">

                              </div>
                              <div class="wish_btn">
                                 <input type="button" value="삭제"
                                    onclick="location='wish_del?wish_title=${ws.wish_title}';" />
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </c:forEach>
            </div>
         </div>
      </div>


   </form>

</div>