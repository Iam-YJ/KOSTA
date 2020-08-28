/*
    view : �������̺�
     - ������ �������� ������ �������̺��� ���� ���̺�ó�� ����ϴ� ��
     (select, insert, update, delete�� �����ϴ� - ��, �ɼǿ� ���� DML �ȵ� �� �ִ�.)
     
     1) �������� ����
        : ���̺��� Ư���� �÷��� ���ڵ带 �����ؼ� �並 ����� ���ѿ� ������ �ִ�
            DBA���� ���� ���̺��� �ƴ� ���� ������ �����Ѵ�. 
            
     2) ������ ������ �ܼ�ȭ 
        : JOIN �Ǵ� SUBQUERY ���� �� ������ ���� ����ϴ� ��� VIEW�� ����
          ����ϸ� VIEW�� �̸����� ������ ������ ���̺�ó�� �ܼ�ȭ�ؼ� ����� �� �ִ�.
     
     * �� ���� OR ����
     CREATE VIEW OR REPLACE ���̸�
     AS ���̸�;
     
     - �ɼ� ���� 
     1) WITH READ ONLY - �б����� (DML �ȵȴ�)
     2) WITH CHECK OPTION - �並 ���� �� ������ �̿��ؼ� ����� �Ǹ�
                            INSERT �� �� ���ǿ� �ش��ϴ� ������ ����Ϸ��ϸ� ���� �߻� �����ش�. 
*/

--scott ���� ���� 

select * from copy_emp;

drop table copy_emp;


--���̺� ����
create table copy_emp
as select * from emp;

select * from copy_emp;

--�並 �����Ѵ� -- ������ �־�� �並 ���� �� �ִ�.
create or replace view view_emp 
as select * from copy_emp;


--�並 �����Ϸ��� �並 ������ �� �ִ� ���� �ʿ��ϴ� -scott ���� 
--���� �ο��� ���ؼ� system �������� �����Ѵ�
grant create view, create sequence to scott;


--�並 �˻��Ѵ�
select * from view_emp where ename='SMITH';
select * from view_emp order by sal desc;

--�並 ����
delete from view_emp where empno = 7902;

--���̺� �˻�
select * from copy_emp;

--���̺��� ���ڵ� ����
delete from copy_emp where empno=7839;

--��� ������ ���� ���̺��� �ٶ󺸸鼭 CRUD�� �ϰ� �ִ�.
--���̺��� 2���� �ƴ϶� ��������� ���� ���̺��� �ٶ�

-- 1)�������� �������� �並 �����غ���
create or replace view view_emp
as select empno, ename, job, deptno
from copy_emp where deptno=30; --�μ��� 30���� �ֵ鸸 ���̰�

--�� �˻�
select * from view_emp;

--insert �غ���
1) ���̺�
insert into copy_emp(empno, ename, job, sal, hiredate, deptno)
values(9000, 'ȿ��', 'MANAGER',3500, SYSDATE, 30);

insert into copy_emp(empno, ename, job, sal, hiredate, deptno)
values(9000, '�缮', 'MANAGER',3500, SYSDATE, 20);

select * from copy_emp;
select * from view_emp; 

2) view 
insert into view_emp values(9001,'��','SALESMAN',30);

insert into view_emp values(9002,'����','SALESMAN',20);
* 20�� �μ��� �信 ����ϸ� �����Ѵ�. ������ �並 �˻����� �� ��� ����� 20�� ������ �˻����� �ʴ´�.
    �׷��� �並 ����ϴ� DBA���忡���� ��Ȳ������. ���� �̷� ��ȣ�� �κ��� �ذ��ϱ� ���� �並 ������ ��
    ������ �ִٸ� WITH CHECK OPTION�� �����ϴ� ���� �����Ѵ�.
    
--�ٽ� �並 �����غ���. - WITH CHECK OPTION�� �־
create or replace view view_emp
as select empno, ename, job, deptno from copy_emp where deptno=30
with check option;

--�ٽ� ��� ���̺� �����͸� ����غ���.
insert into view_emp values(9000,'��','SALESMAN',10); --����
insert into view_emp values(9001,'���','SALESMAN',20); --����
insert into view_emp values(9002,'����','SALESMAN',30);

select * from copy_emp;

--�信 ���ڵ� ����
delete from view_emp where job='MANAGER';

select * from view_emp;
select * from copy_emp;


--�並 ������ �� �б� �������� 
create or replace view view_emp
as select empno, ename, job, deptno from copy_emp where deptno=30
with read only; --�б� ����


--�信 insert or delete or update�� �غ��� : ����� �ȵȴ�!

insert into view_emp values(9000,'��','SALESMAN',10); --����
update view_emp set empno = 8000;

select * from view_emp;
select * from copy_emp;


2) ������ ������ ��� ���� ����Ѵ�
--
grant create view to jang;

Create Table subEmp(
	emp_id 	   int, --�����ȣ
	emp_name	   Varchar2(20) Not Null,  --����̸�
	job      	               Varchar2(20) Not Null,  --����
	dept_id  	  int, --�μ���ȣ
	sal 	              int Not Null,--�޿�
	bonus	              int,--���ʽ�
	mgr_id	              int,--�����ڹ�ȣ
	hiredate             date  Not Null, --�Ի���
	constraint emp_id_pk Primary Key(emp_id) --��������
);

INSERT INTO subEMP VALUES (6200,'��ö��','��ǥ',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO subEMP VALUES (6311,'�����','����',100, 3500,Null,6200, '1998-12-17');

INSERT INTO subEMP VALUES (7489,'�ε���','������',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO subEMP VALUES (7522,'����ö','������',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO subEMP VALUES (6321,'������','����',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO subEMP VALUES (6351,'������','����',300,   2850,NULL,6200,'2000-05-31');

INSERT INTO subEMP VALUES (7910,'�̿���','�渮',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO subEMP VALUES (6361,'��ö��','����',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO subEMP VALUES (7878,'����','������',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO subEMP VALUES (7854,'������','������',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO subEMP VALUES (7872,'�̹���','�繫��',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO subEMP VALUES (7920,'������','�繫��',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO subEMP VALUES (7901,'������','������',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO subEMP VALUES (7933,'��ö��','�繫��',200,  1050,NULL,6361,'2002-01-02');

drop table subemp;

create or replace view view_emp
as
select * from subEmp
where sal > (select max(avg(sal)) from subEMP
            where dept_id is not null
            group by dept_id);
            
--�� �˻� 
select * from view_emp where emp_id=6321;

--------------------------------------------------------------------
/*
 SEQUENCE : �ڵ����� �� ���� 
    
    :�������
    CREATE SEQUENCE �������̸�
    [START WITH �ʱⰪ]
    [INCREMENT BY ������]
    [MAXVALUE �ִ밪]
    [MINVALUE �ּҰ�]
    [CACHE : NOCACHE]
    [CYCLE : NOCYCLE]
    
    * �����
    �������̸�.NEXTVAL : ����������
    �������̸�.CURRVAL : ���� ������
    
    *������ ����
    ALTER SEQUENCE �������̸�
    
    *������ ����
    DROP SEQUENCE �������̸�
*/

--������ ����
create sequence seq_no nocache;

--������ ���
select seq_no.nextval, seq_no.currval
from dual;

--������ ����
drop sequence seq_no;

--������ �ɼǼ���, ����
create sequence seq_no
start with 10
increment by 5
maxvalue 100
minvalue 5
cycle
nocache;
--nocache ������. ĳ�ø� ���� �ʱ� ������ �׶��׶����� �ϳ��� �����ϸ� �̾ƿ� 
--ĳ�ô� ������� �̸� ��Ƶΰ� ����.. �׷��� ���ڱ� �̻��� �� ������ ���� ������..

select seq_no.nextval, seq_no.currval
from dual;

--���̺� ����
create table board(
    board_no number(4) primary key,
    subject varchar2(30),
    content varchar2(50),
    regdate date
    
);

select * from board;
--���� ����� �� ����� �������� �����Ѵ�
create sequence board_seq_no nocache;

insert into board values(board_seq_no.nextval, '�������','������?',sysdate);
--�� nextval�̳ĸ�,, ���� �ִ� ��ȣ���� �ϳ��� �������Ѽ� �ֱ� ���� 

--���⼭ board_seq_no �ϸ� ��������.. seq���� ������ ���ڷ� �������� ���°ɱ�

-- ++ �������� insert into�� ���� �� �����ص� ��ȣ�� �ڵ����� �Ѿ�� ..
--      �ݵ�� �������� �Ѿ��. ������ 1���� 2, 2���� 3.. �̷��� ���� 

------------------------------------------------------------------------
/*
     transaction
        : �������� �۾��� (insert, update, delete)�� �ϳ��� ������ ��� �ѹ��� commit(����) , rollback(���)�ؼ� �ϰ����� �����ϵ��� �ϴ� ��
        : savepotin �̸�; �� �����ϸ� rollback �̸�; �� �̿��ؼ� ���ϴ� ���� �������� ���ó���� �����ϴ� 
*/

commit;

drop table copy_emp;

--���̺� ����
create table copy_emp
as select * from emp;

select * from copy_emp;

commit;
rollback; --��Ʈ��(�ѹ��̳� Ŀ�� ���� ���ĺ���) �ѹ��� �ѹ�ȴ�. 

--���ڵ� ����
delete from copy_emp where job='MANAGER';

--���ڵ� ���
insert into copy_emp(empno, ename, job, sal) values(9000, 'ȿ��','TEACHER',2500);

--���ڵ� ����
update copy_emp set hiredate=sysdate, sal=500 where deptno=30;

--���
rollback;

savepoint A;
delete from copy_emp where job='MANAGER';
insert into copy_emp(empno, ename, job, sal) values(9000, 'ȿ��','TEACHER',2500);

savepoint B;
update copy_emp set hiredate=sysdate, sal=500 where deptno=30;
insert into copy_emp(empno, ename, job, sal) values(9005, '��','TEACHER',2500);
insert into copy_emp(empno, ename, job, sal) values(9006, '�缮','TEACHER',2500);

savepoint C;
delete from copy_emp where deptno=20;

--���
rollback to B;

--����Ϸ�
COMMIT;

select * from copy_emp;
----------------------------------------------------------------------
--���� JANG �������� SCOTT ������ ���̺� �����غ���
SELECT * FROM SCOTT.SALGRADE; --���� ������ �ٸ� ������ ���̺��� �����Ϸ��� ���� �ο�(������ OR �ְ�����ڰ�)�ؾ��Ѵ�.

--SYSTEM ���� �����ؼ� ���� �ο��Ѵ�
 GRANT ALL ON SCOTT.SALGRADE TO JANG; 

-- SYSTEM���� �����ؼ� ���� �����Ѵ� 
REVOKE ALL ON SCOTT.SALGRADE FROM JANG;

