package service;

import java.sql.SQLException;
import java.util.List;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;
import exception.DuplicatedException;
import exception.NotFoundException;
import session.Session;
import session.SessionSet;

public class MemberService {
	static MemberDAO mdao = new MemberDAOImpl();

	public Member login(String userId, String password) throws SQLException, NotFoundException {
		Member member = mdao.login(userId, password);
		if (member == null) {
			throw new NotFoundException("��ġ�ϴ� ȸ�� ������ �����ϴ�.");
		}

		SessionSet sessionSet = SessionSet.getInstance();
		Session session = new Session(userId);
		sessionSet.add(session);

		return member;

	}

	public static boolean register(String userId, String password, String nickName)
			throws SQLException, DuplicatedException {
		try {
			mdao.register(userId, password, nickName);
			SessionSet sessionSet = SessionSet.getInstance();
			Session session = new Session(userId);
			sessionSet.add(session);
		} catch (SQLException e) {
			throw new SQLException ("�̹� �����ϴ� ���̵��Դϴ�.");
		}
		return true;
	}

	/**
	 * ȸ�� ����
	 */
	public int update(Member member) throws SQLException {
		int result = mdao.update(member);
		if (result == 0) {
			throw new SQLException("ȸ���� �������� ���߽��ϴ�");
		}
		return result;
	}

	/**
	 * ȸ�� ����
	 */
	public int delete(Member member) throws SQLException {
		int result = mdao.delete(member);
		if (result == 0) {
			throw new SQLException("�������� �ʾҽ��ϴ�..");
		}
		return result;
	}

	public int updatePoint(int userNo, int points) throws SQLException {
		int result = mdao.updatePoint(userNo, points);
		if (result == 0) {
			throw new SQLException("POINTS�� ������Ʈ���� �ʾҽ��ϴ�.");
		}
		return result;
	}

	public List<Member> rank() throws SQLException, NotFoundException {
		List<Member> list = mdao.rank();
		if (list.size() == 0 || list == null) {
			throw new NotFoundException("ȸ�� ��ŷ�� ��ȸ�� �� �����ϴ�.");
		}

		return list;
	}

	public int insertTest(int userNo, Object o, String wordLevel, int corNum, int wrongNum, String wordNo)
			throws SQLException {
		int result = mdao.insertTest(userNo, o, wordLevel, corNum, wrongNum, wordNo);
		if (result == 0) {
			throw new SQLException("�����Ʈ�� ������Ʈ���� �ʾҽ��ϴ�.");
		}
		return result;

	}

}
