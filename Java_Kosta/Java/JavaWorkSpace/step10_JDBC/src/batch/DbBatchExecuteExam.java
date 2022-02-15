package batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import kosta.util.DbUtil;

public class DbBatchExecuteExam {

	/**
	 * �����ϱ�
	 */

	public void delete(List<Integer> empNoList) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from copy_emp where empno = ?";

		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);

			for (int empno : empNoList) {
				ps.setInt(1, empno);

				ps.addBatch(); // �ϰ�ó���� �۾��� �߰�
				ps.clearParameters();
			}
			int result[] = ps.executeBatch(); // �ϰ�ó��(��� ����)
			System.out.println("�����Ͽ����ϴ�.");
			System.out.println("���� ���� : " + result.length);

			for (int re : result) {
				System.out.println(re);
			}
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			DbUtil.dbClose(con, ps);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7521, 7844, 8888, 7900);
		new DbBatchExecuteExam().delete(list);
	}

}
