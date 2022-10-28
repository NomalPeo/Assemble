create table persistent_logins(
    username varchar2(64) not null -- 회원아이디
    ,series varchar2(64) primary key -- 회원비밀번호
    ,token varchar2(64) not null -- 토큰 정보
    ,last_used timestamp not null -- 로그인 한 날짜 시간
);