package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Menu;
import util.DbUtil;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> selectMenu() throws SQLException {
		List<Menu> list = new ArrayList<Menu>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM menu";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				int menuNo = rs.getInt(1);
				int resNo = rs.getInt(2);
				String menuName = rs.getString(3);
				String menuPrice = rs.getString(4);

				Menu menu = new Menu(menuNo, resNo, menuName, menuPrice);
				list.add(menu);
			}

		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public int insertMenu(Menu menu) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into menu values(menu_NO_SEQ.nextval,?,?,?");
			ps.setInt(1, menu.getResNo());
			ps.setString(2, menu.getMenuName());
			ps.setString(3, menu.getMenuPrice());

			result = ps.executeUpdate();
		} finally {

			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public int deleteMenu(int resNo, String menuName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("delete from menu where menu_name=? and res_no=?");
			ps.setString(1, menuName);
			ps.setInt(2, resNo);

			result = ps.executeUpdate();
		} finally {

			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public int updateMenu(Menu menu) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update menu set menu_name=?, menu_price=? where res_no=?");
			ps.setString(1, menu.getMenuName());
			ps.setString(2, menu.getMenuPrice());
			ps.setInt(3, menu.getResNo());

			result = ps.executeUpdate();
		} finally {

			DbUtil.dbClose(ps, con);
		}

		return result;
	}

}
