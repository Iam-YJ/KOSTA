package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import model.dto.Melon;
import model.dto.Noti;
import model.dto.User;

public class UserDAOImpl implements UserDAO{

	@Override
	public int join(User user) {

		return 0;
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
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	/**
	 * 찜하기 조회 
	 */
	@Override
	public List<Melon> selectBookMark(int userNo) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Melon> list = new ArrayList<Melon>();
		String sql = "SELECT * FROM RESTAURANT WHERE RES_NO IN (SELECT RES_NO FROM BOOKMARK WHERE USER_NO = ?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				int resNo = rs.getInt(1);
				String resName = rs.getString(2);
				String resPlace = rs.getString(3);
				String resTel = rs.getString(4);
				String resType = rs.getString(5);
				String resPhoto = rs.getString(6);
				int resHits = rs.getInt(7);
				int resGrade = rs.getInt(8);
				String resPrice = rs.getString(9);
				
				Melon melon = new Melon(resNo, resName, resPlace, resTel, resType, resPhoto, resHits, resGrade, resPrice);
				
				list.add(melon);
			}
		}finally {
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	/**
	 * 친구 추가 - 친구의 리뷰, 찜 목록 봐야하고 
	 */
	@Override
	public int insertFriends(int userNo, int friendNo) {
		/*Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO BOOKMARK VALUES(BOOKMARK_NO_SEQ.NEXTVAL, ?, ?)";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			ps.setInt(2, resNo);
			
			result = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;*/
		return 0;
	}

	/**
	 * 친구 삭제 
	 */
	@Override
	public int deleteFriends(String frId) {

		return 0;
	}

	/*
	 * 회원정보 수정
	 * */
	@Override
	public int updateUserInfo(User user) throws SQLException {
	Connection con = DbUtil.getConnection();
	PreparedStatement ps =null;
	int result= 0;
	String sql = "UPDATE USERLIST SET USER_NICKNAME=?, USER_EMAIL=?, USER_PREFER=? WHERE USER_NO=?";
	
	try {
		con=DbUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1,user.getNickname());
		ps.setString(2,user.getEmail());
		ps.setString(3,user.getPrefer());
		ps.setInt(4, user.getUserNo());
		
		result = ps.executeUpdate();//실행
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		//닫기
		DbUtil.dbClose(ps, con);
	}
			
			return result;
	}
	

	/**
	 *  유저입장 공지사항 조회
	 * */
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
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return list;
	}

}
