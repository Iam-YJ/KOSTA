

public interface EmpDAO {
   /**
    * 레코드 삽입
    * insert into emp(empno,ename,job,sal,hiredate)
    * values(?,?,?,?,sysdate)
    * */
	int empInsert(EmpDTO dto);
	
	/**
	 * empno(사원번호) 중복체크기능
	 * @return : true이면 중복, false이면 사용가능
	 * 
	 * select empno from emp where empno=?
	 * */
	boolean duplicateByEmpno(int empno) ;
	
	/**
	 * 사원번호에 해당하는 레코드 검색
	 *select empno, ename, job, sal, hiredate from emp where empno=? 
	 * */
	EmpDTO selectByEmpno(int empno);
	
	/**
	 * 모든 사원정보 검색하기
	 * select empno, ename, job, sal, hiredate from emp
	 * */
	 List<EmpDTO> selectAll();
	 
	 /**
	  * 사원번호에 해당하는 레코드 삭제
	  *  delete from emp where empno=?
	  * */
	 int empDelete(int empno);
	 
	 /**
	  * 사원번호에 해당하는 사원정보 수정하기
	  *  ( ename, job, sal 수정)
	  *  update emp 
	  *  set ename=? , job=? , sal=?
	  *  where empno=?
	  *  
	  * */
	 int empUpdate(EmpDTO dto);
}













