package kosta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosta.util.DbUtil;
import kosta.vo.Emp;

public class PrepareSqlQueryDAO {
	// MenuExam me;

	/**
	 * emp ���̺��� ��� ����� ename ���� ��������
	 */

	public void selectEname() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select ename from emp");
			rs = ps.executeQuery();

			while (rs.next()) {
				String ename = rs.getString(1);
				System.out.println(ename);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs); // select ����̿��� �Լ����� 3��
		}
	}

	public void selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select * from emp");
			rs = ps.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				System.out.println(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps, rs); // select ����̿��� �Լ����� 3��
		}
	}

	public void delete(int empno) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("delete from emp where empno=?");
			ps.setInt(1, empno);

			int i = ps.executeUpdate();

			if (i == 0) {
				System.out.println("���� �ȵ�");
			} else {
				System.out.println("���� ����");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, ps);

		}

	}

	public void update(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("update emp set ename=?, job=?, sal=? where empno=?");

			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getSal());
			ps.setInt(4, emp.getEmpno());

			int i = ps.executeUpdate();

			if (i == 0) {
				System.out.println("������Ʈ ����");
			} else {
				System.out.println("������Ʈ ����");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DbUtil.dbClose(con, ps);
		}
	}

	public void selectByEmpno(int empno) {

	}

	public void insert(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into emp(empno, ename, job, hiredate) values(?,?,?,sysdate)";

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());

			int i = ps.executeUpdate();

			if (i == 0) {
				System.out.println("������Ʈ ����");
			} else {
				System.out.println("������Ʈ ����");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DbUtil.dbClose(con, ps);
		}

	}
}
