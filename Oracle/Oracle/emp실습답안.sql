select * from emp;

 -- 1
  select emp_name, (sal+100)*12 ��� from emp;
  
  -- 2
  select emp_name,job,dept_id from emp where job='������';
  
  -- 3
select * from emp where hiredate='2001��12��3��'; --���x

select * from emp where hiredate='2001-12-3';

select * from emp 
  where 
  to_char(hiredate,'yyyy')||'��'|| 
  to_char(hiredate,'MM')||'��' || 
  to_char(hiredate,'DD')||'��' = '2001��12��03��';
  
  
  select * from emp where to_char(hiredate,'yyyy-mm-dd')='2001-12-03';
  
 select HIREDATE, TO_CHAR(HIREDATE,'YYYY"��"MM"��"DD"��"') from emp ;
    
    SELECT  * FROM EMP
    WHERE TO_CHAR(HIREDATE,'YYYY"��"MM"��"DD"��"')='2001��12��03��';
   
 
  
  select  hiredate , to_char(hiredate,'yyyy-mm-dd HH:MI:SS') from emp ;
  
  select sysdate,to_char(sysdate,'yyyy-mm-dd HH:MI:SS')
  from dual where sysdate='2017-02-27';
  
  
  -- 4
  select emp_name,job,hiredate,dept_id from emp where dept_id=200;
  
  -- 5
  select emp_name,sal from emp where sal between 3000 and 5000;
  
  -- 6
  select emp_id,mgr_id,emp_name,dept_id from emp
  where mgr_id in(6311,6361,6351);
  
  -- 7
  select * from emp where job='�繫��' or job='�渮';
  
  select * from emp where job in('�繫��','�渮');
  
  -- 8
  select * from emp where  sal>=3000 and job='����';
  
  -- 9
  select * from emp where job not in('������','�繫��');
  
  select * from emp where  (job !='������'and job!='�繫��')
  
  
  -- 10
  select * from emp where sal not between 1500 and 2500;
  
  -- 11
  select * from emp 
  where job in('�渮','����') and sal >=3000 
  order by hiredate ;
 
  -- 12
  select * from emp 
  order by dept_id , sal desc;

  -- 13
  select * from emp 
  where bonus is not null and hiredate >= '2000-1-01';
  
  
  select * from emp 
  where bonus is not null and to_char(hiredate,'yyyy') >= '2000';

  -- 14
  select * from emp where emp_name like '��_��';
  
  
  -- 15
  select bonus, nvl(bonus,0) from emp;
  
  
  update emp set bonus = nvl(bonus,0) ;
  
  
  update emp 
  set bonus=0 
  where bonus is null ;
  

  -- 16
  update emp 
  set emp_name='�嵿��',sal=3500 
  where job like '%��' and sal between 2000 and 3000;
  
  -- 17
  delete from emp where emp_name like '%ö%' and job='����';

  delete  emp where emp_name like '%ö%' and job='����';
  
  
  -- 18
  drop table emp; --
  
  --DDL : CREATE ,ALTER ,DROP  --ROLLBACK�ȵ�
  --DML : INSERT ,UPDATE ,DELETE - ROLLBACK����
  
  
  
  