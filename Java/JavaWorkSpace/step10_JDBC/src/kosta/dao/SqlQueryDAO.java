package kosta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kosta.frame.MenuExam;
import kosta.util.DbUtil;

public class SqlQueryDAO {
	MenuExam me;
	
	/**
	 * emp 테이블에서 모든 사원의 ename 정보 가져오기
	 */

	public void selectEname() {
		Connection con = null; //지역변수로 해서 쓰고 없어지고 쓰고 없어지고 반복 
		// 로드 -> static 블럭 끝
		Statement st = null;
		ResultSet rs = null;
		
		try { //connectino은 던져서 , 한쪽에서 처리가 편함
			// 연결
			con = DbUtil.getConnection();
			// 실행
			st = con.createStatement();
			rs = st.executeQuery("select empno, ename, job, hiredate from emp");
			while(rs.next()) {
				String empno = rs.getString(1);
				System.out.print(empno + " : ");
				
				String ename = rs.getString(2);
				System.out.print(ename + " : ");
				
				String job = rs.getString(3);
				System.out.print(job + " : ");
				
				String hiredate = rs.getString(4);
				System.out.println(hiredate);
				
				me.textArea.append(empno + " : "+ename + " : "+job + " : "+hiredate+"\n");
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 닫기 -- 무조건 실행해야 하기 때문에 .. finally로 
					// + try - catch 하고오는게 좋음 
			DbUtil.dbClose(con, st, rs); //select 블록이여서 함수인자 3개
		}
	}

}
