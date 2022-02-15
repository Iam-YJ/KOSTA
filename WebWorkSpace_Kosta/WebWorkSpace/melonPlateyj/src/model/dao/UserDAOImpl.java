package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Melon;
import model.dto.Noti;
import model.dto.User;
import util.DbUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public int joinKakao(int userNo, String userNick, String userAge, String userEmail, String userGender) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO userlist(USER_NO,USER_NICKNAME,USER_AGE,USER_EMAIL,USER_GENDER) VALUES(?,?,?,?,?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setString(2, userNick);
			ps.setString(3, userAge);
			ps.setString(4, userEmail);
			ps.setString(5, userGender);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	/**
	 * 찜하기 추가
	 */
	@Override
	public int insertBookMark(int userNo, int resNo) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO BOOKMARK VALUES(BOOKMARK_NO_SEQ.NEXTVAL, ?, ?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, resNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	/**
	 * 찜하기 삭제
	 */
	@Override
	public int deleteBookMark(int userNo, int resNo) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM BOOKMARK WHERE USER_NO = ? AND RES_NO = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, resNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	/**
	 * 찜하기 조회
	 */
	@Override
	public List<Melon> selectBookMark(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Melon> list = new ArrayList<Melon>();
		String sql = "SELECT * FROM RESTAURANT WHERE RES_NO IN (SELECT RES_NO FROM BOOKMARK WHERE USER_NO = ?)";

		try {
			con = DbUtil.getConnection();
			System.out.println("sql: " + sql);
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int resNo = rs.getInt(1);
				System.out.println("resNo: " + resNo);
				String resName = rs.getString(2);
				String resPlace = rs.getString(3);
				String resTel = rs.getString(4);
				String resType = rs.getString(5);
				String resPhoto = rs.getString(6);
				int resHits = rs.getInt(7);
				int resGrade = rs.getInt(8);
				String resPrice = rs.getString(9);
				
				Melon melon = new Melon(resNo, resName, resPlace, resTel, resType, resPhoto, resHits, resGrade, resPrice);
				System.out.println("melon: " + melon);

				list.add(melon);
				System.out.println("list: " + list);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	/**
	 * 포인트 증가
	 */
	@Override
	public int updatePoint(int userNo, int point) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE USERLIST SET USER_POINT = ? WHERE USER_NO = ?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, point);
			ps.setInt(2, userNo);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	/**
	 * 친구 추가 - 친구의 리뷰, 찜 목록 봐야하고
	 */
	@Override
	public int insertFriends(int userNo, int friendNo) {
		/*
		 * Connection con = null; PreparedStatement ps = null; int result = 0; String
		 * sql = "INSERT INTO BOOKMARK VALUES(BOOKMARK_NO_SEQ.NEXTVAL, ?, ?)";
		 * 
		 * try { con = DbUtil.getConnection(); ps = con.prepareStatement(sql);
		 * ps.setInt(1, userNo); ps.setInt(2, resNo);
		 * 
		 * result = ps.executeUpdate();
		 * 
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }finally { DbUtil.dbClose(ps,
		 * con); }
		 * 
		 * return result;
		 */
		return 0;
	}


	/**
	 * 친구 삭제
	 */
	@Override
	public int deleteFriends(String frId) {

		return 0;
	}
	
	/**
	 *  회원정보 조회
	 * */
	@Override
	public User selectUserInfo(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "SELECT * FROM USERLIST WHERE USER_NO = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int userno = rs.getInt(1);
				String nickname = rs.getString(2);
				String age = rs.getString(3);
				String email = rs.getString(4);
				String gender = rs.getString(5);
				String grade = rs.getString(6);
				int point = rs.getInt(7);
				String prefer = rs.getString(8);
				int attend = rs.getInt(9);
				int usage = rs.getInt(10);
				
				user =new User(userno, nickname, age, email, gender, grade, point, prefer, attend, usage);
				
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return user;
	}

	/*
	 * 회원정보 수정
	 */
	@Override
	public int updateUserInfo(User user) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE USERLIST SET USER_NICKNAME=?, USER_EMAIL=?, USER_PREFER=? WHERE USER_NO=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getNickname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPrefer());
			ps.setInt(4, user.getUserNo());

			result = ps.executeUpdate();// 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	/**
	 * 유저입장 공지사항 조회
	 */
	@Override
	public List<Noti> selectNotice() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Noti> list = new ArrayList<Noti>();
		String sql = "SELECT NOTI_NO, USER_NO, NOTI_TITLE, NOTI_DATE, NOTI_CONTENT, NOTI_HITS FROM NOTICE";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int notiNo = rs.getInt(1);
				int userNo = rs.getInt(2);
				String notiTitle = rs.getString(3);
				String notiDate = rs.getString(4);
				String notiContent = rs.getString(5);
				int notiHits = rs.getInt(6);

				Noti noti = new Noti(notiNo, userNo, notiTitle, notiDate, notiContent, notiHits);

				list.add(noti);
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		} // finally

		return list;
	}

	/**
	 * 공지사항 상세보기
	 */
	@Override
	public Noti selectNotiByNotiNo(int notiNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Noti noti = null;
		String sql = "SELECT NOTI_NO, USER_NO, NOTI_TITLE, NOTI_DATE, NOTI_CONTENT, NOTI_HITS FROM NOTICE WHERE NOTI_NO = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, notiNo);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				notiNo = rs.getInt(1);
				int userNo = rs.getInt(2);
				String notiTitle = rs.getString(3);
				String notiDate = rs.getString(4);
				String notiContent = rs.getString(5);
				int notiHits = rs.getInt(6);
				
			   noti = new Noti(notiNo, userNo, notiTitle, notiDate, notiContent, notiHits);

			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return noti;
		
	}
	
	
	@Override
	public int interestInsert(String[] iList) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String str = "";
		String sql = "UPDATE USERLIST SET USER_PREFER=? where user_no = 1521454294";

		for (String s : iList) {
			str += s;
			str += ",";
		}

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, str);
			// ps.setInt(2, 1521454294);

			result = ps.executeUpdate();// 실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		} // finally

		return result;
	}

}
