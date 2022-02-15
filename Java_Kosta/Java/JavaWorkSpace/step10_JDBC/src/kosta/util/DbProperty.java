package kosta.util;

/**
 * DB 관련 속성 정보를 관리하는 상수 필드
 *
 */
public interface DbProperty {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //interface 아래는 자동으로 public static final 임
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

}
