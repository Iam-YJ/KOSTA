package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Menu;

public interface MelonDAO {
	/*
	 * 조회수 순서로 검색(내림차순)
	 * */
	List<Melon> selectByHits() throws SQLException;
	
	/*
	 * 평점순으로 검색 (평점 내림차순)
	 * */
	List<Melon> selectByGrade() throws SQLException;
	
	/*
	 * 음식종류별 검색 (종류)
	 * */
	List<Melon> selectByType(String type) throws SQLException;
	
	/*
	 * 조회수 증가 (맛집no)
	 * */
	int updateHits(int resNo) throws SQLException;
	
	/*
	 * 지역별 검색 (지역)
	 * */
	List<Melon> selectByArea(String area) throws SQLException;
	
	/*
	 * 식당이름별 검색
	 * */
	List<Melon> selectByResName(String resName) throws SQLException;

	/*
	 * 가격순 검색
	 * */
	List<Melon> selectByPrice(String price) throws SQLException;
	
	/*
	 * 주변 식당 추천(내 위치 기준) 
	 * */
	List<Melon> selectRecommend() throws SQLException;
	
	/*
	 * 식당 상세보기 
	 * */
	Melon selectDetailRes(int resNo) throws SQLException;

	List<Melon> selectAll() throws SQLException;
	
	/*
	 * 메뉴 보기
	 * */
	List<Menu> selectMenu(int resNo) throws SQLException;
}
