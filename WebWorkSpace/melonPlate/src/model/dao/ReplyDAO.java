package model.dao;

import java.util.List;

import model.dto.Reply;

public interface ReplyDAO {
	/*
	 * 리뷰 작성
	 * */
	int insertReply(Reply reply);
	
	/*
	 * 리뷰 삭제
	 * */
	int deleteReply(int replNo);
	
	/*
	 * 리뷰 수정
	 * */
	int updateReply(Reply reply);
	
	/*
	 * 리뷰 전체 보기
	 * */
	List<Reply> selectReply();
	
	/*
	 * 공감수 증가
	 * */
	int incrementLike(int replNo);
}
