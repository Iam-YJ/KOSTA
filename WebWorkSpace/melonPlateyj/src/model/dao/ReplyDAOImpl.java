package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Melon;
import model.dto.Reply;
import model.dto.User;
import model.service.UserService;
import util.DbUtil;

public class ReplyDAOImpl implements ReplyDAO {
	
	UserDAOImpl userDao = new UserDAOImpl();
	
	/*
	 * 리뷰 작성 -식당별
	 */
	@Override
	public int insertReply(Reply reply) throws SQLException {
		System.out.println("dao");
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO REVIEW VALUES(REVIEW_NO_SEQ.NEXTVAL,?,?,0,?,?,?,SYSDATE,0)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, reply.getResNo());
			ps.setInt(2, reply.getUserNo());
			ps.setInt(3, reply.getRepGrade());
			ps.setString(4, reply.getRepPhoto());
			ps.setString(5, reply.getRepContent());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}//finally

		return result;
	}//insertReply

	
	/*
	 * 리뷰 삭제 -식당별
	 */
	@Override
	public int deleteReply(int resNo, int userNo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from review where res_no = ? and user_no = ?";
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			ps.setInt(2, userNo);

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(ps, con);
		}//finally
		return result;
	}//deleteReply
	

	/*
	 * 리뷰 수정 -식당별
	 */
	@Override
	public int updateReply(Reply reply) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE REVIEW SET REVIEW_GRADE=?, REVIEW_PHOTO=?,REVIEW_CONTENT=? where res_no = ? and user_no = ?";
		try {
			con = DbUtil.getConnection();

			ps = con.prepareStatement(sql);
	
			ps.setInt(1, reply.getRepGrade());
			ps.setString(2, reply.getRepPhoto());
			ps.setString(3, reply.getRepContent());
			ps.setInt(4, reply.getResNo());
			ps.setInt(5, reply.getUserNo());

			result = ps.executeUpdate();// 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}//finally
		return result;
	}//updateReply
	
	

	/*
	 * 리뷰 전체 보기 - 식당별
	 */
	@Override
	public List<Reply> selectReplyByResNo(int resNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<Reply>();
		String sql = "SELECT * FROM REVIEW WHERE RES_NO = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt(1);
				resNo = rs.getInt(2);
				int userNo = rs.getInt(3);
				int repHits = rs.getInt(4);
				int repGrade = rs.getInt(5);
				String repPhoto = rs.getString(6);
				String repContent = rs.getString(7);
				String repDate = rs.getString(8);
				int repAgree = rs.getInt(9);
				
				Melon melon = selectByResNo(resNo);
				User user = userDao.selectUserInfo(userNo);
				
				Reply reply= new Reply(reviewNo, resNo, melon.getResName(), userNo, user.getNickname(), repHits, repGrade, repPhoto, repContent, repDate, repAgree);
			
				list.add(reply);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return list;
	}//selectReplyByResNo
	
	/**
	 * 리뷰 전체 보기 - 마이페이지 
	 */
	@Override
	public List<Reply> selectReplyByUserNo(int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<Reply>();
		String sql = "SELECT * FROM REVIEW WHERE USER_NO = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt(1);
				int resNo = rs.getInt(2);
				userNo = rs.getInt(3);
				int repHits = rs.getInt(4);
				int repGrade = rs.getInt(5);
				String repPhoto = rs.getString(6);
				String repContent = rs.getString(7);
				String repDate = rs.getString(8);
				int repAgree = rs.getInt(9);
				
				Melon melon = selectByResNo(resNo);
				System.out.println("melon: " + melon);
				User user = userDao.selectUserInfo(userNo);
				System.out.println("user: " + user);
				
				Reply reply= new Reply(reviewNo, resNo, melon.getResName(), userNo, user.getNickname(), repHits, repGrade, repPhoto, repContent, repDate, repAgree);
			
				list.add(reply);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return list;
	}//selectReplyByUserNo

	/*
	 * 공감수 증가
	 */
	@Override
	public int incrementLike(int reviewNo) throws SQLException{
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE REVIEW SET REVIEW_AGREE = REVIEW_AGREE + 1 WHERE REVIEW_NO = ?";
		try {
			con = DbUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);

			result = ps.executeUpdate();// 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}//finally
		return result;
	}//incrementLike


	/**
	 * 식당번호로 식당 검색
	 */
	@Override
	public Melon selectByResNo(int resNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Melon melon = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RES_NO = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				resNo = rs.getInt(1);
				String resName = rs.getString(2);
				String resPlace = rs.getString(3);
				String resTel = rs.getString(4);
				String resType = rs.getString(5);
				String resPhoto = rs.getString(6);
				int resHits = rs.getInt(7);
				int resGrade = rs.getInt(8);
				String resPrice = rs.getString(9);
				
				melon = new Melon(resName, resPlace, resTel, resType, resPhoto, resPrice);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return melon;
	}

	/**
	 * 식당번호, 유저번호로 리뷰 검색
	 */
	@Override
	public Reply selectReplyByResNoAndUserNo(int resNo, int userNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reply reply = null;
		String sql = "SELECT * FROM REVIEW WHERE RES_NO = ? AND USER_NO = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			ps.setInt(2, userNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reviewNo = rs.getInt(1);
				resNo = rs.getInt(2);
				userNo = rs.getInt(3);
				int repHits = rs.getInt(4);
				int repGrade = rs.getInt(5);
				String repPhoto = rs.getString(6);
				String repContent = rs.getString(7);
				String repDate = rs.getString(8);
				int repAgree = rs.getInt(9);
								
				Melon melon = selectByResNo(resNo);
				User user = userDao.selectUserInfo(userNo);
				
				reply= new Reply(reviewNo, resNo, melon.getResName(), userNo, user.getNickname(), repHits, repGrade, repPhoto, repContent, repDate, repAgree);
			
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return reply;
	}


	@Override
	public int selectLikeByReviewNo(int reviewNo) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int repAgree = 0;
		String sql = "SELECT REVIEW_AGREE FROM REVIEW WHERE REVIEW_NO = ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				repAgree = rs.getInt(1);
			}//while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}//finally

		return repAgree;
	}

}