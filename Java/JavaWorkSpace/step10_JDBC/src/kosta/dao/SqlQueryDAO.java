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
	 * emp 테이블에서 모든 사원의 ename 정보 가져오기
	 */

	public void selectAll() {
		Connection con = null; // 지역변수로 해서 쓰고 없어지고 쓰고 없어지고 반복
		// 로드 -> static 블럭 끝
		Statement st = null;
		ResultSet rs = null;

		try { // connectino은 던져서 , 한쪽에서 처리가 편함
				// 연결
			con = DbUtil.getConnection();
			// 실행
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
			// 닫기 -- 무조건 실행해야 하기 때문에 .. finally로
			// + try - catch 하고오는게 좋음
			DbUtil.dbClose(con, st, rs); // select 블록이여서 함수인자 3개
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
				System.out.println("삭제 안됨");
			else
				System.out.println("삭제 성공");
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
				System.out.println("업데이트 안됨");
			else
				System.out.println("업데이트 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, st);
		}

	}

	public void selectByEmpno(int empno) {
		Connection con = null; // 지역변수로 해서 쓰고 없어지고 쓰고 없어지고 반복
		// 로드 -> static 블럭 끝
		Statement st = null;
		ResultSet rs = null;
		String sql = "select empno, ename, job, sal, hiredate from emp where empno=" + empno;

		Emp emp = null;
		try { // connectino은 던져서 , 한쪽에서 처리가 편함
				// 연결
			con = DbUtil.getConnection();
			// 실행
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				// me.textArea.append(empno + " : "+ename + " : "+job + " : "+hiredate+"\n");
			}

			System.out.println("결과 : " + emp);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기 -- 무조건 실행해야 하기 때문에 .. finally로
			// + try - catch 하고오는게 좋음
			DbUtil.dbClose(con, st, rs); // select 블록이여서 함수인자 3개
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
				System.out.println("등록되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.dbClose(con, st);
		}
	}

}
