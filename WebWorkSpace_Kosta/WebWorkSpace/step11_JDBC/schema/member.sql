select *from member; -- alt+x

drop table member;
--ȸ������ ���̺� ����

create table member(
   id varchar2(20) primary key ,
   pwd varchar2(20) not null,
   name varchar2(20) not null,
   age int,
   phone varchar(15),
   addr varchar2(50),
   join_date date not null
)

select * from member;
--���ڵ� �߰�
insert into member(id,pwd,name,age,phone,addr, join_date)
values('jang','1234','������',20,'010-8875-8253','����� ������', sysdate)

commit

