package model.dao;

import java.sql.SQLException;

import model.dto.Menu;

public interface MenuDAO {

	/*
	 * �޴� �߰�
	 */
	int insertMenu(Menu menu) throws SQLException;
}
