package controller;

import java.sql.SQLException;
import java.util.List;

import dto.Admin;
import dto.Member;
import gui.GUIMainView;
import service.MemberService;
import view.EndView;
import view.FailView;
import view.MenuView;

public class MemberController {
	static MemberService memberService = new MemberService();

	/**
	 * �α���
	 */
	public static Member login(String userId, String password) {
		try {
			Member member = memberService.login(userId, password);

    		if (Admin.getUserNo() == member.getUserNo())
    			MenuView.printAdminMenu();
    		else
    			MenuView.printUserMenu(userId, member.getUserNo());
			
			return member;

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());

		}
		return null;
	}

	/**
	 * ȸ������
	 */
	public static boolean register(String userId, String password, String nickName) {
		try {
			MemberService.register(userId, password, nickName);
//			MenuView.printUserMenu(userId, member.getUserNo());
			return true;
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
			return false;
		}
	}

	/**
	 * ȸ�� ����
	 */
	public static void memberUpdate(Member member) {
		try {
			memberService.update(member);
			GUIMainView.appendConsoleField("____________________________________________________________________________________\n\n����� " + member.getUserNo() + ".  \"" + member.getNickName() + "\" �� ������ �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * ȸ�� ����
	 */

	public static void memberDelete(Member member) {
		try {
			memberService.delete(member);
			GUIMainView.appendConsoleField("____________________________________________________________________________________\n\n" + member.getUserNo() + " ���� ����� ���̵� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void updatePoint(int userNo, int points) {
		try {
			memberService.updatePoint(userNo, points);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void rank() {

		try {
			List<Member> list = memberService.rank();
			EndView.printRankList(list);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void insertTest(int userNo, Object o, String wordLevel, int corNum, int wrongNum, String wordNo) {
		try {
			memberService.insertTest(userNo, o, wordLevel, corNum, wrongNum, wordNo);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}




}
