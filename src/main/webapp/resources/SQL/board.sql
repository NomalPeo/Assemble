create table board(
    board_no int primary key,
    board_title varchar2(50) not null,
    board_cont varchar2(4000) not null,
    board_type number (10) not null,
    board_image varchar2(50),
    board_hit number(38),
    board_date date,
    board_replycnt number(10),
    board_category varchar2(10)
);
create sequence board_seq
start with 1
increment by 1
nocache;
commit;
select * from board;

select board_seq.nextval from dual;
insert into board (board_no,board_title,board_cont,board_type,board_image,board_hit,board_date) values(board_seq.nextval,'제목','내용',3,'인생존망_1.jpg',2,sysdate);
commit;
select *from board;
alter table board add board_writer varchar(38);
alter table board modify board_hit default 0;
