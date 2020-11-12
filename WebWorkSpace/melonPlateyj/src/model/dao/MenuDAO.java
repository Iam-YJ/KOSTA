package model.dao;

import java.sql.SQLException;

import model.dto.Menu;

public interface MenuDAO {

	/*
	 * 메뉴 추가
	 */
	int insertMenu(Menu menu) throws SQLException;
}
