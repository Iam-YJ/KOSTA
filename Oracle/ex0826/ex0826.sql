/*
    숫자관련 함수
    1) round(숫자, 자리수) : 반올림
    2) trunc(숫자, 자리수) : 자리수에서 버림
    3) ceil(숫자) : 올림해서 정수로
    4) floor(숫자) : 내림해서 정수로
    5) mod(숫자, 나눌수) : 나머지 
*/

select 45.12457 as 숫자 , '안녕' as 문자
from dual; --임시공간 테이블 

ex) 
select 45.46543, round(45.46543, 0), round(45.46543, 1),  round(45.46543, 2),
round(45.46543, -1), round(45.46543, -2)
from dual;

select 45.46543, trunc(45.46543, 0), trunc(45.46543, 1),  trunc(45.46543, 2),
trunc(45.46543, -1), trunc(45.46543, -2)
from dual;

select 45.46543, ceil(45.46543)
from dual;

select 45.46543, floor(45.46543)
from dual;

select 45.46543, mod(45.46543,6) --나머지
from dual;


select sysdate from dual;

-----------------------------------------------
/*
    문자열 함수 -- 인덱스가 1부터 시작
    1) upper(문자열) : 모두 대문자로 변환
    2) lower(문자열) : 모두 소문자로 변환
    3) initcap(문자열) : 단어의 첫글자 대문자로 변환
    
    4) length(문자열) : 문자열의 길이 - 공백도 문자열에 포함
    
    5) 문자열에서 일부분의 문자열을 추출할 때 
       substr(문자열, 시작index) : 시작index 부터 끝까지 추출(index는 1부터 시작)
       substr(문자열, 시작index, 개수) : 시작 index부터 개수까지 추출
       
    6) 문자열에서 특정 문자가 어디(index)에 있는지 찾기(결과 index로 나온다)
       instr(문자열, 찾는문자열)
       instr(문자열, 찾는문자열, 시작위치) : 시작위치를 -1을 주면 오른쪽부터 검색
                                             시작위치를 2를 주면 2번째 index 부터 찾기시작 
                                             
       instr(문자열, 찾는문자열, 시작위치, 몇번째출현 )
       
       - 찾는 문자열잉 없으면 0
*/

select 'JANG hee juNg', upper('JANG hee juNg'), lower('JANG hee juNg'),
        initcap('JANG hee juNg'), length('JANG hee juNg')
from dual;

ex) substr
select 'abcde ABCDE 12345', substr('abcde ABCDE 12345', 3), substr('abcde ABCDE 12345', 3, 5)
from dual;

ex) inbstr
select 'abcde abcde abcde',instr('abcde abcde abcde', 'c'), instr('abcde abcde abcde', 'c' ,5), 
    instr('abcde abcde abcde', 'c' ,-1), instr('abcde abcde abcde', 'c' ,2,2), instr('abcde abcde abcde', 'g')
from dual;

ex) scott 계정으로 접속한다
    : emp 테이블에서 job의 세번째 글자가 'A' 레코드 검색
    
    select * from emp;
    
-- LIKE
 select * from emp where upper(job) like upper('__A%');

-- SUBSTR : 결과 문자
 select * from emp where substr(job,3,1)='A';
 
-- INSTR : 결과 숫자 
 select * from emp where instr(job,'A',3)=3;
 
 ------------------------------------------------------------------
 /*
  날짜관련 함수
  
  1) sysdate
  2) months_between(날짜, 날짜) : 두 날짜 사이의 개월수 차 
  3) add_months(날짜, 숫자) : 날짜에 숫자만큼 개월수 더하기 
  4) next_day(날짜, 요일) : 날짜를 기준으로 가장 가까운 요일의 날짜 구하기
            * 요일 - 1(일), 2(월), 3(화), 4(수), 5(목), 6(금), 7(토)
  5) last_day(날짜) : 날짜에 해당하는 달의 마지막 일을 구한다 
  
  -- 형변환 함수
  1) to_char() : 문자로 변환
  2) to_date() : 날짜로 변환
  3) to_number() : 숫자로 변환
  */
  
  ex) 오늘날짜를 기준으로 가장 가까운 일요일 구하기
  select sysdate, next_day(sysdate, 1) from dual;
  
  ex) 우리가 만난지 100일 되는날?
  select to_date('2020-07-22') + 100 from dual;
  select sysdate + 100 from dual;
  
  ex) scott 계정의 emp 테이블에서 현재까지 근무 개월수, 몇 년 근무 구하기
  select ename, hiredate, floor(months_between(sysdate, hiredate)) || '개월 ' as 총근무개월,
  ceil(months_between(sysdate, hiredate)/12) || '년 ' as 연차
  from emp;
  
  ex) 현재 달의 마지막 일 언제인지 구하기
  select last_day(sysdate) from dual;
  
  
  --ADD_MONTHS(날짜, 숫자)
  SELECT ADD_MONTHS(SYSDATE, 5), TO_CHAR(ADD_MONTHS(SYSDATE, 5),'YYYY-MM-DD') FROM DUAL;
  
  SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS')
    , TO_CHAR(SYSDATE, 'HH:MI:SS') , TO_CHAR(SYSDATE, 'YYYY')
  FROM DUAL;
  
  
  EX) EMP 테이블에서 각 사원의 입사년도 검색
  SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY') FROM EMP;
  
  EX) 숫자를 3자리마다 콤마
  SELECT 2457000, TO_CHAR(2457000, '999,999,999') FROM DUAL;
  SELECT SAL, TO_CHAR(SAL, '999,999,999') FROM EMP;
  SELECT TO_NUMBER('1000') + 10  FROM DUAL;
  
  ------------------------------------------------------------
  /*
   SELECT 절에서 사용할 수 있는 조건식
   1) DECODE(대상, 값, 문장, 문장,....문장)
      : 비교대상의 값이 정확하게 일치할 때 사용한다.
        조건의 범위를 비교할 대는 사용할 수 없다. 
        
   2) CASE END [대상]
        WHEN 조건식 THEN 문장
        WHEN 조건식 THEN 문장
        WHEN 조건식 THEN 문장
        ...
        ELSE 문장
      END
   
  */
  
  SELECT * FROM EMP;
  
 EX) EMP테이블에서 DEPNO가 10 이면 관리부, 20이면 총무부, 30이면 영업부 
     이외의 값은 기타부 로 출력하고 컬럼명은 부서명 으로 한다.
     (DECODE, CASE END)

     --DECODE
     SELECT EMPNO, ENAME, DEPTNO , DECODE(DEPTNO, 10, '관리부', 20,'총무부', 30,'영업부','기타부') AS 부서명
     FROM EMP ORDER BY 부서명;
     
     --CASE END
       SELECT EMPNO, ENAME, DEPTNO,
       CASE DEPTNO
       WHEN 10 THEN '관리부'
       WHEN 20 THEN '총무부'
       WHEN 30 THEN '영업부'
       ELSE '기타부'
       END AS 부서명
     FROM EMP ORDER BY 부서명 ;
        ----
        SELECT EMPNO, ENAME, DEPTNO,
       CASE 
       WHEN DEPTNO = 10 THEN '관리부'
       WHEN DEPTNO = 20 THEN '총무부'
       WHEN DEPTNO = 30 THEN '영업부'
        FROM EMP;
        

ex)job이 manager인 경우 sal*0.1, ANALYST 인경우는   sal *0.2
     SALESMAN인 경우는 sal * 0.3을 구해서 성과급 필드를 만든다.
      (case end, decode 다 해본다) 
      
      --DECODE
      SELECT EMPNO, ENAME, JOB, SAL, 
      DECODE(JOB, 'MANAGER',SAL*0.1, 'ANALYST',SAL*0.2,'SALESMAN',SAL*0.3,0) AS 성과급
      FROM EMP;
      
      --CASE END
      SELECT EMPNO, ENAME, JOB, SAL,
      CASE LOWER(JOB)
      WHEN 'manager' THEN SAL*0.1
      WHEN 'analyst' THEN SAL*0.2
      WHEN 'salesman' THEN SAL*0.3
      END AS 성과급
      FROM EMP ORDER BY JOB;
      

ex) sal이 2000이하이면 '저소득층'
      sal이 2001 ~ 4000사이면 '중산층'
      sal이 4001 이상이면 '고소득층'  구하여 등급 별칭 해준다.
      (case end) 
      
      SELECT EMPNO, ENAME, JOB,SAL,
      CASE
      WHEN SAL < =2000 THEN '저소득층'
      WHEN SAL BETWEEN 2001 AND 4000 THEN '중산층'
      ELSE '고소득층'
      END AS 등급
      FROM EMP ORDER BY SAL;