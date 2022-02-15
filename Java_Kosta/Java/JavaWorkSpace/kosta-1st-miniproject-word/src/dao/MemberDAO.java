package dao;

import java.sql.SQLException;
import java.util.List;

import dto.Member;

public interface MemberDAO {

	/**
	 * �α����ϱ�
	 */
	Member login(String userId, String password) throws SQLException;

	/**
	 * ȸ�������ϱ�
	 */
	void register(String userId, String password, String nickName) throws SQLException;

	/**
	 * ������ - ȸ�� ����
	 */
	int update(Member member) throws SQLException;

	/**
	 * ������ - ȸ�� ����
	 */
	int delete(Member member) throws SQLException;

	/**
	 * ����Ʈ �߰�
	 */
	int updatePoint(int userNo, int points) throws SQLException;

	/**
	 * ��ŷ
	 */
	List<Member> rank() throws SQLException;

	int insertTest(int userNo, Object o, String wordLevel, int corNum, int wrongNum, String wordNo) throws SQLException;

}
