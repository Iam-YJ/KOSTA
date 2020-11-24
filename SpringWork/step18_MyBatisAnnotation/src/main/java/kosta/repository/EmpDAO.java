package kosta.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;

public class EmpDAO {

	/**
	 * 전체검색
	 */
	public static void selectAll() {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<EmpDTO> list = mapper.selectAll();
			for (EmpDTO emp : list) {
				System.out.println(emp);
			}
		} finally {
			DbUtil.sessionClose(session);

		}
	}

	public static void selectByEmpNo(int empno) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			EmpDTO empDto = mapper.selectByEmpNo(empno);

			System.out.println(empDto);

		} finally {
			DbUtil.sessionClose(session);
		}

	}

	public static void delete(int empno) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();

			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.delete(empno) > 0 ? true : false;

			if (state) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}

		} finally {
			DbUtil.sessionClose(session,state);
		}
	}

	public static void update(EmpDTO empDto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.update(empDto) > 0 ? true : false;

			if (state) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} finally {
			DbUtil.sessionClose(session, state);
		}
	}

	public static void insert(EmpDTO empDto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);

			state = mapper.insert(empDto) > 0 ? true : false;

			if (state) {
				System.out.println("삽입 성공");
			} else {
				System.out.println("삽입실패");
			}
		} finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 동적쿼리
	 */
	public static void ifTest(EmpDTO empDTO) {
		SqlSession session = null;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);

			
		} finally {
			DbUtil.sessionClose(session);
		}
	}

}
