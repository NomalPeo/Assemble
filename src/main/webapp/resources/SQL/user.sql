create table users(
    user_no number(38),
    user_id varchar2(50) primary key,
    user_pwd varchar2(50) not null,
    user_name varchar2(50) not null,
    user_gender number(10) not null,
    user_nickname varchar2(50) not null,
    user_date date,
    user_state int default 1,
    user_delcont varchar2(4000),
    user_deldate date
);

ALTER TABLE users MODIFY(user_pwd VARCHAR2(200));
commit;

ALTER TABLE users DROP COLUMN user_phone1;
ALTER TABLE users DROP COLUMN user_phone2;
ALTER TABLE users DROP COLUMN user_phone3;
ALTER TABLE users DROP COLUMN email_id;
ALTER TABLE users DROP COLUMN email_domain;


select * from users;

delete from users;

create sequence users_seq
start with 1
increment by 1
nocache;

select users_seq.nextval from dual;

create table users_auth(-- 권한 부여 테이블
user_id varchar2(50) not null -- 아이디
, auth varchar2(50) not null -- 권한부여
, constraint users_auth_userid_fk foreign key(user_id) references users(user_id) 
-- 외래키로 설정되어서 tbl_member userid 컬럼 레코드 아이디값만 저장됨.
);
insert into users(user_no,user_id,user_pwd,user_name,user_gender,user_nickname,user_date,user_state)
values(users_seq.nextval,'user12','user00','홍길동',1,'홍길동',sysdate,1);

insert into users_auth(user_id,auth) values('user00','ROLE_ADMIN');
delete from users_auth;
select * from users_auth;


commit;
select mem.user_id,user_no,user_pwd,user_name,user_gender,user_nickname,user_date, auth from users mem LEFT OUTER JOIN 
	users_auth on mem.user_id = users_auth.user_id;
update users_auth set auth = 'ROLE_ADMIN' where user_id = 'zxzxzx';

    
select mem.user_id,user_no, user_pwd,user_name,user_gender,user_nickname,user_date, auth FROM users mem LEFT OUTER JOIN users_auth auth on mem.user_id = auth.user_id; 

create table persistent_logins(
    username varchar2(64) not null -- 회원아이디
    ,series varchar2(64) primary key -- 회원비밀번호
    ,token varchar2(64) not null -- 토큰 정보
    ,last_used timestamp not null -- 로그인 한 날짜 시간
);

ALTER TABLE users DROP COLUMN user_state;
ALTER TABLE users DROP COLUMN user_delcont;
ALTER TABLE users DROP COLUMN user_deldate;
commit;


