-- ���ο� ���� �����Ѵ� (system ������ ����)
-- ������ ������ ������ �ο��Ѵ�
-- ������ �������� �����Ѵ�
-- ������ �ڷḦ �������� ���̺� �����ϰ� ���ڵ� ���� ������ �߰��Ѵ� 

create table subject(
    �����ڵ� varchar2(5) constraint subject_�����ڵ� primary key,
    ���� varchar2(20) constraint subject_���� not null 
);

create table room(
    ���ǽǹ�ȣ number(4) constraint room_���ǽǹ�ȣ primary key,
    �����ο� number(4) constraint room_�����ο� not null
);

create table student(
    ��������ȣ number(2) constraint student_��������ȣ primary key,
    ��_�̸� varchar2(12) constraint student_��_�̸� not null,
    ��_�ֹε�Ϲ�ȣ varchar2(14) constraint student_��_�ֹε�Ϲ�ȣ not null,
    ��_����ó varchar2(14) constraint student_��_����ó not null,
    ��_�ּ� varchar2(50) ,
    ��_�̸��� varchar2(20) 
    
);

create table teacher(
    �����ȣ number(2) constraint teacher_�����ȣ primary key,
    �����̸� varchar2(12) constraint teacher_�����̸� not null,
    �ֹε�Ϲ�ȣ varchar2(14) constraint teacher_�ֹε�Ϲ�ȣ not null,
    ����ó varchar2(14) constraint teacher_����ó not null,
    �ּ� varchar2(50),
    �̸��� varchar2(20) ,
    �����ڵ� varchar2(5) constraint teacher_�����ڵ� not null references subject(�����ڵ�)

);


create table sugagn(
    ��������ȣ number(2) constraint sugagn_��������ȣ primary key references student(��������ȣ),
    �����ڵ� varchar2(5) constraint sugagn_�����ڵ� references subject(�����ڵ�)

);

create table sugagntb(
    �����ڵ� varchar2(5) constraint sugagntb_�����ڵ� primary key references subject(�����ڵ�),
    ���ǽǹ�ȣ number(4) constraint sugagntb_���ǽǹ�ȣ references room(���ǽǹ�ȣ),
    �ð� number(2) constraint sugagntb_�ð� not null,
    �����ȣ number(2) constraint sugagntb_�����ȣ  references teacher(�����ȣ)
    

);

--------------------------------------------------------------------------

--subject
insert into subject(�����ڵ�, ����) values('j1001', 'sql');
insert into subject(�����ڵ�, ����) values('j1002', 'Win2000');
insert into subject(�����ڵ�, ����) values('j1003', 'ASP');
insert into subject(�����ڵ�, ����) values('j1004', 'Php');
insert into subject(�����ڵ�, ����) values('j1005', 'java');
insert into subject(�����ڵ�, ����) values('j1006', 'javascript');

--room
insert into room(���ǽǹ�ȣ, �����ο�) values(901, 34);
insert into room(���ǽǹ�ȣ, �����ο�) values(902, 35);
insert into room(���ǽǹ�ȣ, �����ο�) values(903, 25);
insert into room(���ǽǹ�ȣ, �����ο�) values(904, 32);
insert into room(���ǽǹ�ȣ, �����ο�) values(905, 30);
insert into room(���ǽǹ�ȣ, �����ο�) values(906, 35);

--teacher
insert into teacher(�����ȣ, �����̸�, �ֹε�Ϲ�ȣ, ����ó, �ּ�, �̸���, �����ڵ�) values(1,'ȫ�浿','700918-1622011','031-295-1234','������ �߿��� ���ﵿ','kkk@jok.or.kr','j1001');
insert into teacher(�����ȣ, �����̸�, �ֹε�Ϲ�ȣ, ����ó, �ּ�, �̸���, �����ڵ�) values(2,'������','710419-2018916','02-345-2345','���� ������ ������','kkk@jok.or.kr','j1002');
insert into teacher(�����ȣ, �����̸�, �ֹε�Ϲ�ȣ, ����ó, �ּ�, �̸���, �����ڵ�) values(3,'�̽º�','730112-1344911','031-1234-6789','����� ������ ������','sss@jok.or.kr','j1003');
insert into teacher(�����ȣ, �����̸�, �ֹε�Ϲ�ȣ, ����ó, �ּ�, �̸���, �����ڵ�) values(4,'���õ�','730301-1167623','031-567-5678','����� ���ʱ� ���ʵ�','mmm@jok.or.kr','j1004');
insert into teacher(�����ȣ, �����̸�, �ֹε�Ϲ�ȣ, ����ó, �ּ�, �̸���, �����ڵ�) values(5,'�ַ���','730322-2037921','031-789-3456','����� ������ ���絿','xxx@jok.or.kr','j1005');
insert into teacher(�����ȣ, �����̸�, �ֹε�Ϲ�ȣ, ����ó, �ּ�, �̸���, �����ڵ�) values(6,'�̼���','731122-1646213','031-234-8901','����� ���ϱ� �̾Ƶ�','ppp@jok.or.kr','j1006');

--student
insert into student(��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó, ��_�ּ�, ��_�̸���) values(1,'������','771212-2346111','017-888-8888','�λ�','aaa@hanmail.net');
insert into student(��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó, ��_�ּ�, ��_�̸���) values(2,'�輮��','720112-1234812','016-999-9999','���','bbb@hanmail.net');
insert into student(��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó, ��_�ּ�, ��_�̸���) values(3,'���Ʊ�','730102-1555555','017-555-5555','����','ccc@hanmail.net');
insert into student(��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó, ��_�ּ�, ��_�̸���) values(4,'���ΰ�','801111-2222222','017-222-2222','����','ddd@hanmail.net');
insert into student(��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó, ��_�ּ�, ��_�̸���) values(5,'�迵��','811231-1777777','017-777-7777','����','eee@hanmail.net');
insert into student(��������ȣ, ��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó, ��_�ּ�, ��_�̸���) values(6,'�ڻ��','790915-1333333','017-333-3333','����','fff@hanmail.net');


--sugagn
insert into sugagn(��������ȣ, �����ڵ�) values(1,'j1001');
insert into sugagn(��������ȣ, �����ڵ�) values(2,'j1002');
insert into sugagn(��������ȣ, �����ڵ�) values(3,'j1003');
insert into sugagn(��������ȣ, �����ڵ�) values(4,'j1004');
insert into sugagn(��������ȣ, �����ڵ�) values(5,'j1005');
insert into sugagn(��������ȣ, �����ڵ�) values(6,'j1006');

--sugangtb
insert into sugagntb(�����ڵ�, ���ǽǹ�ȣ, �ð�, �����ȣ) values('j1001', 901, 2, 1);
insert into sugagntb(�����ڵ�, ���ǽǹ�ȣ, �ð�, �����ȣ) values('j1002', 902, 2, 2);
insert into sugagntb(�����ڵ�, ���ǽǹ�ȣ, �ð�, �����ȣ) values('j1003', 903, 2, 3);
insert into sugagntb(�����ڵ�, ���ǽǹ�ȣ, �ð�, �����ȣ) values('j1004', 904, 2, 4);
insert into sugagntb(�����ڵ�, ���ǽǹ�ȣ, �ð�, �����ȣ) values('j1005', 905, 2, 5);
insert into sugagntb(�����ڵ�, ���ǽǹ�ȣ, �ð�, �����ȣ) values('j1006', 906, 2, 6);

-----------------------------------------------------------------------------------


create table reply(
    reply_no number primary key,
    content varchar2(100),
    board_no number references board(board_no),
    reg_date date
);

create sequence reply_no_seq nocache;

insert into reply(reply_no, content, board_no, reg_date)
values (reply_no_seq.nextval, '6-1����̴�',1,sysdate);

commit;

select * from board;
select * from reply;

drop table reply;

delete from copy_emp where empno = 7900;