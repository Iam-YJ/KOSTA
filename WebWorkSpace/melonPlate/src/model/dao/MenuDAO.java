package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Menu;

public interface MenuDAO {

	/**
	 * 메뉴 조회
	 */
	List<Menu> selectMenu() throws SQLException;

	/**
	 * 메뉴 등록
	 */
	int insertMenu(Menu menu) throws SQLException;

	/**
	 * 메뉴 삭제
	 */
	int deleteMenu(int resNo, String menuName) throws SQLException;
	
	
	/*
	 * 메뉴 수정
	 */
	int updateMenu(Menu menu) throws SQLException;

}
