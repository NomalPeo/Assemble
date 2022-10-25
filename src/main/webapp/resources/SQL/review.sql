create table review(
   review_no number(38) primary key, -- review 테이블 pk
   review_cont varchar2(4000) not null, -- 리뷰 내용
   review_rating number(38) not null, -- 별점
   review_like number(38) default 0, -- 리뷰 좋아요
   review_regdate date, -- 등록 날짜
   review_updatedate date, -- 수정 날짜
   user_id varchar2(50), -- user 테이블 fk
   webtoon_title varchar2(50) -- webtoon 테이블 fk
);

alter table review add constraint review_user_id_fk foreign key(user_id) references users(user_id);

alter table review add constraint review_webtoon_title_fk foreign key(webtoon_title) references webtoon(webtoon_title);