package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ReplyDAO;
import model.dao.ReplyDAOImpl;
import model.dto.Melon;
import model.dto.Reply;

public class ReplyService {
	private static ReplyDAO replyDAO = new ReplyDAOImpl();
	
	/**
	 *  ���� ��� 
	 * */
	public static int insertReply(Reply reply) throws SQLException{
		int result = replyDAO.insertReply(reply);
		if(result ==0)
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�..");
		System.out.println("result: " + result);
		return result;
	}
	
	/**
	 *  ���� ��ȸ - �Ĵ纰 
	 * */
	public static List<Reply> selectReplyByResNo(int resNo) throws SQLException{
		List<Reply> list = replyDAO.selectReplyByResNo(resNo);
		return list;
	}
	
	/**
	 *  ���� ��ȸ - ������ 
	 * */
	public static List<Reply> selectReplyByUserNo(int UserNo) throws SQLException{
		List<Reply> list = replyDAO.selectReplyByUserNo(UserNo);
		return list;
	}
	
	
	/**
	 *  ���� ���� 
	 * */
	public static int deleteReply(int resNo, int userNo) throws SQLException{
		
		int result= replyDAO.deleteReply(resNo, userNo);
		if(result==0)throw new SQLException("�������� �ʾҽ��ϴ�.");
		
		return result;
	}
	
	/**
	 *  ���� ����
	 * */
	public static int updateReply(Reply reply) throws SQLException{
		int result =  replyDAO.updateReply(reply);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
		return result;
	}
	
	/**
	 * ���� ������ ���� 
	 */
	public static int incrementLike(int reviewNo) throws SQLException{
		System.out.println("���� ���� ���� service");
		int result = replyDAO.incrementLike(reviewNo);
		System.out.println("result: " + result);
		if(result==0) throw new SQLException("�������� �ʾҽ��ϴ�.");
		return result;
	}
	
	/**
	 * �Ĵ��ȣ�� �Ĵ�˻�
	 */
	public static Melon selectByResNo(int resNo) throws SQLException{
		Melon melon = replyDAO.selectByResNo(resNo);
		if(melon == null) throw new SQLException("�˻���� ����");
		return melon;
	}

	public static Reply selectReplyByResNoAndUserNo(int resNo, int userNo) throws SQLException{
		Reply reply = replyDAO.selectReplyByResNoAndUserNo(resNo, userNo);
		if(reply==null) throw new SQLException("�˻���� ����");
		return reply;
	}
	
	/**
	 * �����ȣ�� ������ �˻�
	 */
	public static int selectLikeByReviewNo(int reviewNo) throws SQLException{
		int like = replyDAO.selectLikeByReviewNo(reviewNo);
		return like;
	}
	
	
}