package dao;

import java.sql.SQLException;
import java.util.List;

public interface TestDAO {

	public List<String> testSelectByUserNo(int userNo) throws SQLException; // �˻�(�ܾ�˻�)

}
