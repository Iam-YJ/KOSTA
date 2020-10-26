package kosta.dao;

import java.util.List;

import kosta.dto.Member;

/**
 * 회원관리
 */
public interface MemberDAO {
	
	/*
	 * 전체검색
	 */
	List<Member> selectAll();
	
	/*
	 * 조건검색(검색필드와 검색단어에 해당하는 레코드 검색)
	 */
	List<Member> searchByKeyWord(String keyField, String keyWord);
	
	/*
	 * 등록하기
	 */
	int insert(Member member);
	
	
	/*
	 * ID 중복체크하기
	 * @return : true 이면 존재함, false 이면 존재하지 않음 
	 */
	boolean idCheck(String id);
	
	/*
	 * ID 삭제 하기
	 */
	int deleteId(String id);
	
	
}
