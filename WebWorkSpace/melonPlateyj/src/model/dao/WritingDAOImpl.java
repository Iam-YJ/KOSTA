package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dto.Melon;
import model.dto.WriList;
import model.dto.Writing;
import util.DbUtil;

public class WritingDAOImpl implements WritingDAO{
	
	@Override
	public List<Melon> selectByName(String resName) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Melon> list = new ArrayList<Melon>();
		String sql = "SELECT * FROM RESTAURANT WHERE RES_NAME = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, resName);
			rs = ps.executeQuery();
			while(rs.next()) {
				int resNo = rs.getInt(1);
				resName = rs.getString(2);
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
	 * 글쓰기 
	 * 1) 글 테이블 추가
	 * 2) 글 상세 테이블 추가 
	 */
	@Override
	public int insertWriting(Writing writing) throws SQLException {
		System.out.println("WritingDaoImpl의 insertWriting() 메소드");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "INSERT INTO WRITING VALUES(WRI_NO_SEQ.NEXTVAL, ?, SYSDATE, ?)";
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, writing.getWriTitle());
			ps.setInt(2, writing.getUserNo());
			
			result = ps.executeUpdate();
			System.out.println("result: " + result);
			if(result==0) {
				con.rollback();
				throw new SQLException("글 등록 실패");
			} else {
				int re[] = insertWriList(con, writing); //글 상세 등록 
				for(int i : re) {
					if(i != Statement.SUCCESS_NO_INFO) {
						con.rollback();
						throw new SQLException("등록할 수 없음");
					}
				}
			}
			System.out.println("con : " + con);
			con.commit();
			
		}finally {
			
			DbUtil.dbClose(ps, con);
		}
		System.out.println("result -> " + result);
		return result;
	}
	
	/**
	 * 글 상세 추가 
	 */
	public int[] insertWriList(Connection con, Writing writing) {
		System.out.println("WritingDaoImpl의 insertWriList() 메소드");
		PreparedStatement ps = null;
		int result[] = null;
		String sql = "INSERT INTO WRILIST VALUES(WRILIST_NO_SEQ.NEXTVAL, WRI_NO_SEQ.CURRVAL, ?, ?)";
		System.out.println("con: " + con);
		
		try {
			ps = con.prepareStatement(sql);
			System.out.println("ps: " + ps);
			for(WriList wriList : writing.getWriList()) {
				//ps.setInt(1, writing.getWriNo()); //글번호 
				ps.setInt(1, wriList.getResNo()); //식당번호 
				ps.setString(2, wriList.getWriContent()); //내용 
				ps.addBatch();
				ps.clearParameters();
			}
						
			result = ps.executeBatch();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	
	/**
	 * 글 삭제 
	 */
	@Override
	public int deleteWriting(int wriNo) {
		System.out.println("WritingDao의 delete메소드");
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "DELETE FROM WRITING WHERE WRI_NO = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			System.out.println(ps+"성공");
			ps.setInt(1, wriNo);
			result = ps.executeUpdate();
			System.out.println(result);
			if(result > 0) {
				con.commit();
			}
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("catch");
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	

	/**
	 * 글 수정
	 */
	@Override
	public int updateWriting(Writing writing) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "UPDATE WRITING SET WRI_TITLE = ? WHERE WRI_NO = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, writing.getWriTitle());
			ps.setInt(2, writing.getWriNo());
			
			result = ps.executeUpdate();
			if(result==0) {
				con.rollback();
				throw new SQLException("글 수정 실패");
			} else {
				int re[] = updateWriList(con, writing); //글 상세 수정
				for(int i : re) {
					if(i != Statement.SUCCESS_NO_INFO) {
						con.rollback();
						throw new SQLException("수정할 수 없음");
					}
				}
			}
		}finally {
			con.commit();
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	
	/**
	 * 글 상세 수정 
	 */
	public int[] updateWriList(Connection con, Writing writing) throws SQLException{
		PreparedStatement ps = null;
		int result[] = null;
		String sql = "UPDATE WRILIST SET WRI_CONTENT = ? WHERE WRI_NO = ? AND RES_NO = ?";
		
		try {
			ps = con.prepareStatement(sql);
			for(WriList wriList : writing.getWriList()) {
				ps.setString(1, wriList.getWriContent()); //내용 
				ps.setInt(2, writing.getWriNo()); //글번호 
				ps.setInt(3, wriList.getResNo()); //식당번호 
				
				ps.addBatch();
				ps.clearParameters();
			}
						
			result = ps.executeBatch();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}


	/**
	 * 글 전체 조회 
	 */
	@Override
	public List<Writing> selectWriting() throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<Writing> list = new ArrayList<Writing>();
		String sql = "SELECT * FROM WRITING";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Writing writing = new Writing(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(4));
				List<WriList> wriList = selectWriList(writing.getWriNo());
				writing.setWriList(wriList);
				
				list.add(writing);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}
	
	/**
	 * 글번호에 해당하는 글 상세 가져오기 
	 */
	public List<WriList> selectWriList(int wriNo) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs= null;
		List<WriList> list = new ArrayList<>();
		String sql = "SELECT * FROM WRILIST WHERE WRI_NO = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, wriNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				WriList wriList = new WriList(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
				list.add(wriList);
			}
		}finally {
			DbUtil.dbClose(rs, ps, null);
		}
		return list;
	}

}
