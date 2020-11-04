package model.dao;

import java.util.List;

import model.dto.Writing;

public interface WritingDAO {
	/*
	 * 글 등록
	 * */
	int insertInfo(Writing w);
	
	/*
	 * 글 삭제
	 * */
	int deleteWriting(int wriNo);
	
	/*
	 * 글 수정
	 * */
	int updateWriting(Writing w);
	
	/*
	 * 글 전체보기
	 * */
	List<Writing> selectWriting();
}
