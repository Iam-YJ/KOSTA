-- 새로운 계정 생성한다 (system 에서만 가능)
-- 생성된 계정에 권한을 부여한다
-- 생성된 계정으로 접속한다
-- 제공된 자료를 바탕으로 테이블 생성하고 레코드 샘플 데이터 추가한다 

create table subject(
    수강코드 varchar2(5) constraint subject_수강코드 primary key,
    과목 varchar2(20) constraint subject_과목 not null 
);

create table room(
    강의실번호 number(4) constraint room_강의실번호 primary key,
    수용인원 number(4) constraint room_수용인원 not null
);

create table student(
    수강생번호 number(2) constraint student_수강생번호 primary key,
    수_이름 varchar2(12) constraint student_수_이름 not null,
    수_주민등록번호 varchar2(14) constraint student_수_주민등록번호 not null,
    수_연락처 varchar2(14) constraint student_수_연락처 not null,
    수_주소 varchar2(50) ,
    수_이메일 varchar2(20) 
    
);

create table teacher(
    강사번호 number(2) constraint teacher_강사번호 primary key,
    강사이름 varchar2(12) constraint teacher_강사이름 not null,
    주민등록번호 varchar2(14) constraint teacher_주민등록번호 not null,
    연락처 varchar2(14) constraint teacher_연락처 not null,
    주소 varchar2(50),
    이메일 varchar2(20) ,
    수강코드 varchar2(5) constraint teacher_수강코드 not null references subject(수강코드)

);


create table sugagn(
    수강생번호 number(2) constraint sugagn_수강생번호 primary key references student(수강생번호),
    수강코드 varchar2(5) constraint sugagn_수강코드 references subject(수강코드)

);

create table sugagntb(
    수강코드 varchar2(5) constraint sugagntb_수강코드 primary key references subject(수강코드),
    강의실번호 number(4) constraint sugagntb_강의실번호 references room(강의실번호),
    시간 number(2) constraint sugagntb_시간 not null,
    강사번호 number(2) constraint sugagntb_강사번호  references teacher(강사번호)
    

);

--------------------------------------------------------------------------

--subject
insert into subject(수강코드, 과목) values('j1001', 'sql');
insert into subject(수강코드, 과목) values('j1002', 'Win2000');
insert into subject(수강코드, 과목) values('j1003', 'ASP');
insert into subject(수강코드, 과목) values('j1004', 'Php');
insert into subject(수강코드, 과목) values('j1005', 'java');
insert into subject(수강코드, 과목) values('j1006', 'javascript');

--room
insert into room(강의실번호, 수용인원) values(901, 34);
insert into room(강의실번호, 수용인원) values(902, 35);
insert into room(강의실번호, 수용인원) values(903, 25);
insert into room(강의실번호, 수용인원) values(904, 32);
insert into room(강의실번호, 수용인원) values(905, 30);
insert into room(강의실번호, 수용인원) values(906, 35);

--teacher
insert into teacher(강사번호, 강사이름, 주민등록번호, 연락처, 주소, 이메일, 수강코드) values(1,'홍길동','700918-1622011','031-295-1234','성남시 중원구 신흥동','kkk@jok.or.kr','j1001');
insert into teacher(강사번호, 강사이름, 주민등록번호, 연락처, 주소, 이메일, 수강코드) values(2,'유관순','710419-2018916','02-345-2345','서울 강남구 개포동','kkk@jok.or.kr','j1002');
insert into teacher(강사번호, 강사이름, 주민등록번호, 연락처, 주소, 이메일, 수강코드) values(3,'이승복','730112-1344911','031-1234-6789','서울시 강남구 논현동','sss@jok.or.kr','j1003');
insert into teacher(강사번호, 강사이름, 주민등록번호, 연락처, 주소, 이메일, 수강코드) values(4,'모택동','730301-1167623','031-567-5678','서울시 서초구 서초동','mmm@jok.or.kr','j1004');
insert into teacher(강사번호, 강사이름, 주민등록번호, 연락처, 주소, 이메일, 수강코드) values(5,'주롱지','730322-2037921','031-789-3456','서울시 강서구 가양동','xxx@jok.or.kr','j1005');
insert into teacher(강사번호, 강사이름, 주민등록번호, 연락처, 주소, 이메일, 수강코드) values(6,'이순신','731122-1646213','031-234-8901','서울시 강북구 미아동','ppp@jok.or.kr','j1006');

--student
insert into student(수강생번호, 수_이름, 수_주민등록번호, 수_연락처, 수_주소, 수_이메일) values(1,'김현진','771212-2346111','017-888-8888','부산','aaa@hanmail.net');
insert into student(수강생번호, 수_이름, 수_주민등록번호, 수_연락처, 수_주소, 수_이메일) values(2,'김석주','720112-1234812','016-999-9999','경기','bbb@hanmail.net');
insert into student(수강생번호, 수_이름, 수_주민등록번호, 수_연락처, 수_주소, 수_이메일) values(3,'고훈기','730102-1555555','017-555-5555','서울','ccc@hanmail.net');
insert into student(수강생번호, 수_이름, 수_주민등록번호, 수_연락처, 수_주소, 수_이메일) values(4,'유민경','801111-2222222','017-222-2222','전남','ddd@hanmail.net');
insert into student(수강생번호, 수_이름, 수_주민등록번호, 수_연락처, 수_주소, 수_이메일) values(5,'김영수','811231-1777777','017-777-7777','충주','eee@hanmail.net');
insert into student(수강생번호, 수_이름, 수_주민등록번호, 수_연락처, 수_주소, 수_이메일) values(6,'박상원','790915-1333333','017-333-3333','강원','fff@hanmail.net');


--sugagn
insert into sugagn(수강생번호, 수강코드) values(1,'j1001');
insert into sugagn(수강생번호, 수강코드) values(2,'j1002');
insert into sugagn(수강생번호, 수강코드) values(3,'j1003');
insert into sugagn(수강생번호, 수강코드) values(4,'j1004');
insert into sugagn(수강생번호, 수강코드) values(5,'j1005');
insert into sugagn(수강생번호, 수강코드) values(6,'j1006');

--sugangtb
insert into sugagntb(수강코드, 강의실번호, 시간, 강사번호) values('j1001', 901, 2, 1);
insert into sugagntb(수강코드, 강의실번호, 시간, 강사번호) values('j1002', 902, 2, 2);
insert into sugagntb(수강코드, 강의실번호, 시간, 강사번호) values('j1003', 903, 2, 3);
insert into sugagntb(수강코드, 강의실번호, 시간, 강사번호) values('j1004', 904, 2, 4);
insert into sugagntb(수강코드, 강의실번호, 시간, 강사번호) values('j1005', 905, 2, 5);
insert into sugagntb(수강코드, 강의실번호, 시간, 강사번호) values('j1006', 906, 2, 6);

-----------------------------------------------------------------------------------


create table reply(
    reply_no number primary key,
    content varchar2(100),
    board_no number references board(board_no),
    reg_date date
);

create sequence reply_no_seq nocache;

insert into reply(reply_no, content, board_no, reg_date)
values (reply_no_seq.nextval, '6-1댓글이다',1,sysdate);

commit;

select * from board;
select * from reply;

drop table reply;

delete from copy_emp where empno = 7900;