package kosta.mvc.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kosta.mvc.model.dto.StudentDTO;

public interface StudentMapper {
	
	/**
	 * ��ü�˻�
	 *  	������̼����� �ϴ� �� ����Ϸ��� mybatis-context.xml�� ����ؾ��Ѵ�
	 */
	@Select("select st_no, st_name, st_age, st_addr, st_phone from student")
	List<StudentDTO> selectAll();

}
