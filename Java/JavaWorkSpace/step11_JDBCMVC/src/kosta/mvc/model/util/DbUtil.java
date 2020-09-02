package kosta.mvc.model.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DB 연동에 필요한 로드, 연결, 닫기 기능 구현
 */

public class DbUtil {

	private static Properties proFile = new Properties();
	
	
	public static Properties getProFile() {
		return proFile;
	}
	
	

	/**
	 * 로드
	 */
	static {
		try {
			// 2개의 properties 파일 로딩해서 properties 객체에 저장한다

			proFile.load(new FileInputStream("resources/board.properties"));
			proFile.load(new FileInputStream("resources/dbInfo.properties"));

			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 연결
	 */
	// static 을 붙여서 다른곳에서 바로 호출할 수 있도록.
	public static Connection getConnection() throws SQLException {
		// 던지면 이거를 사용하는 DAO class에서 예외처리를 하게 하기 위해서
		return DriverManager.getConnection(proFile.getProperty("url"),proFile.getProperty("userName"),proFile.getProperty("userPass"));
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
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
