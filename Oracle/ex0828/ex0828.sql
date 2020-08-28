/*
    view : 가상테이블
     - 실제로 존재하지 않지만 가상테이블을 만들어서 테이블처럼 사용하는 것
     (select, insert, update, delete가 가능하다 - 단, 옵션에 따라 DML 안될 수 있다.)
     
     1) 보안적인 측면
        : 테이블의 특정한 컬럼과 레코드를 선택해서 뷰를 만들어 권한에 제한이 있는
            DBA에서 원본 테이블이 아닌 뷰의 정보를 제공한다. 
            
     2) 복잡한 쿼리를 단순화 
        : JOIN 또는 SUBQUERY 등의 긴 문장을 자주 사용하는 경우 VIEW를 만들어서
          사용하면 VIEW의 이름으로 복잡한 쿼리를 테이블처럼 단순화해서 사용할 수 있다.
     
     * 뷰 생성 OR 수정
     CREATE VIEW OR REPLACE 뷰이름
     AS 뷰이름;
     
     - 옵션 설정 
     1) WITH READ ONLY - 읽기전용 (DML 안된다)
     2) WITH CHECK OPTION - 뷰를 만들 때 조건을 이용해서 만들게 되면
                            INSERT 할 때 조건에 해당하는 정보를 등록하려하면 오류 발생 시켜준다. 
*/

--scott 계정 접속 

select * from copy_emp;

drop table copy_emp;


--테이블 복사
create table copy_emp
as select * from emp;

select * from copy_emp;

--뷰를 생성한다 -- 권한이 있어야 뷰를 만들 수 있다.
create or replace view view_emp 
as select * from copy_emp;


--뷰를 생성하려면 뷰를 생성할 수 있는 권한 필요하다 -scott 계정 
--권한 부여를 위해서 system 계정으로 접속한다
grant create view, create sequence to scott;


--뷰를 검색한다
select * from view_emp where ename='SMITH';
select * from view_emp order by sal desc;

--뷰를 삭제
delete from view_emp where empno = 7902;

--테이블 검색
select * from copy_emp;

--테이블의 레코드 삭제
delete from copy_emp where empno=7839;

--뷰는 원본인 실제 테이블을 바라보면서 CRUD를 하고 있다.
--테이블이 2개가 아니라 만들어져서 원본 테이블을 바라봄

-- 1)보안적인 측면으로 뷰를 생성해본다
create or replace view view_emp
as select empno, ename, job, deptno
from copy_emp where deptno=30; --부서가 30번인 애들만 보이게

--뷰 검색
select * from view_emp;

--insert 해본다
1) 테이블
insert into copy_emp(empno, ename, job, sal, hiredate, deptno)
values(9000, '효리', 'MANAGER',3500, SYSDATE, 30);

insert into copy_emp(empno, ename, job, sal, hiredate, deptno)
values(9000, '재석', 'MANAGER',3500, SYSDATE, 20);

select * from copy_emp;
select * from view_emp; 

2) view 
insert into view_emp values(9001,'비','SALESMAN',30);

insert into view_emp values(9002,'나영','SALESMAN',20);
* 20번 부서를 뷰에 등록하면 성공한다. 하지만 뷰를 검색했을 때 방금 등록한 20번 정보가 검색되지 않는다.
    그러면 뷰를 사용하는 DBA입장에서는 당황스럽다. 따라서 이런 모호한 부분을 해결하기 위해 뷰를 생성할 때
    조건이 있다면 WITH CHECK OPTION을 설정하는 것을 권장한다.
    
--다시 뷰를 생성해본다. - WITH CHECK OPTION을 넣어서
create or replace view view_emp
as select empno, ename, job, deptno from copy_emp where deptno=30
with check option;

--다시 뷰와 테이블에 데이터를 등록해본다.
insert into view_emp values(9000,'비','SALESMAN',10); --실패
insert into view_emp values(9001,'비비','SALESMAN',20); --실패
insert into view_emp values(9002,'비비비','SALESMAN',30);

select * from copy_emp;

--뷰에 레코드 삭제
delete from view_emp where job='MANAGER';

select * from view_emp;
select * from copy_emp;


--뷰를 생성할 때 읽기 전용으로 
create or replace view view_emp
as select empno, ename, job, deptno from copy_emp where deptno=30
with read only; --읽기 전용


--뷰에 insert or delete or update를 해본다 : 결론은 안된다!

insert into view_emp values(9000,'비','SALESMAN',10); --실패
update view_emp set empno = 8000;

select * from view_emp;
select * from copy_emp;


2) 복잡한 쿼리를 뷰로 만들어서 사용한다
--
grant create view to jang;

Create Table subEmp(
	emp_id 	   int, --사원번호
	emp_name	   Varchar2(20) Not Null,  --사원이름
	job      	               Varchar2(20) Not Null,  --직업
	dept_id  	  int, --부서번호
	sal 	              int Not Null,--급여
	bonus	              int,--보너스
	mgr_id	              int,--관리자번호
	hiredate             date  Not Null, --입사일
	constraint emp_id_pk Primary Key(emp_id) --제약조건
);

INSERT INTO subEMP VALUES (6200,'박철수','대표',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO subEMP VALUES (6311,'김대정','부장',100, 3500,Null,6200, '1998-12-17');

INSERT INTO subEMP VALUES (7489,'민동규','세일즈',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO subEMP VALUES (7522,'정종철','세일즈',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO subEMP VALUES (6321,'이종길','부장',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO subEMP VALUES (6351,'진대준','부장',300,   2850,NULL,6200,'2000-05-31');

INSERT INTO subEMP VALUES (7910,'이영희','경리',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO subEMP VALUES (6361,'김철수','부장',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO subEMP VALUES (7878,'백기수','연구직',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO subEMP VALUES (7854,'진영진','세일즈',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO subEMP VALUES (7872,'이문정','사무직',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO subEMP VALUES (7920,'마리아','사무직',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO subEMP VALUES (7901,'정동길','연구직',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO subEMP VALUES (7933,'김철수','사무직',200,  1050,NULL,6361,'2002-01-02');

drop table subemp;

create or replace view view_emp
as
select * from subEmp
where sal > (select max(avg(sal)) from subEMP
            where dept_id is not null
            group by dept_id);
            
--뷰 검색 
select * from view_emp where emp_id=6321;

--------------------------------------------------------------------
/*
 SEQUENCE : 자동증가 값 설정 
    
    :생성방법
    CREATE SEQUENCE 시퀀스이름
    [START WITH 초기값]
    [INCREMENT BY 증가값]
    [MAXVALUE 최대값]
    [MINVALUE 최소값]
    [CACHE : NOCACHE]
    [CYCLE : NOCYCLE]
    
    * 사용방법
    시퀀스이름.NEXTVAL : 시퀀스증가
    시퀀스이름.CURRVAL : 현재 시퀀스
    
    *시퀀스 수정
    ALTER SEQUENCE 시퀀스이름
    
    *시퀀스 삭제
    DROP SEQUENCE 시퀀스이름
*/

--시퀀스 생성
create sequence seq_no nocache;

--시퀀스 사용
select seq_no.nextval, seq_no.currval
from dual;

--시퀀스 삭제
drop sequence seq_no;

--시퀀스 옵션설정, 생성
create sequence seq_no
start with 10
increment by 5
maxvalue 100
minvalue 5
cycle
nocache;
--nocache 권장함. 캐시를 쓰지 않기 때문에 그때그때마다 하나씩 증가하며 뽑아옴 
--캐시는 어느정도 미리 담아두고 꺼냄.. 그래서 갑자기 이상한 값 나오는 오류 날수도..

select seq_no.nextval, seq_no.currval
from dual;

--테이블 생성
create table board(
    board_no number(4) primary key,
    subject varchar2(30),
    content varchar2(50),
    regdate date
    
);

select * from board;
--글을 등록할 때 사용한 시퀀스를 생성한다
create sequence board_seq_no nocache;

insert into board values(board_seq_no.nextval, '배고프다','뭐먹지?',sysdate);
--왜 nextval이냐면,, 원래 있던 번호에서 하나를 증가시켜서 넣기 때문 

--여기서 board_seq_no 하면 오류던데.. seq에서 정해진 숫자로 넣을수는 없는걸까

-- ++ 시퀀스는 insert into를 했을 때 실패해도 번호가 자동으로 넘어간다 ..
--      반드시 시퀀스가 넘어간다. 무조건 1다음 2, 2다음 3.. 이렇게 ㄴㄴ 

------------------------------------------------------------------------
/*
     transaction
        : 여러개의 작업을 (insert, update, delete)를 하나의 단위로 묶어서 한번에 commit(저장) , rollback(취소)해서 일관성을 유지하도록 하는 것
        : savepotin 이름; 을 설정하면 rollback 이름; 을 이용해서 원하는 영역 지점까지 취소처리가 가능하다 
*/

commit;

drop table copy_emp;

--테이블 복사
create table copy_emp
as select * from emp;

select * from copy_emp;

commit;
rollback; --세트가(롤백이나 커밋 실행 이후부터) 한번에 롤백된다. 

--레코드 삭제
delete from copy_emp where job='MANAGER';

--레코드 등록
insert into copy_emp(empno, ename, job, sal) values(9000, '효리','TEACHER',2500);

--레코드 수정
update copy_emp set hiredate=sysdate, sal=500 where deptno=30;

--취소
rollback;

savepoint A;
delete from copy_emp where job='MANAGER';
insert into copy_emp(empno, ename, job, sal) values(9000, '효리','TEACHER',2500);

savepoint B;
update copy_emp set hiredate=sysdate, sal=500 where deptno=30;
insert into copy_emp(empno, ename, job, sal) values(9005, '비','TEACHER',2500);
insert into copy_emp(empno, ename, job, sal) values(9006, '재석','TEACHER',2500);

savepoint C;
delete from copy_emp where deptno=20;

--취소
rollback to B;

--저장완료
COMMIT;

select * from copy_emp;
----------------------------------------------------------------------
--현재 JANG 계정에서 SCOTT 계정의 테이블 접근해본다
SELECT * FROM SCOTT.SALGRADE; --현재 계정이 다른 계정의 테이블을 접근하려면 권한 부여(소유자 OR 최고관리자가)해야한다.

--SYSTEM 으로 접속해서 권한 부여한다
 GRANT ALL ON SCOTT.SALGRADE TO JANG; 

-- SYSTEM으로 접속해서 권한 제거한다 
REVOKE ALL ON SCOTT.SALGRADE FROM JANG;

