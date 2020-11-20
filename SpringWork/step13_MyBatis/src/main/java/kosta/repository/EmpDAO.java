package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;

public class EmpDAO {

	/**
	 * 모든 사원의 이름 검색
	 */

	public static void selectEname() {
		SqlSession session = null; // session은 메소드 단위로 움직여야한다
		try {
			// 연결, 실행, 닫기
			session = DbUtil.getSession();
			List<String> list = session.selectList("empMapper.selectEname"); //empMapper.xml의 nameSpace이름.id가 된 것 
	
			System.out.println("***** emp의 ename 정보 *****");
			System.out.println(list);
		} finally {
			DbUtil.sessionClose(session);
		}
	}
	

	/**
	 * 등록하기
	 */
	public static void insert(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.insert("empMapper.insert", empDTO) > 0 ? true : false;
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제하기
	 */
	
	public static void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			state  = session.delete("empMapper.delete", empno) > 0 ? true  :false;
		}finally {
			DbUtil.sessionClose(session,state);
		}
	}
	
	
	/**
	 * 수정하기
	 */
	
	public static void update(EmpDTO empDTO) {
		SqlSession session = null;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			state  = session.update("empMapper.update", empDTO) > 0 ? true  :false;
		}finally {
			DbUtil.sessionClose(session,state);
		}
	}

}//클래스 끝


