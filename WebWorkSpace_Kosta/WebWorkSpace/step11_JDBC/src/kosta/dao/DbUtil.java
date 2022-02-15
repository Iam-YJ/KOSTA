package kosta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

/**
 * DB������ ���� �ε�, ����, �ݱ� ��� Ŭ����
 */
public class DbUtil {

	private static DataSource ds;
	/**
	 * �ε�
	 */
	static {
		// context.xml���� �ε��� �Ǿ
		// ���⼭ ���� �о�;��Ѵ�(context��)

		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/myoracle");
			// jdbc/myoracle�� context.xml�� ���� name

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * ����
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	/**
	 * �ݱ� (insert, update ,delete �ΰ�� )
	 */
	public static void dbClose(Statement st, Connection con) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ݱ�(select �ΰ��)
	 */
	public static void dbClose(ResultSet rs, Statement st, Connection con) {
		try {
			if (rs != null)
				rs.close();
			dbClose(st, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}