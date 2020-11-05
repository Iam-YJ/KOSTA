package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ReplyDAO;
import model.dao.ReplyDAOImpl;
import model.dto.Reply;

public class ReplyService {
	private static ReplyDAO replyDAO = new ReplyDAOImpl();
	
	/**
	 *  리뷰 등록 
	 * */
	public static int insertReply(Reply reply) throws SQLException{
		int result = replyDAO.insertReply(reply);
		if(result ==0)
			throw new SQLException("등록되지 않았습니다..");
		System.out.println("result: " + result);
		return result;
	}
	
	/**
	 *  리뷰 조회 - 식당별 
	 * */
	public static List<Reply> selectReplyByResNo(int resNo) throws SQLException{
		List<Reply> list = replyDAO.selectReplyByResNo(resNo);
		return list;
	}
	
	/**
	 *  리뷰 조회 - 유저별 
	 * */
	public static List<Reply> selectReplyByUserNo(int UserNo) throws SQLException{
		List<Reply> list = replyDAO.selectReplyByUserNo(UserNo);
		return list;
	}
	
	
	/**
	 *  리뷰 삭제 
	 * */
	public static int deleteReply(int resNo, int userNo) throws SQLException{
		
		int result= replyDAO.deleteReply(resNo, userNo);
		if(result==0)throw new SQLException("삭제되지 않았습니다.");
		
		return result;
	}
	
	/**
	 *  리뷰 수정
	 * */
	public static int updateReply(Reply reply) throws SQLException{
		int result =  replyDAO.updateReply(reply);
		if(result==0) throw new SQLException("수정되지 않았습니다.");
		return result;
	}
	
	/**
	 * 리뷰 공감수 증가 
	 */
	public static int incrementLike(int res_no, int user_no) throws SQLException{
		int result = replyDAO.incrementLike(res_no, user_no);
		if(result==0) throw new SQLException("증가되지 않았습니다.");
		return result;
	}
	
	
}
