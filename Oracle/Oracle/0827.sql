/*
 JOIN
  : �ѹ��� SELECT�������� 2���̻��� ���̺� �ִ� �÷��� ������ �˻��ϰ���
    �Ҷ� ����Ѵ�.
  : JOIN�� ����
    1) INNER JOIN = EQ JOIN = ������� = NATURAL JOIN
    
    2) OUTER JOIN
        - LEFT OUTER JOIN
        - RIGHT OUTER JOIN
        - FULL OUTER JOIN
        
    3) SELF JOIN 
    
   : JOIN�� �ڵ��ϴ� ���
     1) SQL JOIN��� : FULL OUTER JOIN�� �������� ����.
     2) ANSI JOIN��� : ǥ���̱� ������ ���� 
*/
SELECT * FROM EMP;
SELECT * FROM DEPT;

EX) SMITH ����� JOB, DNAME, LOC �˻��ϰ� �ʹ�. --> JOIN �ʿ��ϴ�.


--���̺� ����
CREATE TABLE TEST1(
  ID VARCHAR2(3) PRIMARY KEY,
  NAME VARCHAR2(20),
  ADDR VARCHAR2(30)
);

--���õ����� �߰�
INSERT INTO TEST1 VALUES(1,'����','����');
INSERT INTO TEST1 VALUES(2,'����','�뱸');
INSERT INTO TEST1 VALUES(3,'ȿ��','���ֵ�');
INSERT INTO TEST1 VALUES(4,'����','�λ�');
INSERT INTO TEST1 VALUES(5,'����','����');

SELECT * FROM TEST1;

CREATE TABLE TEST2(
 CODE CHAR(3) PRIMARY KEY,
 ID VARCHAR2(3) REFERENCES TEST1(ID),
 JOB VARCHAR2(30),
 SAL NUMBER(3)
);

--���ڵ� ���
INSERT INTO TEST2 VALUES('A01' , 1, '����',400);
INSERT INTO TEST2 VALUES('A02' , 3, '���',500);
INSERT INTO TEST2 VALUES('A03' , 5, '���׿��',300);
INSERT INTO TEST2 VALUES('A04' , NULL, '����',700);

SELECT * FROM TEST1;
SELECT * FROM TEST2;

EX) ID, NAME, ADDR, JOB, SAL ���� �˻��ϰ� �ʹ�.

1) INNER JOIN = EQ JOIN = ��������
 - SQL���� ���
     SELECT  TEST1.ID , NAME, ADDR, JOB, SAL
     FROM TEST1 , TEST2
     WHERE TEST1.ID = TEST2.ID;
 
 
--���̺��̸��� ��Ī�����
   SELECT  T1.ID , NAME, ADDR, JOB, SAL
   FROM TEST1 T1 , TEST2 T2 --���̺��̸��� ��Ī
   WHERE T1.ID = T2.ID;

-- ��� �÷� �˻��ϱ�
   SELECT  *
   FROM TEST1 T1 , TEST2 T2 --���̺��̸��� ��Ī
   WHERE T1.ID = T2.ID;
 
 
 -- ANSI ���� ��� - ����
 SELECT TEST1.ID, NAME, ADDR, JOB, SAL
 FROM TEST1 INNER JOIN TEST2 --INNER �ܾ�� ���������ϴ�.
 ON TEST1.ID = TEST2.ID; --���ǽ�

--���̺� ��Ī�����
  SELECT T1.ID, NAME, ADDR, JOB, SAL
  FROM TEST1 T1 JOIN TEST2  T2 --INNER �ܾ�� ���������ϴ�.
  ON T1.ID = T2.ID; -- PK�� �����÷�(FK)�� �̸��̴ٸ��� �� �ʿ��ϴ�.
  
  * �� ������ USING()���� �����ϱ�
    SELECT ID, NAME, ADDR, JOB, SAL 
    FROM TEST1 T1 JOIN TEST2  T2 --INNER �ܾ�� ���������ϴ�.
    USING(ID); -- PK�� �����÷�(FK)�� �Ӽ����� ������ ����Ѵ�.
      
      *USING�� ����Ҷ� �÷��� ��Ī.  ����Ҽ� ����.
      
  
 * ��� �÷��˻�
   SELECT *
   FROM TEST1 T1 JOIN TEST2  T2 --INNER �ܾ�� ���������ϴ�.
   ON T1.ID = T2.ID; 
  
    SELECT *
    FROM TEST1 T1 JOIN TEST2  T2 --INNER �ܾ�� ���������ϴ�.
    USING(ID);

 * natural JOIN 
   SELECT *
   FROM TEST1  NATURAL JOIN TEST2  --INNER �ܾ�� ���������ϴ�.
   
    * ON�� OR USING()�� ��� �Ҽ�����.
    * ���ʿ� ���� �Ӽ��� ������� ��� �����Ѵ�.
    
 EX) 
  CREATE TABLE COPY_TEST1
    AS SELECT * FROM TEST1;
    
  SELECT * FROM COPY_TEST1;
  ALTER TABLE COPY_TEST1 ADD PHONE VARCHAR2(20) DEFAULT '1111'
  
  SELECT * FROM COPY_TEST1;
  SELECT * FROM TEST1;
  
  --INNER JOIN + ON
   SELECT *
   FROM TEST1 INNER JOIN COPY_TEST1 
   ON TEST1.ID = COPY_TEST1.ID;
  
  --INNER JOIN + USING()
   SELECT *
   FROM TEST1 INNER JOIN COPY_TEST1 
   USING(ID)
  
  -- NATURAL JOIN
   SELECT *
   FROM TEST1 NATURAL JOIN COPY_TEST1 ;
   
   UPDATE COPY_TEST1 SET ADDR =NULL WHERE ID='3';
   
    
    
  -- ���ϴ� �÷� ����
  SELECT TEST1.ID, NAME, ADDR, JOB, SAL
   FROM TEST1 INNER JOIN TEST2
   ON TEST1.ID = TEST2.ID;
    
 -----------------------------------------------------------
 --OUTE JOIN
  1) LEFT OUTER JOIN
  2) RIGHT OUTER JOIN
  3) FULL OUTER JOIN
  
  -SQL���ι�� �ڵ� -- FULL���� �����ȵ�.
  SELECT *
  FROM TEST1 , TEST2
  WHERE TEST1.ID = TEST2.ID(+); --LEFT JOIN
  
   SELECT *
  FROM TEST1 , TEST2
  WHERE TEST1.ID(+) = TEST2.ID; --RIGHT JOIN
  
 
  
  -ANSI ���� ��� �ڵ�
  SELECT *
  FROM TEST1 LEFT  JOIN TEST2 -- LEFT OUTER JOIN
  USING(ID);
  
    SELECT *
  FROM TEST1 RIGHT  JOIN TEST2 -- RIGHT OUTER JOIN
  USING(ID);
  
    SELECT *
  FROM TEST1 FULL  JOIN TEST2 -- FULL OUTER JOIN
  USING(ID);
 
 
 * 3�� ���̺� �����ϱ�
 SELECT * FROM TEST2;
 
 CREATE TABLE TEST3(
   CODE CHAR(3)  PRIMARY KEY REFERENCES TEST2(CODE), --PK ,FK
   MANAGER_NAME VARCHAR2(20)
 );
 
 INSERT INTO TEST3 VALUES('A01','�����');
 INSERT INTO TEST3 VALUES('A02','�����');
 INSERT INTO TEST3 VALUES('A03','���缮');
 
 SELECT * FROM TEST1;
 SELECT * FROM  TEST2;
 SELECT * FROM TEST3;
 
 EX) ID, NAME, JOB, SAL, MANAGER_NAME �˻�
 --SQL���� ���
 SELECT TEST1.ID, NAME, JOB, SAL, MANAGER_NAME
 FROM TEST1 , TEST2, TEST3
 WHERE TEST1.ID=TEST2.ID AND TEST2.CODE = TEST3.CODE;
 
 SELECT *
 FROM TEST1 , TEST2, TEST3
 WHERE TEST1.ID=TEST2.ID AND TEST2.CODE = TEST3.CODE;
    
-- ANSI ���� ��� - ON 
SELECT TEST1.ID, NAME, JOB, SAL, MANAGER_NAME
FROM TEST1 JOIN TEST2 
ON TEST1.ID = TEST2.ID JOIN TEST3 
ON TEST2.CODE =TEST3.CODE; 

-- ANSI ���� ��� - USING    
 SELECT ID, NAME, JOB, SAL, MANAGER_NAME
 FROM TEST1 JOIN TEST2 
 USING(ID) JOIN TEST3 USING(CODE);
 
---------------------------------------------------------
--SELF JOIN
  : �ڽ� ���̺��� �ΰ��� ���� �����ϴ� ��.
  : ����������϶� ����Ѵ�. - �ϳ��� ���̺��� �ϹݼӼ��� �ڽ����̺���
                               PK�� �����ϴ� ��)


 --SCOTT�������� ����
SELECT * FROM EMP;

EX) � ����� ������ ����� �����ϴ� �������� ������ �˻��ϰ� �ʹ�.

SELECT E1.ENAME ����̸� , E1.MGR �����ڹ�ȣ , E2.ENAME �������̸�
FROM EMP E1 JOIN EMP E2 -- E1�� ���, E2�� ������
ON E1.MGR = E2.EMPNO;


 





