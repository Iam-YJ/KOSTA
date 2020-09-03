package kosta.mvc.model.util;
/**
 * DB연동에 필요한 로드, 연결, 닫기 기능 구현
 * */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtil {
	private static Properties proFile = new Properties();
	
	
	public static Properties getProFile() {
		return proFile;
	}
	
  /**
   * 로드
   * */
	static{
		try {
		 //2개의 properties파일 로딩해서 Properties객체에 저장한다. 	
		 proFile.load(new FileInputStream("resources/board.properties"));
		 proFile.load(new FileInputStream("resources/dbInfo.properties"));
		 
		 
		  Class.forName(proFile.getProperty("driverName"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
   /**
    * 연결
    * */
	
	public static Connection getConnection()throws SQLException {
		return DriverManager.getConnection(
				proFile.getProperty("url"), 
				proFile.getProperty("userName"), 
				proFile.getProperty("userPass"));
	}
	
	/**
	 * 닫기(select인경우)
	 * */
	public static void dbClose(Connection con, Statement st , ResultSet rs){
		try {
		  if(rs!=null) rs.close();
		  
		  dbClose(con, st);
		  
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기(insert, update, delete 인경우)
	 * */
    public static void dbClose(Connection con, Statement st ){
    	try {
  		  if(st!=null) st.close();
  		  if(con!=null)con.close();
  		}catch (SQLException e) {
  			e.printStackTrace();
  		}
	}
	
}














