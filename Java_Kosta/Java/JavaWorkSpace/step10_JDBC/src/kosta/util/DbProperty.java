package kosta.util;

/**
 * DB ���� �Ӽ� ������ �����ϴ� ��� �ʵ�
 *
 */
public interface DbProperty {
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //interface �Ʒ��� �ڵ����� public static final ��
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

}
