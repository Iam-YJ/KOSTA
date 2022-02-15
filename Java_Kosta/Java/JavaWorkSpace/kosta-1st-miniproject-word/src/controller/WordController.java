
package controller;

import java.sql.SQLException;
import java.util.List;

import dto.Word;
import gui.GUIMainView;
import service.WordService;
import view.EndView;
import view.FailView;

public class WordController {

	private static WordService service = new WordService();

	/**
	 * �ܾ� �߰��ϱ�
	 */
	public static void wordInsert(Word word) {
		try {
			service.wordInsert(word);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());

		}

	}

	/**
	 * �ܾ� �����ϱ�
	 */

	public static void wordDelete(Word word) {
		try {
			service.wordDelete(word);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void wordSelect() { // ��ü�ܾ� �˻�
		try {
			List<Word> list = service.wordSelect();
			EndView.printWordList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void wordSelectByWord(String eng) { // ���ܾ� �˻�
		try {
			List<Word> list = service.wordSelectByWord(eng);
			EndView.printWordList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void wordSelectByWordKor(String kor) { // �ѱ� �˻�
		try {
			List<Word> list = service.wordSelectByWordKor(kor);
			EndView.printWordList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void wordSelectByAlphabet(String alphabet) { // ���ĺ��˻�
		try {
			List<Word> list = service.wordSelectByAlphabet(alphabet);
			EndView.printWordList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void wordSelectByUser(int userNo) { // ��ü�ܾ� �˻�
		try {
			List<Word> list = service.selectUserWord(userNo);
			EndView.printWordList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static boolean getAnswer(int wordNo, String answer) {
		boolean flag = false;
		try {
			flag = service.wordTest(wordNo, answer);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

		return flag;
	}

	public static boolean getAnswerByLevel(int wordNo, String wordLevel, String answer) {
		boolean flag = false;
		try {
			flag = service.wordTestByLevel(wordNo, wordLevel, answer);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

		return flag;
	}

	/**
	 * �ܾ� �������� (�ܾ� �ѹ���)
	 * @return 
	 */
	public static void wordSelectByWordNo(int userNo) {
		try {
			List<Word> list = service.wordSelectByWordNo(userNo);
			EndView.printWordList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void resetTestNote(int userNo) {
		try {
			service.wordResetByUserNo(userNo);
			GUIMainView.appendConsoleField("���� ��Ʈ�� �ʱ�ȭ �Ͽ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}

}
