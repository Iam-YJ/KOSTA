-- ������ �������� ����.
--��������
CREATE USER EXAM IDENTIFIED BY EXAM;

--�⺻ ���� �ο�
GRANT CONNECT , RESOURCE TO EXAM;

--���� CONN EXAM/EXAM


drop table emp;

--emp ���̺� ����
Create Table emp(
	emp_id 	   NUMBER(4)  Primary KEY, --�����ȣ
	emp_name	 Varchar2(30) Not Null,  --����̸�
	job      	               Varchar2(20) Not Null,  --����
	dept_id  	  NUMBER(3), --�μ���ȣ
	sal 	              NUMBER(5) Not Null,--�޿�
	bonus	              NUMBER(5),--���ʽ�
	mgr_id	              NUMBER(5),--�����ڹ�ȣ
	hiredate             date  Not Null --�Ի���
)



--�����ͻ���

INSERT INTO EMP VALUES (6200,'��ö��','��ǥ�̻�',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO EMP VALUES (6311,'�����','����',100, 3500,Null,6200, '1998-12-17');

INSERT INTO EMP VALUES (7489,'�ε���','������',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO EMP VALUES (7522,'����ö','������',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO EMP VALUES (6321,'������','����',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO EMP VALUES (6351,'������','����',300,   2850,NULL,6200,'2000-05-31');

INSERT INTO EMP VALUES (7910,'�̿���','�渮',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO EMP VALUES (6361,'��ö��','����',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO EMP VALUES (7878,'����','������',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO EMP VALUES (7854,'������','������',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO EMP VALUES (7872,'�̹���','�繫��',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO EMP VALUES (7920,'�踶����','�繫��',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO EMP VALUES (7901,'������','������',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO EMP VALUES (7933,'��ö��','�繫��',200,  1050,NULL,6361,'2002-01-02');


--1. emp ���̺��� �� ��� emp_name�� �޿�(sal)�� 100�� ���� �� 12�� ���� ���� ��µǵ��� select���� ������� ����غ�����
select emp_name, ((sal+100)*12) as ��� from emp;

--2. ������ job�� �������� ��� ����� �̸�, ������, �μ���ȣ�� �˻��غ�����
select emp_name, job, dept_id from emp where job='������';

--3. �Ի����� 2001�� 12�� 3���� ��� ����� �˻��ϼ���
select * from emp where hiredate='2001-12-03';
select * from emp where to_char(hiredate,'YYYY"��"MM"��"DD"��"') = '2001��12��03��';

--4. �μ���ȣ�� 200�� �μ����� �ٹ��ϴ� ��� ����� �̸��� ������,�Ի���, �μ���ȣ �˻��ϼ���.
select emp_name, job, hiredate, dept_id from emp where dept_id=200;

--5. emp���̺��� �޿��� 3000�̻� 5000������ ��� ����� �̸��� �޿��� ����ϼ���.
select emp_name, sal from emp where sal between 3000 and 5000;

--6. emp ���̺��� �����ڹ�ȣ�� 6311, 6361, 6351 ��� �ϳ��� ��� ����� �����ȣ, �����ڹ�ȣ, �̸�, �μ���ȣ�� ����ϼ���
select emp_id, mgr_id, emp_name, dept_id from emp where mgr_id in(6311, 6361, 6351);

--7. �������� �繫���̰ų� �渮�� ����� ��� ������ �˻��ϼ���.
select * from emp where job in('�繫��','�渮');

--8. emp ���̺��� �޿��� 3000�̻��� ��� ������ ������ �˻��ϼ���
select * from emp where sal >= 3000 and job='����';

--9. emp ���̺��� �������� �������̰ų� �繫���� �ƴ� ��� ����� ������ �˻��ϼ���
select * from emp where not job = '�繫��';
select * from emp where job not in('������','�繫��');

--10. emp ���̺��� �޿��� 1500�̻� 2500 ���ϰ� �ƴ� ��� ����� ������ �˻��ϼ���
select * from emp where not sal between 1500 and 2500;

--11. �������� �渮�̰ų� �����̸鼭 �޿��� 3000�� �Ѵ� ��� ����� ������ �˻��ϰ� ���� ���� �Ի��� ������� ����ϼ���
select * from emp where job = '�渮' or job = '����' and sal >= 3000 order by hiredate;

--12. ����� �μ���ȣ�� �������� ������������ �����ϵ�, ���� �μ� �ȿ����� �޿��� ���� ����� ���� ��� �ǵ����ϼ���.
select * from emp order by dept_id , sal desc;

--13. ���ʽ��� null�� �ƴϸ鼭 �Ի����� 2000�� �̻��� ����� ������ �˻��ϼ���
select * from emp where bonus is not null and hiredate >= '2000-01-01';
select * from emp where bonus is not null and to_char(hiredate,'yyyy') >= '2000';

--14. emp_name�� 3�����̰� �� ���ڰ� '��'�̸� ù���ڴ� '��'���� �����ϴ� ����� �����˻��ϼ���
select * from emp;
select * from emp where emp_name LIKE '��_��';

--15. ���ʽ��� null�� ����� ���ʽ��� 0���� �����ϼ���
update emp set bonus = 0 where bonus is null; -- ����ɷ� ����. where ���� ���� �����ؼ� ���� ���� 
update emp set bonus = nvl(bonus, 0); -- ����ɷ� ����. ��ü ���ڵ带 ���� ����

--16. ������ '��'���� �����鼭 �޿��� 2000~3000 ������ ����� �̸��� '�嵿��' �޿��� 3500���� �����ϼ���
update emp set emp_name ='�嵿��', sal=3500 where job like '%��';

--17. emp_name�� 'ö'�ڰ� ���鼭 ������ ������ ����� ������ �����ϼ���.
delete emp where emp_name like '%ö%' and job = '����';

--18. ���̺��� �����ϼ��� 
drop table emp;

--DDL : CREATE, ALTER, DROP - ROLLBACK �ȵ�
--DML : INSERT, UPDATE, DELETE - ROLLBACK ���� 

