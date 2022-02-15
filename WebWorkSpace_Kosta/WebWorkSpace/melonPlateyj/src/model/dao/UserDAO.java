package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Noti;
import model.dto.User;

public interface UserDAO {
	/*
	 * 카카오 회원가입 
	 * */
	int  joinKakao(int userNo, String userNick, String userAge, String userEmail, String userGender);
	
	/*
	 * 로그인  
	 * */
	
	
	/*
	 * 찜하기 추가  
	 * */
	int insertBookMark(int userNo, int resNo);
	
	/*
	 * 찜하기 삭제  
	 * */
	int deleteBookMark(int userNo, int resNo);
	
	/*
	 * 찜하기 조회
	 */
	List<Melon> selectBookMark(int userNo) throws SQLException;
	
	/*
	 * 좋아하는 음식종류 등록
	 * */
	//int insertKind();
	
	/*
	 * 포인트 증가
	 * */
	int updatePoint(int userNo, int point);
	
	
	/*
	 * 친구 등록
	 * */
	int insertFriends(int userNo, int friendNo);
	
	/*
	 * 친구 삭제
	 * */
	int deleteFriends(String frId);
	
	/**
	 * 회원정보 조회
	 */
	User selectUserInfo(int userNo) throws SQLException;
	
	/*
	 * 회원정보 수정
	 * */
	int updateUserInfo(User user) throws SQLException;
	
	/*
	 * 공지사항 보기
	 * */
	List<Noti> selectNotice() throws SQLException;

	/**
	 * 공지사항 상세보기
	 */
	Noti selectNotiByNotiNo(int notiNo) throws SQLException;
	
	/**
	 * 관심분야 추가
	 */
	int interestInsert(String[] iList) throws SQLException;
}
