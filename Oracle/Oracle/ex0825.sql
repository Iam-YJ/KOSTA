--��������
/*
  3) UNIQUE
     : �ߺ��ȵ�,  NULL�����(NOT NULL�����ϸ� PK�� ����) - �ĺ�Ű�߿� ��ǥŰ�� �ɼ� ���� �÷��� �����Ѵ�.
     : �ϳ��� ���̺� ������ �÷��� ���� ����
     : ��ǥŰ�� �ɼ� ������ �����ؾ��ϴ� �÷��� �����Ѵ�.
  
  4) CHECK
     : ������ �����ؼ� ���ǿ� �ش��ϴ� ���̿ܿ��� INSERT �ɼ� ������ �ϴ°�.
  
  5) DEFAULT
     : �⺻�� ����
     : INSERT�Ҷ� ���� ���� ������ �ڵ����� DEFAULT���� INSERT�ȴ�.
       EX) �����, ������ȸ��

*/
--EX) ���̺� ����
CREATE TABLE TEST(
  ID VARCHAR2(20) PRIMARY KEY, 
  JUMIN CHAR(13)  UNIQUE, -- NULL ���
  AGE NUMBER(2) CHECK(AGE >=10 AND AGE <=20),
  ADDR VARCHAR2(20) CHECK(ADDR='����' OR ADDR='�뱸' OR ADDR='����'),
  GENDER CHAR(6) DEFAULT '����'
);

SELECT * FROM TEST;

--���ڵ� ���
INSERT INTO TEST VALUES('JANG','1111',12,'����', DEFAULT);
INSERT INTO TEST(ID,JUMIN,AGE) VALUES('HEE','2222',15);--�ڵ����� GENDER �� ����.
INSERT INTO TEST(ID,JUMIN,AGE,GENDER) VALUES('CCC','333',15,NULL);

INSERT INTO TEST(ID,AGE,GENDER) VALUES('FFF',15,NULL);

-------------------------------------------------------------
--���̺� ����
--1) �÷��߰�
  ALTER TABLE ���̺��̸� ADD ( �÷��� ������Ÿ�� [��������] ,..... )
  
  EX)
   ALTER TABLE TEST ADD ( PHONE VARCHAR2(20) , ETC  VARCHAR2(30)  DEFAULT '��Ÿ' );
   
   ALTER TABLE TEST ADD NAME1 VARCHAR2(20)  DEFAULT '����' NOT NULL ; --����( DEFAULT NOT NULL)
  
   ALTER TABLE TEST ADD NO1 NUMBER(2)  
  
  SELECT * FROM TEST;
  DESC TEST;
  
--2) �÷� ����
 ALTER TABLE ���̺��̸� DROP COLUMN �÷���;
 
 EX) ALTER TABLE TEST DROP COLUMN PHONE;
     ALTER TABLE TEST DROP COLUMN NAME1;
 
 
 
--3)������Ÿ�� ����
 ALTER TABLE ���̺��̸� MODIFY �÷��� ���浥����Ÿ��; 
 EX) ALTER TABLE TEST MODIFY NO1 VARCHAR2(20);
 
 SELECT * FROM TEST;
 
 --4)�÷��̸� ����
 ALTER TABLE ���̺��̸� RENAME COLUMN �������÷��� TO �������̸�;
 
 --5) �������� �߰�
 ALTER TABLE ���̺��̸� ADD CONSTRAINT ��Ī ��������;
 EX) ALTER TABLE TEST ADD CONSTRAINT TEST_NO1_UNIQUE UNIQUE(NO1); 
 

 
 6)�������� ����
 ALTER TABLE ���̺��̸� DROP CONSTRAINT ���������̸�; 
 
 
 7) ���̺� ����
 DROP TABLE ���̺��̸�;
 
----------------------------------------------------
/*
���̺� ����
 CREATE TABLE ���̺��̸�
 AS ���������̺���;
*/

1) ��� �÷��� ��� ���ڵ� ���� -  �� �������� ���� �ȵ�.
SELECT * FROM COPY_EMP;

 : �������� �߰�
ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_PK PRIMARY KEY(EMPNO);
ALTER TABLE COPY_EMP ADD CONSTRAINT COPY_EMP_F FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO);

2) Ư�� �÷�(PROJECT)�� Ư�� ���ڵ�(SELECTION)�� �����ϱ�
 CREATE TABLE COPY_EMP2
  AS SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000;
  
  SELECT * FROM COPY_EMP2;
  
3) ���̺� ������ �����ϱ�
 CREATE TABLE COPY_EMP3
 AS SELECT * FROM EMP WHERE 1=0;
 
 SELECT * FROM COPY_EMP3;
 
 
 --DML����(INSERT, UPDATE, DELETE) 
 /*
    : ��Ȳ�� ���� COMMIT OR ROLLBACK �����ϴ�. - TRANSACTION�� �̿��Ѵ�.
 */
 
 --INSERT  : ���ڵ� ����
 INSERT INTO ���̺��̸�(�÷���,....) VALUES(��,.....);
 INSERT INTO ���̺��̸� VALUES(��,....); -- ����÷��� ������� ���� ����.
 
 
 --UPDATE : ���ڵ� ����
 UPDATE ���̺��̸�
 SET �÷���=���氪, �÷���= ���氪, ....
 [ WHERE ���ǽ� ];
 
 
 --DELETE : ���ڵ� ����
 DELETE [FROM] ���̺��̸�
 [WHERE ���ǽ�];


-- COPY_EMP���̺� ������ �ǽ�..
SELECT * FROM COPY_EMP;
DESC COPY_EMP;
EX) EMPNO�� 7654�� ����� ENAME�� 'HEE' , JOB�� '����' , SAL�� 3500���� �����ϼ���.

UPDATE COPY_EMP
SET ENAME='HEE' , JOB='����' , SAL=3500
WHERE EMPNO=7654;


EX) SAL�� 1000 ~ 2000������ �����  �޿��� 3000, �Ի����� ���糯¥�� ����.
UPDATE COPY_EMP
SET SAL=3000, HIREDATE = SYSDATE
--WHERE SAL >=1000 AND SAL <=2000;
WHERE SAL BETWEEN 1000 AND 2000;


SELECT * FROM COPY_EMP ORDER BY SAL;


EX) DEPTNO�� 30�̸鼭 JOB�� SALESMAN�� ����� COMM�� 1000���� �����ϼ���.
UPDATE COPY_EMP
SET COMM=2000
WHERE DEPTNO=30 AND LOWER(JOB) =LOWER('sALESmAn');


EX) EMPNO�� 7782�� 7844�� ����� �����ϼ���.
DELETE FROM COPY_EMP
WHERE EMPNO=7782 OR EMPNO=7844;


EX) ��� 2�� ����ϱ�

----------------------------------------------------------------
--DQL���� : SELECT��
/*
   SELECT DISTINCT | *  | �÷��� AS ��Ī , �÷��� AS ��Ī ,......  --��(�Ӽ�)����-PROJECTION
   FROM ���̺��̸�
   [WHERE  ���ǽ� ] -- ���ڵ�(Ʃ��)���� - SELECTION
   [ORDER BY ���Ĵ���÷� ASC | DESC , ���Ĵ���÷� ASC|DESC]
   
   
   --�������
      FROM -> WHERE -> SELECT -> ORDER BY
*/

SELECT * FROM EMP;

1) ���� �÷��� ��Ī �����
SELECT EMPNO, ENAME AS �̸� , JOB AS "��� ����" , SAL �޿� FROM EMP;

2) �ߺ��� ���� (DISTINCT)
SELECT DISTINCT EMPNO, JOB FROM EMP;

EX)�츮 ������ ����(JOB)���� �� �˰� �ʹ�.
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;

EX) �޿��� 2000�̻��� ��� �˻�.
SELECT *
FROM EMP
WHERE SAL >=2000; --SELECTION(���ڵ�����)

EX) �޿��� 2000�̻��� ��� �˻��ϰ� �޿��� �������� ��������.
SELECT * FROM EMP WHERE SAL >2000 ORDER BY SAL; --�ø�����
SELECT * FROM EMP WHERE SAL >2000 ORDER BY SAL DESC; --��������

EX) JOB�� �������� ������������ �ϰ� ������ �޿��� �������� �ø����� ����
SELECT * FROM EMP ORDER BY JOB DESC , SAL ;

-----------------------------------------------------
/*
  -������ ����
  
   1) ���������
      : +, - , * , /  , MOD(��, ������) - ������
      
   2) ���迬����
     > ,<  , >=  , <= , != ,  = ����
     
   3) �񱳿�����
      - AND
      - OR
      - BETWEEN �ּҰ� AND �ִ밪
         : �ϳ��� �÷��� �������� �ּ� ~ �ִ� ������ ������ ����Ҷ� AND������ ���� ���ϴ�.
      
      - �÷��� IN (��, ��,....)
         : �ϳ��� �÷��� �������� ���� OR �����ڷ� ���ϰ��� �Ҷ� OR������ ���� ���ϴ�.
      
      - LIKE 
         : ���ϵ�ī�幮��( _ , %) �� �Բ� ����ϸ� ������ �߿� Ư���� ���ڸ� ������
           ���ڵ带 �˻��Ҷ� ����Ѵ�. 
           -  1) _ : �ѹ���
                 % : 0���̻��� ����
                 
            EX) JOB LIKE 'J%' - JOB�� J�� �����ϴ� ���ڿ��� �˻�
                JOB LIKE '%J%' - JOB�� J��� ���ڸ� �����ϰ� �ִ� ���ڵ� �˻�
                JOB LIKE '___' - 3���ڸ� �˻�
                JOB LIKE 'A_B%' - 
                
                
       * ���� ������ �տ� NOT�� ���̸� �ݴ�
*/

EX) ���������
 SELECT EMPNO, ENAME, SAL , COMM ,  SAL+COMM
 FROM EMP; -- NULL�� �����ϰ� ������ ��������� ����ȵȴ�.
 
 * NULL���� ã�Ƽ� ���ϴ� ���� �����ϰ� ������ �Ѵ�. - NVL(��, ���氪 ) �Լ��̿��Ѵ�.
 SELECT COMM , NVL(COMM, 100) AS NVL�Լ� FROM EMP;
 
 
 SELECT EMPNO, ENAME, SAL , COMM ,  (SAL+NVL(COMM,0)) * 12 AS ���
 FROM EMP;
 
 EX) ~�� ����� ~ �Դϴ� 
 SELECT ENAME || '�� �����' || SAL || '�Դϴ�.' AS "���� �ϱ�"
 FROM EMP


EX) SAL�� 2000 ~ 4000 ������ ���ڵ� �˻�
 -- AND
 SELECT * FROM EMP  WHERE SAL >=2000 AND SAL <=4000 ORDER BY SAL;
 
 EX) SAL�� 2000 ~ 4000 ���� �ƴ�  ���ڵ� �˻�
 SELECT * FROM EMP  WHERE NOT(SAL >=2000 AND SAL <=4000) ORDER BY SAL;
 
 
 -- BETWEEN AND
 SELECT * FROM EMP WHERE SAL BETWEEN 2000 AND 4000 ORDER BY SAL;
  SELECT * FROM EMP WHERE SAL NOT BETWEEN 2000 AND 4000 ORDER BY SAL;
 
 
 EX) EMPNO�� 7499, 7566 7782, 7839 �� ���ڵ� �˻�
  --OR
   SELECT * FROM EMP WHERE  EMPNO=7499  OR EMPNO=7566 OR EMPNO=7782 OR EMPNO=7839;
   SELECT * FROM EMP WHERE  NOT(EMPNO=7499  OR EMPNO=7566 OR EMPNO=7782 OR EMPNO=7839);
  
  --IN
  SELECT * FROM EMP WHERE EMPNO IN(7499,7566,7782,7839);
  SELECT * FROM EMP WHERE EMPNO NOT IN(7499,7566,7782,7839);


 --LIKE ������
 EX) JOB�� 'A'�� �����ϴ� ���ڵ� �˻�
  SELECT * FROM EMP WHERE JOB LIKE 'A%';
  SELECT * FROM EMP WHERE JOB = 'A%';--�˻��ȵ�.
  
  SELECT * FROM EMP WHERE UPPER(JOB) LIKE UPPER('a%');
  SELECT * FROM EMP WHERE UPPER(JOB) NOT LIKE UPPER('a%');
  
 
 EX) JOB�� ���� N���γ����� ���ڵ� �˻�
 SELECT * FROM EMP WHERE JOB LIKE '%N';
 
 EX) ENAME�� 4������ ���ڵ� �˻�
  SELECT * FROM EMP WHERE ENAME LIKE '____';
  SELECT * FROM EMP WHERE ENAME NOT LIKE '____';
 
 EX) ENAME�� A���ڰ� ���� ���ڵ� �˻�
  SELECT * FROM EMP WHERE ENAME LIKE '%A%';
 
 EX) ENAME�� ��ü���ڴ� 5�����̰� ù���ڴ� A
 SELECT * FROM EMP WHERE ENAME LIKE 'A____' ;
  SELECT * FROM EMP WHERE ENAME LIKE 'A%E%' ;
  
 /*
  -ANY : �ϳ��� �����ϸ� TRUE
    �÷��� < ANY(100, 200, 300)  - �ִ밪���� ������ TRUE
    �÷��� > ANY (100, 200,300)  - �ּҰ����� ũ�� TRUE
  
  -ALL : ��� �����ؾ߸� TRUE
     �÷��� < ALL (100, 200, 300)  - �ּҰ����� ������ TRUE
     �÷��� > ALL (100, 200,300)  - �ִ밪���� ũ�� TRUE
  
 */ 
 
 
 SELECT * FROM EMP;
 SELECT * FROM EMP WHERE SAL < ANY(1000,2000,3000) ORDER BY SAL; --3000���� ������ 
 SELECT * FROM EMP WHERE SAL > ANY(1000,2000,3000) ORDER BY SAL; --1000���� ũ�� 
 
 SELECT * FROM EMP WHERE SAL < ALL(1000,2000,3000) ORDER BY SAL; -- 1000���� ������
 SELECT * FROM EMP WHERE SAL > ALL(1000,2000,3000) ORDER BY SAL; -- 3000���� ũ��
 
 -- DEPTNO(�μ���ȣ) �� 30�� ��������� �޿����� ���� �޴� ��� �˻�
  1) 30�� �μ��� ������� �޿� 
   SELECT SAL FROM EMP WHERE DEPTNO=30;
   
2) 1)�� �������� ����ؼ� �˻�
 SELECT * FROM EMP WHERE  SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO=30) ORDER BY SAL;
 
 
-- DEPTNO(�μ���ȣ) �� 30�� ��������� �޿����� ���� �޴� ��� �˻�
SELECT * FROM EMP WHERE  SAL < ALL(SELECT SAL FROM EMP WHERE DEPTNO=30) ORDER BY SAL;


---------------------------------------------------------------------
/*
  --NULL�� ã��
   1) IS NULL
   2) IS NOT NULL
*/

SELECT * FROM EMP;
EX) COMM�� NULL�� ���ڵ� �˻��ϱ�
  SELECT * FROM EMP WHERE COMM= 'NULL';
  SELECT * FROM EMP WHERE COMM= NULL;
  
  SELECT * FROM EMP WHERE COMM IS NULL;
  
EX) COMM�� NULL�� �ƴ� ���ڵ� �˻��ϱ� 
  SELECT * FROM EMP WHERE COMM IS NOT NULL;

-------------------------------------------------------
/*
   1) �����Լ�
    -SUM(�÷���) : ����
    -AVG(�÷���) : ���
    -MIN(�÷���) : �ּҰ�
    -MAX(�÷���) : �ִ밪
    -COUNT(�÷���) : NULL�� ������ ��ü ���ڵ��
    -COUNT(*) : NULL������ ��ü ���ڵ� ��  
*/

EX) �������̺� ����
CREATE TABLE SUNGJUCK(
  NAME VARCHAR(20) PRIMARY KEY,
  BAN NUMBER(1),
  KOR NUMBER(3) CHECK(KOR BETWEEN 0 AND 100) ,
  ENG NUMBER(3) CHECK(ENG BETWEEN 0 AND 100) ,
  MATH NUMBER(3) CHECK(MATH BETWEEN 0 AND 100) 
);

--���÷��ڵ� �߰�
INSERT INTO SUNGJUCK VALUES('ȿ��',1 , 80,90,60);
INSERT INTO SUNGJUCK VALUES('����',1 , 90,70,85);
INSERT INTO SUNGJUCK VALUES('����',1 , 80,70,90);

INSERT INTO SUNGJUCK VALUES('�缮',2 , 95,95,70);
INSERT INTO SUNGJUCK VALUES('��'  ,2 , 60,85,85);

INSERT INTO SUNGJUCK VALUES('����',3 , 70,80,90);
INSERT INTO SUNGJUCK VALUES('�߱�',3 , 60,85,95);
INSERT INTO SUNGJUCK VALUES('����',3 , 55,90,50);

INSERT INTO SUNGJUCK VALUES('�ҿ�',3 , NULL,90,50);



SELECT * FROM SUNGJUCK;
EX) �� ���κ� ����, ��� ���Ѵ�.
SELECT NAME, BAN, KOR, ENG, MATH , 
(NVL(KOR,0)+NVL(ENG,0)+ NVL(MATH,0)) AS ���� ,
ROUND( (NVL(KOR,0)+NVL(ENG,0)+ NVL(MATH,0))/3  , 2) AS ���
FROM SUNGJUCK; 

EX) ���������� ����, ���, ���ڵ�� , �ִ밪, �ּҰ�.....

SELECT SUM(KOR) ���� , AVG(KOR) , AVG(NVL(KOR,0)), COUNT(KOR), COUNT(*)  ,
 MAX(KOR), MIN(KOR)
FROM SUNGJUCK;

SELECT NAME , SUM(KOR) ���� , AVG(KOR) 
FROM SUNGJUCK; --�Ϲ��÷��� �����Լ��� �Բ� ����Ҽ� ����. ��, GROUP BY ������ ��밡���ϴ�.

--
EX) �� �ݺ� ������ ����, ���, �ִ�, �ּ� ���ϱ�
SELECT BAN, SUM(KOR), AVG(KOR), MAX(KOR), MIN(KOR)
FROM SUNGJUCK
GROUP BY BAN; --�� �ݺ� �׷��� ���� �׷캰 �����Լ��� �����.
              -- GROUP BY���� ���� �÷��� SELECT������ ��� �Ҽ� �ִ�.
              
              
EX) KOR ������ 70�̻��� �л����� �ݺ� ����, ��� ���Ѵ�.
SELECT BAN, SUM(KOR) , AVG(KOR)
FROM SUNGJUCK
WHERE KOR >=70
GROUP BY BAN;


EX) KOR�� ����� 70�̻��� �л����� �ݺ� ����, ��� ���Ѵ�.
SELECT BAN, SUM(KOR) , AVG(KOR)
FROM SUNGJUCK
WHERE AVG(KOR) >=70 -- ����(�����Լ��� WHERE�� �������� ����Ҽ�����)
GROUP BY BAN; --����


SELECT BAN, SUM(KOR) , AVG(KOR)
FROM SUNGJUCK
GROUP BY BAN
HAVING AVG(KOR) >=70 ; --GROUP BY ���� ������ ����ϸ� �����Լ��� �������� ����Ҷ� ����.


-- SELECT����
SELECT    5)
FROM      1)
WHERE     2)
GROUP BY  3)
HAVING    4)
ORDER BY  6)
---------------------------------------------------



SELECT * FROM SUNGJUCK;












