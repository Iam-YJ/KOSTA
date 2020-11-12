package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Noti;

public interface AdminDAO {
	/*
	 * 맛집 등록
	 */
	int insertRes(Melon melon) throws SQLException;

	/*
	 * 맛집 삭제
	 */
	int deleteRes(int resNo) throws SQLException;

	/*
	 * 맛집 수정
	 */
	int updateRes(Melon melon) throws SQLException;

	/*
	 * 회원 등급 관리
	 */
	void manageUserGrade(String userId, String grade) throws SQLException;

	/*
	 * 공지사항 작성
	 */
	int insertNotice(String notiTitle, String notiContent) throws SQLException;

	/*
	 * 공지사항 수정
	 */
	int updateNotice(Noti notice) throws SQLException;

	/*
	 * 공지사항 삭제
	 */
	int deleteNotice(int notiNo) throws SQLException;

	/*
	 * 회원 추방
	 */

	int banUser(String userId) throws SQLException;

	/**
	 * 공지사항 조회
	 */
	List<Noti> selectNoti() throws SQLException;

	/*
	 * 공지사항 상세보기
	 */
	Noti selectByNoti(int notiNo) throws SQLException;

	/*
	 * 조회수
	 */
	int increamentByHits(int notiNo) throws SQLException;

}
