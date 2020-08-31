select * from teacher;
select * from student;
select * from subject;
select * from room;
select * from sugagn;
select * from sugagntb;


--1. 성별이 여자인 학생의 정보 검색
select *
from student
where 수_주민등록번호 like '%-2%';


--2. 생년월일이 1973년인 수강생 정보를 검색(substr)
select substr(수_주민등록번호, 1,2) as 생년월일, 수강생번호, 수_이름, 수_주민등록번호,수_연락처, 수_주소, 수_이메일
from student
where 수_주민등록번호 like '73%';


--3. 성이 '홍'이 아닌 강사의 정보 검색
select * 
from teacher
where not 강사이름 like '홍%';

--4. 강남구에 거주하는 강사의 정보 검색
select *
from teacher
where 주소 like '%강남구%';


--5. java를 강의하는 강사 정보 검색(서브쿼리 이용)
select *
from teacher t join subject s
on t.수강코드 = s.수강코드
where s.과목 = 'java';


--6. 주소가 null이 아닌 강사의 정보 검색
select *
from teacher 
where 주소 is not null;

--7.sql 수업을 수강하고 있는 학생의 정보를 검색하는 뷰 작성
select s.수강생번호, s.수_이름, sb.과목
from (student s join sugagn sg on s.수강생번호 = sg.수강생번호) 
join (sugagn sg join subject sb on sg.수강코드 = sb.수강코드)
on s.수강생번호 = sg.수강생번호
where sb.과목 = 'sql';


--8.강사가 담당하는 과목과 그 과목이 어느 강의실에서 진행되며 
    -- 총 수용 인원이 몇 명인지 검색(아래그림 참조) - (join 이용하여 뷰 작성)

create view 강사뷰 as
select t.강사번호,t.강사이름,t.수강코드,sb.과목,tb.강의실번호,r.수용인원
from teacher t join subject sb
on t.수강코드=sb.수강코드 join sugagntb tb
on sb.수강코드 = tb.수강코드 join room r
on tb.강의실번호 = r.강의실번호;

select * from 강사뷰;



--9. 아래의 그림을 보고 만드세요(학생의 이름, 주민번호,성별을 출력하세요)
select 수_이름, 수_주민등록번호, decode(substr(수_주민등록번호, 8,1),'1','남자','2','여자')as 성별
from student;

--10. 아래의 그림을 보고 만드세요
--(teacher 강사의 이름을 기주으로 올림차순으로 정렬하여 
--정렬된 순서대로 rownum이 출력되도록 하시오)
select rownum, t.*
from (select 강사이름, 연락처, 주소 from teacher order by 강사이름) t;


