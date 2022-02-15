package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Noti;

public interface AdminDAO {
	/*
	 * ���� ���
	 */
	int insertRes(Melon melon) throws SQLException;

	/*
	 * ���� ����
	 */
	int deleteRes(int resNo) throws SQLException;

	/*
	 * ���� ����
	 */
	int updateRes(Melon melon) throws SQLException;

	/*
	 * ȸ�� ��� ����
	 */
	void manageUserGrade(String userId, String grade) throws SQLException;

	/*
	 * �������� �ۼ�
	 */
	int insertNotice(String notiTitle, String notiContent) throws SQLException;

	/*
	 * �������� ����
	 */
	int updateNotice(Noti notice) throws SQLException;

	/*
	 * �������� ����
	 */
	int deleteNotice(int notiNo) throws SQLException;

	/*
	 * ȸ�� �߹�
	 */

	int banUser(String userId) throws SQLException;

	/**
	 * �������� ��ȸ
	 */
	List<Noti> selectNoti() throws SQLException;

	/*
	 * �������� �󼼺���
	 */
	Noti selectByNoti(int notiNo) throws SQLException;

	/*
	 * ��ȸ��
	 */
	int increamentByHits(int notiNo) throws SQLException;

}