package kosta.mvc.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.model.dto.StudentDTO;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SqlSession session;


	@Override
	public StudentDTO duplicateCheck(String stNo) {
		StudentDTO studentDto = session.selectOne("studentMapper.select", stNo);
		return studentDto;
	}

	@Override
	public int insert(StudentDTO studentDto) {
		int result = session.insert("studentMapper.insert", studentDto);
		return result;
	}

	/*
	 * @Override public List<StudentDTO> selectAll() { List<StudentDTO> list =
	 * session.selectList("studentMapper.select");
	 * 
	 * return list; }
	 */
	
	//mapper를 어노테이션으로 함
	@Override
	public List<StudentDTO> selectAll() {
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		return mapper.selectAll();
	}

	@Override
	public int delete(String stNo) {
		return session.delete("studentMapper.delete",stNo);
	}

	@Override
	public int update(StudentDTO studentDto) {
		return session.update("studentMapper.update", studentDto);
	}

}
