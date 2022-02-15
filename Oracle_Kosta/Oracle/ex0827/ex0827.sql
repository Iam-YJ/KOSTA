/*
 join 
  : �ѹ��� select �������� 2�� �̻��� ���̺� �ִ� �÷��� ������ �˻��ϰ��� �� �� ����Ѵ�. 
  : join�� ����
  1) inner join = EQ JOIN = �������� = natural join
  2) left join
    - left outer join
    - right outer join
    - full outer join
  3) self join
  
  :join�� �ڵ��ϴ� ���
  1) SQL JOIN ��� : FULL OUTER JOIN�� �������� ���� 
  2) ANSI JOIN ��� : ǥ���̱� ������ ����

*/

select * from emp;
select * from dept;

ex) smith ����� job, dname, log �˻��ϰ� �ʹ� -> join �ʿ��ϴ�

--���̺� ����
create table test1(
 id varchar2(3) primary key,
 name varchar2(20),
 addr varchar2(30)
);

--���õ����� �߰�
insert into test1 values(1,'����','����');
insert into test1 values(2,'����','�뱸');
insert into test1 values(3,'ȿ��','���ֵ�');
insert into test1 values(4,'����','�λ�');
insert into test1 values(5,'����','����');

select * from test1;

create table test2(
 code char(3) primary key,
 id varchar2(3) references test1(id),
 job varchar2(30),
 sal number(3)
);

--���ڵ� ���
insert into test2 values('A01',1,'����',400);
insert into test2 values('A02',3,'���',500);
insert into test2 values('A03',5,'���׿��',300);
insert into test2 values('A04',NULL,'����',700);


select * from test1;
select * from test2;

ex) id, name, addr, job, sal ���� �˻��ϰ� �ʹ�.
1) INNER JOIN = EQ JOIN = ��������
    -SQL ���� ���
    select test1.id, name, addr, job, sal
    from test1, test2
    where test1.id = test2.id;
    
--���̺��̸��� ��Ī �����
    select t1.id, name, addr, job, sal
    from test1 t1, test2 t2 -- ���̺� �̸��� ��Ī 
    where t1.id = t2.id;

--��� �÷� �˻��ϱ�
   select *
    from test1 t1, test2 t2 -- ���̺� �̸��� ��Ī 
    where t1.id = t2.id;


-- ANSI ���� ��� - ���� 
    select test1.id, name, addr, job, sal
    from test1 inner join test2 --inner �ܾ�� ���������ϴ�
    on test1.id = test2.id;
    
--���̺� ��Ī �����
    select t1.id, name, addr, job, sal
    from test1 t1 inner join test2 t2--inner �ܾ�� ���������ϴ�
    on t1.id = t2.id; --pk�� �����÷�(fk)�� �̸��� �ٸ� �� �� �ʿ��ϴ� 

* �� ������ using()���� �����ϱ�
    select id, name, addr, job, sal
    from test1 inner join test2 --inner �ܾ�� ���������ϴ�
    using(id); --pk�� �����÷�(fk)�� �Ӽ����� ���� �� ����Ѵ� 
    
        * using�� ����� �� �÷��� ��Ī�� ����� �� ����. 

* ��� �÷� �˻�
    select *
    from test1 t1 join test2 t2 --inner �ܾ�� ���������ϴ�
    on t1.id = t2.id;
    
    select *
    from test1 t1 join test2 t2 --inner �ܾ�� ���������ϴ�
    using(id);  

* natural join : inner join ���� �� �κ����� 
    select *
    from test1 natural join test2--inner �ܾ�� ���������ϴ�
    
    * on�� or using()�� ����� �� ����.
    * ���ʿ� ���� �Ӽ��� ������� ��� �����ϴ�
    
ex)
    create table copy_test1
    as select * from test1;
 
    select * from copy_test1;
    
    alter table copy_test1 add phone varchar2(20) default '1111';
    
    -- inner join + on
          -- ����Ǵ� ���� 2���� ���� 
        select * 
        from test1 inner join copy_test1
        on test1.id = copy_test1.id;
        
    -- inner join + using()
         --using�� �� �͸� 1�� ������ �������� �� ����
        select * 
        from test1 inner join copy_test1
        using(id);
    
    -- natural join
         -- ����Ǵ� ���� 1������ ���� 
        select * 
        from test1 natural join copy_test1;
        
--���ϴ� �÷� ����
    select test1.id, name, addr, job, sal
    from test1 inner join test2
    on test1.id = test2.id;

------------------------------------------------------
--outer join
1) left outer join
2) right outer join
3) full outer join

-- SQL ���� ��� �ڵ� --full ���� �����ȵ�
    select * 
    from test1, test2
    where test1.id = test2.id(+); --left join
    --�����Ѱ� �� ������, Ư���� ���ڵ忡 �ִ� ���� �� �����ش�..
    
    select * 
    from test1, test2
    where test1.id(+) = test2.id; --right join

-- ANSI ���� ��� �ڵ� 
    select *
    from test1 left outer join test2 --left outer join
    using(id);

    select *
    from test1 right outer join test2 --right outer join
    using(id);
    --test2�� �� ���´� 
    
    select *
    from test1 full outer join test2 --full outer join 
    using(id);
    --outer �� ��� ���� 
    
    
    * 3�� ���̺� �����ϱ�
    select * from test2;
    
    create table test3(
        code char(3) primary key references test2(code), --pk, fk ���� ����
        manager_name varchar2(20)
    );
   
    insert into test3 values('A01','�����');
    insert into test3 values('A02','�����');
    insert into test3 values('A03','���缮');
    
    ex) id, name, job, sal, manager_name �˻� 
   
    --SQL ���� ��� 
    select test1.id, name, job, sal, manager_name
    from test1, test2, test3
    where test1.id=test2.id and test2.code=test3.code;

    select *
    from test1, test2, test3
    where test1.id=test2.id and test2.code=test3.code;
    
    -- ANSI ���� ��� --ON, USING
    select test1.id, name, job, sal, manager_name
    from test1 join test2
    on test1.id = test2.id join test3
    on test2.code = test3.code;
    
        --using
    select id, name, job, sal, manager_name
    from test1 join test2
    using(id) join test3 using(code);
   
 --------------------------------------------------------------------
 --self join
    : �ڽ� ���̺��� �ΰ��� ���� �����ϴ� ��
    : ����� ������ �� ����Ѵ� - �ϳ��� ���̺��� �ϹݼӼ��� �ڽ����̺��� pk�� �����ϴ� �� 
    
--scott �������� ���� 
select * from emp;

ex) � ����� ������ �� ����� �����ϴ� �������� ������ �˻��ϰ� �ʹ�

select e1.ename ����̸�, e1.mgr �����ڹ�ȣ, e2.ename �������̸� 
from emp e1 join emp e2 --e1�� ���, e2�� ���������̺� 
on  e1.mgr = e2.empno;


-------------------------------------------------------------------
--join �ǽ�
SELECT * FROM emp;
SELECT * FROM dept; --�μ�����
SELECT * FROM salgrade; --�޿����


-- 1. SMITH �� ����  ���� �˻�(ename, emp.deptno, loc .)
    select * 
    from emp join dept 
    using (deptno) --�ߺ��� ���� �߰� x 
    where ename = 'SMITH';

--2. NEW YORK�� �ٹ��ϴ� ����� �̸��� �޿��� ���
    select ename, sal, loc
    from dept inner join emp
    on emp.deptno = dept.deptno
    where dept.loc = 'NEW YORK';

-- 3. ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի��� ���
    select ename, hiredate, dname
    from dept inner join emp
    on dept.deptno = emp.deptno
    where dept.dname = 'ACCOUNTING';

-- 4. ������ MANAGER�� ����� �̸�, �μ��� ���
    select ename, dept.dname, job
    from dept join emp
    on dept.deptno = emp.deptno
    where emp.job='MANAGER';
    

-- 5. ����� �޿��� �� ��������� �˻�
-- between A and B
select * from salgrade;
select * from emp;

SELECT EMPNO, ENAME, SAL, GRADE, LOSAL, HISAL
 FROM EMP JOIN salgrade
 ON SAL BETWEEN LOSAL AND HISAL;
 

--6. ��� ���̺��� �μ� ��ȣ�� �μ� ���̺��� �����ؼ� �μ���, �޿� ��޵� �˻�

    select dname, grade
    from emp join salgrade
    on sal between losal and hisal join dept
    on emp.deptno = dept.deptno;
    
    /*
    select dname, grade
    from emp join empt using(deptno) join salgrade on sal between losal and hisal ;
    */
    

--7. SMITH�� �޴���(mgr) �̸�(ename) �˻�
    'SMITH�� �����ڴ� ~ �Դϴ�'
    
    select e1.ename||'�� �����ڴ� ' ||  e2.ename || '�Դϴ�'
    from emp e1 join emp e2 --e1�� ���, e2�� ���������̺� 
    on  e1.mgr = e2.empno
    where e1.ename = 'SMITH';

--8. �����ڰ� KING�� ������� �̸��� ����(job) �˻�
    select e1.ename ���, e2.ename �������̸� , e1.job ����
    from emp e1 join emp e2
    on e1.mgr = e2.empno
    where e2.ename = 'KING';

--9. SMITH �� ������ �μ���ȣ(DEPTNO)���� �ٹ��ϴ� ����� �̸� ���
-- ��, SMITH ������ ���� ��� �Ұ�
    
    select E1.ENAME, E1.DEPTNO , E2.ENAME
    from emp e1 join emp e2
    on e1.deptno = e2.deptno
    WHERE not e1.ename ='SMITH' and e2.ename = 'SMITH';

10. SMITH �� ������ �ٹ���(LOC)���� �ٹ��ϴ� ����� �̸� ���
-- ��, SMITH ������ ���� ��� �Ұ�

    /*
    select emp.ename, dept.loc
    from emp join dept
    on emp.deptno = dept.deptno
    where  emp.ename= 'SMITH' and emp.deptno = dept.deptno;
    */ -- ����
    
    --�����Բ�
    select e1.ename, d1.loc, e2.ename, d2.loc
    from (emp e1 join dept d1 on e1.deptno = d1.deptno)
    join (emp e2 join dept d2 on e2.deptno = d2.deptno )
    on d1.loc = d2.loc;
    --where e1.ename='SMITH' AND E2.ENAME!='SMITH';
    
    select e1.ename, d1.loc, e2.ename, d2.loc
    from (emp e2 join dept d2 on e2.deptno = d2.deptno );
    
-- 11, �����, �ش� �ϴ� �޴����� �˻�
-- �ݵ�� ��� �����(CEO����) ���� �˻�
-- CEO�� ��� �޴��� ���� null
    select e1.ename, e2.ename
    from emp e1 join emp e2 --e1�� ���, e2�� ������
    on e1.mgr = e2.empno;
    
    ----------------------------------------------------------------------
   /*
    -set ���� 
    
    1) ������
        - UNION : �ߺ����� �����ϰ� ��ģ��
        - UNION ALL : �ߺ����� �����ؼ� ��ģ��
    2) ������
        - INTERSECT : A�� B�� ���� ���ڵ带 �˻��Ѵ�
    3) ������
        - MINUS : A MINUS B �̸� A���� B�� �� ������ ���ڵ� �˻��Ѵ� 
*/
    select * from emp;
    
    --���̺� ����
    create table set_emp 
    as select empno, ename, job, sal
    from emp 
    where deptno = 20;
    
    select * from set_emp;
    insert into set_emp values(8000,'HEE','MANAGER',2500);
    insert into set_emp values(8001,'KING','TEACHER',3000);
    
    --������ : UNION
    select empno, ename, job, sal from emp
    union select empno, ename, job, sal from set_emp;
    
    select empno, ename, job, sal from emp
    union all select empno, ename, job, sal from set_emp;
    
    --������
    select empno, ename, job, sal from emp
    minus select empno, ename, job, sal from set_emp;
    -- ���� ���ſ��� ���߿� ���� ��
    
    select empno, ename, job, sal from set_emp
    minus select empno, ename, job, sal from emp;
    
----------------------------------------------------------
/*
    SUBQUERY : ������
    - ���� �����ȿ��� �Ǵٸ� �������� �����ϴ� ��
    - �ݵ�� ��ȣ�� ���� ��ȣ�ȿ� �ִ� ��� ���� ����� �Ŀ� �� ����� ������ ���ο� Ȱ���Ѵ�
    - ���������� ��� ���ڵ尡 �Ѱ��� ���� >, <, >=, <=, !=, =�� ����Ѵ�.
    - ���������� ������ڵ尡 2�� �̻��� ���� ,IN, ANY, ALL�� �̿��Ѵ�
    - �ַ� SELECT������ ���� ��������� INSERT, UPDATE, DELETE������ ����Ѵ�.
*/

ex) emp ���̺��� ��ձ޿����� ���� �޴� ����� ���� �˻�
    1) ��� �޿��� ���Ѵ�
        select avg(sal) from emp;
    
    2) 1)���� ���� ����� ������ �������� ����Ѵ�
        select * from emp where sal > 2077;
    
    * ���� 2������ �ѹ������� ���������� �ذ��Ѵ� 
        select * from emp where sal > (select avg(sal) from emp);
        
ex) job�� 'A' ���ڿ��� �� ����� �μ��� ���� ������ �ٹ��ϴ� ����� �μ��̸�(DNAME)�� �˻��Ѵ� 
    
    1) JOB�� 'A'���ڿ��� �� ����� �μ���ȣ�� �˻��ϴ�
        select distinct deptno from emp where job like '%A%';
    
    2) 1)�� �ִ� ������ �������� ����Ͽ� dname�� ���Ѵ� 
        
        select dname from dept
        where deptno in (10,20,30);
        
        select dname from dept
        where deptno in (select distinct deptno from emp where job like '%A%');
        
ex) �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޿����� �� ���� �޴� ����� ������ ���Ѵ� - �ִ밪���� ����

    1) 30�� �μ��� �ִ� �޿��� ���Ѵ�
        select max(sal) from emp where deptno=30;
    
    2) 1)�� �������� ����Ѵ�.
        select * from emp where sal > (select max(sal) from emp where deptno=30); --��������� 1�� 
        
    -------------------------------------------------------------
    1) 30�μ��� �޿� ���Ѵ�
        select sal from emp where deptno=30;
    
    2) 1)�� �������� ����Ѵ� 
        select * from emp where sal > all (select sal from emp where deptno=30); --��������� ������ 

        
ex) �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޿����� �� ���� �޴� ����� ������ ���Ѵ� -- �ּҰ����� ����
    
    1) 
    select sal from emp where deptno=30;
    
    2) 
    select * from emp where sal > any (select sal from emp where deptno=30);
    
---------------------------------------------------------------------------------
create table sub_emp
as select * from emp where 1=0; --���ڵ�� �������� ���� ������ ������ 

select * from sub_emp;

-- subquery �� �̿��� insert
insert into sub_emp (select * from emp where job = 'MANAGER');

*Ư�� �÷��� �����ؼ� INSERT �ϰ� �ʹ�
insert into sub_emp(empno, ename, job,sal)
(select empno, ename, job, sal from emp where sal < 2000);


-- subquery�� �̿��� update
ex) empno�� 7499�� ��� �޿��� ��� �޿��� �����Ѵ�
update sub_emp set sal = (select avg(sal) from sub_emp) where empno = 7499;

ex) empno�� 7782�� ����� job, sal, comm�� �����Ѵ�
: �����ϴ� ���� emp ���̺��� empno�� 7839�� ��� ������ �����ͼ� �� ������ �����Ѵ�

update sub_emp set (job, sal, comm) = (select job, sal, comm from emp where empno=7839) where empno=7782;


-- subquery �� �̿��� delete
ex) sub_emp�� ��� �޿����� ���� �޴� ����� ��� �����Ѵ�

delete from sub_emp
where sal > (select avg(sal) from sub_emp);

----------------------------------------------------------

--�ζ��� �� : from�� �ڿ� ���������� ���� ���¸� �ζ��� ���� �Ѵ� 
* ROWNUM : ���ȣ �ڵ����� ����� �ش�

SELECT ROWNUM ��ȣ , EMPNO, ENAME, JOB, SAL FROM EMP
ORDER BY SAL DESC;


- ���� SAL�� �������� �����Ѵ�.
    select * from emp order by sal desc;

- ���ĵ� ���̺��� ������ ROWNUM�� �����.
    select rownum, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc);


--rownum�� 3���� ���� ���ڵ� �˻�
    select rownum, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc)
    where rownum < 3;
    --rownum�� �׶��׶� �ڵ����� �ο��ȴ�. -> where���� �������� ����ʿ� ���� -> �̹� �����Ǿ��ִ� 3 ���ϸ� (1,2)�� ������ �Ǵ� ���̴� 
    
     select  empno, ename, job, sal, mgr
    from (select * from emp order by sal desc)
    where rownum < 3;
    --rownum�� ������ ���� �� �ؿ� �ڵ����� ����ִ� 

--rownum�� 3���� ū ���ڵ� �˻�
    select rownum, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc)
    where rownum > 3; --����� �ȳ��´� 
    
* ���� ������ �����Ϸ��� �ζ��κ並 �� ����Ѵ�
select * from (
    select rownum ��ȣ, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc))
    where ��ȣ> 3;
    
    
    * ��ȣ 5~7�� ��� �˻�
    select * from 
    (select rownum ��ȣ, empno, ename, job, sal, mgr
    from(select * from emp order by sal desc))
    where ��ȣ between 5 and 7;