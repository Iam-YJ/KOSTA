package kosta.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.model.dto.Electronics;
import kosta.util.DbUtil;

public class ElectronicsDAOImpl implements ElectronicsDAO {

	@Override
	public List<Electronics> selectAll() throws SQLException {

		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Electronics> list = new ArrayList<Electronics>();
		String sql = "SELECT * FROM Electronics";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?가 있다면 ?의 순서대로 개수만큼 ps.setXxx() 필요

			rs = ps.executeQuery(sql);

			while (rs.next()) {
				// 커서를 아래로 이동하며 데이터 조회
				String modelNum = rs.getString(1);
				String modelName = rs.getString(2);
				int price = rs.getInt(3);
				String description = rs.getString(4);
				String password = rs.getString(5);
				String writeday = rs.getString(6);
				int readnum = rs.getInt(7);
				String fname = rs.getString(8);
				int fsize = rs.getInt(9);

				Electronics e = new Electronics(modelNum, modelName, price, description, password, writeday, readnum,
						fname, fsize);

				// list에 저장한다
				list.add(e);
			}

			// 연결 실행
		} finally {
			// 닫기
			DbUtil.dbClose(rs, ps, con);
		}
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Electronics elec = null;
		try {
			ps = con.prepareStatement("select * from Electronics where model_num=?");
			ps.setString(1, modelNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return elec;
	}

	@Override
	public int increamentByReadnum(String modelNum) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update Electronics set readnum = readnum+1 where model_num=?";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, modelNum);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}

		return result;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("insert into Electronics " + "values(?,?,?,?,?,sysdate,0,?,?)");
			ps.setString(1, electronics.getModelNum());
			ps.setString(2, electronics.getModelName());
			ps.setInt(3, electronics.getPrice());
			ps.setString(4, electronics.getDescription());
			ps.setString(5, electronics.getPassword());
			ps.setString(6, electronics.getFname());
			ps.setInt(7, electronics.getFsize());

			result = ps.executeUpdate();

			// 연결 실행
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement("delete Electronics where model_num = ? and password = ?");

			ps.setString(1, modelNum);
			ps.setString(2, password);


			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement("update Electronics set " + " model_name=?,price=?,description=?"
					+ "  where model_num=? and password=?");

			ps.setString(1, electronics.getModelName());
			ps.setInt(2, electronics.getPrice());
			ps.setString(3, electronics.getDescription());
			ps.setString(4, electronics.getModelNum());
			ps.setString(5, electronics.getPassword());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(ps, con);
		}
		return result;
	}

}
