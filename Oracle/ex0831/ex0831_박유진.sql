select * from teacher;
select * from student;
select * from subject;
select * from room;
select * from sugagn;
select * from sugagntb;


--1. ������ ������ �л��� ���� �˻�
select *
from student
where ��_�ֹε�Ϲ�ȣ like '%-2%';
--where ��_�ֹε�Ϲ�ȣ like '______-2_____';


--2. ��������� 1973���� ������ ������ �˻�(substr)
select substr(��_�ֹε�Ϲ�ȣ, 1,2) as �������, ��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ,��_����ó, ��_�ּ�, ��_�̸���
from student
where ��_�ֹε�Ϲ�ȣ like '73%';

/* select * from student
where substr(��_�ֹε�Ϲ�ȣ,1,2) ='73'; */


--3. ���� 'ȫ'�� �ƴ� ������ ���� �˻�
select * 
from teacher
where not �����̸� like 'ȫ%';

--4. �������� �����ϴ� ������ ���� �˻�
select *
from teacher
where �ּ� like '%������%';


--5. java�� �����ϴ� ���� ���� �˻�(�������� �̿�)
select *
from teacher t join subject s
on t.�����ڵ� = s.�����ڵ�
where s.���� = 'java';

select * from teacher where �����ڵ� = 
(select �����ڵ�  from subject where upper(����) = upper('java'));


--6. �ּҰ� null�� �ƴ� ������ ���� �˻�
select *
from teacher 
where �ּ� is not null;

--7.sql ������ �����ϰ� �ִ� �л��� ������ �˻��ϴ� �� �ۼ�
create view �л��� as
select s.��������ȣ, s.��_�̸�, sb.����
from (student s join sugagn sg on s.��������ȣ = sg.��������ȣ) 
join subject sb on sg.�����ڵ� = sb.�����ڵ�
where sb.���� = 'sql';

--using ���
create view �л��� as
select *
from student inner join sugagn  using(��������ȣ) inner join subject  
using(�������ڵ�) where ���� = 'sql';

-- �������� �̿�
select * from student
where ��������ȣ = (select ��������ȣ from sugagn
where �����ڵ�=(select �����ڵ� from subject where ����='sql'));


--8.���簡 ����ϴ� ����� �� ������ ��� ���ǽǿ��� ����Ǹ� 
    -- �� ���� �ο��� �� ������ �˻�(�Ʒ��׸� ����) - (join �̿��Ͽ� �� �ۼ�)

create view ����� as
select t.�����ȣ,t.�����̸�,t.�����ڵ�,sb.����,tb.���ǽǹ�ȣ,r.�����ο�
from teacher t join subject sb
on t.�����ڵ�=sb.�����ڵ� join sugagntb tb
on sb.�����ڵ� = tb.�����ڵ� join room r
on tb.���ǽǹ�ȣ = r.���ǽǹ�ȣ;

select * from �����;

create or replace view v_teacherInfo 
as
select teacher.�����ȣ, �����̸�, �����ڵ�, ����, ���ǽǹ�ȣ, �����ο� 
from teacher join subject using(�����ڵ�)
              join sugagntb using (�����ڵ�)
                join room using(���ǽǹ�ȣ);


--9. �Ʒ��� �׸��� ���� ���弼��(�л��� �̸�, �ֹι�ȣ,������ ����ϼ���)
select ��_�̸�, ��_�ֹε�Ϲ�ȣ, decode(substr(��_�ֹε�Ϲ�ȣ, 8,1),'1','����','2','����')as ����
from student;


--10. �Ʒ��� �׸��� ���� ���弼��
--(teacher ������ �̸��� �������� �ø��������� �����Ͽ� 
--���ĵ� ������� rownum�� ��µǵ��� �Ͻÿ�)
select rownum, t.*
from (select �����̸�, ����ó, �ּ� from teacher order by �����̸�) t;


