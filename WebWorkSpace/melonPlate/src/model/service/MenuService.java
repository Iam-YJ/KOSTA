package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.MenuDAO;
import model.dao.MenuDAOImpl;
import model.dto.Menu;

public class MenuService {

	private static MenuDAO menuDAO = new MenuDAOImpl();

	/**
	 * MenuDAOImpl�� ���� ��� �޼ҵ� ȣ��
	 */
	public static int insertMenu(Menu menu) throws SQLException {
		int result = menuDAO.insertMenu(menu);
		return result;
	}

	/**
	 * MenuDAOImpl�� ���� ���� �޼ҵ� ȣ��
	 */
	public static int deleteMenu(int resNo, String menuName) throws SQLException {
		int result = menuDAO.deleteMenu(resNo, menuName);
		return result;

	}

	/**
	 * MenuDAOImpl�� ���� ���� �޼ҵ� ȣ��
	 */
	public static int updateMenu(Menu menu) throws SQLException {
		int result = menuDAO.updateMenu(menu);
		return result;

	}

	/**
	 * MenuDAOImpl�� ���� ��ȸ �޼ҵ� ȣ��
	 */
	public static List<Menu> selectMenu() throws SQLException {
		List<Menu> list = menuDAO.selectMenu();
		return list;

	}

}
