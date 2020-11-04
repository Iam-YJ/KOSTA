package model.dao;

import java.util.List;

import model.dto.Melon;

public interface MelonDAO {
	/*
	 * 조회수 순서로 검색(내림차순)
	 * */
	List<Melon> selectByHits(int hits);
	
	/*
	 * 평점순으로 검색 (평점 내림차순)
	 * */
	List<Melon> selectByGrade(double grade);
	
	/*
	 * 음식종류별 검색 (종류)
	 * */
	List<Melon> selectByType(String type);
	
	/*
	 * 조회수 증가 (맛집no)
	 * */
	int updateHits(int resNo);
	
	/*
	 * 지역별 검색 (지역)
	 * */
	List<Melon> selectByArea(String area);
	

}
