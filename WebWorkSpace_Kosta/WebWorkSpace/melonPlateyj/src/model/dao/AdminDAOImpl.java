package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;

import model.dto.Melon;
import model.dto.Noti;
import util.DbUtil;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public int insertRes(Melon melon) throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into restaurant values(RES_NO_SEQ.nextval,?,?,?,?,?,0,0,?)");
			ps.setString(1, melon.getResName());
			ps.setString(2, melon.getResPlace());
			ps.setString(3, melon.getResTel());
			ps.setString(4, melon.getResType());
			ps.setString(5, melon.getResPhoto());
			ps.setString(6, melon.getResPrice());


			result = ps.executeUpdate();
		} finally {

			DbUtil.dbClose(ps, con);
		}

		return result;

	}


	@Override
	public int deleteRes(int resNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("delete from restaurant where RES_NO =?");

			ps.setInt(1, resNo);

			result = ps.executeUpdate();

		} finally {

			DbUtil.dbClose(ps, con);

		}
		return result;
	}

	@Override
	public int updateRes(Melon melon) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {

			con = DbUtil.getConnection();
			ps = con.prepareStatement(
					"update restaurant set RES_NAME=?, RES_PLACE=?, RES_TEL=?, RES_TYPE=?, RES_PHOTO=?, RES_GRADE=?, RES_PRICE=? where RES_NUM=?");

			ps.setString(1, melon.getResName());
			ps.setString(2, melon.getResPlace());
			ps.setString(3, melon.getResTel());
			ps.setString(4, melon.getResType());
			ps.setString(5, melon.getResPhoto());
			ps.setDouble(6, melon.getResGrade());
			ps.setString(7, melon.getResPrice());
			ps.setInt(8, melon.getResNo());

			result = ps.executeUpdate();
		} finally {

			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public void manageUserGrade(String userId, String grade) throws SQLException {
		// 유저에서 유저 상태 가져오는 기능 사용 후
		// 유저 상태 변경하기

	}

	@Override
	   public int insertNotice(String title, String content) throws SQLException {
	      // 로드 연결 실행 닫기
	      Connection con = null;
	      PreparedStatement ps = null;
	      int result = 0;

	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement("insert into NOTICE values(NOTI_NO_SEQ.nextval,2,?,sysdate,?,0)");
	         // 공지사항no 유저no 공지사항제목 공지사항작성날짜 공지사항내용 공지사항조회수
	         
	         ps.setString(1, title);
	         ps.setString(2, content);
	         
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
	         ps = con.prepareStatement("update NOTICE set NOTI_TITLE=?, NOTI_CONTENT=? WHERE NOTI_NO=?");
	         // 공지사항no 유저no 공지사항제목 공지사항작성날짜 공지사항내용 공지사항조회수
	         ps.setString(1, notice.getNotiTitle());
	         ps.setString(2, notice.getNotiContent());
	         ps.setInt(3, notice.getNotiNo());

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
	      // 유저에서 사용자 불러오는 기능 사용해서 찾은 후
	      // 그 유저의 상태 변경
	      return 0;
	   }

	   @Override
	   public List<Noti> selectNoti() throws SQLException {
	      List<Noti> list = new ArrayList<Noti>();
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      String sql = "SELECT * FROM NOTICE";

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
	         }

	      } finally {
	         DbUtil.dbClose(rs, ps, con);
	      }
	      return list;
	   }

	   @Override
	   public Noti selectByNoti(int notiNo) throws SQLException {
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      Noti noti = null;
	      String sql = "SELECT * FROM NOTICE WHERE NOTI_NO=?";
	      
	      try {
	         
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, notiNo);
	         rs = ps.executeQuery();
	         
	         if(rs.next()) {
	            noti = new Noti(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
	         }
	         
	      } finally {
	         DbUtil.dbClose(rs, ps, con);
	      }
	        return noti;
	   }
	   
	   @Override
	   public int increamentByHits(int notiNo) throws SQLException {
	      Connection con = null;
	      PreparedStatement ps = null;
	      int result = 0;
	      String sql = "update notice set noti_hits = noti_hits+1 where noti_no=?";

	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         ps.setInt(1, notiNo);

	         result = ps.executeUpdate();

	      } finally {
	         DbUtil.dbClose(ps, con);

	      }
	      return result;
	   }
}