package kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB ������ �ʿ��� �ε�, ����, �ݱ� ��� ����
 */

public class DbUtil {

	/**
	 * �ε�
	 */
	static {
		try {
			Class.forName(DbProperty.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����
	 */
	// static �� �ٿ��� �ٸ������� �ٷ� ȣ���� �� �ֵ���.
	public static Connection getConnection() throws SQLException {
		// ������ �̰Ÿ� ����ϴ� DAO class���� ����ó���� �ϰ� �ϱ� ���ؼ�
		return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORD);
	}

	/**
	 * �ݱ�(select�� ���)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) // null�� �ƴ� -> ���𰡸� ���� -> �״ϱ� �ݾƶ�
				rs.close(); // ���� �������� ������ �� ���� �ݱ�
			/*
			 * if (st != null) st.close(); if (con != null) con.close();
			 */ // ���� �ڵ� ������ �Ʒ� �޼ҵ� ��
			dbClose(con, st);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * �ݱ�(insert, update, delete�� ��� )
	 */
	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
