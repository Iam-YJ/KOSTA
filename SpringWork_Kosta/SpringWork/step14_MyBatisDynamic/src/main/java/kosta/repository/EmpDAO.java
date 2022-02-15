package kosta.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;

public class EmpDAO {

	/**
	 * 동적 쿼리(if문과 where, trim)
	 */

	public static List<EmpDTO> ifTest(EmpDTO dto) {
		SqlSession session = DbUtil.getSession();
		List<EmpDTO> list = null;

		try {

			list = session.selectList("dynamicMapper.ifSelect", dto);

		} finally {
			DbUtil.sessionClose(session);
		}

		return list;
	}

	public static boolean updateTest(EmpDTO dto) {
		SqlSession session = null;
		boolean result = false;

		try {

			session = DbUtil.getSession();
			result = session.update("dynamicMapper.setUpdate", dto) > 0 ? true : false;

		} finally {
			DbUtil.sessionClose(session, result);
		}

		return result;
	}

	/**
	 * forEach
	 */
	public static List<EmpDTO> forEachTest(List<Integer> paramList) {
		SqlSession session = null;
		List<EmpDTO> list = null;

		try {

			session = DbUtil.getSession();
			list = session.selectList("dynamicMapper.forSelect", paramList);

		} finally {
			DbUtil.sessionClose(session);
		}

		return list;
	}
}
