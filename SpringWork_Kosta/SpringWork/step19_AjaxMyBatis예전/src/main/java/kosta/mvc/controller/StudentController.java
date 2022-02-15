package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.model.dto.StudentDTO;
import kosta.mvc.model.service.StudentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService service;
	// @RequiredArgsConstructor�� ����ϸ� �ʵ忡 �� final�� �ٿ�����Ѵ�
	// final�� ���̸� �ݵ�� �ʱ�ȭ�� �ؾ��Ѵ�
	
	/**
	 * �ߺ�üũ
	 */
	@RequestMapping(value="/check",produces = "text/html; charset=UTF-8")
	public String duplicateCheck(String stNo) {
		
		return service.duplicateCheck(stNo);
	}
	
	/**
	 * ���
	 */
	@RequestMapping(value="/insert")
	public int insert(StudentDTO studentDto) {
		return service.insert(studentDto);
	}
	
	/**
	 * ��ü�˻�
	 */
	@RequestMapping(value="/select")
	public List<StudentDTO> selectAll(){
		return service.selectAll();
	}
	
	/**
	 * ����
	 */
	@RequestMapping(value="/update")
	public int update(StudentDTO studentDto) {
		return service.update(studentDto);
	}
	
	/**
	 * ����
	 */
	@RequestMapping(value="/delete")
	public int delete(String stNo) {
		return service.delete(stNo);
	}
	
	
}
