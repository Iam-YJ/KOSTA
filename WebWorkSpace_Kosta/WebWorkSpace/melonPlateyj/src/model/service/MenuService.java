package model.service;

import java.sql.SQLException;

import model.dao.MenuDAO;
import model.dao.MenuDAOImpl;
import model.dto.Menu;

public class MenuService {
	private static MenuDAO menuDAO = new MenuDAOImpl();
	
	/**
	 * MenuDAOImpl�� �޴� ��� �޼ҵ� ȣ��
	 */
	public static int insertMenu(Menu menu) throws SQLException {
		int result = menuDAO.insertMenu(menu);
		return result;
	}


}
