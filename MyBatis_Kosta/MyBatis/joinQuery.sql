
  SELECT * FROM commentb;--�Խù����̺�
  SELECT * FROM users; --�����
  SELECT * FROM reply; --�亯
  
    CREATE TABLE users(
     user_id VARCHAR2(20) PRIMARY KEY,
     user_name VARCHAR2(30)
  );
  
  INSERT INTO users VALUES('jang','������');
  INSERT INTO users VALUES('kim','������');
  
  CREATE TABLE commentb(
     comment_No INT PRIMARY KEY,
     user_id VARCHAR2(20) REFERENCES users(user_id),
     comment_Content VARCHAR2(100),
     reg_Date date
  );
  
  
  INSERT INTO commentb VALUES(2,'jang','��ſ� JDBC',sysdate);
  INSERT INTO commentb VALUES(1,'jang','ȣȣ',sysdate);
  INSERT INTO commentb VALUES(3,'kim','��ſ� oracle',sysdate);
  INSERT INTO commentb VALUES(4,'kim','�ְ��� cj',sysdate);
  INSERT INTO commentb VALUES(5,'jang','��ſ� mybatis',sysdate);
  

  CREATE TABLE reply(
    reply_no INT PRIMARY KEY, -- underscore (��۹�ȣ)
    comment_No INT REFERENCES commentb(comment_No), --�θ�۹�ȣ
    user_id VARCHAR2(20) REFERENCES users(user_id),
    reply_content VARCHAR2(100),
    reg_date date
  );
  
  INSERT INTO reply VALUES(10,1,'kim', '1���� ��� -1', SYSDATE);
  INSERT INTO reply VALUES(20,1,'jang', '1���� ��� -2', SYSDATE);
  INSERT INTO reply VALUES(30,1,'kim', '1���� ��� -3', SYSDATE);
  
  INSERT INTO reply VALUES(40,3,'jang', '3���� ��� -1', SYSDATE);
  INSERT INTO reply VALUES(50,3,'kim', '3���� ��� -2', SYSDATE);
  
  commit;
  
  select * from users;
  select * from commentb;
   select * from reply;
  
  --1:1�� ���� ����1) �Ѱ��� Comment�� �Ѹ��� �ۼ��� ������ ������.
  SELECT c.comment_No, c.user_id, u.user_name, c.comment_Content, c.reg_Date
		FROM commentb c JOIN users u
		ON c.user_id = u.user_id;
		
--1:���� ���� ����2) �Ѱ��� Comment�� �������� ������ �ۼ��� �� �ִ�.		
  SELECT c.comment_no, c.user_id, c.comment_Content, 
       r.reply_no, r.reply_content,r.user_id, r.reg_date
  FROM commentB c JOIN reply r
  ON c.comment_no = r.comment_no
  
  
  SELECT * FROM emp;
  SELECT * FROM dept;
  SELECT * FROM salgrade;
  
  SELECT d.dname, d.loc, e.empno, e.ename
  FROM emp e JOIN dept d
  ON e.deptno = d.deptno
  
  SELECT empno, ename, job, sal, grade, losal, hisal
  FROM emp e JOIN salgrade s
  ON e.sal BETWEEN s.losal AND s.hisal
  
  
  
  
  
  SELECT c.comment_no,  c.comment_Content, 
       r.reply_no, r.reply_content, r.user_id,  r.reg_date
     FROM commentB c JOIN reply r
     ON c.comment_no = r.comment_no
  
  
  
  select  comment_no , user_id, comment_content, reg_date
  from commentb
  
   INSERT INTO commentb VALUES(8,'jang',null,sysdate);
  commit
