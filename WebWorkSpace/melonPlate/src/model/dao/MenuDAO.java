package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Menu;

public interface MenuDAO {

	/**
	 * �޴� ��ȸ
	 */
	List<Menu> selectMenu() throws SQLException;

	/**
	 * �޴� ���
	 */
	int insertMenu(Menu menu) throws SQLException;

	/**
	 * �޴� ����
	 */
	int deleteMenu(int resNo, String menuName) throws SQLException;
	
	
	/*
	 * �޴� ����
	 */
	int updateMenu(Menu menu) throws SQLException;

}
