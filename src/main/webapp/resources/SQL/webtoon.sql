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
select * from webtoon;
delete from webtoon;
create SEQUENCE webtoon_seq
start with 1
increment by 1
nocache;

select * from webtoon;