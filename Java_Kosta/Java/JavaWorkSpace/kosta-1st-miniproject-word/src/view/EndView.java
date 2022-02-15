package view;

import java.util.List;
import dto.Member;
import dto.Word;
import gui.GUIMainView;

public class EndView {
	/**
	 * �ܾ� ��ü ���
	 */
	public static void printWordList(List<Word> list) {
		GUIMainView.appendConsoleField("------------- �ܾ� " + list.size() + "�� -------------\n\n");
		String text = "____________________________________________________________________________________\n\n";
		int num = 0;
		for (Word word : list) {
			text = text + ++num + ".\n\n" + word.getWordEng() + "\n\""
					+ word.getWordKor() + "\"\n\n (���� : " + word.getWordLevel() + ")  (ǰ�� : " + word.getWordPart() + ")\n____________________________________________________________________________________\n\n";
		}
		GUIMainView.appendConsoleField(text);
	}

	public static void printMessage(String message) {
		GUIMainView.appendConsoleField(message);
	}

	public static void printWord(Word word) {
		System.out.println(word);
	}

	/**
	 * ��ŷ ���
	 */
	public static void printRankList(List<Member> list) {
		int rank = 1;
		GUIMainView.setConsoleField("------------- ��ϵ� �� �ο� " + list.size() + "�� -------------\n\n");
		String text = "____________________________________________________________________________________\n\n";
		for (Member member : list) {
			text = text + rank++ + ".  " + member.getNickName() + "\n(ID: "
					+ member.getUserNo() + "  /  " + member.getUserId() + ")\n\nPoints : " + member.getPoints() + "\n____________________________________________________________________________________\n\n";
		}
		GUIMainView.appendConsoleField(text);
	}
}
