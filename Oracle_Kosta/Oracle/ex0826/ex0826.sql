/*
    ���ڰ��� �Լ�
    1) round(����, �ڸ���) : �ݿø�
    2) trunc(����, �ڸ���) : �ڸ������� ����
    3) ceil(����) : �ø��ؼ� ������
    4) floor(����) : �����ؼ� ������
    5) mod(����, ������) : ������ 
*/

select 45.12457 as ���� , '�ȳ�' as ����
from dual; --�ӽð��� ���̺� 

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

select 45.46543, mod(45.46543,6) --������
from dual;


select sysdate from dual;

-----------------------------------------------
/*
    ���ڿ� �Լ� -- �ε����� 1���� ����
    1) upper(���ڿ�) : ��� �빮�ڷ� ��ȯ
    2) lower(���ڿ�) : ��� �ҹ��ڷ� ��ȯ
    3) initcap(���ڿ�) : �ܾ��� ù���� �빮�ڷ� ��ȯ
    
    4) length(���ڿ�) : ���ڿ��� ���� - ���鵵 ���ڿ��� ����
    
    5) ���ڿ����� �Ϻκ��� ���ڿ��� ������ �� 
       substr(���ڿ�, ����index) : ����index ���� ������ ����(index�� 1���� ����)
       substr(���ڿ�, ����index, ����) : ���� index���� �������� ����
       
    6) ���ڿ����� Ư�� ���ڰ� ���(index)�� �ִ��� ã��(��� index�� ���´�)
       instr(���ڿ�, ã�¹��ڿ�)
       instr(���ڿ�, ã�¹��ڿ�, ������ġ) : ������ġ�� -1�� �ָ� �����ʺ��� �˻�
                                             ������ġ�� 2�� �ָ� 2��° index ���� ã����� 
                                             
       instr(���ڿ�, ã�¹��ڿ�, ������ġ, ���°���� )
       
       - ã�� ���ڿ��� ������ 0
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

ex) scott �������� �����Ѵ�
    : emp ���̺��� job�� ����° ���ڰ� 'A' ���ڵ� �˻�
    
    select * from emp;
    
-- LIKE
 select * from emp where upper(job) like upper('__A%');

-- SUBSTR : ��� ����
 select * from emp where substr(job,3,1)='A';
 
-- INSTR : ��� ���� 
 select * from emp where instr(job,'A',3)=3;
 
 ------------------------------------------------------------------
 /*
  ��¥���� �Լ�
  
  1) sysdate
  2) months_between(��¥, ��¥) : �� ��¥ ������ ������ �� 
  3) add_months(��¥, ����) : ��¥�� ���ڸ�ŭ ������ ���ϱ� 
  4) next_day(��¥, ����) : ��¥�� �������� ���� ����� ������ ��¥ ���ϱ�
            * ���� - 1(��), 2(��), 3(ȭ), 4(��), 5(��), 6(��), 7(��)
  5) last_day(��¥) : ��¥�� �ش��ϴ� ���� ������ ���� ���Ѵ� 
  
  -- ����ȯ �Լ�
  1) to_char() : ���ڷ� ��ȯ
  2) to_date() : ��¥�� ��ȯ
  3) to_number() : ���ڷ� ��ȯ
  */
  
  ex) ���ó�¥�� �������� ���� ����� �Ͽ��� ���ϱ�
  select sysdate, next_day(sysdate, 1) from dual;
  
  ex) �츮�� ������ 100�� �Ǵ³�?
  select to_date('2020-07-22') + 100 from dual;
  select sysdate + 100 from dual;
  
  ex) scott ������ emp ���̺��� ������� �ٹ� ������, �� �� �ٹ� ���ϱ�
  select ename, hiredate, floor(months_between(sysdate, hiredate)) || '���� ' as �ѱٹ�����,
  ceil(months_between(sysdate, hiredate)/12) || '�� ' as ����
  from emp;
  
  ex) ���� ���� ������ �� �������� ���ϱ�
  select last_day(sysdate) from dual;
  
  
  --ADD_MONTHS(��¥, ����)
  SELECT ADD_MONTHS(SYSDATE, 5), TO_CHAR(ADD_MONTHS(SYSDATE, 5),'YYYY-MM-DD') FROM DUAL;
  
  SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD'), TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS')
    , TO_CHAR(SYSDATE, 'HH:MI:SS') , TO_CHAR(SYSDATE, 'YYYY')
  FROM DUAL;
  
  
  EX) EMP ���̺��� �� ����� �Ի�⵵ �˻�
  SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY') FROM EMP;
  
  EX) ���ڸ� 3�ڸ����� �޸�
  SELECT 2457000, TO_CHAR(2457000, '999,999,999') FROM DUAL;
  SELECT SAL, TO_CHAR(SAL, '999,999,999') FROM EMP;
  SELECT TO_NUMBER('1000') + 10  FROM DUAL;
  
  ------------------------------------------------------------
  /*
   SELECT ������ ����� �� �ִ� ���ǽ�
   1) DECODE(���, ��, ����, ����,....����)
      : �񱳴���� ���� ��Ȯ�ϰ� ��ġ�� �� ����Ѵ�.
        ������ ������ ���� ��� ����� �� ����. 
        
   2) CASE END [���]
        WHEN ���ǽ� THEN ����
        WHEN ���ǽ� THEN ����
        WHEN ���ǽ� THEN ����
        ...
        ELSE ����
      END
   
  */
  
  SELECT * FROM EMP;
  
 EX) EMP���̺��� DEPNO�� 10 �̸� ������, 20�̸� �ѹ���, 30�̸� ������ 
     �̿��� ���� ��Ÿ�� �� ����ϰ� �÷����� �μ��� ���� �Ѵ�.
     (DECODE, CASE END)

     --DECODE
     SELECT EMPNO, ENAME, DEPTNO , DECODE(DEPTNO, 10, '������', 20,'�ѹ���', 30,'������','��Ÿ��') AS �μ���
     FROM EMP ORDER BY �μ���;
     
     --CASE END
       SELECT EMPNO, ENAME, DEPTNO,
       CASE DEPTNO
       WHEN 10 THEN '������'
       WHEN 20 THEN '�ѹ���'
       WHEN 30 THEN '������'
       ELSE '��Ÿ��'
       END AS �μ���
     FROM EMP ORDER BY �μ��� ;
        ----
        SELECT EMPNO, ENAME, DEPTNO,
       CASE 
       WHEN DEPTNO = 10 THEN '������'
       WHEN DEPTNO = 20 THEN '�ѹ���'
       WHEN DEPTNO = 30 THEN '������'
        FROM EMP;
        

ex)job�� manager�� ��� sal*0.1, ANALYST �ΰ���   sal *0.2
     SALESMAN�� ���� sal * 0.3�� ���ؼ� ������ �ʵ带 �����.
      (case end, decode �� �غ���) 
      
      --DECODE
      SELECT EMPNO, ENAME, JOB, SAL, 
      DECODE(JOB, 'MANAGER',SAL*0.1, 'ANALYST',SAL*0.2,'SALESMAN',SAL*0.3,0) AS ������
      FROM EMP;
      
      --CASE END
      SELECT EMPNO, ENAME, JOB, SAL,
      CASE LOWER(JOB)
      WHEN 'manager' THEN SAL*0.1
      WHEN 'analyst' THEN SAL*0.2
      WHEN 'salesman' THEN SAL*0.3
      END AS ������
      FROM EMP ORDER BY JOB;
      

ex) sal�� 2000�����̸� '���ҵ���'
      sal�� 2001 ~ 4000���̸� '�߻���'
      sal�� 4001 �̻��̸� '��ҵ���'  ���Ͽ� ��� ��Ī ���ش�.
      (case end) 
      
      SELECT EMPNO, ENAME, JOB,SAL,
      CASE
      WHEN SAL < =2000 THEN '���ҵ���'
      WHEN SAL BETWEEN 2001 AND 4000 THEN '�߻���'
      ELSE '��ҵ���'
      END AS ���
      FROM EMP ORDER BY SAL;