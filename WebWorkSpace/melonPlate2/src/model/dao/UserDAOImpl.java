package model.dao;

import java.util.List;

import model.dto.Noti;
import model.dto.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public int join(User user) {

		return 0;
	}

	@Override
	public int insertBookMark(int resNo) {

		return 0;
	}

	@Override
	public int deleteBookMark(int resNo) {

		return 0;
	}

	@Override
	public int updatePoint(String userId, int point) {

		return 0;
	}

	@Override
	public int insertFriends(String userId, String frId) {

		return 0;
	}

	@Override
	public int deleteFriends(String frId) {

		return 0;
	}

	@Override
	public int updateUserInfo(User user) {

		return 0;
	}

	@Override
	public List<Noti> selectNotice() {

		return null;
	}

}
