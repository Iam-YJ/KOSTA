package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;

public class joinDAO {
	
	/**
	 * 1번
	 */
	public static void selectOne(int empno) {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("joinMapper.selectOne",empno);

			for (EmpDTO dto : list) {
				System.out.print(dto.getDept().getDname()+" : ");
				System.out.println(dto.getEname() );
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}
	

	/**
	 * 1-1 
	 */
	public static void deptTest() {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("joinMapper.deptTest");

			for (EmpDTO dto : list) {
				System.out.print(dto.getDept().getDname()+" : ");
				System.out.println(dto.getEname() );
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	

	/**
	 * 2-1 
	 */
	public static void gradeTest() {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("joinMapper.gradeTest");

			for (EmpDTO dto : list) {
				System.out.print(dto.getEname()+" : ");
				System.out.print(dto.getSal()+" : ");
				System.out.println(dto.getSalgrade().getGrade());
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}
	/*	*//**
			 * 1 : 다 관계
			 *//*
				 * 
				 * public static void collectioinTest() { SqlSession session = null;
				 * 
				 * try { session = DbUtil.getSession(); List<CommentbDTO> list =
				 * session.selectList("joinMapper.collectionTest");
				 * 
				 * //System.out.println(list.size());
				 * 
				 * for(CommentbDTO dto : list) { System.out.println(dto.getCommentNo() +
				 * "의 "+dto.getCommentContent()+"대한 reply"); for(ReplyDTO reply :
				 * dto.getReplies()) { System.out.print(reply.getReplyContent() + " | ");
				 * System.out.println(reply.getUserId()); //작성자 } System.out.println(); }
				 * 
				 * } finally { DbUtil.sessionClose(session); } }
				 */
}
