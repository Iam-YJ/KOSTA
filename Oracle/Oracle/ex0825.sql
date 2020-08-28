--제약조건
/*
  3) UNIQUE
     : 중복안됨,  NULL허용함(NOT NULL설정하면 PK와 동일) - 후보키중에 대표키가 될수 없는 컬럼에 설정한다.
     : 하나의 테이블에 여러개 컬럼에 설정 가능
     : 대표키는 될수 없지만 유일해야하는 컬럼에 설정한다.
  
  4) CHECK
     : 조건을 설정해서 조건에 해당하는 값이외에는 INSERT 될수 없도록 하는것.
  
  5) DEFAULT
     : 기본값 설정
     : INSERT할때 값을 넣지 않으면 자동으로 DEFAULT값이 INSERT된다.
       EX) 등록일, 최초조회수

*/
--EX) 테이블 생성
CREATE TABLE TEST(
  ID VARCHAR2(20) PRIMARY KEY, 
  JUMIN CHAR(13)  UNIQUE, -- NULL 허용
  AGE NUMBER(2) CHECK(AGE >=10 AND AGE <=20),
  ADDR VARCHAR2(20) CHECK(ADDR='서울' OR ADDR='대구' OR ADDR='대전'),
  GENDER CHAR(6) DEFAULT '남자'
);

SELECT * FROM TEST;

--레코드 등록
INSERT INTO TEST VALUES('JANG','1111',12,'서울', DEFAULT);
INSERT INTO TEST(ID,JUMIN,AGE) VALUES('HEE','2222',15);--자동으로 GENDER 값 들어간다.
INSERT INTO TEST(ID,JUMIN,AGE,GENDER) VALUES('CCC','333',15,NULL);

INSERT INTO TEST(ID,AGE,GENDER) VALUES('FFF',15,NULL);

-------------------------------------------------------------
--테이블 수정
--1) 컬럼추가
  ALTER TABLE 테이블이름 ADD ( 컬럼명 데이터타입 [제약조건] ,..... )
  
  EX)
   ALTER TABLE TEST ADD ( PHONE VARCHAR2(20) , ETC  VARCHAR2(30)  DEFAULT '기타' );
   
   ALTER TABLE TEST ADD NAME1 VARCHAR2(20)  DEFAULT '희정' NOT NULL ; --순서( DEFAULT NOT NULL)
  
   ALTER TABLE TEST ADD NO1 NUMBER(2)  
  
  SELECT * FROM TEST;
  DESC TEST;
  
--2) 컬럼 삭제
 ALTER TABLE 테이블이름 DROP COLUMN 컬럼명;
 
 EX) ALTER TABLE TEST DROP COLUMN PHONE;
     ALTER TABLE TEST DROP COLUMN NAME1;
 
 
 
--3)데이터타입 변경
 ALTER TABLE 테이블이름 MODIFY 컬럼명 변경데이터타입; 
 EX) ALTER TABLE TEST MODIFY NO1 VARCHAR2(20);
 
 SELECT * FROM TEST;
 
 --4)컬럼이름 변경
 ALTER TABLE 테이블이름 RENAME COLUMN 변경전컬럼명 TO 변경할이름;
 
 --5) 제약조건 추가
 ALTER TABLE 테이블이름 ADD CONSTRAINT 별칭 제약조건;
 EX) ALTER TABLE TEST ADD CONSTRAINT TEST_NO1_UNIQUE UNIQUE(NO1); 
 

 
 6)제약조건 삭제
 ALTER TABLE 테이블이름 DROP CONSTRAINT 제약조건이름; 
 
 
 7) 테이블 삭제
 DROP TABLE 테이블이름;
 
----------------------------------------------------
/*
테이블 복사
 CREATE TABLE 테이블이름
 AS 복사할테이블내용;
*/

1) 모든 컬럼과 모든 레코드 복사 -  단 제약조건 복사 안됨.
SELECT * FROM COPY_EMP;

 : 제약조건 추가
ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_PK PRIMARY KEY(EMPNO);
ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_F FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO);

2) 특정 컬럼(PROJECT)과 특정 레코드(SELECTION)만 복사하기
 CREATE TABLE COPY_EMP2
  AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000;
  
  SELECT * FROM COPY_EMP2;
  
3) 테이블 구조만 복사하기
 CREATE TABLE COPY_EMP3
 AS SELECT * FROM EMP WHERE 1=0;
 
 SELECT * FROM COPY_EMP3;
 
 
 --DML문장(INSERT, UPDATE, DELETE) 
 /*
    : 상황에 따라 COMMIT OR ROLLBACK 가능하다. - TRANSACTION을 이용한다.
 */
 
 --INSERT  : 레코드 삽입
 INSERT INTO 테이블이름(컬럼명,....) VALUES(값,.....);
 INSERT INTO 테이블이름 VALUES(값,....); -- 모든컬럼에 순서대로 값을 설정.
 
 
 --UPDATE : 레코드 수정
 UPDATE 테이블이름
 SET 컬럼명=변경값, 컬럼명= 변경값, ....
 [ WHERE 조건식 ];
 
 
 --DELETE : 레코드 삭제
 DELETE [FROM] 테이블이름
 [WHERE 조건식];


-- COPY_EMP테이블 가지고 실습..
SELECT * FROM COPY_EMP;
DESC COPY_EMP;
EX) EMPNO가 7654인 사원의 ENAME을 'HEE' , JOB을 '백조' , SAL를 3500으로 변경하세요.

UPDATE COPY_EMP
SET ENAME='HEE' , JOB='백조' , SAL=3500
WHERE EMPNO=7654;


EX) SAL가 1000 ~ 2000사이인 사원의  급여를 3000, 입사일은 현재날짜로 변경.
UPDATE COPY_EMP
SET SAL=3000, HIREDATE = SYSDATE
--WHERE SAL >=1000 AND SAL <=2000;
WHERE SAL BETWEEN 1000 AND 2000;


SELECT * FROM COPY_EMP ORDER BY SAL;


EX) DEPTNO가 30이면서 JOB이 SALESMAN인 사원의 COMM을 1000으로 변경하세요.
UPDATE COPY_EMP
SET COMM=2000
WHERE DEPTNO=30 AND LOWER(JOB) =LOWER('sALESmAn');


EX) EMPNO가 7782와 7844인 사원을 삭제하세요.
DELETE FROM COPY_EMP
WHERE EMPNO=7782 OR EMPNO=7844;


EX) 사원 2면 등록하기

----------------------------------------------------------------
--DQL문장 : SELECT문
/*
   SELECT DISTINCT | *  | 컬럼명 AS 별칭 , 컬럼명 AS 별칭 ,......  --열(속성)제한-PROJECTION
   FROM 테이블이름
   [WHERE  조건식 ] -- 레코드(튜플)제한 - SELECTION
   [ORDER BY 정렬대상컬럼 ASC | DESC , 정렬대상컬럼 ASC|DESC]
   
   
   --실행순서
      FROM -> WHERE -> SELECT -> ORDER BY
*/

SELECT * FROM EMP;

1) 원한 컬럼과 별칭 만들기
SELECT EMPNO, ENAME AS 이름 , JOB AS "담당 업무" , SAL 급여 FROM EMP;

2) 중복행 제거 (DISTINCT)
SELECT DISTINCT EMPNO, JOB FROM EMP;

EX)우리 직원의 직무(JOB)종류 를 알고 싶다.
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;

EX) 급여가 2000이상인 사원 검색.
SELECT *
FROM EMP
WHERE SAL >=2000; --SELECTION(레코드제한)

EX) 급여가 2000이상인 사원 검색하고 급여를 기준으로 내림정렬.
SELECT * FROM EMP WHERE SAL >2000 ORDER BY SAL; --올림차순
SELECT * FROM EMP WHERE SAL >2000 ORDER BY SAL DESC; --내림차순

EX) JOB을 기준으로 내림차순으로 하고 같으면 급여를 기준으로 올림차순 정렬
SELECT * FROM EMP ORDER BY JOB DESC , SAL ;

-----------------------------------------------------
/*
  -연산자 종류
  
   1) 산술연산자
      : +, - , * , /  , MOD(값, 나눌수) - 나머지
      
   2) 관계연산자
     > ,<  , >=  , <= , != ,  = 같다
     
   3) 비교연산자
      - AND
      - OR
      - BETWEEN 최소값 AND 최대값
         : 하나의 컬럼을 기준으로 최소 ~ 최대 범위를 조건을 사용할때 AND연산자 보다 편하다.
      
      - 컬럼명 IN (값, 값,....)
         : 하나의 컬럼을 기준으로 값을 OR 연산자로 비교하고자 할때 OR연산자 보다 편하다.
      
      - LIKE 
         : 와일드카드문자( _ , %) 와 함께 사용하며 데이터 중에 특정한 문자를 포함한
           레코드를 검색할때 사용한다. 
           -  1) _ : 한문자
                 % : 0개이상의 문자
                 
            EX) JOB LIKE 'J%' - JOB이 J로 시작하는 문자열을 검색
                JOB LIKE '%J%' - JOB이 J라는 문자를 포함하고 있는 레코드 검색
                JOB LIKE '___' - 3글자를 검색
                JOB LIKE 'A_B%' - 
                
                
       * 위에 연산자 앞에 NOT을 붙이면 반대
*/

EX) 산술연산자
 SELECT EMPNO, ENAME, SAL , COMM ,  SAL+COMM
 FROM EMP; -- NULL을 포함하고 있으면 산술연산자 적용안된다.
 
 * NULL값을 찾아서 원하는 값을 변경하고 연산을 한다. - NVL(값, 변경값 ) 함수이용한다.
 SELECT COMM , NVL(COMM, 100) AS NVL함수 FROM EMP;
 
 
 SELECT EMPNO, ENAME, SAL , COMM ,  (SAL+NVL(COMM,0)) * 12 AS 년봉
 FROM EMP;
 
 EX) ~님 년봉은 ~ 입니다 
 SELECT ENAME || '님 년봉은' || SAL || '입니다.' AS "설명 하기"
 FROM EMP


EX) SAL가 2000 ~ 4000 사이인 레코드 검색
 -- AND
 SELECT * FROM EMP  WHERE SAL >=2000 AND SAL <=4000 ORDER BY SAL;
 
 EX) SAL가 2000 ~ 4000 사이 아닌  레코드 검색
 SELECT * FROM EMP  WHERE NOT(SAL >=2000 AND SAL <=4000) ORDER BY SAL;
 
 
 -- BETWEEN AND
 SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 4000 ORDER BY SAL;
  SELECT * FROM EMP WHERE SAL NOT BETWEEN 2000 AND 4000 ORDER BY SAL;
 
 
 EX) EMPNO가 7499, 7566 7782, 7839 인 레코드 검색
  --OR
   SELECT * FROM EMP WHERE  EMPNO=7499  OR EMPNO=7566 OR EMPNO=7782 OR EMPNO=7839;
   SELECT * FROM EMP WHERE  NOT(EMPNO=7499  OR EMPNO=7566 OR EMPNO=7782 OR EMPNO=7839);
  
  --IN
  SELECT * FROM EMP WHERE EMPNO IN(7499,7566,7782,7839);
  SELECT * FROM EMP WHERE EMPNO NOT IN(7499,7566,7782,7839);


 --LIKE 연산자
 EX) JOB이 'A'로 시작하는 레코드 검색
  SELECT * FROM EMP WHERE JOB LIKE 'A%';
  SELECT * FROM EMP WHERE JOB = 'A%';--검색안됨.
  
  SELECT * FROM EMP WHERE UPPER(JOB) LIKE UPPER('a%');
  SELECT * FROM EMP WHERE UPPER(JOB) NOT LIKE UPPER('a%');
  
 
 EX) JOB에 끝이 N으로끝나는 레코드 검색
 SELECT * FROM EMP WHERE JOB LIKE '%N';
 
 EX) ENAME이 4글자인 레코드 검색
  SELECT * FROM EMP WHERE ENAME LIKE '____';
  SELECT * FROM EMP WHERE ENAME NOT LIKE '____';
 
 EX) ENAME에 A글자가 들어가는 레코드 검색
  SELECT * FROM EMP WHERE ENAME LIKE '%A%';
 
 EX) ENAME이 전체글자는 5글자이고 첫글자는 A
 SELECT * FROM EMP WHERE ENAME LIKE 'A____' ;
  SELECT * FROM EMP WHERE ENAME LIKE 'A%E%' ;
  
 /*
  -ANY : 하나라도 만족하면 TRUE
    컬럼명 < ANY(100, 200, 300)  - 최대값보다 작으면 TRUE
    컬럼명 > ANY (100, 200,300)  - 최소값보다 크면 TRUE
  
  -ALL : 모두 만족해야만 TRUE
     컬럼명 < ALL (100, 200, 300)  - 최소값보다 작으면 TRUE
     컬럼명 > ALL (100, 200,300)  - 최대값보다 크면 TRUE
  
 */ 
 
 
 SELECT * FROM EMP;
 SELECT * FROM EMP WHERE SAL < ANY(1000,2000,3000) ORDER BY SAL; --3000보다 작으면 
 SELECT * FROM EMP WHERE SAL > ANY(1000,2000,3000) ORDER BY SAL; --1000보다 크면 
 
 SELECT * FROM EMP WHERE SAL < ALL(1000,2000,3000) ORDER BY SAL; -- 1000보다 작으면
 SELECT * FROM EMP WHERE SAL > ALL(1000,2000,3000) ORDER BY SAL; -- 3000보다 크면
 
 -- DEPTNO(부서번호) 가 30인 사원들중의 급여보다 많이 받는 사원 검색
  1) 30번 부서의 사원들의 급여 
   SELECT SAL FROM EMP WHERE DEPTNO=30;
   
2) 1)을 조건으로 사용해서 검색
 SELECT * FROM EMP WHERE  SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO=30) ORDER BY SAL;
 
 
-- DEPTNO(부서번호) 가 30인 사원들중의 급여보다 적게 받는 사원 검색
SELECT * FROM EMP WHERE  SAL < ALL(SELECT SAL FROM EMP WHERE DEPTNO=30) ORDER BY SAL;


---------------------------------------------------------------------
/*
  --NULL값 찾기
   1) IS NULL
   2) IS NOT NULL
*/

SELECT * FROM EMP;
EX) COMM이 NULL인 레코드 검색하기
  SELECT * FROM EMP WHERE COMM= 'NULL';
  SELECT * FROM EMP WHERE COMM= NULL;
  
  SELECT * FROM EMP WHERE COMM IS NULL;
  
EX) COMM이 NULL이 아닌 레코드 검색하기 
  SELECT * FROM EMP WHERE COMM IS NOT NULL;

-------------------------------------------------------
/*
   1) 집계함수
    -SUM(컬럼명) : 총점
    -AVG(컬럼명) : 평균
    -MIN(컬럼명) : 최소값
    -MAX(컬럼명) : 최대값
    -COUNT(컬럼명) : NULL을 제외한 전체 레코드수
    -COUNT(*) : NULL포함한 전체 레코드 수  
*/

EX) 성적테이블 생성
CREATE TABLE SUNGJUCK(
  NAME VARCHAR(20) PRIMARY KEY,
  BAN NUMBER(1),
  KOR NUMBER(3) CHECK(KOR BETWEEN 0 AND 100) ,
  ENG NUMBER(3) CHECK(ENG BETWEEN 0 AND 100) ,
  MATH NUMBER(3) CHECK(MATH BETWEEN 0 AND 100) 
);

--샘플레코드 추가
INSERT INTO SUNGJUCK VALUES('효리',1 , 80,90,60);
INSERT INTO SUNGJUCK VALUES('나영',1 , 90,70,85);
INSERT INTO SUNGJUCK VALUES('석범',1 , 80,70,90);

INSERT INTO SUNGJUCK VALUES('재석',2 , 95,95,70);
INSERT INTO SUNGJUCK VALUES('비'  ,2 , 60,85,85);

INSERT INTO SUNGJUCK VALUES('동건',3 , 70,80,90);
INSERT INTO SUNGJUCK VALUES('중기',3 , 60,85,95);
INSERT INTO SUNGJUCK VALUES('혜교',3 , 55,90,50);

INSERT INTO SUNGJUCK VALUES('소영',3 , NULL,90,50);



SELECT * FROM SUNGJUCK;
EX) 각 개인별 총점, 평균 구한다.
SELECT NAME, BAN, KOR, ENG, MATH , 
(NVL(KOR,0)+NVL(ENG,0)+ NVL(MATH,0)) AS 총점 ,
ROUND( (NVL(KOR,0)+NVL(ENG,0)+ NVL(MATH,0))/3  , 2) AS 평균
FROM SUNGJUCK; 

EX) 국어점수의 총점, 평균, 레코드수 , 최대값, 최소값.....

SELECT SUM(KOR) 총점 , AVG(KOR) , AVG(NVL(KOR,0)), COUNT(KOR), COUNT(*)  ,
 MAX(KOR), MIN(KOR)
FROM SUNGJUCK;

SELECT NAME , SUM(KOR) 총점 , AVG(KOR) 
FROM SUNGJUCK; --일반컬럼과 집계함수를 함께 사용할수 없다. 단, GROUP BY 있으면 사용가능하다.

--
EX) 각 반별 국어의 총점, 평균, 최대, 최소 구하기
SELECT BAN, SUM(KOR), AVG(KOR), MAX(KOR), MIN(KOR)
FROM SUNGJUCK
GROUP BY BAN; --각 반변 그룹을 지어 그룹별 집계함수를 만든다.
              -- GROUP BY절에 나온 컬럼은 SELECT절에서 사용 할수 있다.
              
              
EX) KOR 점수가 70이상인 학생들의 반별 총점, 평균 구한다.
SELECT BAN, SUM(KOR) , AVG(KOR)
FROM SUNGJUCK
WHERE KOR >=70
GROUP BY BAN;


EX) KOR의 평균이 70이상인 학생들의 반별 총점, 평균 구한다.
SELECT BAN, SUM(KOR) , AVG(KOR)
FROM SUNGJUCK
WHERE AVG(KOR) >=70 -- 오류(집계함수를 WHERE에 조건으로 사용할수없다)
GROUP BY BAN; --실패


SELECT BAN, SUM(KOR) , AVG(KOR)
FROM SUNGJUCK
GROUP BY BAN
HAVING AVG(KOR) >=70 ; --GROUP BY 절이 있을때 사용하면 집계함수를 조건으로 사용할때 쓴다.


-- SELECT문장
SELECT    5)
FROM      1)
WHERE     2)
GROUP BY  3)
HAVING    4)
ORDER BY  6)
---------------------------------------------------



SELECT * FROM SUNGJUCK;












