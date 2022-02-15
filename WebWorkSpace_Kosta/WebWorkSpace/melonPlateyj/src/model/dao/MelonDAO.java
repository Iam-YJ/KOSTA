package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.dto.Melon;
import model.dto.Menu;

public interface MelonDAO {
	/*
	 * ��ȸ�� ������ �˻�(��������)
	 * */
	List<Melon> selectByHits() throws SQLException;
	
	/*
	 * ���������� �˻� (���� ��������)
	 * */
	List<Melon> selectByGrade() throws SQLException;
	
	/*
	 * ���������� �˻� (����)
	 * */
	List<Melon> selectByType(String type) throws SQLException;
	
	/*
	 * ��ȸ�� ���� (����no)
	 * */
	int updateHits(int resNo) throws SQLException;
	
	/*
	 * ������ �˻� (����)
	 * */
	List<Melon> selectByArea(String area) throws SQLException;
	
	/*
	 * �Ĵ��̸��� �˻�
	 * */
	List<Melon> selectByResName(String resName) throws SQLException;

	/*
	 * ���ݼ� �˻�
	 * */
	List<Melon> selectByPrice(String price) throws SQLException;
	
	/*
	 * �ֺ� �Ĵ� ��õ(�� ��ġ ����) 
	 * */
	List<Melon> selectRecommend() throws SQLException;
	
	/*
	 * �Ĵ� �󼼺��� 
	 * */
	Melon selectDetailRes(int resNo) throws SQLException;

	List<Melon> selectAll() throws SQLException;
	
	/*
	 * �޴� ����
	 * */
	List<Menu> selectMenu(int resNo) throws SQLException;
}