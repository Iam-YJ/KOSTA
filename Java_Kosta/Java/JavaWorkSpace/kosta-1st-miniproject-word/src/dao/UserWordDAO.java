package dao;

import java.sql.SQLException;
import java.util.List;
import dto.UserWord;

public interface UserWordDAO {

	/**
	 * �ܾ� �߰��ϱ� (���ο�)
	 */
	int wordInsert(UserWord userWord) throws SQLException;

	/**
	 * �ܾ� �����ϱ� (���ο�)
	 */
	int wordDelete(UserWord userWord) throws SQLException;

	/**
	 * ���� �ܾ� ��ü  ����
	 */
	List<UserWord> selectMemberWord(int userNo) throws SQLException;

	/**
	 * �ܾ� ���� (�ְ��� ���� 10��)
	 */
	public boolean wordTest(int wordNo, String answer) throws SQLException;
}
