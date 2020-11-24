package kosta.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;
import kosta.dto.UserDTO;

public class EmpDAO {

	/**
	 * 모든 사원의 이름 검색
	 */

	public static void selectEname() {
		SqlSession session = null; // session은 메소드 단위로 움직여야한다
		try {
			// 연결, 실행, 닫기
			session = DbUtil.getSession();
			List<String> list = session.selectList("empMapper.selectEname"); // empMapper.xml의 nameSpace이름.id가 된 것

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
		} finally {
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
			state = session.delete("empMapper.delete", empno) > 0 ? true : false;
		} finally {
			DbUtil.sessionClose(session, state);
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
			state = session.update("empMapper.update", empDTO) > 0 ? true : false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
	}

	/**
	 * 전체검색
	 */
	public static void selectAll() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectAll");
			// 첫번째 인수는 무조건 id 이다

			for (EmpDTO e : list) {
				System.out.println(e);
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}

	/**
	 * empno에 해당하는 전체 검색
	 */

	public static void selectByEmpno(int empno) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			EmpDTO empDTO = session.selectOne("empSelectMapper.selectBySal", empno);
			// 첫번째 인수는 무조건 id 이다

			System.out.println(empDTO);

		} finally {
			DbUtil.sessionClose(session);
		}
	}

	/**
	 * 급여보다 적게 받는 사원 정보 검색
	 */
	public static void selectBySal(int sal) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectBySal", sal);
			// 첫번째 인수는 무조건 id 이다

			for (EmpDTO e : list) {
				System.out.println(e);
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}

	/**
	 * 최소 ~ 최대 검색
	 */
	public static void selectByMinMax(int min, int max) {
		SqlSession session = null;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("min", min);
		map.put("max", max);

		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectByMinMax", map);
			// 첫번째 인수는 무조건 id 이다

			for (EmpDTO e : list) {
				System.out.println(e);
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}

	/**
	 * 정렬 컬럼을 인수로 받아서
	 */
	public static void selectOrder(String column) {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectOrder", column);
			// 첫번째 인수는 무조건 id 이다

			for (EmpDTO e : list) {
				System.out.println(e);
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}

	/**
	 * 검색필드에 해당하는 검색단어를 포함하고 있는 레코드 검색
	 */
	public static void selectByKeyField(String keyField, String keyWord) {
		SqlSession session = null;

		Map<String, String> map = new HashMap<String, String>();

		try {
			map.put("keyField", keyField);
			map.put("keyWord", keyWord);

			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectByKeyField", map);
			// 첫번째 인수는 무조건 id 이다

			for (EmpDTO e : list) {
				System.out.println(e);
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}

	/**
	 * 다른 곳에서 쿼리문 불러오고 싶을 때
	 */
	public static void selectByJob(String job) {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			EmpDTO dto = session.selectOne("empMapper.selectByJob", job);
			// 첫번째 인수는 무조건 id 이다

			System.out.println(dto);

		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	
	/**
	 * 
	 */
	public static void test() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			List<UserDTO> list =session.selectList("empMapper.userSelect");
			
			for(UserDTO u : list) {
				System.out.println(u);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}

}// 클래스 끝
