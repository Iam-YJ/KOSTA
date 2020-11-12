package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dto.Menu;
import util.DbUtil;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public int insertMenu(Menu menu) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();

			ps = con.prepareStatement("insert into menu values(menu_NO_SEQ.nextval,RES_NO_SEQ.nextval,?,?)");
			ps.setString(1, menu.getMenuName());
			ps.setString(2, menu.getMenuPrice());



			result = ps.executeUpdate();
		} finally {

			DbUtil.dbClose(ps, con);
		}

		return result;

	}

}
