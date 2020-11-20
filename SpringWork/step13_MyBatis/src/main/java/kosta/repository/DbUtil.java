package kosta.repository;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {

	private static SqlSessionFactory factory;

	static {
		String resource = "config/SqlMapConfig.xml";

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * MyBatis의 SqlSession 객체를 리턴해주는 메소드 작성 : 
	 * 	SqlSession은 CRUD 작업에 관련된 메소드 제공
	 * 	commit, rollback에 관련된 transaction 메소드 제공한다
	 * 
	 * 기본적으로 자동 commit이 아니기 때문에 DML 작업일 경우에 반드시 commit or rollback 처리 필수적이다
	 * 
	 * : JDBC의 Connection과 유사하다
	 */

	public static SqlSession getSession() {
		return factory.openSession();
	}

	/**
	 * 닫기 (select 전용)
	 */
	public static void sessionClose(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}

	/**
	 * 닫기 (DML - insert , update, delete 전용)
	 * 
	 * @param : boolean형은 true이면 commit , false이면 rollback
	 */

	public static void sessionClose(SqlSession session, boolean state) {
		if (session != null) {
			if (state) {
				session.commit();
			} else {
				session.rollback();
			}
			session.close();
		}
	}
}
