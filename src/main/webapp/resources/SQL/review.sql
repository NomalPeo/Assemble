create table review(
   review_no number(38) primary key, -- review ?뀒?씠釉? pk
   review_cont varchar2(4000) not null, -- 由щ럭 ?궡?슜
   review_like number(38) default 0, -- 由щ럭 醫뗭븘?슂
   review_regdate date, -- ?벑濡? ?궇吏?
   review_updatedate date, -- ?닔?젙 ?궇吏?
   review_id varchar2(50), -- user ?뀒?씠釉? fk
   review_thumbnail varchar2(50) -- webtoon ?뀒?씠釉? fk
);

create SEQUENCE review_seq
start with 1
increment by 1
nocache;

select review_seq.nextval from dual

alter table review drop column review_rating;

select * from review

select * from review r, webtoon w where r.review_thumbnail = '검빨로 레벨업.jpg'

delete review


commit