--��������
/*
 3) unique
    : �ߺ��ȵ�, null �����(not null �����ϸ� pk�� ����) - �ĺ�Ű �߿� ��ǥŰ�� �� �� ���� �÷��� ����
    : �ϳ��� ���̺� ������ �÷��� ���� ����
    : ��ǥŰ�� �� �� ������ �����ؾ��ϴ� �÷��� �����Ѵ�
 4) check
    : ������ �����ؼ� ���ǿ� �ش��ϴ� �� �̿ܿ��� insert �� �� ������ �ϴ� ��
 5) default
    : �⺻�� ����
    : insert �� �� ���� ���� ������ �ڵ����� default ���� insert �ȴ�.
    ex) �����, ���� ��ȸ��, 

*/

--���̺� ����
create table test(
    id varchar2(20) primary key,
    jumin char(13) unique, --null ���
    age number(2) check(age >= 10 and age <= 20),
    addr varchar2(20) check(addr = '����' or addr='�뱸' or addr='����'),
    gender char(6) default '����'
    
);

select * from test;

-- ���ڵ� ���
insert into test values('jang','111',12,'����',default);
insert into test(id,jumin,age) values('hee','2222',12); --null ������ default �����Ǹ� �ڵ����� ä����(gender��)
insert into test(id,jumin, age,gender) values('jung','33333',11,null);
insert into test(id,addr) values('jud��d','�뱸');

--------------------------------------------------------------
--���̺� ����
-- 1) �÷� �߰�
alter table ���̺��̸� add �÷��� ������Ÿ�� [��������], ...
ex) 
alter table test add ( phone varchar2(20), etc varchar2(30) default '��Ÿ');
alter table test add name1 varchar2(20) default '����' not null; --����(�÷��� ������Ÿ�� default not null)
select * from test;
alter table test add aa number(2);

--2) �÷� ����
alter table ���̺��̸� drop column �÷���;
ex)
alter table test drop column phone;
alter table test drop column etc;

select * from test;


--3) ������Ÿ�� ����
alter table ���̺��̸� modify �÷��� ���浥����Ÿ��; 

ex)
alter table test modify iddds varchar2(40);
alter table test modify aa varchar2(40);

desc test;


--4) �÷��̸� ����
alter table ���̺��̸� rename column �������÷��� to ������ �̸�;

ex)
alter table test rename column id to iddds;

select * from test;

--5) �������� �߰�
alter table ���̺��̸� add constraint ��Ī(���������̸�) ��������;

ex)
alter table test add constraint aa_hello_unique unique(aa);
desc test;

--6) �������� ����
alter table ���̺��̸� drop constraint ��Ī;

ex)
alter table test drop constraint aa_hello_unique;
desc test;


--7) ���̺� ����
drop table ���̺��̸�

ex)
drop table test;
select * from test;

------------------------------------------------------------------------------

--���̺� ���� : ���������� ���� �ȵ� 
/*
 create table ���̺��̸�
 as ������ ���̺� ����;
*/

ex) soctt ������ �ִ� emp ���̺� �����ϱ� - ���� scott ����
select * from emp;

1) ��� ���ڵ�, ��� �÷� �����ϱ� - �� ���������� ���� �ȵ� 
-> �������� �߰� 
create table copy_emp
as select * from emp;

alter table copy_emp add constraint copy_emp_pk primary key(empno); -- ������ �ߺ��� ���� not null�̿��� pk �߰� ����
alter table copy_emp add constraint copy_emp_f foreign key(deptno) references dept(deptno);

2) Ư�� �÷���(project) Ư�� ���ڵ常(selection)�� �����ϱ�
create table copy_emp2
as select empno, ename, job, sal from emp where sal >=3000 ;

select * from copy_emp2;

3) ���̺� ������ �����ϱ�
create table copy_emp3
as select * from emp where 1=0;

select * from copy_emp3;


--DML �۾� (insert, update , delete)
/*
 : ��Ȳ�� ���� commit or rollback �����ϴ� - transaction �̿�
*/

-- insert : ���ڵ� ����
insert into ���̺��̸�(�÷���,..) values(��,..);
insert into ���̺��̸� values(��,..); - ��� �÷��� ������� ���� ���� 
 
-- update : ���ڵ� ����
update ���̺��̸�
set �÷��� = ���氪, �÷��� = ���氪, ...
[ where ���ǽ� ] ;

-- delete : ���ڵ� ����
delete [from] ���̺��̸�
[where ���ǽ�] ;

-- copy_emp ���̺�� �ǽ��Ѵ�

ex) empno�� 7654�� ����� ename�� 'hee', job�� '����', sal�� 3500���� �����ϼ���
update copy_emp
set ename = 'hee', job = '����', sal=3500
where empno = 7654;

select * from copy_emp;

ex) sal�� 1000~2000 ������ ����� �޿��� 3000, �Ի����� ���糯¥�� ����
update copy_emp
set sal=3000, hiredate = sysdate
where sal>=1000 and sal <= 2000;
--where sal between 1000 and 2000;

select * from copy_emp order by sal;

ex) deptno�� 20�̸鼭 job�� salesman�� ����� comm�� 1000���� �����ϼ���.
update copy_emp
set comm=1000
where deptno=20 and job='SALESMAN';
--where lower(job) = lower('SalESMan');

select * from copy_emp;


ex) empno�� 7782�� 7844�� ����� �����ϼ���.

delete from copy_emp
where empno=7782 or empno=7844; --2�� �����ؾ��ؼ� .. ��ȣ or�� ��ȣ�� and �̸� ���� ���� ���� 

select * from copy_emp;


ex) ��� 2�� ����ϱ�
insert into copy_emp(empno, ename, job) values(1111,'YJ','���');
insert into copy_emp(empno, ename, job) values(1112,'YJ','���');

select * from copy_emp;

---------------------------------------------------------------------------
--DQL ���� : select ��
/*
    select distinct | * | �÷��� as ��Ī,... - ��(�Ӽ�) ���ѵδ� �� - projection(���� �����ϴ� ��)
    from ���̺� �̸� 
    [where ���ǽ�] - ���ڵ�(Ʃ��) ���� - selection 
    [order by ���Ĵ���÷� asc | desc, ���Ĵ���÷� asc | desc ]
    
    --�������
    from -> where -> select -> order by
*/

select * from emp;

1) ���ϴ� �÷��� ��Ī �����
select empno, ename as �̸� , job as "������", sal �޿� from emp;

2) �ߺ��� ����(distinct)
select distinct empno, job from emp;

ex) �츮 ������ ����(job) ������ �˰� �ʹ�
select job from emp; 
select distinct job from emp;

ex)�޿��� 2000�̻��� ��� �˻�
select *
from emp
where sal >= 2000; --selection ���ڵ� ���� 

ex) �޿��� 2000�̻��� ��� �˻��ϰ� �޿��� �������� ��������
select * from emp where sal > 2000 order by sal; -�ø�����`
select * from emp where sal > 2000 order by sal desc; --��������

ex) job�� �������� ���������ϰ� ������, �޿��� �������� �ø����� ����
select * from emp order by job desc, sal;

------------------------------------------------------
/*
- ������ ����
1) ��� ������
 : +, -, *, /, mod(��, ������) - ������
2) ���� ������
 : >, <, >=, <=, !=, = 
3) �񱳿�����
 - and
 - or
 - between �ּҰ� and �ִ밪 
    : �ϳ��� �÷��� �������� �ּ� ~ �ִ� ������ �������� ����� �� and �����ں��� ���ϴ�    
 - �÷��� in(��, ��..)
    : �ϳ��� �÷��� �������� ���� or �����ڷ� ���ϰ��� �� �� or �����ں��� ���ϴ� .
 - like 
    : ���ϵ�ī�幮�� (_, %)�� �Բ� ����ϸ� ������ �߿� Ư���� ���ڸ� ������ 
      ���ڵ带 �˻��� �� ����Ѵ�.
       * 1) _ : �� ����
            % : 0�� �̻��� ����
             
            ex) job like 'j%' - job�� j�� �����ϴ� ���ڿ��� �˻�
                job like '%j%' - job�� j��� ���ڸ� �����ϰ� �ִ� ���ڵ� 
                job like '___' - 3���ڸ� �˻� 
                job like 'A_B%' - 

*/

ex) ���������
select empno, ename, sal, comm, sal + comm 
from emp; -- null�� �����ϰ� ������ ��������� ���� �ȵ� 

* null���� ã�Ƽ� ���ϴ� ������ �����ϰ� ������ �Ѵ�. - nvl(��, ���氪 )�Լ� �̿��Ѵ�.
select comm, nvl(comm,100) from emp;

select empno, ename, sal, comm , (sal + nvl(comm, 0))*12 as ���� 
from emp;

ex) ~�� ������ ~�Դϴ�. 
select ename || '�� ������ ' || sal || '�Դϴ�.' as "���� �ϱ�"
from emp;

ex) sal�� 200 ~ 4000 ������ ���ڵ� �˻�
-- and 
    select * from emp 
    where sal >= 2000 and sal <=4000;
    order by sal;
    
ex) sal�� 200 ~ 4000 ������ ���ڵ� �˻�
    *���� ������ �տ� not�� ���̸� �ݴ� 
    select * from emp 
    where not(sal >= 2000 and sal <=4000)
    order by sal;

-- between and 
    select * from emp where sal between 2000 and 4000 order by sal;
    select * from emp where sal not between 2000 and 4000 order by sal;
    

ex) empno�� 7499, 7566, 7782, 7839 �� ���ڵ� �˻�
--or
select * from emp where empno=7499 or empno=7566 or empno=7782 or empno=7830 ;
select * from emp where not (empno=7499 or empno=7566 or empno=7782 or empno=7830) ;

--in
select * from emp where empno in (7499,7566, 7782, 7839);
select * from emp where empno not in (7499,7566, 7782, 7839);


--like ������

                
ex) job�� 'A'�� �����ϴ� ���ڵ� �˻�
select * from emp where job like 'A%';

select * from emp where job = 'A%';  -- �˻��ȵ� 
select * from emp where upper(job) like upper('a%');
select * from emp where upper(job) not like upper('a%');

ex) job�� ���� N���� ������ ���ڵ� �˻�
select * from emp where job like '%N';

ex) ename�� 4������ ���ڵ� �˻�
select * from emp where ename like '____';

ex) ename�� a���ڰ� ���� ���ڵ� �˻� 
select * from emp where ename like '%A%';

ex) ename�� ��ü���ڴ� 5�����̰� ù���ڴ� A�� ���ڵ� �˻�
select * from emp where ename like 'A____';


/*
 - ANY : �ϳ��� �����ϸ� TRUE
    �÷��� < ANY  (100, 200, 300) - �ִ밪(300)���� ������ TRUE
    �÷��� > ANY  (100, 200, 300) - �ּҰ�(100)���� ũ�� TRUE
    
- ALL : ��� �����ؾ߸� true
    �÷��� < ANY  (100, 200, 300) - �ּҰ�(100)���� ������ TRUE
    �÷��� > ANY  (100, 200, 300) - �ִ밪(300)���� ũ�� TRUE
*/

select * from emp ; 
select * from emp where sal < any (1000,2000,3000) order by sal; - 3000���� ������ 
select * from emp where sal > any (1000,2000,3000) order by sal; - 1000���� ũ��

select * from emp where sal < all (1000,2000,3000) order by sal; - 1000���� ������ 
select * from emp where sal > all (1000,2000,3000) order by sal; - 3000���� ũ��

-- deptno(�μ���ȣ)�� 30�� ����� �� �޿����� ���� �޴� ��� �˻�
1) 30�� �μ��� ������� �޿�
select sal from emp where deptno=30 ;

2) 1)�� �������� ����ؼ� �˻�
select * from emp where sal > all(select sal from emp where deptno=30);

-- deptno(�μ���ȣ)�� 30�� ����� �� �޿����� ���� �޴� ��� �˻� 
select * from emp where sal < all(select sal from emp where deptno=30);

-----------------------------------------------------------------------
/*
--null �� ã��

1) is null

2) is not null
*/

select * from emp;
ex) comm�� null�� ���ڵ� �˻��ϱ�
 select * from emp where comm is null;
 
ex) comm�� null�� �ƴ� ���ڵ� �˻��ϱ�
 select * from emp where comm is not null;
 
 -------------------------------------------------
 
 /*
  1) �����Լ�
  - sum() : ����
  - avg() : ���
  - min() : �ּҰ�
  - max() : �ִ밪
  - count(�÷���) : null�� ������ ��ü ���ڵ� �� 
  - count(*) : null�� ������ ��ü ���ڵ� �� 
 */
 
 ex) �������̺� ����
 create table sungjuck(
    name varchar(20) primary key,
    ban number(1),
    kor number(3) check( kor between 0 and 100),
    eng number(3) check( eng between 0 and 100),
    math number(3) check( math between 0 and 100)
 );

--���� ���ڵ� �߰� 
insert into sungjuck values('ȿ��',1,80,90,33);
insert into sungjuck values('��ȿ',1,80,30,100);
insert into sungjuck values('ȿȿ',1,50,10,77);

insert into sungjuck values('����',2,55,90,22);
insert into sungjuck values('����',2,80,90,90);

insert into sungjuck values('��'  ,3,80,30,100);
insert into sungjuck values('����',3,20,15,100);
insert into sungjuck values('�ʹ�',3,56,99,100);
insert into sungjuck values('��'  ,3,null,99,100);

select * from sungjuck;

ex) �� ���κ� ����, ��� ���Ѵ� 
select name, ban, kor, eng, math,
(nvl(kor,0)+nvl(eng,0)+nvl(math,0)) as ����,
round((nvl(kor,0)+nvl(eng,0)+nvl(math,0))/ 3,0) as ���
from sungjuck;


ex) ���������� ����, ��� , ���ڵ� ��, �ִ밪, �ּҰ�..
select sum(kor) ����, avg(kor), round(avg(nvl(kor,0)),0), count(kor), count(*),
max(kor), min(nvl(kor,0))
from sungjuck;

select name, sum(kor) ����, avg(kor)
from sungjuck; --�Ϲ��÷��� �����Լ��� �Բ� ����� �� ����. ��, group by ������ ��밡���� 

ex) �� �ݺ� ������ ����, ���, �ִ�, �ּ� ���ϱ�
select ban , sum(kor), avg(kor), max(kor), min(kor)
from sungjuck
group by ban; -- �� �ݺ� �׷��� ���� �׷캰 �����Լ��� �����
              -- group by ���� ���� �÷��� select������ ����� �� �ִ�.

              
ex) kor ������ 70 �̻��� �л����� �ݺ� ����, ��� ���Ѵ�.
select ban, sum(kor), avg(kor)
from sungjuck
where kor >= 70
group by ban;

ex) kor ����� 70 �̻��� �л����� �ݺ� ����, ��� ���Ѵ�.
select ban, sum(kor), avg(kor)
from sungjuck
where avg(kor) >= 70 -- �����Լ��� where���� �� �� ���� (������� ������) <����!!>
group by ban;


select ban, sum(kor), avg(kor)
from sungjuck
group by ban
having avg(kor) > = 70;


-----------------------------------------------------------------------
--select����
select (5)
from (1)
where  (2)
group by (3)
having  (4)
order by (6)



select * from sungjuck;
