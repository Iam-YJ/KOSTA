package kosta.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.model.dto.StudentDTO;
import kosta.mvc.model.repository.StudentDao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	
	private final StudentDao studentDao;

	@Override
	public String duplicateCheck(String stNo) {
		StudentDTO studentDto = studentDao.duplicateCheck(stNo);
		String str = "";
		
		if(studentDto != null) {
			str = "사용중입니다.";
		}else {
			str = "사용가능";
		}
		
		return str;
	}

	@Override
	public List<StudentDTO> selectAll() {
		return studentDao.selectAll();
	}

	@Override
	public int insert(StudentDTO studentDto) {
		
		return studentDao.insert(studentDto);
	}

	@Override
	public int update(StudentDTO studentDto) {
		return studentDao.update(studentDto);
	}

	@Override
	public int delete(String stNo) {
		return studentDao.delete(stNo);
	}

}
