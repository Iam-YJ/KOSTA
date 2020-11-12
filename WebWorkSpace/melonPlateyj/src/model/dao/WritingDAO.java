package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.WriList;
import model.dto.Writing;

public interface WritingDAO {
	
	/**
	 * 식당이름으로 검색 
	 */
	List<Melon> selectByName(String resName) throws SQLException;
	
	/*
	 * 글 등록
	 * */
	int insertWriting(Writing writing) throws SQLException;
	
	/*
	 * 글 삭제
	 * */
	int deleteWriting(int wriNo);
	
	/*
	 * 글 수정
	 * */
	int updateWriting(Writing writing) throws SQLException;
	
	/*
	 * 글 전체보기
	 * */
	List<Writing> selectWriting() throws SQLException;
}
