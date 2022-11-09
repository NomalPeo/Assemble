<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/thema/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
   href="/resources/css/content/content.css">
<script type="text/javascript" src="/resources/js/jquery.js">
   

</script>
<meta charset="UTF-8">

</head>
<body class="ligth" style="position: static; top: auto;">
   <div id="cwarp">
      <div class="Layout">
         <div class="ContentLayout">
            <div class="ContentMainPage">
               <div class="leftContentMainContainer">
                  <div class="upperleftContentMainContainer">
                     <div class="upperleft">
                        <div class="upperleftOverview">
                           <div class="ContentOverview">
                              <img alt="썸네일"
                                 src="/resources/upload/${con.webtoon_thumbnail}"
                                 class="imageContentOverView">
                              <div class="ContentOverview-ContentOverview"></div>
                              <div class="ContentOverview-ContentOverview2"></div>
                           </div>
                           <div class="ContentOverview3">
                              <video data-obj="#" class="ContentOverview4"></video>
                           </div>
                           <div class="css-0">
                              <div class="ContentOverviewThumbnail">
                                 <div class="ContentOverviewThumbnail2">
                                    <div class="ThumbnailImage">
                                       <div class="ThumbnailImage2"></div>
                                       <img src="/resources/upload/${con.webtoon_thumbnail}"
                                          alt="썸네일" class="ThumbnailImage3">
                                    </div>
                                 </div>
                              </div>
                              <div class="ContentOverviewInfo">
                                 <span class="Text-ContentOverviewInfo">${con.webtoon_title}</span>
                                 <div class="ContentOverviewInfo2">
                                    <span
                                       class="Text-Separator-ContentOverviewInfo">${con.webtoon_tag1}</span>
                                    <img alt="메타데이터 구분점"
                                       src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxMCAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBvcGFjaXR5PSIwLjYiIGN4PSI1IiBjeT0iOCIgcj0iMSIgZmlsbD0id2hpdGUiLz4KPC9zdmc+Cg=="
                                       class="Separator-ContentOverviewInfo"> <span
                                       class="Text-Separator-ContentOverviewInfo">${con.webtoon_tag2}</span>
                                 </div>
                                 <div class="ContentOverviewInfo3">
                                    <div>
                                       <span class="Text-Separator-ContentOverviewInfo">${con.webtoon_complete}</span>
                                    </div>
                                    <div>
                                       <div class="Publishing-ContentOverviewInfo">
                                          <span class="Text-Publishing-ContentOverviewInfo">${con.webtoon_platform},
                                             ${con.webtoon_writer}</span>
                                       </div>
                                    </div>
                                 </div>
                                 <div class="ContentOverviewInfo4"></div>
                              </div>
                           </div>
                        </div>
                     </div>


                     <div class="Shortcuts">
                        <form action="/wish_ok" method="POST">
                           <input type="hidden" name="title" value="${con.webtoon_title}" />
                           <input type="hidden" name="thumbnail"
                              value="${con.webtoon_thumbnail}" />
                           <button type="submit" name="submit"
                              class="ShortcutsMainAction">찜하기</button>
                        </form>
                     </div>
                  </div>



                  <div class="lowerleftContentMainContainer"></div>
               </div>


               <div class="rightContentMainContainer">
                  <div class="MainTab-ContentMainContainer">
                     <div class="MainTab">
                        <div class="Main-Tab">
                           <div class="MainTabIntroduction1">
                              <div class="MainTabIntroduction2">
                                 <span class="MainTab-title-Introduction">${con.webtoon_title}</span><span class="MainTabIntroduction3">의 작품소개</span>

                              </div>

                           </div>
                        </div>

                     </div>
                  </div>

                  <div>
                     <div class="ContentDetailTabContainer">
                        <div class="ContentTitleSection">
                           <span class="Text-ContentTitleSection"></span>
                        </div>
                        <span class="Text-ContentDetailTabContainer">${con.webtoon_cont}
                        </span>
                     </div>



                     <div>
                        <div class="ContentSeriesSection">
                           <div class="ContentTitleSection">
                              <span class="Text-ContentTitleSection">이런 웹툰은 어떠세요? </span>
                           </div>

                           <div class="ScrollableHorizontalList">
                              <ul class="List-ScrollableHorizontalList" draggable="true">
                                 <c:forEach var="wc2" items="${wc2}">
                                    <li><a
                                       href="/content?webtoon_thumbnail=${wc2.webtoon_thumbnail}"
                                       class="css-0">
                                          <div data-obj="#" class="PosterViewItem1">
                                             <div class="PosterViewItem2">
                                                <div class="PosterImage">
                                                   <div class="PosterImage2"></div>
                                                   <img src="resources/upload/${wc2.webtoon_thumbnail}"
                                                      alt="썸네일" class="ThumbnailImage3">
                                                </div>
                                                <div class="PosterViewItem-PosterViewItem"></div>
                                             </div>
                                             <div class="Text-PosterViewItem">
                                                <div class="Text-PosterViewItem1">${wc2.webtoon_title}</div>
                                                <div class="Metadata-PosterViewItem">
                                                   <div class="BadgesWithSpace"></div>
                                                   <div class="TextsWithSeparator-Metadata">
                                                      <span class="Text">${wc2.webtoon_complete}</span> <img
                                                         alt="메타데이터 구분점"
                                                         src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMTAiIGhlaWdodD0iMTYiIHZpZXdCb3g9IjAgMCAxMCAxNiIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGNpcmNsZSBjeD0iNSIgY3k9IjgiIHI9IjEiIGZpbGw9ImJsYWNrIiBmaWxsLW9wYWNpdHk9IjAuMjUiLz4KPC9zdmc+Cg=="
                                                         class="Separator"> <span class="Text">${wc2.webtoon_tag1}
                                                      </span>

                                                   </div>
                                                </div>
                                             </div>

                                          </div>
                                    </a></li>
                                 </c:forEach>
                              </ul>
                           </div>
                        </div>
                     </div>
                     <div class="ContentCommentsContainer">
                        <div class="ContentCommentsContainer2">
                           <div class="CommentsContainer">
                              <div class="CommentsTab">
                                 <div class="CommentsTab2">

                                    <div class="Commentsentire-Tab">
                                       <div data-obj="#" class="CommentsentireTab">
                                          <div class="CommentsentireTab2">
                                             <span class="CommentsentireTab3">댓글</span>
                                          </div>
                                       </div>
                                    </div>
                                 </div>
                              </div>

                              <form name="review-form" method="post" action="content_review">
                                 <div class="CommentInputField1">
                                    <div class="CommentInputField2">
                                       <div class="CommentInputField3">
                                          <div class="CommentInputField4">
                                             <textarea name="review_cont"
                                                placeholder="댓글을 입력해 주세요."
                                                class="Textarea-CommentInputField"
                                                style="height: auto;"></textarea>
                                             <input type="hidden" name="review_thumbnail"
                                                value="${con.webtoon_thumbnail}" />
                                             <button class="Text-CommentInputField" type="submit">등록</button>

                                          </div>

                                       </div>
                                    </div>
                                 </div>

                              </form>
													
                              <div class="Text-CommentsContainer">
                                 <c:forEach var="rev" items="${rev_list}">
                                    <div data-obj="#">
                                       <div data-ojb="#" class="css-0">
                                          <div class="Commnet">
                                             <div class="Commnet2">
                                                <div class="CommentTitle">

                                                   <span class="Username-Comment">${rev.review_id}</span>
                                                   <span class="Date-Comment">${rev.review_regdate}</span>
                                                </div>
                                                <span class="Text-Comment">${rev.review_cont}</span>
                                                <div class="Del-comment1">
                                                   <input class="Del-Comment2" type="button" size="20"
                                                      value="삭제" onclick="location='review_del?review_no=${rev.review_no}&review_thumbnail=${rev.review_thumbnail }';" />
                                                </div>
                                             </div>
                                          </div>
                                          <div class="LineComment">
                                             <div class="Divider-Line"></div>
                                          </div>
                                       </div>
                                    </div>
                                 </c:forEach>
                              </div>

                           </div>

                        </div>



                     </div>




                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <%@include file="../include/footer.jsp"%>
</body>
</html>