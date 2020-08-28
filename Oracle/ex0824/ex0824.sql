--���� �������� �����Ѵ�.  conn jang/1234

/*
Datatype ����

1) ������ 
    char(byte ��) - ��������
    varchar2(byte ��) - ������ ���� 
    
    varchar2(10) --> 10byte ũ��, �ѱ��� �ִ� 5����
    varchar2(10 char) --> byte���� ������� ������ �ִ� 10�� ���� 
    
    :������ �� �ݵ�� '��' ���´�.
    
    nchar() of nvarchar2()
    
2) ������
    : number(��ü�ڸ���)
    : number(��ü�ڸ���, �Ҽ����ڸ�)
    : smallint
      int
      
    ex) number(2) : -99 ~ 99 ����
    
3) ��¥��
    : date 
    : ��¥�� ������ �� '��-��-��' or '��/��/��'
    : ���� ��¥�� �ð��� �˻� -> sysdate �Լ��� �̿�

*/


/*
 - ���̺� ����
 create table ���̺��̸�(
    �÷��� datatype [null : not null] [constraint ��Ī ������������],
    �÷��� datatype [null : not null] [constraint ��Ī ������������],
    ...   
  );
  
  
 - �������� ����
 1) primary key
 2) foreign key
 3) unique
 4) check
 
 5) default 
*/

/*
1) primary key
 : �⺻Ű = ��ǥŰ = pk
 : pk�� �����ϸ� not null, �ߺ��ȵ�
 : pk �÷��� �ڵ� index ������ 
 : �ϳ��� ���̺� pk�� �ݵ�� �Ѱ��� �����Ѵ�. 
 : �������� �÷��� �ϳ��� ��� pk ������ �����ϴ�(����Ű)
*/


ex) ���̺� ����
create table member(
    id varchar2(20) constraint member_id_pk primary key,
    name varchar2(10) not null, 
    age number(2) not null,
    addr varchar2(30) ,
    regdate date 

);

-- ���̺� �˻�
select * from member;

-- ���̺� ����
desc member;

-- ���ڵ� ���(����)
insert into ���̺��̸�(�÷���,  �÷���, ... ) values(��, ��...);
insert into ���̺��̸� values(��, ��...);

ex ) �߰�
insert into member(id, name, age, addr, regdate) values('JANG','������',20,'����',sysdate);

insert into member(id, name, age, addr, regdate) values('jang','������',20,'����',sysdate);

insert into member values('hee','����',22, '�뱸','2020-08-24');

-- null or not null üũ
insert into member(name, age) values('ȿ��',22); - id�� pk �̹Ƿ� not null �̴�

insert into member(id, name, age) values ('aa','ȿ��',22); 

select * from member;

insert into memebr(id, name, age) values ('bb', '����',99);


-- ������ ����
create table test1(
 name1 varchar2(5),
 name2 varchar2(5 char),
 name3 char(5),
 name4 char, --byte���� �����ϸ� �⺻ 1byte ����
 name5 varchar2(1) --byte���� ������ �� ����. 
 
);

desc test1; -- ���̺� ����

insert into test1(name1) values('abcde');
insert into test1(name1) values('������'); --ũ�⸦ ����� ��Ͼȵ�

insert into test1(name2) values('������'); --����

insert into test1(name3) values('a');
insert into test1(name3) values('ab');
insert into test1(name3) values('abc');
insert into test1(name3) values('������'); --�ڸ����� ����� ����


--������
create table test2(
    no1 number(2),
    no2 number(5,2), --��ü 5�ڸ��߿� �Ҽ��� 2�ڸ� 
    no3 number,
    no4 smallint,
    no5 int
    
);

desc test2;

insert into test2(no1) values(-99);

insert into test2(no2) values(32.5424);
insert into test2(no2) values(32.23);

insert into test3(no3) values(9);
insert into test3(no3) values(99);
insert into test3(no3) values(9999999); --number()�� ���� ���������� �ֶ�´�� �� �� 

insert into test4(no3) values(9999999); 
insert into test5(no3) values(9999999); 


select * from test2;

-----------------------------------------------------
--���̺� ����
drop table  member;


--�ΰ��� �÷��� �ϳ��� pk�� ����� 
create table member(
    id varchar2(5 char), --����� �ѱ��̵� ������� 5���ڱ��� ������
    jumin char(6),
    name varchar2(7) not null,
    age number(3),
    addr varchar2(20),
    constraint mem_id_jumin_pk primary key(id, jumin)
);

--���̺� �˻�
select * from member;

--���̺� ����
desc member;

--���ڵ� ���
insert into member values('jang','11111','ȿ��',null,null);
insert into member values('jang','11112','ȿ��',null,null);
insert into member values('JANG','11111','ȿ��',null,null);
insert into member values('JANG','11112','ȿ��',null,null);

-- ���̺� ���� ���� - ������ Ÿ�� ����
alter table member modify name varchar2(20);

------------------------------------------------------------------
--2) Foreign key
/* 
 : �ܷ�Ű = FK
 : �ٸ� ���̺��� �⺻Ű(PK)�� �����ϴ� ��
 : ���ڵ带 ����� �� �����Ǵ� �÷��� �ִ� �� �ܴ̿� ����� �� ����
 : NULL ���, �ߺ�����
 : �� ���̺� �������� �÷��� FK ���� ����
 
  * ���ǻ���
     INSERT �� �� : �θ� insert -> �ڽ� insert �Ѵ�
     DELETE �� ��  : �ڽ� delete -> �θ� delete �Ѵ� 
      - �̷��� ���ŷο��� �ذ��ϱ� ���ؼ� ���̺� ������ �� �ɼ� ������ �� �ִ�.
      on delete cascade - �θ� ������ �� �ڽķ��ڵ嵵 �Բ� �ڵ����� �����ȴ�

*/

--���̺� ����
create table dept(
    dept_no char(3) constraint dept_no_pk primary key,
    dname varchar2(20) not null,
    loc varchar2(30)
    
);


--���� ������ �߰�
insert into dept(dept_no, dname, loc) values('a01','�λ��','����');
insert into dept(dept_no, dname, loc) values('a02','�渮��','�뱸');
insert into dept(dept_no, dname, loc) values('a03','������','����');

--���̺� ����
create table emp(
    emp_no number(3) constraint emp_no_pk primary key, --�����ȣ
    ename varchar2(20) not null,
    age number(3),
    dept_no char(3) constraint emp_deptno_fk references dept(dept_no)

);

--���õ����� �߰�
insert into emp(emp_no, ename, age, dept_no) values(1,'��ȿ��',20,null); -- �μ���ȣ null ����� �� ����
insert into emp(emp_no, ename, age, dept_no) values(2,'�̹̿�',22,'a01');
insert into emp(emp_no, ename, age, dept_no) values(3,'������',25,'a01'); --�μ���ȣ �ߺ� ����
insert into emp(emp_no, ename, age, dept_no) values(4,'���̿�',22,'a04');--����

insert into dept values('a04','������','����');
insert into emp(emp_no, ename, age, dept_no) values(4,'���̿�',25,'a04');


--���ڵ� ����
truncate ���̺��̸�; --��� ���ڵ带 ����(����) : rollback �ȵ�
delete from ���̺��̸�; --��� ���ڵ带 ���� : rollback ����
delete from ���̺��̸� where ���ǽ�; -- ���ǿ� �ش��ϴ� ���ڵ带 ���� 

* from Ű���� ���� �����ϴ�. 

ex) �����ǰ� �ִ� �ڽ� ���ڵ带 �����غ���
delete from emp where emp_no=4; --����

ex) ��������� �θ��ڵ带 �����غ���
delete from dept where dept_no = 'a01'; --�������� 

* �����ϰ� ������ ������ �ڽ� ���ڵ� ���� �����ϰ� �θ� �����Ѵ�
delete emp where dept_no='a01';
delete from dept where dept_no = 'a01'; --��������

--on delete cascade �ɼ� �����ϱ�
drop table emp;
drop table dept;

--dept ���̺� �����Ѵ� - ���� �ִ� ���� �״�� �ٽ� ���� 

-- �ڽ����̺��� emp ���̺��� �ɼ��� �����ؼ� �����غ��� 
create table emp(
    emp_no number(3) constraint emp_no_pk primary key, --�����ȣ
    ename varchar2(20) not null,
    age number(3),
    dept_no char(3) constraint emp_deptno_fk references dept(dept_no) on delete cascade 
);

--���÷��ڵ� �߰�
insert into emp values(1,'����',20,'a01');
insert into emp values(2,'ȿ��',21,'a02');
insert into emp values(3,'����',22,'a01');

-- �θ��ڵ带 �����غ���(�����ǰ� �ִ� ��� ���ڵ� ����)
delete from dept where dept_no='a01';


drop table emp;
--foreign key�� �ǵڿ� �ۼ��ϱ�
create table emp(
    emp_no number(3) constraint emp_no_pk primary key, --�����ȣ
    ename varchar2(20) not null,
    age number(3),
    dept_no char(3) ,
    job varchar2(30) not null,
    constraint emp_deptno_fk foreign key(dept_no) references dept(dept_no) on delete cascade 

);


select * from emp;
select * from dept;

