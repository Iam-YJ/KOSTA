package kosta.mvc.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kosta.mvc.model.dto.StudentDTO;

public interface StudentMapper {
	
	/**
	 * 전체검색
	 *  	어노테이션으로 하는 것 등록하려면 mybatis-context.xml에 등록해야한다
	 */
	@Select("select st_no, st_name, st_age, st_addr, st_phone from student")
	List<StudentDTO> selectAll();

}
