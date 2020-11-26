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
	// @RequiredArgsConstructor를 사용하면 필드에 꼭 final을 붙여줘야한다
	// final을 붙이면 반드시 초기화를 해야한다
	
	/**
	 * 중복체크
	 */
	@RequestMapping(value="/check",produces = "text/html; charset=UTF-8")
	public String duplicateCheck(String stNo) {
		
		return service.duplicateCheck(stNo);
	}
	
	/**
	 * 등록
	 */
	@RequestMapping(value="/insert")
	public int insert(StudentDTO studentDto) {
		return service.insert(studentDto);
	}
	
	/**
	 * 전체검색
	 */
	@RequestMapping(value="/select")
	public List<StudentDTO> selectAll(){
		return service.selectAll();
	}
	
	/**
	 * 수정
	 */
	@RequestMapping(value="/update")
	public int update(StudentDTO studentDto) {
		return service.update(studentDto);
	}
	
	/**
	 * 삭제
	 */
	@RequestMapping(value="/delete")
	public int delete(String stNo) {
		return service.delete(stNo);
	}
	
	
}
