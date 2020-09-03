package batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import kosta.util.DbUtil;

public class DbBatchExecuteExam {
	
	
	/**
	 * 삭제하기
	 */
	
	public void delete(List<Integer> empNoList) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from copy_emp where empno = ?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			for(int empno: empNoList) {
				ps.setInt(1, empno);
				
				ps.addBatch(); // 일괄처리할 작업을 추가 
				ps.clearParameters();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public static void main(String[] args) {
		
	}

}
