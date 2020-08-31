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


--2. ��������� 1973���� ������ ������ �˻�(substr)
select substr(��_�ֹε�Ϲ�ȣ, 1,2) as �������, ��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ,��_����ó, ��_�ּ�, ��_�̸���
from student
where ��_�ֹε�Ϲ�ȣ like '73%';


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


--6. �ּҰ� null�� �ƴ� ������ ���� �˻�
select *
from teacher 
where �ּ� is not null;

--7.sql ������ �����ϰ� �ִ� �л��� ������ �˻��ϴ� �� �ۼ�
select s.��������ȣ, s.��_�̸�, sb.����
from (student s join sugagn sg on s.��������ȣ = sg.��������ȣ) 
join (sugagn sg join subject sb on sg.�����ڵ� = sb.�����ڵ�)
on s.��������ȣ = sg.��������ȣ
where sb.���� = 'sql';


--8.���簡 ����ϴ� ����� �� ������ ��� ���ǽǿ��� ����Ǹ� 
    -- �� ���� �ο��� �� ������ �˻�(�Ʒ��׸� ����) - (join �̿��Ͽ� �� �ۼ�)

create view ����� as
select t.�����ȣ,t.�����̸�,t.�����ڵ�,sb.����,tb.���ǽǹ�ȣ,r.�����ο�
from teacher t join subject sb
on t.�����ڵ�=sb.�����ڵ� join sugagntb tb
on sb.�����ڵ� = tb.�����ڵ� join room r
on tb.���ǽǹ�ȣ = r.���ǽǹ�ȣ;

select * from �����;



--9. �Ʒ��� �׸��� ���� ���弼��(�л��� �̸�, �ֹι�ȣ,������ ����ϼ���)
select ��_�̸�, ��_�ֹε�Ϲ�ȣ, decode(substr(��_�ֹε�Ϲ�ȣ, 8,1),'1','����','2','����')as ����
from student;

--10. �Ʒ��� �׸��� ���� ���弼��
--(teacher ������ �̸��� �������� �ø��������� �����Ͽ� 
--���ĵ� ������� rownum�� ��µǵ��� �Ͻÿ�)
select rownum, t.*
from (select �����̸�, ����ó, �ּ� from teacher order by �����̸�) t;


