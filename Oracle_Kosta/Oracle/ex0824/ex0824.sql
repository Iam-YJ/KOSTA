--각자 계정으로 접속한다.  conn jang/1234

/*
Datatype 종류

1) 문자형 
    char(byte 수) - 고정길이
    varchar2(byte 수) - 가변형 길이 
    
    varchar2(10) --> 10byte 크기, 한글은 최대 5글자
    varchar2(10 char) --> byte수와 관계없이 무조건 최대 10개 문자 
    
    :저장할 때 반드시 '값' 묶는다.
    
    nchar() of nvarchar2()
    
2) 숫자형
    : number(전체자리수)
    : number(전체자리수, 소수점자리)
    : smallint
      int
      
    ex) number(2) : -99 ~ 99 까지
    
3) 날짜형
    : date 
    : 날짜를 저장할 때 '년-월-일' or '년/월/일'
    : 현재 날짜와 시간을 검색 -> sysdate 함수를 이용

*/


/*
 - 테이블 생성
 create table 테이블이름(
    컬럼명 datatype [null : not null] [constraint 별칭 제약조건종류],
    컬럼명 datatype [null : not null] [constraint 별칭 제약조건종류],
    ...   
  );
  
  
 - 제약조건 종류
 1) primary key
 2) foreign key
 3) unique
 4) check
 
 5) default 
*/

/*
1) primary key
 : 기본키 = 대표키 = pk
 : pk를 설정하면 not null, 중복안됨
 : pk 컬럼은 자동 index 설정됨 
 : 하나의 테이블에 pk는 반드시 한개만 존재한다. 
 : 여러개의 컬럼을 하나로 묶어서 pk 설정은 가능하다(복합키)
*/


ex) 테이블 생성
create table member(
    id varchar2(20) constraint member_id_pk primary key,
    name varchar2(10) not null, 
    age number(2) not null,
    addr varchar2(30) ,
    regdate date 

);

-- 테이블 검색
select * from member;

-- 테이블 구조
desc member;

-- 레코드 등록(삽입)
insert into 테이블이름(컬럼명,  컬럼명, ... ) values(값, 값...);
insert into 테이블이름 values(값, 값...);

ex ) 추가
insert into member(id, name, age, addr, regdate) values('JANG','장희정',20,'서울',sysdate);

insert into member(id, name, age, addr, regdate) values('jang','장희정',20,'서울',sysdate);

insert into member values('hee','나영',22, '대구','2020-08-24');

-- null or not null 체크
insert into member(name, age) values('효리',22); - id는 pk 이므로 not null 이다

insert into member(id, name, age) values ('aa','효리',22); 

select * from member;

insert into memebr(id, name, age) values ('bb', '나영',99);


-- 문자형 예제
create table test1(
 name1 varchar2(5),
 name2 varchar2(5 char),
 name3 char(5),
 name4 char, --byte수를 생략하면 기본 1byte 설정
 name5 varchar2(1) --byte수를 생략할 수 없다. 
 
);

desc test1; -- 테이블 구조

insert into test1(name1) values('abcde');
insert into test1(name1) values('장희정'); --크기를 벗어나서 등록안됨

insert into test1(name2) values('장희정'); --성공

insert into test1(name3) values('a');
insert into test1(name3) values('ab');
insert into test1(name3) values('abc');
insert into test1(name3) values('장희정'); --자리수를 벗어나서 오류


--숫자형
create table test2(
    no1 number(2),
    no2 number(5,2), --전체 5자리중에 소수점 2자리 
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
insert into test3(no3) values(9999999); --number()의 값을 주지않으면 주라는대로 다 줌 

insert into test4(no3) values(9999999); 
insert into test5(no3) values(9999999); 


select * from test2;

-----------------------------------------------------
--테이블 삭제
drop table  member;


--두개의 컬럼을 하나의 pk로 만들기 
create table member(
    id varchar2(5 char), --영어든 한글이든 상관없이 5글자까지 가능해
    jumin char(6),
    name varchar2(7) not null,
    age number(3),
    addr varchar2(20),
    constraint mem_id_jumin_pk primary key(id, jumin)
);

--테이블 검색
select * from member;

--테이블 구조
desc member;

--레코드 등록
insert into member values('jang','11111','효리',null,null);
insert into member values('jang','11112','효리',null,null);
insert into member values('JANG','11111','효리',null,null);
insert into member values('JANG','11112','효리',null,null);

-- 테이블 구조 변경 - 데이터 타입 변경
alter table member modify name varchar2(20);

------------------------------------------------------------------
--2) Foreign key
/* 
 : 외래키 = FK
 : 다른 테이블의 기본키(PK)를 참조하는 것
 : 레코드를 등록할 때 참조되는 컬럼에 있는 값 이외는 등록할 수 없다
 : NULL 허용, 중복가능
 : 한 테이블에 여러개의 컬럼에 FK 설정 가능
 
  * 주의사항
     INSERT 할 때 : 부모 insert -> 자식 insert 한다
     DELETE 할 때  : 자식 delete -> 부모 delete 한다 
      - 이러한 번거로움을 해결하기 위해서 테이블 생성할 때 옵션 설정할 수 있다.
      on delete cascade - 부모를 삭제할 때 자식레코드도 함께 자동으로 삭제된다

*/

--테이블 생성
create table dept(
    dept_no char(3) constraint dept_no_pk primary key,
    dname varchar2(20) not null,
    loc varchar2(30)
    
);


--샘플 데이터 추가
insert into dept(dept_no, dname, loc) values('a01','인사부','서울');
insert into dept(dept_no, dname, loc) values('a02','경리부','대구');
insert into dept(dept_no, dname, loc) values('a03','교육부','제주');

--테이블 생성
create table emp(
    emp_no number(3) constraint emp_no_pk primary key, --사원번호
    ename varchar2(20) not null,
    age number(3),
    dept_no char(3) constraint emp_deptno_fk references dept(dept_no)

);

--샘플데이터 추가
insert into emp(emp_no, ename, age, dept_no) values(1,'이효리',20,null); -- 부서번호 null 허용할 수 있음
insert into emp(emp_no, ename, age, dept_no) values(2,'이미영',22,'a01');
insert into emp(emp_no, ename, age, dept_no) values(3,'전선영',25,'a01'); --부서번호 중복 가능
insert into emp(emp_no, ename, age, dept_no) values(4,'정미영',22,'a04');--오류

insert into dept values('a04','경제부','서울');
insert into emp(emp_no, ename, age, dept_no) values(4,'정미영',25,'a04');


--레코드 삭제
truncate 테이블이름; --모든 레코드를 삭제(절삭) : rollback 안됨
delete from 테이블이름; --모든 레코드를 삭제 : rollback 가능
delete from 테이블이름 where 조건식; -- 조건에 해당하는 레코드를 삭제 

* from 키워드 생략 가능하다. 

ex) 참조되고 있는 자식 레코드를 삭제해본다
delete from emp where emp_no=4; --성공

ex) 참조대상인 부모레코드를 삭제해본다
delete from dept where dept_no = 'a01'; --삭제실패 

* 삭제하고 싶으면 참조된 자식 레코드 먼저 삭제하고 부모를 삭제한다
delete emp where dept_no='a01';
delete from dept where dept_no = 'a01'; --삭제성공

--on delete cascade 옵션 설정하기
drop table emp;
drop table dept;

--dept 테이블 생성한다 - 위에 있는 쿼리 그대로 다시 실행 

-- 자식테이블인 emp 테이블의 옵션을 설정해서 생성해본다 
create table emp(
    emp_no number(3) constraint emp_no_pk primary key, --사원번호
    ename varchar2(20) not null,
    age number(3),
    dept_no char(3) constraint emp_deptno_fk references dept(dept_no) on delete cascade 
);

--샘플레코드 추가
insert into emp values(1,'나영',20,'a01');
insert into emp values(2,'효리',21,'a02');
insert into emp values(3,'선영',22,'a01');

-- 부모레코드를 삭제해본다(참조되고 있는 대상 레코드 삭제)
delete from dept where dept_no='a01';


drop table emp;
--foreign key를 맨뒤에 작성하기
create table emp(
    emp_no number(3) constraint emp_no_pk primary key, --사원번호
    ename varchar2(20) not null,
    age number(3),
    dept_no char(3) ,
    job varchar2(30) not null,
    constraint emp_deptno_fk foreign key(dept_no) references dept(dept_no) on delete cascade 

);


select * from emp;
select * from dept;

