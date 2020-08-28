select * from emp;

 -- 1
  select emp_name, (sal+100)*12 년봉 from emp;
  
  -- 2
  select emp_name,job,dept_id from emp where job='세일즈';
  
  -- 3
select * from emp where hiredate='2001년12월3일'; --결과x

select * from emp where hiredate='2001-12-3';

select * from emp 
  where 
  to_char(hiredate,'yyyy')||'년'|| 
  to_char(hiredate,'MM')||'월' || 
  to_char(hiredate,'DD')||'일' = '2001년12월03일';
  
  
  select * from emp where to_char(hiredate,'yyyy-mm-dd')='2001-12-03';
  
 select HIREDATE, TO_CHAR(HIREDATE,'YYYY"년"MM"월"DD"일"') from emp ;
    
    SELECT  * FROM EMP
    WHERE TO_CHAR(HIREDATE,'YYYY"년"MM"월"DD"일"')='2001년12월03일';
   
 
  
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
  select * from emp where job='사무직' or job='경리';
  
  select * from emp where job in('사무직','경리');
  
  -- 8
  select * from emp where  sal>=3000 and job='부장';
  
  -- 9
  select * from emp where job not in('세일즈','사무직');
  
  select * from emp where  (job !='세일즈'and job!='사무직')
  
  
  -- 10
  select * from emp where sal not between 1500 and 2500;
  
  -- 11
  select * from emp 
  where job in('경리','부장') and sal >=3000 
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
  select * from emp where emp_name like '박_수';
  
  
  -- 15
  select bonus, nvl(bonus,0) from emp;
  
  
  update emp set bonus = nvl(bonus,0) ;
  
  
  update emp 
  set bonus=0 
  where bonus is null ;
  

  -- 16
  update emp 
  set emp_name='장동건',sal=3500 
  where job like '%직' and sal between 2000 and 3000;
  
  -- 17
  delete from emp where emp_name like '%철%' and job='부장';

  delete  emp where emp_name like '%철%' and job='부장';
  
  
  -- 18
  drop table emp; --
  
  --DDL : CREATE ,ALTER ,DROP  --ROLLBACK안됨
  --DML : INSERT ,UPDATE ,DELETE - ROLLBACK가능
  
  
  
  