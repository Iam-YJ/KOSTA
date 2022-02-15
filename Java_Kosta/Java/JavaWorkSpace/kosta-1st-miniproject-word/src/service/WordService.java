
package service;

import java.sql.SQLException;
import java.util.List;

import dao.WordDAO;
import dao.WordDAOImpl;
import dto.Word;
import gui.GUIMainView;

public class WordService {
	static WordDAO wd = new WordDAOImpl();

	/**
	 * �ܾ� �߰� 
	 * */
	public void wordInsert(Word word) throws SQLException {
		if (wd.wordInsert(word) > 0) {
			GUIMainView.appendConsoleField("____________________________________________________________________________________\n\n�ܾ� \"" + word.getWordEng() + "\"  /  \"" + word.getWordKor() + "\" ��  �߰��Ǿ����ϴ�.");
		}
		else throw new SQLException("��ϵ��� �ʾҽ��ϴ�..");

	}
	/**
	 * �ܾ� ����
	 */
	public void wordDelete(Word word) throws SQLException {
		int result = wd.wordDelete(word);
		if (result > 0) {
			GUIMainView.appendConsoleField("____________________________________________________________________________________\n\n�ܾ� \"" + word.getWordEng() + "\" �� " + result + "�� �����Ǿ����ϴ�.");
		}
		else throw new SQLException("�������� �ʾҽ��ϴ�..");
	}

	
	/**
	 * �ܾ� �˻� (��ü �ܾ� ��ȸ)
	 */
	public List<Word> wordSelect() throws SQLException	{ //��ü�ܾ� �˻�
		List<Word> list = wd.wordSelect();
		if (list.size() == 0 || list == null) {
			throw new SQLException("��ġ�ϴ� �ܾ �����ϴ�");
		}
		return list;
	}

	/**
	 * �ܾ� �˻� (�ܾ�� �˻� )
	 */
	public List<Word> wordSelectByWord(String eng) throws SQLException { //Ư���ܾ� �˻�
		List<Word> list = wd.wordSelectByWord(eng);
		if (list.size() == 0 || list == null) {
			throw new SQLException("��ġ�ϴ� �ܾ �����ϴ�");
		}
		return list;
	}

	/**
	 * �ܾ� �˻� (�ѱ۷� �˻� )
	 */
	public List<Word> wordSelectByWordKor(String kor) throws SQLException { //Ư���ܾ� �˻�
		List<Word> list = wd.wordSelectByWordKor(kor);
		if (list.size() == 0 || list == null) {
			throw new SQLException("��ġ�ϴ� �ܾ �����ϴ�");
		}
		return list;
	}

	/**
	 * �ܾ� �˻� (���ĺ� �˻�)
	 */
	public List<Word> wordSelectByAlphabet(String alphabet) throws SQLException { //���ĺ��˻�
		List<Word> list = wd.wordSelectByAlphabet(alphabet);
		if (list.size() == 0 || list == null) {
			throw new SQLException("��ġ�ϴ� �ܾ �����ϴ�");
		}
		return list;
	}
	
	/**
	 * �ܾ� �˻� (���� �ܾ���)
	 */
	public List<Word> selectUserWord(int userNo) throws SQLException	{ //��ü�ܾ� �˻�
		List<Word> list = wd.wordSelectByUserNo(userNo);
		if (list.size() == 0 || list == null) {
			throw new SQLException("��ġ�ϴ� �ܾ �����ϴ�");
		}
		return list;
	}
	

	
	/**
	 * �ܾ� ����(�ְ��� ���� 10��)
	 */
	public static boolean wordTest(int wordNo, String answer) throws SQLException {
		boolean flag = wd.wordTest(wordNo, answer);
//		if (flag == false) {
//			throw new SQLException("�����Դϴ�");
//		}
		return flag;
	}
	
	/**
	 * �ܾ����(������)
	 */
	public static boolean wordTestByLevel(int wordNo, String wordLevel, String answer) throws SQLException{
		boolean flag = wd.wordTestByLevel(wordNo, wordLevel, answer);
//		if (flag == false) {
//		throw new SQLException("�����Դϴ�");
//	}
		return flag;
	}
	
	/**
	 * �ܾ� �˻� (�ܾ� �ѹ���)
	 */
	public static List<Word> wordSelectByWordNo(int userNo) throws SQLException {
		List<Word> list = wd.wordSelectByWordNo(userNo);
		
		if (list.size() == 0 || list == null) {
			throw new SQLException("��ġ�ϴ� �ܾ �����ϴ�");
		}
		return list;
	}
	
	/**
	 * ���� ��Ʈ �ʱ�ȭ
	 */
	public static void wordResetByUserNo(int userNo) throws SQLException {
		wd.wordResetByUserNo(userNo);
	}
}

