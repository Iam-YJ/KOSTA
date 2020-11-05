package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dto.Melon;
import model.dto.Noti;
import util.DbUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public int insertRes(Melon melon) throws SQLException {

		return 0;
	}

	@Override
	public int deleteRes(int resNo) throws SQLException {

		return 0;
	}

	@Override
	public int updateRes(Melon melon) throws SQLException {

		return 0;
	}

	@Override
	public void manageUserGrade(String userId, String grade) throws SQLException {
		//유저에서 유저 상태 가져오는 기능 사용 후 
		//유저 상태 변경하기

	}

	@Override
	public int insertNotice(Noti notice) throws SQLException {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into NOTICE " + "values(NOTI_NO_SEQ.nextval,?,?,sysdate,?,?)");
			// 공지사항no 유저no 공지사항제목 공지사항작성날짜 공지사항내용 공지사항조회수
			ps.setInt(1, notice.getUserNo());
			ps.setString(2, notice.getNotiTitle());
			ps.setString(3, notice.getNotiContent());
			ps.setInt(4, notice.getNotiHits());

			result = ps.executeUpdate();

			// 연결 실행
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int updateNotice(Noti notice) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update NOTICE set " + "NOTI_TITLE=?, NOTI_CONTENT=?");
			// 공지사항no 유저no 공지사항제목 공지사항작성날짜 공지사항내용 공지사항조회수
			ps.setString(1, notice.getNotiTitle());
			ps.setString(2, notice.getNotiContent());

			result = ps.executeUpdate();

			// 연결 실행
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int deleteNotice(int notiNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("delete from NOTICE where NOTI_NO = ?");
			// 공지사항no 유저no 공지사항제목 공지사항작성날짜 공지사항내용 공지사항조회수
			ps.setInt(1, notiNo);

			result = ps.executeUpdate();

			// 연결 실행
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	
	@Override
	public int banUser(String userId) throws SQLException {
		//유저에서 사용자 불러오는 기능 사용해서 찾은 후 
		// 그 유저의 상태 변경
		return 0;
	}

}
