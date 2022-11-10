create table thema(
    thema_title varchar2(1000) not null,
    thema_cont varchar(1000)
)

select * from thema

insert into thema(thema_title,thema_cont) values('신의탑','테스트 입력');

select a.thema_title, a.thema_cont, b.webtoon_writer, b.webtoon_cont, b.webtoon_platform, b.webtoon_complete, b.webtoon_tag1, 
b.webtoon_tag2, b.webtoon_thumbnail
from thema a all outer join webtoon b on a.thema_title = b.webtoon_title;