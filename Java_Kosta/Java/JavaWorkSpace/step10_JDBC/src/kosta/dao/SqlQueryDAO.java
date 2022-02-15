package kosta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kosta.util.DbUtil;
import kosta.vo.Emp;

public class SqlQueryDAO {

	// MenuExam me;

	/**
	 * emp ���̺��� ��� ����� ename ���� ��������
	 */

	public void selectAll() {
		Connection con = null; // ���������� �ؼ� ���� �������� ���� �������� �ݺ�
		// �ε� -> static �� ��
		Statement st = null;
		ResultSet rs = null;

		try { // connectino�� ������ , ���ʿ��� ó���� ����
				// ����
			con = DbUtil.getConnection();
			// ����
			st = con.createStatement();
			rs = st.executeQuery("select empno, ename, job,  hiredate from emp");
			while (rs.next()) {
				String empno = rs.getString(1);
				System.out.print(empno + " : ");

				String ename = rs.getString(2);
				System.out.print(ename + " : ");

				String job = rs.getString(3);
				System.out.print(job + " : ");

				String hiredate = rs.getString(4);
				System.out.println(hiredate);

				// me.textArea.append(empno + " : "+ename + " : "+job + " : "+hiredate+"\n");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ݱ� -- ������ �����ؾ� �ϱ� ������ .. finally��
			// + try - catch �ϰ���°� ����
			DbUtil.dbClose(con, st, rs); // select ����̿��� �Լ����� 3��
		}
	}

	public void delete(int empno) {
		Connection con = null;
		Statement st = null;
		String sql = "delete from emp where empno=" + empno;
		try {
			con = DbUtil.getConnection();
			st = con.createStatement();
			int i = st.executeUpdate(sql);
			if (i == 0)
				System.out.println("���� �ȵ�");
			else
				System.out.println("���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, st);
		}

	}

	public void update(Emp emp) {
		Connection con = null;
		Statement st = null;
		String sql = "update emp set ename='" + emp.getEname() + "' , job='" + emp.getJob() + "' , sal=" + emp.getSal()
				+ " where empno=" + emp.getEmpno();
		try {
			con = DbUtil.getConnection();
			st = con.createStatement();
			int i = st.executeUpdate(sql);
			if (i == 0)
				System.out.println("������Ʈ �ȵ�");
			else
				System.out.println("������Ʈ ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, st);
		}

	}

	public void selectByEmpno(int empno) {
		Connection con = null; // ���������� �ؼ� ���� �������� ���� �������� �ݺ�
		// �ε� -> static �� ��
		Statement st = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp where empno=" + empno;

		Emp emp = null;
		try { // connectino�� ������ , ���ʿ��� ó���� ����
				// ����
			con = DbUtil.getConnection();
			// ����
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				// me.textArea.append(empno + " : "+ename + " : "+job + " : "+hiredate+"\n");
			}

			System.out.println("��� : " + emp);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ݱ� -- ������ �����ؾ� �ϱ� ������ .. finally��
			// + try - catch �ϰ���°� ����
			DbUtil.dbClose(con, st, rs); // select ����̿��� �Լ����� 3��
		}
	}

	public void insert(Emp emp) {
		Connection con = null;
		Statement st = null;
		String sql = "insert into emp(empno, ename, job, hiredate) values(" + emp.getEmpno() + ",'" + emp.getEname()
				+ "','" + emp.getJob() + "', sysdate)";
		try {
			con = DbUtil.getConnection();
			st = con.createStatement();
			int result = st.executeUpdate(sql);

			if (result > 0) {
				System.out.println("��ϵǾ����ϴ�.");
			} else {
				System.out.println("��ϵ��� �ʾҽ��ϴ�.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, st);
		}
	}

}
