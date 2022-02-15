package view;

import java.sql.SQLException;
import java.util.Random;

import controller.MemberController;
import controller.UserWordController;
import controller.WordController;
import dao.UserWordDAO;
import dao.UserWordDAOImpl;
import dao.WordDAO;
import dao.WordDAOImpl;
import dto.Member;
import dto.UserWord;
import dto.Word;
import gui.GUIMainView;
import session.SessionSet;

public class MenuView {
	public static int CurrentMenu = 0;
	public static void printUserMenu(String userId, int userNo) { // ȸ�� �޴�
		CurrentMenu = 1;
		SessionSet ss = SessionSet.getInstance();
		GUIMainView.setConsoleField("-----" + userId + " �α��� �� -----\n\n");
		GUIMainView.appendConsoleField("1. �ܾ� �˻�  |  2. �ܾ� ����  |  3. �ܾ� ���� |  4. ��ŷ/ȸ�� ���\n\n____________________________________________________________________________________\n\n5. ���� �ܾ� �߰�  |  6. ���� �ܾ� ����\n\n____________________________________________________________________________________\n\n7. ���� ��Ʈ  |  8. ���� ��Ʈ �ʱ�ȭ ");
	}

	public static void printNonUserMenu() { // ��ȸ�� �޴�
		CurrentMenu = 80;
		SessionSet ss = SessionSet.getInstance();
		GUIMainView.setConsoleField("----- Guest �α��� �� -----\n\n");
		GUIMainView.appendConsoleField(" 1. �ܾ� �˻�  |  2. �ܾ� ����  |  3. �ܾ� ����");
	}

	public static void printAdminMenu() { // ������ �޴�
		CurrentMenu = 90;
			SessionSet ss = SessionSet.getInstance();
			GUIMainView.setConsoleField("----- Administrator �α��� �� -----\n\n");
			GUIMainView.appendConsoleField("1. �ܾ� �߰�  |  2. �ܾ� ����  |  3. ȸ�� ���  |  4. ȸ�� ����  |  5. ȸ�� ����");
	}

	public static void printUpdateAdminMember() {
		GUIMainView.setConsoleField("======= ȸ�� ���� =====\n\n____________________________________________________________________________________\n\n");
		GUIMainView.appendConsoleField("���� �� ����� ȸ�� ��ȣ");
		String userStrNo = GUIMainView.getInputDialog("���� �� ȸ�� ��ȣ", "ȸ�� ��ȣ �Է�");
		while (userStrNo.length() == 0 || !userStrNo.matches("^[0-9]*$")) {
			GUIMainView.appendConsoleField("���ڸ� �Է� �����մϴ�.");
			userStrNo = GUIMainView.getInputDialog("���� �� ȸ�� ��ȣ", "ȸ�� ��ȣ �Է�");
		}
		int userNo = Integer.parseInt(userStrNo);

		GUIMainView.appendConsoleField("\n�� ��й�ȣ");
		String password = GUIMainView.getInputDialog("�� ��й�ȣ", "�� ��й�ȣ �Է�");
		while(password.length() < 4) {
			GUIMainView.appendConsoleField("��й�ȣ�� �ּ� 4�� �̻��̿��� �մϴ�.");
			password = GUIMainView.getInputDialog("�� ��й�ȣ", "�� ��й�ȣ �Է�");
		}

		GUIMainView.appendConsoleField("\n�� �г���");
		String nickName = GUIMainView.getInputDialog("�� �г���", "�� �г��� �Է�");
		while(nickName.length() < 3) {
			GUIMainView.appendConsoleField("�г����� �ּ� 3�� �̻��̿��� �մϴ�.");
			password = GUIMainView.getInputDialog("�� �г���", "�� �г��� �Է�");
		}
		
		GUIMainView.appendConsoleField("����Ʈ �� ����");
		userStrNo = GUIMainView.getInputDialog("����Ʈ �� ����", "����Ʈ �� �Է�");
		while (userStrNo.length() == 0 || !userStrNo.matches("^[0-9]*$")) {
			GUIMainView.appendConsoleField("���ڸ� �Է� �����մϴ�.");
			userStrNo = GUIMainView.getInputDialog("����Ʈ �� ����", "����Ʈ �� �Է�");
		}
		int points = Integer.parseInt(userStrNo);
		
		Member member = new Member(userNo, null, password, nickName, points);
		MemberController.memberUpdate(member);
	}

	public static void printDeleteAdminMember() {
		GUIMainView.setConsoleField("======= ȸ�� ���� =====\n\n____________________________________________________________________________________\n\n");
		GUIMainView.appendConsoleField("���� �� ȸ�� ��ȣ");
		String userStrNo = GUIMainView.getInputDialog("���� �� ȸ�� ��ȣ", "ȸ�� ��ȣ �Է�");
		while (userStrNo.length() == 0 || !userStrNo.matches("^[0-9]*$")) {
			GUIMainView.appendConsoleField("���ڸ� �Է� �����մϴ�.");
			userStrNo = GUIMainView.getInputDialog("���� �� ȸ�� ��ȣ", "ȸ�� ��ȣ �Է�");
		}
		int userNo = Integer.parseInt(userStrNo);
		
		Member member = new Member(userNo);
		MemberController.memberDelete(member);

	}

	/**
	 * ������ �ܾ� �߰�
	 */
	public static void printInputAdminWord() {
		GUIMainView.setConsoleField("======= �ܾ� �߰� =====\n\n____________________________________________________________________________________\n\n");
		GUIMainView.appendConsoleField("�ܾ� ����");
		String wordLev = GUIMainView.getInputDialog("�߰��� �ܾ� ����", "L    (Low)\nM  (Medium)\nH   (High)");
		while (wordLev.length() != 1 || !"LMH".contains(wordLev.toUpperCase())) {
			GUIMainView.appendConsoleField("L  M  H �߿� �Է��ϼ���.");
			wordLev = GUIMainView.getInputDialog("�߰��� �ܾ� ����", "L    (Low)\nM  (Medium)\nH   (High)");
		}

		GUIMainView.appendConsoleField("\n���ܾ�");
		String wordEng = GUIMainView.getInputDialog("�߰��� ���ܾ�", "���ܾ� �Է�");
		while(wordEng.length() == 0 || !wordEng.matches("^[a-zA-Z]*$")) {
			GUIMainView.appendConsoleField("���ĺ��� �Է� �����մϴ�.");
			wordEng = GUIMainView.getInputDialog("�߰��� ���ܾ�", "���ܾ� �Է�");
		}

		GUIMainView.appendConsoleField("\n�ѱ� ��");
		String wordKor = GUIMainView.getInputDialog("�߰��� �ѱ� ��", "�ѱ� �� �Է�");
		while (wordKor.length() == 0 || wordKor.matches("^[a-zA-Z0-9]*$")) {
			GUIMainView.appendConsoleField("������ ���ڴ� �Է��� �� �����ϴ�");
			wordKor = GUIMainView.getInputDialog("�߰��� �ѱ� ��", "�ѱ� �� �Է�");
		}

		GUIMainView.appendConsoleField("\nǰ��");
		String wordPart = GUIMainView.getInputDialog("ǰ��", "ǰ�� �Է�");
		while (wordPart.length() == 0 || !wordPart.matches("^[a-z]*$")) {
			GUIMainView.appendConsoleField("���� �ҹ��ڸ� �Է� �����մϴ�");
			wordPart = GUIMainView.getInputDialog("ǰ��", "ǰ�� �Է�");
		}

		Word word = new Word(wordLev, wordEng, wordKor, wordPart);
		WordController.wordInsert(word);
	}
	

	/**
	 * ������ �ܾ� ����
	 */

	public static void printDeleteAdminWord() {
		GUIMainView.setConsoleField("======= �ܾ� ���� =====\n\n____________________________________________________________________________________\n\n");
		GUIMainView.appendConsoleField("���ܾ�");
		String wordEng = GUIMainView.getInputDialog("������ ���ܾ�", "���ܾ� �Է�");
		while(wordEng.length() == 0 || !wordEng.matches("^[a-zA-Z]*$")) {
			GUIMainView.appendConsoleField("���ĺ��� �Է� �����մϴ�.");
			wordEng = GUIMainView.getInputDialog("������ ���ܾ�", "���ܾ� �Է�");
		}

		Word word = new Word(wordEng);
		WordController.wordDelete(word);
	}

	/**
	 * ��ü �ܾ� �˻� �޴� (��ü ��ȸ / �ܾ�� ã�� / ���ĺ����� ã��)
	 */
	public static void printAllWord() {
		GUIMainView.setConsoleField("� ������� �ܾ �˻��ұ��? ");
		GUIMainView.appendConsoleField("1. ��ü �˻�  |  2. �ܾ� �˻�  |  3. ���ĺ� �˻�  |  4. �ѱ� �˻�  |  5. ���� �ܾ� �˻�");
	}

	/**
	 * ��ü �ܾ� �˻� �޴� (��ü ��ȸ / �ܾ�� ã�� / ���ĺ����� ã��) - Guest
	 */
	public static void printAllWordGuest() {
		GUIMainView.setConsoleField("� ������� �ܾ �˻��ұ��? ");
		GUIMainView.appendConsoleField("1. ��ü �˻�  |  2. �ܾ� �˻�  |  3. ���ĺ� �˻�  |  4. �ѱ� �˻�");
	}

	/**
	 * �ܾ� ����
	 */
	public static void wordTest(int userNo) {
		WordDAO wd = new WordDAOImpl();
		UserWordDAO uwd = new UserWordDAOImpl();
		GUIMainView.setConsoleField("======= �ܾ� ������ �����մϴ� =====\n\n____________________________________________________________________________________\n\n");
		try {
			if (userNo != 0) {
				GUIMainView.userWordTest(uwd.selectMemberWord(userNo));
			}
			GUIMainView.wordTest(wd.wordSelect(), userNo);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return;
	}

	/**
	 * �ܾ� ����
	 */
	public static void wordGame(int userNo) {
		WordDAO wd = new WordDAOImpl();
		UserWordDAO uwd = new UserWordDAOImpl();
		GUIMainView.setConsoleField("======= �ܾ� ������ �����մϴ� =====\n\n____________________________________________________________________________________\n\n");
		try {
			int life = 5;
			int userWordCount = 0;
			if (userNo != 0) {
				userWordCount = uwd.selectMemberWord(userNo).size();
			}
			Random rand = new Random();
			while (life > 0){
				if (userNo != 0 && userWordCount > 0 && rand.nextInt(3) == 0) {
					life = GUIMainView.userWordGame(uwd.selectMemberWord(userNo));
					userWordCount--;
				}
				else life = GUIMainView.wordGame(wd.wordSelect(), userNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return;
	}

	/**
	 * �ܾ��߰�
	 */
	public static void printInputWord(int userNo) {
		GUIMainView.setConsoleField("======= ���� �ܾ� �߰� =====\n\n____________________________________________________________________________________\n\n");
		GUIMainView.appendConsoleField("�ܾ� ����");
		String wordLev = GUIMainView.getInputDialog("�߰��� �ܾ� ����", "L    (Low)\nM  (Medium)\nH   (High)");
		while (wordLev.length() != 1 || !"LMH".contains(wordLev.toUpperCase())) {
			GUIMainView.appendConsoleField("L  M  H �߿� �Է��ϼ���.");
			wordLev = GUIMainView.getInputDialog("�߰��� �ܾ� ����", "L    (Low)\nM  (Medium)\nH   (High)");
		}

		GUIMainView.appendConsoleField("\n���ܾ�");
		String wordEng = GUIMainView.getInputDialog("�߰��� ���ܾ�", "���ܾ� �Է�");
		while(wordEng.length() == 0 || !wordEng.matches("^[a-zA-Z]*$")) {
			GUIMainView.appendConsoleField("���ĺ��� �Է� �����մϴ�.");
			wordEng = GUIMainView.getInputDialog("�߰��� ���ܾ�", "���ܾ� �Է�");
		}

		GUIMainView.appendConsoleField("\n�ѱ� ��");
		String wordKor = GUIMainView.getInputDialog("�߰��� �ѱ� ��", "�ѱ� �� �Է�");
		while (wordKor.length() == 0 || wordKor.matches("^[a-zA-Z0-9]*$")) {
			GUIMainView.appendConsoleField("������ ���ڴ� �Է��� �� �����ϴ�");
			wordKor = GUIMainView.getInputDialog("�߰��� �ѱ� ��", "�ѱ� �� �Է�");
		}

		GUIMainView.appendConsoleField("\nǰ��");
		String wordPart = GUIMainView.getInputDialog("ǰ��", "ǰ�� �Է�");
		while (wordPart.length() == 0 || !wordPart.matches("^[a-z]*$")) {
			GUIMainView.appendConsoleField("���� �ҹ��ڸ� �Է� �����մϴ�");
			wordPart = GUIMainView.getInputDialog("ǰ��", "ǰ�� �Է�");
		}

		UserWord memberWord = new UserWord(userNo, wordLev, wordEng, wordKor, wordPart);
		UserWordController.wordInsert(memberWord);
	}

	/**
	 * �ܾ����
	 */
	public static void printDeleteWord(int userNo) {
		GUIMainView.setConsoleField("======= ���� �ܾ� ���� =====\n\n____________________________________________________________________________________\n\n");
		GUIMainView.appendConsoleField("���ܾ�");
		String wordEng = GUIMainView.getInputDialog("������ ���ܾ�", "���ܾ� �Է�");
		while(wordEng.length() == 0 || !wordEng.matches("^[a-zA-Z]*$")) {
			GUIMainView.appendConsoleField("���ĺ��� �Է� �����մϴ�.");
			wordEng = GUIMainView.getInputDialog("������ ���ܾ�", "���ܾ� �Է�");
		}

		UserWord userWord = new UserWord(userNo, wordEng);
		UserWordController.wordDelete(userWord);
	}

}
