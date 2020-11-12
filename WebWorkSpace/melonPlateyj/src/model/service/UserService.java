package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.UserDAO;
import model.dao.UserDAOImpl;
import model.dto.Melon;
import model.dto.Noti;
import model.dto.User;

public class UserService {

	UserDAO dao = new UserDAOImpl();

	/**
	 * 가입하기
	 */

	public int joinKakao(int userNo, String userNick, String userAge, String userEmail, String userGender) {
		int result = dao.joinKakao(userNo, userNick, userAge, userEmail, userGender);
		return result;

	}

	/**
	 * 찜하기 추가
	 */
	public int insertBookMark(int userNo, int resNo) {

		int result = dao.insertBookMark(userNo, resNo);
		return result;
	}

	/**
	 * 찜하기 삭제
	 */
	public int deleteBookMark(int userNo, int resNo) {

		int result = dao.deleteBookMark(userNo, resNo);
		return result;
	}

	/**
	 * 찜하기 조회
	 */
	public List<Melon> selectBookMark(int userNo) throws SQLException {
		List<Melon> list = dao.selectBookMark(userNo);
		return list;
	}

	/**
	 * 포인트 증가
	 */
	public int updatePoint(int userNo, int point) {

		int result = dao.updatePoint(userNo, point);
		return result;
	}

	/**
	 * 개인정보 조회하기
	 * */
	public User selectUserInfo(int userNo) throws SQLException{
		User user = dao.selectUserInfo(userNo);
		if (user == null)
			throw new SQLException("검색결과 없습니다.");
		return user;
	}
	
	
	/**
	 * 회원정보 수정
	 */
	public int updateUserInfo(User user) throws SQLException {

		int result = dao.updateUserInfo(user);
		if (result == 0)
			throw new SQLException("수정되지 않았습니다.");
		return result;
	}

	/**
	 * 공지사항 조회
	 */

	public List<Noti> selectNotice() throws SQLException {
		List<Noti> list = dao.selectNotice();
		if (list.size() == 0)
			throw new SQLException("검색결과 없습니다.");
		return list;
	}

	public Noti selectNotiByNotiNo(int notiNo) throws SQLException {
		Noti noti = dao.selectNotiByNotiNo(notiNo);
		if(noti == null) throw new SQLException("내용없음");
		return noti;

	}

	public int interestInsert(String[] iList) throws SQLException{
		int result = dao.interestInsert(iList);
		if (result == 0)
			throw new SQLException("관심분야가 선택되지 않았습니다.");
		return result;
	}

}
