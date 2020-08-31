/*
 join 
  : 한번에 select 문장으로 2개 이상의 테이블에 있는 컬럼의 정보를 검색하고자 할 때 사용한다. 
  : join의 종류
  1) inner join = EQ JOIN = 동등조인 = natural join
  2) left join
    - left outer join
    - right outer join
    - full outer join
  3) self join
  
  :join을 코딩하는 방식
  1) SQL JOIN 방식 : FULL OUTER JOIN은 지원하지 않음 
  2) ANSI JOIN 방식 : 표준이기 때문에 권장

*/

select * from emp;
select * from dept;

ex) smith 사람의 job, dname, log 검색하고 싶다 -> join 필요하다

--테이블 생성
create table test1(
 id varchar2(3) primary key,
 name varchar2(20),
 addr varchar2(30)
);

--샘플데이터 추가
insert into test1 values(1,'희정','서울');
insert into test1 values(2,'나영','대구');
insert into test1 values(3,'효리','제주도');
insert into test1 values(4,'현솔','부산');
insert into test1 values(5,'가현','서울');

select * from test1;

create table test2(
 code char(3) primary key,
 id varchar2(3) references test1(id),
 job varchar2(30),
 sal number(3)
);

--레코드 등록
insert into test2 values('A01',1,'가수',400);
insert into test2 values('A02',3,'배우',500);
insert into test2 values('A03',5,'개그우먼',300);
insert into test2 values('A04',NULL,'백조',700);


select * from test1;
select * from test2;

ex) id, name, addr, job, sal 정보 검색하고 싶다.
1) INNER JOIN = EQ JOIN = 동등조인
    -SQL 조인 방식
    select test1.id, name, addr, job, sal
    from test1, test2
    where test1.id = test2.id;
    
--테이블이름에 별칭 만들기
    select t1.id, name, addr, job, sal
    from test1 t1, test2 t2 -- 테이블 이름에 별칭 
    where t1.id = t2.id;

--모든 컬럼 검색하기
   select *
    from test1 t1, test2 t2 -- 테이블 이름에 별칭 
    where t1.id = t2.id;


-- ANSI 조인 방식 - 권장 
    select test1.id, name, addr, job, sal
    from test1 inner join test2 --inner 단어는 생략가능하다
    on test1.id = test2.id;
    
--테이블 별칭 만들기
    select t1.id, name, addr, job, sal
    from test1 t1 inner join test2 t2--inner 단어는 생략가능하다
    on t1.id = t2.id; --pk와 참조컬럼(fk)의 이름이 다를 때 꼭 필요하다 

* 위 문장을 using()으로 변경하기
    select id, name, addr, job, sal
    from test1 inner join test2 --inner 단어는 생략가능하다
    using(id); --pk와 참조컬럼(fk)의 속석명이 같을 때 사용한다 
    
        * using을 사용할 대 컬럼명에 별칭은 사용할 수 없다. 

* 모든 컬럼 검색
    select *
    from test1 t1 join test2 t2 --inner 단어는 생략가능하다
    on t1.id = t2.id;
    
    select *
    from test1 t1 join test2 t2 --inner 단어는 생략가능하다
    using(id);  

* natural join : inner join 내에 한 부분으로 
    select *
    from test1 natural join test2--inner 단어는 생략가능하다
    
    * on절 or using()을 사용할 수 없다.
    * 양쪽에 같은 속성을 기반으로 모두 조인하다
    
ex)
    create table copy_test1
    as select * from test1;
 
    select * from copy_test1;
    
    alter table copy_test1 add phone varchar2(20) default '1111';
    
    -- inner join + on
          -- 공통되는 것은 2번씩 나옴 
        select * 
        from test1 inner join copy_test1
        on test1.id = copy_test1.id;
        
    -- inner join + using()
         --using을 쓴 것만 1번 나오고 나머지는 또 나옴
        select * 
        from test1 inner join copy_test1
        using(id);
    
    -- natural join
         -- 공통되는 것은 1번씩만 나옴 
        select * 
        from test1 natural join copy_test1;
        
--원하는 컬럼 선택
    select test1.id, name, addr, job, sal
    from test1 inner join test2
    on test1.id = test2.id;

------------------------------------------------------
--outer join
1) left outer join
2) right outer join
3) full outer join

-- SQL 조인 방식 코딩 --full 조인 지원안됨
    select * 
    from test1, test2
    where test1.id = test2.id(+); --left join
    --동등한게 다 나오고, 특정한 레코드에 있는 것을 다 보여준다..
    
    select * 
    from test1, test2
    where test1.id(+) = test2.id; --right join

-- ANSI 조인 방식 코딩 
    select *
    from test1 left outer join test2 --left outer join
    using(id);

    select *
    from test1 right outer join test2 --right outer join
    using(id);
    --test2가 다 나온다 
    
    select *
    from test1 full outer join test2 --full outer join 
    using(id);
    --outer 는 사용 가능 
    
    
    * 3개 테이블 조인하기
    select * from test2;
    
    create table test3(
        code char(3) primary key references test2(code), --pk, fk 동시 설정
        manager_name varchar2(20)
    );
   
    insert into test3 values('A01','삼순이');
    insert into test3 values('A02','삼식이');
    insert into test3 values('A03','유재석');
    
    ex) id, name, job, sal, manager_name 검색 
   
    --SQL 조인 방식 
    select test1.id, name, job, sal, manager_name
    from test1, test2, test3
    where test1.id=test2.id and test2.code=test3.code;

    select *
    from test1, test2, test3
    where test1.id=test2.id and test2.code=test3.code;
    
    -- ANSI 조인 방식 --ON, USING
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
    : 자신 테이블을 두개로 만들어서 조인하는 것
    : 재귀적 관계일 때 사용한다 - 하나의 테이블에서 일반속성이 자신테이블의 pk를 참조하는 것 
    
--scott 계정으로 접속 
select * from emp;

ex) 어떤 사원의 정보와 그 사원을 관리하는 관리자의 정보를 검색하고 싶다

select e1.ename 사원이름, e1.mgr 관리자번호, e2.ename 관리자이름 
from emp e1 join emp e2 --e1은 사원, e2는 관리자테이블 
on  e1.mgr = e2.empno;


-------------------------------------------------------------------
--join 실습
SELECT * FROM emp;
SELECT * FROM dept; --부서정보
SELECT * FROM salgrade; --급여등급


-- 1. SMITH 에 대한  정보 검색(ename, emp.deptno, loc .)
    select * 
    from emp join dept 
    using (deptno) --중복된 정보 추가 x 
    where ename = 'SMITH';

--2. NEW YORK에 근무하는 사원의 이름과 급여를 출력
    select ename, sal, loc
    from dept inner join emp
    on emp.deptno = dept.deptno
    where dept.loc = 'NEW YORK';

-- 3. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력
    select ename, hiredate, dname
    from dept inner join emp
    on dept.deptno = emp.deptno
    where dept.dname = 'ACCOUNTING';

-- 4. 직급이 MANAGER인 사원의 이름, 부서명 출력
    select ename, dept.dname, job
    from dept join emp
    on dept.deptno = emp.deptno
    where emp.job='MANAGER';
    

-- 5. 사원의 급여가 몇 등급인지를 검색
-- between A and B
select * from salgrade;
select * from emp;

SELECT EMPNO, ENAME, SAL, GRADE, LOSAL, HISAL
 FROM EMP JOIN salgrade
 ON SAL BETWEEN LOSAL AND HISAL;
 

--6. 사원 테이블의 부서 번호로 부서 테이블을 참조해서 부서명, 급여 등급도 검색

    select dname, grade
    from emp join salgrade
    on sal between losal and hisal join dept
    on emp.deptno = dept.deptno;
    
    /*
    select dname, grade
    from emp join empt using(deptno) join salgrade on sal between losal and hisal ;
    */
    

--7. SMITH의 메니저(mgr) 이름(ename) 검색
    'SMITH의 관리자는 ~ 입니다'
    
    select e1.ename||'의 관리자는 ' ||  e2.ename || '입니다'
    from emp e1 join emp e2 --e1은 사원, e2는 관리자테이블 
    on  e1.mgr = e2.empno
    where e1.ename = 'SMITH';

--8. 관리자가 KING인 사원들의 이름과 직급(job) 검색
    select e1.ename 사원, e2.ename 관리자이름 , e1.job 직업
    from emp e1 join emp e2
    on e1.mgr = e2.empno
    where e2.ename = 'KING';

--9. SMITH 와 동일한 부서번호(DEPTNO)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 절대 출력 불가
    
    select E1.ENAME, E1.DEPTNO , E2.ENAME
    from emp e1 join emp e2
    on e1.deptno = e2.deptno
    WHERE not e1.ename ='SMITH' and e2.ename = 'SMITH';

10. SMITH 와 동일한 근무지(LOC)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 절대 출력 불가

    /*
    select emp.ename, dept.loc
    from emp join dept
    on emp.deptno = dept.deptno
    where  emp.ename= 'SMITH' and emp.deptno = dept.deptno;
    */ -- 내꺼
    
    --선생님꺼
    select e1.ename, d1.loc, e2.ename, d2.loc
    from (emp e1 join dept d1 on e1.deptno = d1.deptno)
    join (emp e2 join dept d2 on e2.deptno = d2.deptno )
    on d1.loc = d2.loc;
    --where e1.ename='SMITH' AND E2.ENAME!='SMITH';
    
    select e1.ename, d1.loc, e2.ename, d2.loc
    from (emp e2 join dept d2 on e2.deptno = d2.deptno );
    
-- 11, 사원명, 해당 하는 메니저명 검색
-- 반드시 모든 사원들(CEO포함) 정보 검색
-- CEO인 경우 메니저 정보 null
    select e1.ename, e2.ename
    from emp e1 join emp e2 --e1은 사원, e2는 관리자
    on e1.mgr = e2.empno;
    
    ----------------------------------------------------------------------
   /*
    -set 집합 
    
    1) 합집합
        - UNION : 중복행을 제외하고 합친다
        - UNION ALL : 중복행을 포함해서 합친다
    2) 교집합
        - INTERSECT : A와 B의 공통 레코드를 검색한다
    3) 차집합
        - MINUS : A MINUS B 이면 A에서 B를 뺀 나머지 레코드 검색한다 
*/
    select * from emp;
    
    --테이블 복사
    create table set_emp 
    as select empno, ename, job, sal
    from emp 
    where deptno = 20;
    
    select * from set_emp;
    insert into set_emp values(8000,'HEE','MANAGER',2500);
    insert into set_emp values(8001,'KING','TEACHER',3000);
    
    --합집합 : UNION
    select empno, ename, job, sal from emp
    union select empno, ename, job, sal from set_emp;
    
    select empno, ename, job, sal from emp
    union all select empno, ename, job, sal from set_emp;
    
    --차집합
    select empno, ename, job, sal from emp
    minus select empno, ename, job, sal from set_emp;
    -- 먼저 쓴거에서 나중에 쓴거 뺌
    
    select empno, ename, job, sal from set_emp
    minus select empno, ename, job, sal from emp;
    
----------------------------------------------------------
/*
    SUBQUERY : 부질의
    - 메인 쿼리안에서 또다른 쿼리문이 존재하는 것
    - 반드시 괄호로 묶고 괄호안에 있는 결과 먼저 실행된 후에 그 결과를 가지고 메인에 활용한다
    - 서브쿼리의 결과 레코드가 한개인 경우는 >, <, >=, <=, !=, =를 사용한다.
    - 서브쿼리의 결과레코드가 2개 이상인 경우는 ,IN, ANY, ALL을 이용한다
    - 주로 SELECT절에서 많이 사용하지만 INSERT, UPDATE, DELETE에서도 사용한다.
*/

ex) emp 테이블의 평균급여보다 많이 받는 사원의 정보 검색
    1) 평균 급여를 구한다
        select avg(sal) from emp;
    
    2) 1)에서 나온 결과를 가지고 조건으로 사용한다
        select * from emp where sal > 2077;
    
    * 위의 2문장을 한문장으로 서브쿼리로 해결한다 
        select * from emp where sal > (select avg(sal) from emp);
        
ex) job에 'A' 문자열이 들어간 사원의 부서와 같은 곳에서 근무하는 사원의 부서이름(DNAME)을 검색한다 
    
    1) JOB에 'A'문자열이 들어간 사원의 부서번호를 검색하다
        select distinct deptno from emp where job like '%A%';
    
    2) 1)에 있는 정보를 조건으로 사용하여 dname을 구한다 
        
        select dname from dept
        where deptno in (10,20,30);
        
        select dname from dept
        where deptno in (select distinct deptno from emp where job like '%A%');
        
ex) 부서번호가 30인 사원들의 급여중에서 가장 많은 급여보다 더 많이 받는 사원의 정보를 구한다 - 최대값보다 많이

    1) 30번 부서의 최대 급여를 구한다
        select max(sal) from emp where deptno=30;
    
    2) 1)을 조건으로 사용한다.
        select * from emp where sal > (select max(sal) from emp where deptno=30); --결과집합이 1개 
        
    -------------------------------------------------------------
    1) 30부서의 급여 구한다
        select sal from emp where deptno=30;
    
    2) 1)을 조건으로 사용한다 
        select * from emp where sal > all (select sal from emp where deptno=30); --결과집합이 여러개 

        
ex) 부서번호가 30인 사원들의 급여중에서 가장 적은 급여보다 더 많이 받는 사원의 정보를 구한다 -- 최소값보다 많이
    
    1) 
    select sal from emp where deptno=30;
    
    2) 
    select * from emp where sal > any (select sal from emp where deptno=30);
    
---------------------------------------------------------------------------------
create table sub_emp
as select * from emp where 1=0; --레코드는 가져오지 말고 구조만 가져와 

select * from sub_emp;

-- subquery 를 이용한 insert
insert into sub_emp (select * from emp where job = 'MANAGER');

*특정 컬럼만 선택해서 INSERT 하고 싶다
insert into sub_emp(empno, ename, job,sal)
(select empno, ename, job, sal from emp where sal < 2000);


-- subquery를 이용한 update
ex) empno가 7499인 사원 급여를 평균 급여로 변경한다
update sub_emp set sal = (select avg(sal) from sub_emp) where empno = 7499;

ex) empno가 7782인 사원의 job, sal, comm을 수정한다
: 수정하는 값은 emp 테이블의 empno가 7839인 사원 정보를 가져와서 그 값으로 변경한다

update sub_emp set (job, sal, comm) = (select job, sal, comm from emp where empno=7839) where empno=7782;


-- subquery 를 이용한 delete
ex) sub_emp의 평균 급여보다 많이 받는 사원을 모두 삭제한다

delete from sub_emp
where sal > (select avg(sal) from sub_emp);

----------------------------------------------------------

--인라인 뷰 : from절 뒤에 서브쿼리가 오는 형태를 인라인 뷰라고 한다 
* ROWNUM : 행번호 자동으로 만들어 준다

SELECT ROWNUM 번호 , EMPNO, ENAME, JOB, SAL FROM EMP
ORDER BY SAL DESC;


- 먼저 SAL을 기준으로 정렬한다.
    select * from emp order by sal desc;

- 정렬된 테이블을 가지고 ROWNUM을 만든다.
    select rownum, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc);


--rownum이 3보다 작은 레코드 검색
    select rownum, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc)
    where rownum < 3;
    --rownum은 그때그때 자동으로 부여된다. -> where절이 마지막에 실행됨에 따라서 -> 이미 생성되어있는 3 이하만 (1,2)만 나오게 되는 것이다 
    
     select  empno, ename, job, sal, mgr
    from (select * from emp order by sal desc)
    where rownum < 3;
    --rownum은 나오기 전에 그 밑에 자동으로 깔려있다 

--rownum이 3보다 큰 레코드 검색
    select rownum, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc)
    where rownum > 3; --결과가 안나온다 
    
* 위의 문장을 성공하려면 인라인뷰를 또 사용한다
select * from (
    select rownum 번호, empno, ename, job, sal, mgr
    from (select * from emp order by sal desc))
    where 번호> 3;
    
    
    * 번호 5~7인 경우 검색
    select * from 
    (select rownum 번호, empno, ename, job, sal, mgr
    from(select * from emp order by sal desc))
    where 번호 between 5 and 7;