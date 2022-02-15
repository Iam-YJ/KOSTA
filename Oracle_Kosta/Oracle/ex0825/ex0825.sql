--제약조건
/*
 3) unique
    : 중복안됨, null 허용함(not null 설정하면 pk와 동일) - 후보키 중에 대표키가 될 수 없는 컬럼에 설정
    : 하나의 테이블에 여러개 컬럼에 설정 가능
    : 대표키는 될 수 없지만 유일해야하는 컬럼에 설정한다
 4) check
    : 조건을 설정해서 조건에 해당하는 값 이외에는 insert 될 수 없도록 하는 것
 5) default
    : 기본값 설정
    : insert 할 때 값을 넣지 않으면 자동으로 default 값이 insert 된다.
    ex) 등록일, 최초 조회수, 

*/

--테이블 생성
create table test(
    id varchar2(20) primary key,
    jumin char(13) unique, --null 허용
    age number(2) check(age >= 10 and age <= 20),
    addr varchar2(20) check(addr = '서울' or addr='대구' or addr='대전'),
    gender char(6) default '남자'
    
);

select * from test;

-- 레코드 등록
insert into test values('jang','111',12,'서울',default);
insert into test(id,jumin,age) values('hee','2222',12); --null 이지만 default 설정되면 자동으로 채워짐(gender가)
insert into test(id,jumin, age,gender) values('jung','33333',11,null);
insert into test(id,addr) values('judㅇd','대구');

--------------------------------------------------------------
--테이블 수정
-- 1) 컬럼 추가
alter table 테이블이름 add 컬럼명 데이터타입 [제약조건], ...
ex) 
alter table test add ( phone varchar2(20), etc varchar2(30) default '기타');
alter table test add name1 varchar2(20) default '희정' not null; --순서(컬럼명 데이터타입 default not null)
select * from test;
alter table test add aa number(2);

--2) 컬럼 삭제
alter table 테이블이름 drop column 컬럼명;
ex)
alter table test drop column phone;
alter table test drop column etc;

select * from test;


--3) 데이터타입 변경
alter table 테이블이름 modify 컬럼명 변경데이터타입; 

ex)
alter table test modify iddds varchar2(40);
alter table test modify aa varchar2(40);

desc test;


--4) 컬럼이름 변경
alter table 테이블이름 rename column 변경전컬럼명 to 변경할 이름;

ex)
alter table test rename column id to iddds;

select * from test;

--5) 제약조건 추가
alter table 테이블이름 add constraint 별칭(제약조건이름) 제약조건;

ex)
alter table test add constraint aa_hello_unique unique(aa);
desc test;

--6) 제약조건 삭제
alter table 테이블이름 drop constraint 별칭;

ex)
alter table test drop constraint aa_hello_unique;
desc test;


--7) 테이블 삭제
drop table 테이블이름

ex)
drop table test;
select * from test;

------------------------------------------------------------------------------

--테이블 복사 : 제약조건은 복사 안됨 
/*
 create table 테이블이름
 as 복사할 테이블 내용;
*/

ex) soctt 계정에 있는 emp 테이블 복사하기 - 먼저 scott 접속
select * from emp;

1) 모든 레코드, 모든 컬럼 복사하기 - 단 제약조건은 복사 안됨 
-> 제약조건 추가 
create table copy_emp
as select * from emp;

alter table copy_emp add constraint copy_emp_pk primary key(empno); -- 데이터 중복이 없고 not null이여서 pk 추가 가능
alter table copy_emp add constraint copy_emp_f foreign key(deptno) references dept(deptno);

2) 특정 컬럼과(project) 특정 레코드만(selection)만 복사하기
create table copy_emp2
as select empno, ename, job, sal from emp where sal >=3000 ;

select * from copy_emp2;

3) 테이블 구조만 복사하기
create table copy_emp3
as select * from emp where 1=0;

select * from copy_emp3;


--DML 작업 (insert, update , delete)
/*
 : 상황에 따라 commit or rollback 가능하다 - transaction 이용
*/

-- insert : 레코드 삽입
insert into 테이블이름(컬럼명,..) values(값,..);
insert into 테이블이름 values(값,..); - 모든 컬럼에 순서대로 값을 설정 
 
-- update : 레코드 수정
update 테이블이름
set 컬럼면 = 변경값, 컬럼명 = 변경값, ...
[ where 조건식 ] ;

-- delete : 레코드 삭제
delete [from] 테이블이름
[where 조건식] ;

-- copy_emp 테이블로 실습한다

ex) empno가 7654인 사원의 ename을 'hee', job을 '백조', sal을 3500으로 변경하세요
update copy_emp
set ename = 'hee', job = '백조', sal=3500
where empno = 7654;

select * from copy_emp;

ex) sal가 1000~2000 사이인 사원의 급여를 3000, 입사일은 현재날짜로 변경
update copy_emp
set sal=3000, hiredate = sysdate
where sal>=1000 and sal <= 2000;
--where sal between 1000 and 2000;

select * from copy_emp order by sal;

ex) deptno가 20이면서 job이 salesman인 사원의 comm을 1000으로 변경하세요.
update copy_emp
set comm=1000
where deptno=20 and job='SALESMAN';
--where lower(job) = lower('SalESMan');

select * from copy_emp;


ex) empno가 7782와 7844인 사원을 삭제하세요.

delete from copy_emp
where empno=7782 or empno=7844; --2명 삭제해야해서 .. 번호 or로 번호가 and 이면 조건 만족 안함 

select * from copy_emp;


ex) 사원 2명 등록하기
insert into copy_emp(empno, ename, job) values(1111,'YJ','백수');
insert into copy_emp(empno, ename, job) values(1112,'YJ','백수');

select * from copy_emp;

---------------------------------------------------------------------------
--DQL 문장 : select 문
/*
    select distinct | * | 컬럼명 as 별칭,... - 열(속성) 제한두는 것 - projection(열을 제한하는 것)
    from 테이블 이름 
    [where 조건식] - 레코드(튜플) 제한 - selection 
    [order by 정렬대상컬럼 asc | desc, 정렬대상컬럼 asc | desc ]
    
    --실행순서
    from -> where -> select -> order by
*/

select * from emp;

1) 원하는 컬럼과 별칭 만들기
select empno, ename as 이름 , job as "담당업무", sal 급여 from emp;

2) 중복행 제거(distinct)
select distinct empno, job from emp;

ex) 우리 직원의 직무(job) 종류를 알고 싶다
select job from emp; 
select distinct job from emp;

ex)급여가 2000이상인 사원 검색
select *
from emp
where sal >= 2000; --selection 레코드 제한 

ex) 급여가 2000이상인 사원 검색하고 급여를 기준으로 내림결졍
select * from emp where sal > 2000 order by sal; -올림차순`
select * from emp where sal > 2000 order by sal desc; --내림차순

ex) job을 기주으로 내림차순하고 같으면, 급여를 기준으로 올림차순 정렬
select * from emp order by job desc, sal;

------------------------------------------------------
/*
- 연산자 종류
1) 산술 연산자
 : +, -, *, /, mod(값, 나눌수) - 나머지
2) 관계 연산자
 : >, <, >=, <=, !=, = 
3) 비교연산자
 - and
 - or
 - between 최소값 and 최대값 
    : 하나의 컬럼을 기준으로 최소 ~ 최대 범위를 조건으로 사용할 떄 and 연산자보다 편하다    
 - 컬럼명 in(값, 값..)
    : 하나의 컬럼을 기준으로 값은 or 연산자로 비교하고자 할 대 or 연산자보다 편하다 .
 - like 
    : 와일드카드문자 (_, %)와 함께 사용하며 데이터 중에 특정한 문자를 포함한 
      레코드를 검색할 때 사용한다.
       * 1) _ : 한 문자
            % : 0개 이상의 문자
             
            ex) job like 'j%' - job이 j로 시작하는 문자열을 검색
                job like '%j%' - job이 j라는 문자를 포함하고 있는 레코드 
                job like '___' - 3글자를 검색 
                job like 'A_B%' - 

*/

ex) 산술연산자
select empno, ename, sal, comm, sal + comm 
from emp; -- null을 포함하고 있으면 산술연산자 적용 안됨 

* null값을 찾아서 원하는 값으로 변경하고 연산을 한다. - nvl(값, 변경값 )함수 이용한다.
select comm, nvl(comm,100) from emp;

select empno, ename, sal, comm , (sal + nvl(comm, 0))*12 as 연봉 
from emp;

ex) ~님 연봉은 ~입니다. 
select ename || '님 연봉은 ' || sal || '입니다.' as "설명 하기"
from emp;

ex) sal가 200 ~ 4000 사이인 레코드 검색
-- and 
    select * from emp 
    where sal >= 2000 and sal <=4000;
    order by sal;
    
ex) sal가 200 ~ 4000 사이인 레코드 검색
    *위에 연산자 앞에 not을 붙이면 반대 
    select * from emp 
    where not(sal >= 2000 and sal <=4000)
    order by sal;

-- between and 
    select * from emp where sal between 2000 and 4000 order by sal;
    select * from emp where sal not between 2000 and 4000 order by sal;
    

ex) empno가 7499, 7566, 7782, 7839 인 레코드 검색
--or
select * from emp where empno=7499 or empno=7566 or empno=7782 or empno=7830 ;
select * from emp where not (empno=7499 or empno=7566 or empno=7782 or empno=7830) ;

--in
select * from emp where empno in (7499,7566, 7782, 7839);
select * from emp where empno not in (7499,7566, 7782, 7839);


--like 연산자

                
ex) job이 'A'로 시작하는 레코드 검색
select * from emp where job like 'A%';

select * from emp where job = 'A%';  -- 검색안됨 
select * from emp where upper(job) like upper('a%');
select * from emp where upper(job) not like upper('a%');

ex) job이 끝이 N으로 끝나는 레코드 검색
select * from emp where job like '%N';

ex) ename이 4글자인 레코드 검색
select * from emp where ename like '____';

ex) ename에 a글자가 들어가는 레코드 검색 
select * from emp where ename like '%A%';

ex) ename이 전체글자는 5글자이고 첫글자는 A인 레코드 검색
select * from emp where ename like 'A____';


/*
 - ANY : 하나라도 만족하면 TRUE
    컬럼명 < ANY  (100, 200, 300) - 최대값(300)보다 작으면 TRUE
    컬럼명 > ANY  (100, 200, 300) - 최소값(100)보다 크면 TRUE
    
- ALL : 모두 만족해야만 true
    컬럼명 < ANY  (100, 200, 300) - 최소값(100)보다 작으면 TRUE
    컬럼명 > ANY  (100, 200, 300) - 최대값(300)보다 크면 TRUE
*/

select * from emp ; 
select * from emp where sal < any (1000,2000,3000) order by sal; - 3000보다 작으면 
select * from emp where sal > any (1000,2000,3000) order by sal; - 1000보다 크면

select * from emp where sal < all (1000,2000,3000) order by sal; - 1000보다 작으면 
select * from emp where sal > all (1000,2000,3000) order by sal; - 3000보다 크면

-- deptno(부서번호)가 30인 사원들 중 급여보다 많이 받는 사원 검색
1) 30번 부서의 사원들의 급여
select sal from emp where deptno=30 ;

2) 1)을 조건으로 사용해서 검색
select * from emp where sal > all(select sal from emp where deptno=30);

-- deptno(부서번호)가 30인 사원들 중 급여보다 적게 받는 사원 검색 
select * from emp where sal < all(select sal from emp where deptno=30);

-----------------------------------------------------------------------
/*
--null 값 찾기

1) is null

2) is not null
*/

select * from emp;
ex) comm이 null인 레코드 검색하기
 select * from emp where comm is null;
 
ex) comm이 null이 아닌 레코드 검색하기
 select * from emp where comm is not null;
 
 -------------------------------------------------
 
 /*
  1) 집계함수
  - sum() : 총점
  - avg() : 평균
  - min() : 최소값
  - max() : 최대값
  - count(컬럼명) : null을 제외한 전체 레코드 수 
  - count(*) : null을 포함한 전체 레코드 수 
 */
 
 ex) 성적테이블 생성
 create table sungjuck(
    name varchar(20) primary key,
    ban number(1),
    kor number(3) check( kor between 0 and 100),
    eng number(3) check( eng between 0 and 100),
    math number(3) check( math between 0 and 100)
 );

--샘플 레코드 추가 
insert into sungjuck values('효리',1,80,90,33);
insert into sungjuck values('리효',1,80,30,100);
insert into sungjuck values('효효',1,50,10,77);

insert into sungjuck values('개리',2,55,90,22);
insert into sungjuck values('리개',2,80,90,90);

insert into sungjuck values('집'  ,3,80,30,100);
insert into sungjuck values('가고',3,20,15,100);
insert into sungjuck values('싶다',3,56,99,100);
insert into sungjuck values('널'  ,3,null,99,100);

select * from sungjuck;

ex) 각 개인별 총점, 평균 구한다 
select name, ban, kor, eng, math,
(nvl(kor,0)+nvl(eng,0)+nvl(math,0)) as 총점,
round((nvl(kor,0)+nvl(eng,0)+nvl(math,0))/ 3,0) as 평균
from sungjuck;


ex) 국어점수의 총점, 평균 , 레코드 수, 최대값, 최소값..
select sum(kor) 총점, avg(kor), round(avg(nvl(kor,0)),0), count(kor), count(*),
max(kor), min(nvl(kor,0))
from sungjuck;

select name, sum(kor) 총점, avg(kor)
from sungjuck; --일반컬럼과 집계함수를 함께 사용할 수 없다. 단, group by 있으면 사용가능함 

ex) 각 반별 국어의 총점, 평균, 최대, 최소 구하기
select ban , sum(kor), avg(kor), max(kor), min(kor)
from sungjuck
group by ban; -- 각 반별 그룹을 지어 그룹별 집계함수를 만든다
              -- group by 절에 나온 컬럼은 select절에서 사용할 수 있다.

              
ex) kor 점수가 70 이상인 학생들의 반별 총점, 평균 구한다.
select ban, sum(kor), avg(kor)
from sungjuck
where kor >= 70
group by ban;

ex) kor 평균이 70 이상인 학생들의 반별 총점, 평균 구한다.
select ban, sum(kor), avg(kor)
from sungjuck
where avg(kor) >= 70 -- 직계함수는 where절에 쓸 수 없다 (실행순서 때문에) <오류!!>
group by ban;


select ban, sum(kor), avg(kor)
from sungjuck
group by ban
having avg(kor) > = 70;


-----------------------------------------------------------------------
--select문장
select (5)
from (1)
where  (2)
group by (3)
having  (4)
order by (6)



select * from sungjuck;
