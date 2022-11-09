create table reply(
    board_reply_rno number(38) primary key,
    board_reply_cont varchar2(4000) not null,
    board_regdate date,
    board_reply_bno number(38),
    board_reply_writer varchar2(50)
);

alter table reply add constraint reply_board_reply_bno_fk foreign key(board_reply_bno) references board(board_no);

select * from reply;

insert into reply values(3,'안녕하세요',sysdate,9,'둘리');
commit;

select * from reply;
update reply set board_reply_writer ='둘리';

create sequence rno_seq
start with 1
increment by 1
nocache;