package kosta.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.dto.EmpDTO;

/**
 * SQL 문장 interface 기반
 */
public interface EmpMapper {

	/**
	 * 전체검색
	 */
	@Select("select empno, ename, job, sal, hiredate from emp")
	@Results(value = { @Result(column = "empno", property = "empno"), @Result(column = "ename", property = "ename") }) // resultMap으로
																														// 받기

	List<EmpDTO> selectAll();

	/*
	 * <select id="selectAll" resultType="emp"> <include refid="empSelectSql" />
	 * </select>
	 */
	/**
	 * 사원번호에 해당하는 정보 검색
	 */
	@Select("select empno, ename, job, sal, hiredate from emp where empno = #{_parameter}")
	EmpDTO selectByEmpNo(int empno);

	/**
	 * 사원번호에 해당하는 정보 삭제
	 */
	@Delete("delete from emp where empno = #{_parameter}")
	int delete(int empno);

	/**
	 * 사원번호에 해당하는 정보 수정
	 */
	@Update("update emp set ename = #{ename} , job = #{job}, sal=#{sal} where empno = #{empno}")
	int update(EmpDTO empDto);

	/**
	 * 사원 등록하기
	 */
	@Insert("insert into emp(empno, ename, job, sal, hiredate) values(#{empno},#{ename},#{job},#{sal},sysdate)")
	int insert(EmpDTO empDto);

	/**
	 * 동적쿼리 
	 *  : 동적쿼리를 사용하기 위해서는 <script></script>를 써줘야한다
	 */
	@Select("<script> "
			+ "select empno, ename, job, sal, hiredate form emp \r\n"
			+ "<trim prefix=\"where\" prefixOverrides=\"and | or\">\r\n" + 
			"		 	<if test=\"empName != null\"> \r\n" + 
			"		   		 ename=#{empName}\r\n" + 
			"		   	  </if>\r\n" + 
			"		   	\r\n" + 
			"		   	<if test=\"job != null \">\r\n" + 
			"		  	 and job=#{job}\r\n" + 
			"		   	</if>\r\n" + 
			"		   	\r\n" + 
			"		   	<!-- <choose>라는 그렇지않다면 이라는 조건을 넣는 것도 있다. -->\r\n" + 
			"		   	\r\n" + 
			"	 	</trim>"	
			+ "</script>") 
	List<EmpDTO>   ifTest(EmpDTO empDTO);
		

}
