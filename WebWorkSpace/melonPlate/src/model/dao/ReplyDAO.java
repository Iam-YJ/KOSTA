package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Reply;

public interface ReplyDAO {
	/*
	 * 식당리뷰 작성
	 * */
	int insertReply(Reply reply)throws SQLException;
	
	
	/*
	 * 식당리뷰 삭제
	 * */
	int deleteReply(int resNo, int userNo) throws SQLException;
	
	
	/*
	 * 식당리뷰 수정
	 * */
	int updateReply(Reply reply)throws SQLException;
	
	
	/*
	 * 리뷰 전체 보기 - 식당별
	 * */
	List<Reply> selectReplyByResNo(int resNo)throws SQLException;
	
	/*
	 * 리뷰 전체 보기 - 마이페이지
	 * */
	List<Reply> selectReplyByUserNo(int userNo)throws SQLException;
	
	/*
	 * 공감수 증가
	 * */
	int incrementLike(int res_no, int user_no)throws SQLException;
}
