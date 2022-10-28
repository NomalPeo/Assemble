create table webtoon(
    webtoon_no number(38),
    webtoon_title varchar2(50) primary key,
    webtoon_writer varchar2(50) not null,
    webtoon_cont varchar2(4000) not null,
    webtoon_platform varchar2(50) not null,
    webtoon_complete int not null,
    webtoon_tag1 varchar2(50) not null,
    webtoon_tag2 varchar2(50),
    webtoon_thumbnail varchar2(100) not null,
    webtoon_image1 varchar2(100),
    webtoon_image2 varchar2(100),
    webtoon_image3 varchar2(100)
);
alter table webtoon add webtoon_age number(10);



	select * from webtoon where webtoon_tag1 = '로맨스';
select * from webtoon;
delete from webtoon;
create SEQUENCE webtoon_seq
start with 1
increment by 1
nocache;
commit;
select * from webtoon;
commit;
	select WEBTOON_THUMBNAIL from (select * from WEBTOON where WEBTOON_TAG1 = '로맨스' ) where ROWNUM <= 5;

	select WEBTOON_THUMBNAIL from (select * from WEBTOON where WEBTOON_TAG1 = '로맨스' ) where ROWNUM BETWEEN 1 and 5;
    select WEBTOON_THUMBNAIL from (select rownum as rn, webtoon_thumbnail from webtoon where webtoon_tag1 = '로맨스' ) where rn BETWEEN 6 and 10;
    
SELECT ROWNUM FROM webtoon;

insert into webtoon (webtoon_age) value(15);






