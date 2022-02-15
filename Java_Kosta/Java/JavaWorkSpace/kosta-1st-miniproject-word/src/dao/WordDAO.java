
package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Word;

public interface WordDAO {

	/**
	 * �˻���� (��ü�˻�)
	 */
	public List<Word> wordSelect() throws SQLException; // ��ü�˻�(��ü�ܾ�˻�)

	/**
	 * �˻���� (�ܾ�� �˻�)
	 */
	public List<Word> wordSelectByWord(String eng) throws SQLException; // �˻�(�ܾ�˻�)

	/**
	 * �˻���� (���ĺ����� �˻�)
	 */
	public List<Word> wordSelectByAlphabet(String alphabet) throws SQLException; // �˻�(���ĺ��˻�)

	/**
	 * �ܾ� �߰��ϱ� (������)
	 */
	int wordInsert(Word word) throws SQLException;

	/**
	 * �ܾ� �����ϱ� (������)
	 */
	int wordDelete(Word word) throws SQLException;

	/**
	 * �ܾ� ���� (�ְ��� ���� 10��)
	 */
	public boolean wordTest(int wordNo, String answer) throws SQLException;

	/**
	 * �ܾ� ����(������)
	 */
	public boolean wordTestByLevel(int wordNo, String wordLevel, String answer) throws SQLException;

	/**
	 * �ܾ� �ҷ����� (������)
	 */
	public List<Word> wordSelectByLevel(String level) throws SQLException;
	
	/**
	 * �ܾ� �ҷ����� (�ܾ� �ѹ���)
	 */
	public List<Word> wordSelectByWordNo(int userNo) throws SQLException;

	/**
	 * �˻� ��� (�ѱ�)
	 */
	public List<Word> wordSelectByWordKor(String kor) throws SQLException;

	/**
	 * �˻� ��� (���� �ܾ�)
	 */
	public List<Word> wordSelectByUserNo(int userNo) throws SQLException;

	/**
	 * ���� ��Ʈ �ʱ�ȭ
	 */
	public void wordResetByUserNo(int userNo) throws SQLException;


}
