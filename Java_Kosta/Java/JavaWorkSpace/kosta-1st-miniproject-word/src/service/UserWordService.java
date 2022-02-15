package service;

import java.sql.SQLException;
import java.util.List;
import dao.UserWordDAO;
import dao.UserWordDAOImpl;
import dto.UserWord;

public class UserWordService {
	static UserWordDAO uw = new UserWordDAOImpl();

	public int wordInsert(UserWord userWord) throws SQLException {
		int result = uw.wordInsert(userWord);
		if (result == 0) {
			throw new SQLException("�ܾ �߰����� ���߽��ϴ�");
		}
		return result;
	}

	public int wordDelete(UserWord userWord) throws SQLException {
		int result = uw.wordDelete(userWord);
		if (result == 0) {
			throw new SQLException("�ܾ �������� ���߽��ϴ�");
		}
		return result;
	}

	public List<UserWord> selectMemberWord(int userNo) throws SQLException {
		List<UserWord> list = uw.selectMemberWord(userNo);
		if (list.size() == 0 || list == null) {
			throw new SQLException("���� �ܾ����� �ҷ����� ���߽��ϴ�");
		}
		return list;
	}
	
	/**
	 * �ܾ� ����(�ְ��� ���� 10��)
	 */
	public static boolean wordTest(int wordNo, String answer) throws SQLException {
		boolean flag = uw.wordTest(wordNo, answer);
/*		if (flag == false) { // GUI���� ���� ��µǹǷ� �ּ� ó��
			throw new SQLException("�����Դϴ�");
		}	*/
		return flag;
	}
}
