create table wish(
    wish_title varchar2(100),
    wish_id varchar2(100)
)

select * from wish

select * from wish where wish_id='test3'
select count(*) from wish



select * from webtoon wb, wish ws
		where wb.webtoon_title = ws.wish_title

commit

select * from
(select * from webtoon, (select count(wish_title) as cnt , wish_title from wish group by wish_title having count(wish_title) > 0) 
where webtoon_title = wish_title order by cnt desc) where rownum <= 3 

select * from
(select * from webtoon, (select count(wish_title) as cnt , wish_title from wish group by wish_title having count(wish_title) > 0) 
where webtoon_title = wish_title order by cnt desc) where rownum <= 3 

select count(wish_title) as cnt , wish_title from wish group by wish_title having count(wish_title) > 0

select * from (select * from webtoon, (select count(wish_title) as cnt, wish_title from (select * from wish, (select * from users where user_gender = 1) where wish_id = user_id) 
group by wish_title having count(wish_title) > 0) where wish_title = webtoon_title order by cnt desc) where rownum between 1 and 3

select * from (select * from webtoon, (select count(wish_title) as cnt, wish_title from (select * from wish, (select * from users where user_gender = 2) where wish_id = user_id) 
group by wish_title having count(wish_title) > 0) where wish_title = webtoon_title order by cnt desc) where rownum between 1 and 3

alter table wish add wish_thumbnail varchar2(100)