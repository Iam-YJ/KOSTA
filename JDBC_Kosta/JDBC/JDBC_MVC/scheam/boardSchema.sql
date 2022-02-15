drop table board;

create table board(
	board_no int primary key,
	subject varchar2(30) not null,
	writer varchar2(20) not null,
	content varchar2(50) not null,
	board_date date not null
); 


--시퀀스 만들기 전에 권한 부여(system계정에서만 가능)
grant  create sequence  to scott;

  
--시퀀스 만들기
create sequence board_seq nocache; 


select * from board;

commit;

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db수업', '장희정', '잼난다', sysdate)




