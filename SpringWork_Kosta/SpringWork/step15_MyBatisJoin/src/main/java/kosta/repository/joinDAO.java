package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.CommentbDTO;
import kosta.dto.ReplyDTO;

public class joinDAO {

	/**
	 * 1 : 1 관계
	 */
	public static void associationTest() {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			List<CommentbDTO> list = session.selectList("joinMapper.associationTest");
			
			for(CommentbDTO dto : list) {
				System.out.print(dto.getCommentNo() + ", ");
				System.out.print(dto.getUser().getUserName() + ", ");
				System.out.print(dto.getCommentContent() + ", ");
				System.out.println(dto.getRegDate() + " ");
			}
			

		} finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 1 : 다 관계
	 */

	public static void collectioinTest() {
		SqlSession session = null;

		try {
			session = DbUtil.getSession();
			List<CommentbDTO> list = session.selectList("joinMapper.collectionTest");

			//System.out.println(list.size());
			
			for(CommentbDTO dto : list) {
				System.out.println(dto.getCommentNo() + "의 "+dto.getCommentContent()+"대한 reply");
				for(ReplyDTO reply : dto.getReplies()) {
					System.out.print(reply.getReplyContent() + " | ");
					System.out.println(reply.getUserId()); //작성자
				}
				System.out.println();
			}

		} finally {
			DbUtil.sessionClose(session);
		}
	}
}
