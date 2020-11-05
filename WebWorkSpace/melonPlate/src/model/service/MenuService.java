package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.MenuDAO;
import model.dao.MenuDAOImpl;
import model.dto.Menu;

public class MenuService {

	private static MenuDAO menuDAO = new MenuDAOImpl();

	/**
	 * MenuDAOImpl의 맛집 등록 메소드 호출
	 */
	public static int insertMenu(Menu menu) throws SQLException {
		int result = menuDAO.insertMenu(menu);
		return result;
	}

	/**
	 * MenuDAOImpl의 맛집 삭제 메소드 호출
	 */
	public static int deleteMenu(int resNo, String menuName) throws SQLException {
		int result = menuDAO.deleteMenu(resNo, menuName);
		return result;

	}

	/**
	 * MenuDAOImpl의 맛집 수정 메소드 호출
	 */
	public static int updateMenu(Menu menu) throws SQLException {
		int result = menuDAO.updateMenu(menu);
		return result;

	}

	/**
	 * MenuDAOImpl의 맛집 조회 메소드 호출
	 */
	public static List<Menu> selectMenu() throws SQLException {
		List<Menu> list = menuDAO.selectMenu();
		return list;

	}

}
