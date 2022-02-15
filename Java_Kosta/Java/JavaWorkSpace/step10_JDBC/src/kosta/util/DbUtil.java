package kosta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB 연동에 필요한 로드, 연결, 닫기 기능 구현
 */

public class DbUtil {

	/**
	 * 로드
	 */
	static {
		try {
			Class.forName(DbProperty.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 연결
	 */
	// static 을 붙여서 다른곳에서 바로 호출할 수 있도록.
	public static Connection getConnection() throws SQLException {
		// 던지면 이거를 사용하는 DAO class에서 예외처리를 하게 하기 위해서
		return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORD);
	}

	/**
	 * 닫기(select인 경우)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) // null이 아님 -> 무언가를 썼음 -> 그니까 닫아라
				rs.close(); // 가장 마지막에 생성된 것 부터 닫기
			/*
			 * if (st != null) st.close(); if (con != null) con.close();
			 */ // 공통 코드 때문에 아래 메소드 씀
			dbClose(con, st);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * 닫기(insert, update, delete인 경우 )
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
