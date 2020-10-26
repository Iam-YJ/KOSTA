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
		// �ε� ���� ���� �ݱ�
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "SELECT * FROM MEMBER ORDER BY JOIN_DATE DESC";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?�� �ִٸ� ?�� ������� ������ŭ ps.setXxx() �ʿ�

			rs = ps.executeQuery(sql);

			while (rs.next()) {
				// Ŀ���� �Ʒ��� �̵��ϸ� ������ ��ȸ
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				String phone = rs.getString(5);
				String addr = rs.getString(6);
				String date = rs.getString(7);

				// Member ��ü�� �����Ѵ�
				Member m = new Member(id, pwd, name, age, phone, addr, date);
				// list�� �����Ѵ�
				list.add(m);
			}

			// ���� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ݱ�
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
		// �ε� ���� ���� �ݱ�
		Connection con = null;
		PreparedStatement ps = null;
		
		int result = 0;

		String sql = "insert into member(id,pwd,name,age,phone,addr, join_date)\r\n" + 
				"values(?,?,?,?,?,?, sysdate)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ?�� �ִٸ� ?�� ������� ������ŭ ps.setXxx() �ʿ�
			ps.setString(1, member.getId());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getName());
			ps.setInt(4, member.getAge());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getAddr());
			
			result = ps.executeUpdate();

			// ���� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ݱ�
			DbUtil.dbClose(ps, con);

		}

		return result;
	}

	@Override
	public boolean idCheck(String id) {
		// �ε� ���� ���� �ݱ�
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		String sql = "SELECT * FROM MEMBER where upper(id)=upper(?)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, id.trim());

			if (rs.next()) { // Ŀ���� �Ʒ��� �̵��ϸ鼭 �����͸� ��ȸ
				result = true;
			}

			// ���� ����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ݱ�
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
