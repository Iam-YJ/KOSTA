--���� �������� �����Ѵ�. conn jang/1234
/*
 Datatype ����
  1) ������
     char(byte��) - ��������
     varchar2(byte��) - ������ ����
     
     varchar2(10) --> 10byte ũ��  , �ѱ��� �ִ� 5����.
     varchar2(10 char) -> byte���� ������� ������ �ִ� 10�� ����
     
     : �����Ҷ� �ݵ�� '��' ���´�.
     
     
     nchar() or nvarchar2()
  
  2) ������
     : number(��ü�ڸ���)
     : number(��ü�ڸ���, �Ҽ����ڸ�)
     : smallint
       int 
       
    ex) number(2) : -99 ~ 99 ���� 
       
  3) ��¥��
     : date
     : ��¥�� �����Ҷ� '��-��-��' or '��/��/��'
     : ���� ��¥�� �ð��� �˻�  - sysdate �Լ��� �̿���.
*/

/*
  -���̺� ����
  create table ���̺��̸�(
     �÷��� datatype [null | not null]  [constraint ��Ī ������������] ,
     �÷��� datatype [null | not null]  [constraint ��Ī ������������] ,
     �÷��� datatype [null | not null]  [constraint ��Ī ������������] ,
     ....
  
  );
  
  
  * �������� ����
    1) Primary key
    2) Foreign key
    3) unique
    4) check
    
    5) default
*/

/*
1) primary key 
    : �⺻Ű= ��ǥŰ = pk
    : pk�� �����ϸ� not null, �ߺ��ȵ�.
    : pk�÷��� �ڵ� index ������.
    : �ϳ��� ���̺� pk�� �ݵ�� �Ѱ��� �����Ѵ�.
    : �������� �÷��� �ϳ��� ��� pk������ �����ϴ�(����Ű)
*/

--���ڵ� �˻�
select * from member;

--���̺� ����
desc member;

--���ڵ� ���(����)
insert into ���̺��̸�(�÷���, �÷���,....) values(��, ��,.....);
insert into ���̺��̸� values(��,��,.....);

ex) �߰�
insert into member(id,name,AGE,ADDR,REGDATE) VALUES('JANG','������',20,'����', SYSDATE );
insert into member(id,name,AGE,ADDR,REGDATE) VALUES('jang','������',20,'����', SYSDATE );

insert into member values('hee','����',25,'�뱸','2020-7-22');

--null or not null üũ
insert into member(name, age) values('ȿ��',22); --id�� pk�̹Ƿ� not null

insert into member(id, name, age) values('aa','ȿ��',22); --����

select * from member;
insert into member(id, name, age) values('bb','����',100);--����
insert into member(id, name, age) values('bb','����',99);

--����������
create table test1(
 name1 varchar2(5),
 name2 varchar2(5 char),
 name3 char(5),
 name4 char, --byte���� �����ϸ� �⺻ 1byte����
 name5 varchar2(1) -- byate���� �����Ҽ� ����.
);

desc test1; --���̺���

insert into test1(name1) values('abcde');
insert into test1(name1) values('������'); -- ũ�⸦ ����� ��Ͼȵ�.

insert into test1(name2) values('������'); --����

insert into test1(name3) values('a');
insert into test1(name3) values('ab'); 
insert into test1(name3) values('abc');
insert into test1(name3) values('������');  --����

select * from member; -- �ּ�....

--������
create table test2(
  no1 number(2),
  no2 number(5,2), --��ü 5�ڸ��߿� �Ҽ��� 2�ڸ�
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
--���̺� ����
drop table member;

-- �ΰ��� �÷��� �ϳ��� pk�� �����
CREATE TABLE MEMBER(
  ID VARCHAR2(5 CHAR) ,
  JUMIN CHAR(6),
  NAME VARCHAR2(5) NOT NULL,
  AGE NUMBER(3),
  ADDR VARCHAR2(20) ,
  CONSTRAINT MEM_ID_JUMIN_PK PRIMARY KEY(ID,JUMIN)
);

--���̺� �˻�
SELECT * FROM MEMBER;
--���̺� ����
DESC MEMBER;

--���ڵ� ���
INSERT INTO MEMBER VALUES('JANG','11111','ȿ��',NULL, NULL);
INSERT INTO MEMBER VALUES('JANG','2222','ȿ��',NULL, NULL);
INSERT INTO MEMBER VALUES('HEE','2222','ȿ��',NULL, NULL);

INSERT INTO MEMBER VALUES('HEE','2222','ȿ��',NULL, NULL);

--���̺��� ���� - ������ Ÿ�� ����
ALTER TABLE MEMBER MODIFY NAME VARCHAR2(20);

-------------------------------------------------------------------
--2) Foreign key
/*
  : �ܷ�Ű = FK
  : �ٸ����̺��� �⺻Ű(PK)�� �����ϴ� ��.
  : ���ڵ带 ����Ҷ� �����Ǵ� �÷��� �ִ� �� �ܴ̿� ����Ҽ� ����.
  : NULL ���, �ߺ�����.
  : �����̺� �������� �÷���  FK���� ������.
  
   * ���ǻ���
     INSERT�Ҷ� : �θ� INSERT -> �ڽ� INSERT�Ѵ�.
     DELETE �Ҷ� :�ڽ� DELETE  -> �θ� DELETE  �Ѵ�.
      - �̷��� ���ŷο��� �ذ��ϱ� ���ؼ� ���̺� �����Ҷ� �ɼ� �����Ҽ� �ִ�.
         ON DELETE CASCADE   - �θ� �����Ҷ� �ڽķ��ڵ�� �Բ� ���� �ڵ����� �ȴ�.
*/

--���̺� ����
CREATE TABLE DEPT(
  DEPT_NO CHAR(3) CONSTRAINT DPET_NO_PK PRIMARY KEY,
  DNAME VARCHAR2(20) NOT NULL,
  LOC VARCHAR2(30)
);

--���� ������ �߰�
INSERT INTO DEPT(DEPT_NO, DNAME, LOC) VALUES('A01','�λ��','����');
INSERT INTO DEPT(DEPT_NO, DNAME, LOC) VALUES('A02','�渮��','�뱸');
INSERT INTO DEPT(DEPT_NO, DNAME, LOC) VALUES('A03','������','���ֵ�');

--���̺� ����
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --�����ȣ
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  DEPT_NO CHAR(3) CONSTRAINT EMP_DEPTNO_FK REFERENCES DEPT(DEPT_NO)
);

SELECT * FROM EMP;

--���ĵ����� �߰�
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(1,'��ȿ��',20, NULL);-- �μ���ȣ NULL ����� 
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(2,'�̹̿�',22, 'A01');
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(3,'������',25, 'A01');--�μ���ȣ�ߺ�����

INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(4,'���̿�',25, 'A04');--�����߻�

--�θ�Ű�� ���� ����ϰ� �ڽ�Ű�� ����Ѵ�.
INSERT INTO DEPT VALUES('A04','������','����');
INSERT INTO EMP(EMP_NO, ENAME, AGE, DEPT_NO) VALUES(4,'���̿�',25, 'A04');

--���ڵ� ����
TRUNCATE ���̺��̸�; --��� ���ڵ带 ����(����)  : ROLLBACK�ȵ�)
DELETE FROM ���̺��̸�; --��� ���ڵ带 ���� : ROLLBACK ����)
DELETE FROM ���̺��̸� WHERE ���ǽ�; --���ǿ� �ش��ϴ� ���ڵ带 ����

 * FORM Ű���� ���������ϴ�.


EX) �����ǰ� �ִ� �ڽ� ���ڵ带 �����غ���.
DELETE FROM EMP WHERE EMP_NO=4; --����

EX) ���������  �θ��ڵ带 �����غ���.
DELETE FROM DEPT WHERE DEPT_NO='A01'; -- ���� ����.

* �����ϰ� ������ �����Ǵ� �ڽ� ���ڵ� ���� �����ϰ� �θ� �����Ѵ�.
DELETE EMP WHERE DEPT_NO='A01'; --����
DELETE FROM DEPT WHERE DEPT_NO='A01'; --����

--ON DELETE CASCADE �ɼ� �����ϱ�
DROP TABLE EMP;
DROP TABLE DEPT;

-- DEPT���̺� �����Ѵ�. - ���� ���� �״�� �ٽ� ����.

-- �ڽ����̺� EMP���̺��� �ɼ��� �����ؼ� �����غ���.
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --�����ȣ
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  DEPT_NO CHAR(3) CONSTRAINT EMP_DEPTNO_FK REFERENCES DEPT(DEPT_NO) ON DELETE CASCADE
);

--���÷��ڵ� �߰�
INSERT INTO EMP VALUES(1,'����',20, 'A01' );
INSERT INTO EMP VALUES(2,'ȿ��',22, 'A02' );
INSERT INTO EMP VALUES(3,'����',21, 'A01' );

-- �θ��ڵ带 �����غ���(�����ǰ� �ִ� ��� ���ڵ� ����)
DELETE FROM DEPT WHERE DEPT_NO='A01';



DROP TABLE EMP;
--FOREIGN KEY�� �ǵڿ� �ۼ��ϱ�.
CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --�����ȣ
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  �μ��ڵ� CHAR(3) ,
  JOB VARCHAR2(30) NOT NULL,
  CONSTRAINT EMP_DEPTNO_FK FOREIGN KEY(�μ��ڵ�) REFERENCES DEPT(DEPT_NO) ON DELETE CASCADE
);


CREATE TABLE EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY, --�����ȣ
  ENAME VARCHAR2(20) NOT NULL,
  AGE NUMBER(3),
  �μ��ڵ� CHAR(3) CONSTRAINT EMP_DEPTNO_FK REFERENCES DEPT(DEPT_NO) ON DELETE CASCADE
);


SELECT * FROM DEPT;
SELECT * FROM EMP;











