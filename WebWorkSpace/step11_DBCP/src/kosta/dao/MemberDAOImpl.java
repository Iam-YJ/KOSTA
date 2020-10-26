package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kosta.dto.Member;
import kosta.servlet.insertServlet;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<Member> selectAll() {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "SELECT * FROM MEMBER ORDER BY JOIN_DATE DESC";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?가 있다면 ?의 순서대로 개수만큼 ps.setXxx() 필요

			rs = ps.executeQuery(sql);

			while (rs.next()) {
				// 커서를 아래로 이동하며 데이터 조회
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				String addr = rs.getString(6);
				String date = rs.getString(7);

				// Member 객체에 저장한다
				Member m = new Member(id, pwd, name, age, phone, addr, date);
				// list에 저장한다
				list.add(m);
			}

			// 연결 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.dbClose(rs, ps, con);

		}

		return list;
	}

	@Override
	public List<Member> searchByKeyWord(String keyField, String keyWord) {

		return null;
	}

	@Override
	public int insert(Member member) {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;

		String sql = "insert into member(id,pwd,name,age,phone,addr, join_date)\r\n" + 
				"values(?,?,?,?,?,?, sysdate)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?가 있다면 ?의 순서대로 개수만큼 ps.setXxx() 필요
			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getAddr());
			
			result = ps.executeUpdate();

			// 연결 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);

		}

		return result;
	}

	@Override
	public boolean idCheck(String id) {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "SELECT * FROM MEMBER where upper(id)=upper(?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, id.trim());

			if (rs.next()) { // 커서를 아래로 이동하면서 데이터를 조회
				result = true;
			}

			// 연결 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 닫기
			DbUtil.dbClose(ps, con);

		}

		return result;
	}

	@Override
	public int deleteId(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
