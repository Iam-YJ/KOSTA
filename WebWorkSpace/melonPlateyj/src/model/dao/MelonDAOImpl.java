package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.Melon;
import model.dto.Menu;
import util.DbUtil;

public class MelonDAOImpl implements MelonDAO{

	/**
	 * 조회수 정렬
	 */
	@Override
	public List<Melon> selectByHits() throws SQLException {
		List<Melon> list = new ArrayList<Melon>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT ORDER BY RES_HITS DESC";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
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

	   @Override
	   public List<Melon> selectByGrade() throws SQLException{
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs= null;
	      List<Melon> list = new ArrayList<>();
	      String sql = "SELECT * FROM RESTAURANT ORDER BY RES_GRADE DESC";
	      try {
	         con = DbUtil.getConnection();
	         ps = con.prepareStatement(sql);
	         rs= ps.executeQuery();
	         while(rs.next()) {
	            Melon melon = 
	                  new Melon(rs.getInt(1),rs.getString(2),rs.getString(3),
	                        rs.getString(4),rs.getString(5),rs.getString(6),
	                        rs.getInt(7),rs.getInt(8),rs.getString(9));
	            list.add(melon);
	         }
	      }finally {
	         DbUtil.dbClose(rs, ps, con);
	      }
	      return list;
	   }

	@Override
	public List<Melon> selectByType(String type) throws SQLException {
		List<Melon> list = new ArrayList<Melon>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RES_TYPE like ?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+type+"%");
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
	 * 조회수 업데이트
	 */
	@Override
	public int updateHits(int resNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE RESTAURANT SET RES_HITS = RES_HITS+1 WHERE RES_NO = ?";
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, null);
		}
		return result;
	}

	/**
	 * 식당종류(음식테마) 정렬
	 */
	@Override
	public List<Melon> selectByArea(String area) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RES_PLACE LIKE ?";
		List<Melon> list = new ArrayList<Melon>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + area + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				int resNo = rs.getInt(1);
				String resName = rs.getString(2);
				String resPlace = rs.getString(3);
				String resTel = rs.getString(4);
				String resType = rs.getString(5);
				String resPhoto = rs.getString(6);
				int resHits = rs.getInt(7);
				int resGrade = rs.getInt(8);
				String resPrice = rs.getString(9);

				Melon melon = new Melon(resNo, resName, resPlace, resTel, resType, resPhoto, resHits, resGrade,
						resPrice);

				list.add(melon);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	
	@Override
	public List<Melon> selectByResName(String resName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RES_NAME LIKE ?";
		List<Melon> list = new ArrayList<Melon>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+resName+"%");
			
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
	 * 지역별 정렬
	 */
	@Override
	public List<Melon> selectByPrice(String price) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RES_PRICE LIKE ?";
		List<Melon> list = new ArrayList<Melon>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, price.charAt(0)+"%");
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

	@Override
	public List<Melon> selectRecommend() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT RES_NAME, RES_PLACE FROM RESTAURANT";
		List<Melon> list = new ArrayList<Melon>();
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String resName = rs.getString(1);
				String resPlace = rs.getString(2);
				Melon melon = new Melon(resName, resPlace);
				
				list.add(melon);
				
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public Melon selectDetailRes(int resNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT WHERE RES_NO = ?";
		Melon melon = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				resNo = rs.getInt(1);
				String resName = rs.getString(2);
				String resPlace = rs.getString(3);
				String resTel = rs.getString(4);
				String resType = rs.getString(5);
				String resPhoto = rs.getString(6);
				int resHits = rs.getInt(7);
				int resGrade = rs.getInt(8);
				String resPrice = rs.getString(9);
				
				melon = new Melon(resNo, resName, resPlace, resTel, resType, resPhoto, resHits, resGrade, resPrice);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return melon;
	}

	@Override
	public List<Melon> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM RESTAURANT";
		List<Melon> list = new ArrayList<Melon>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
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
		System.out.println("list all : " + list);
		return list;
	}

	@Override
	public List<Menu> selectMenu(int resNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MENU WHERE RES_NO = ?";
		List<Menu> list = new ArrayList<Menu>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, resNo);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int menuNo = rs.getInt(1);
				resNo = rs.getInt(2);
				String menuName = rs.getString(3);
				String menuPrice = rs.getString(4);
				
				Menu menu = new Menu(menuNo, resNo, menuName, menuPrice);
				list.add(menu);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		System.out.println("dao : " + list);
		return list;
	}

}
