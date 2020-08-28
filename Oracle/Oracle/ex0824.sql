--각자 계정으로 접속한다. conn jang/1234
/*
 Datatype 종류
  1) 문자형
     char(byte수) - 고정길이
     varchar2(byte수) - 가변형 길이
     
     varchar2(10) --> 10byte 크기  , 한글은 최대 5글자.
     varchar2(10 char) -> byte수와 관계없이 무조건 최대 10개 문자
     
     : 저장할때 반드시 '값' 묶는다.
     
     
     nchar() or nvarchar2()
  
  2) 숫자형
     : number(전체자리수)
     : number(전체자리수, 소수점자리)
     : smallint
       int 
       
    ex) number(2) : -99 ~ 99 까지 
       
  3) 날짜형
     : date
     : 날짜를 저장할때 '년-월-일' or '년/월/일'
     : 현재 날짜와 시간을 검색  - sysdate 함수를 이용함.
*/

/*
  -테이블 생성
  create table 테이블이름(
     컬럼명 datatype [null | not null]  [constraint 별칭 제약조건종류] ,
     컬럼명 datatype [null | not null]  [constraint 별칭 제약조건종류] ,
     컬럼명 datatype [null | not null]  [constraint 별칭 제약조건종류] ,
     ....
  
  );
  
  
  * 제약조건 종류
    1) Primary key
    2) Foreign key
    3) unique
    4) check
    
    5) default
*/

/*
1) primary key 
    : 기본키= 대표키 = pk
    : pk를 설정하면 not null, 중복안됨.
    : pk컬럼은 자동 index 설정됨.
    : 하나의 테이블에 pk는 반드시 한개만 존재한다.
    : 여러개의 컬럼을 하나로 묶어서 pk설정은 가능하다(복합키)
*/

--레코드 검색
select * from member;

--테이블 구조
desc member;

--레코드 등록(삽입)
insert into 테이블이름(컬럼명, 컬럼명,....) values(값, 값,.....);
insert into 테이블이름 values(값,값,.....);

ex) 추가
insert into member(id,name,AGE,ADDR,REGDATE) VALUES('JANG','장희정',20,'서울', SYSDATE );
insert into member(id,name,AGE,ADDR,REGDATE) VALUES('jang','장희정',20,'서울', SYSDATE );

insert into member values('hee','나영',25,'대구','2020-7-22');

--null or not null 체크
insert into member(name, age) values('효리',22); --id는 pk이므로 not null

insert into member(id, name, age) values('aa','효리',22); --성공

select * from member;
insert into member(id, name, age) values('bb','나영',100);--오류
insert into member(id, name, age) values('bb','나영',99);

--문자형예제
create table test1(
 name1 varchar2(5),
 name2 varchar2(5 char),
 name3 char(5),
 name4 char, --byte수를 생략하면 기본 1byte설정
 name5 varchar2(1) -- byate수를 생략할수 없다.
);

desc test1; --테이블구조

insert into test1(name1) values('abcde');
insert into test1(name1) values('장희정'); -- 크기를 벗어나서 등록안됨.

insert into test1(name2) values('장희정'); --성공

insert into test1(name3) values('a');
insert into test1(name3) values('ab'); 
insert into test1(name3) values('abc');
insert into test1(name3) values('장희정');  --오류

select * from member; -- 주석....

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

insert into test2(no3) values(9);
insert into test2(no3) values(99);
insert into test2(no3) values(99999999999);

insert into test2(no4) values(99999999999);
insert into test2(no5) values(99999999999);
select * from test2;

--------------------------------------------------------
--테이블 삭제
drop table member;

-- 두개의 컬럼을 하나의 pk로 만들기
CREATE TABLE MEMBER(
  ID VARCHAR2(5 CHAR) ,
  JUMIN CHAR(6),
  NAME VARCHAR2(5) NOT NULL,
  AGE NUMBER(3),
  ADDR VARCHAR2(20) ,
  CONSTRAINT MEM_ID_JUMIN_PK PRIMARY KEY(ID,JUMIN)
);

--테이블 검색
SELECT * FROM MEMBER;
--테이블 구조
DESC MEMBER;

--레코드 등록
INSERT INTO MEMBER VALUES('JANG','11111','효리',NULL, NULL);
INSERT INTO MEMBER VALUES('JANG','2222','효리',NULL, NULL);
INSERT INTO MEMBER VALUES('HEE','2222','효리',NULL, NULL);

INSERT INTO MEMBER VALUES('HEE','2222','효리',NULL, NULL);

--테이블구조 변경 - 데이터 타입 변경
ALTER TABLE MEMBER MODIFY NAME VARCHAR2(20);

-------------------------------------------------------------------
--2) Foreign key
/*
  : 외래키 = FK
  : 다른테이블의 기본키(PK)를 참조하는 것.
  : 레코드를 등록할때 참조되는 컬럼에 있는 값 이외는 등록할수 없다.
  : NULL 허용, 중복가능.
  : 한테이블에 여러개의 컬럼에  FK설정 가능함.
  
   * 주의사항
     INSERT할때 : 부모 INSERT -> 자식 INSERT한다.
     DELETE 할때 :자식 DELETE  -> 부모 DELETE  한다.
      - 이러한 번거로움을 해결하기 위해서 테이블 생성할때 옵션 설정할수 있다.
         ON DELETE CASCADE   - 부모를 삭제할때 자식레코드드 함께 삭제 자동으로 된다.
*/

--테이블 생성
CREATE TABLE DEPT(
  DEPT_NO CHAR(3) CONSTRAINT DPET_NO_PK PRIMARY KEY,
  DNAME VARCHAR2(20) NOT NULL,
  LOC VARCHAR2(30)
);

--샘플 데이터 추가
INSERT INTO DEPT(DEPT_NO, DNAME, LOC) VALUES('A01','인사부','서울');
INSERT INTO DEPT(DEPT_NO, DNAME, LOC) VALUES('A02','경리부','대구');
INSERT INTO DEPT(DEPT_NO, DNAME, LOC) VALUES('A03','교육부','제주도');

--테이블 생성
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --사원번호
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  DEPT_NO CHAR(3) CONSTRAINT EMP_DEPTNO_FK REFERENCES DEPT(DEPT_NO)
);

SELECT * FROM EMP;

--샘픔데이터 추가
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(1,'이효리',20, NULL);-- 부서번호 NULL 허용함 
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(2,'이미영',22, 'A01');
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(3,'전선영',25, 'A01');--부서번호중복가능

INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(4,'정미연',25, 'A04');--오류발생

--부모키를 먼저 등록하고 자식키를 등록한다.
INSERT INTO DEPT VALUES('A04','경제부','서울');
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(4,'정미연',25, 'A04');

--레코드 삭제
TRUNCATE 테이블이름; --모든 레코드를 삭제(절삭)  : ROLLBACK안됨)
DELETE FROM 테이블이름; --모든 레코드를 삭제 : ROLLBACK 가능)
DELETE FROM 테이블이름 WHERE 조건식; --조건에 해당하는 레코드를 삭제

 * FORM 키워드 생략가능하다.


EX) 참조되고 있는 자식 레코드를 삭제해본다.
DELETE FROM EMP WHERE EMP_NO=4; --성공

EX) 참조대상인  부모레코드를 삭제해본다.
DELETE FROM DEPT WHERE DEPT_NO='A01'; -- 삭제 실패.

* 삭제하고 싶으면 참조되는 자식 레코드 먼저 삭제하고 부모 삭제한다.
DELETE EMP WHERE DEPT_NO='A01'; --성공
DELETE FROM DEPT WHERE DEPT_NO='A01'; --성공

--ON DELETE CASCADE 옵션 설정하기
DROP TABLE EMP;
DROP TABLE DEPT;

-- DEPT테이블 생성한다. - 위에 쿼리 그대로 다시 실행.

-- 자식테이블 EMP테이블을 옵션을 설정해서 생성해본다.
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --사원번호
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  DEPT_NO CHAR(3) CONSTRAINT EMP_DEPTNO_FK REFERENCES DEPT(DEPT_NO) ON DELETE CASCADE
);

--샘플레코드 추가
INSERT INTO EMP VALUES(1,'나영',20, 'A01' );
INSERT INTO EMP VALUES(2,'효리',22, 'A02' );
INSERT INTO EMP VALUES(3,'선영',21, 'A01' );

-- 부모레코드를 삭제해본다(참조되고 있는 대상 레코드 삭제)
DELETE FROM DEPT WHERE DEPT_NO='A01';



DROP TABLE EMP;
--FOREIGN KEY를 맨뒤에 작성하기.
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --사원번호
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  부서코드 CHAR(3) ,
  JOB VARCHAR2(30) NOT NULL,
  CONSTRAINT EMP_DEPTNO_FK FOREIGN KEY(부서코드) REFERENCES DEPT(DEPT_NO) ON DELETE CASCADE
);


CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --사원번호
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  부서코드 CHAR(3) CONSTRAINT EMP_DEPTNO_FK REFERENCES DEPT(DEPT_NO) ON DELETE CASCADE
);


SELECT * FROM DEPT;
SELECT * FROM EMP;











