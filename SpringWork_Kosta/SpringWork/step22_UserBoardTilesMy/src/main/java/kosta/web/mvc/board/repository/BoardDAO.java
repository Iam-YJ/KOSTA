package kosta.web.mvc.board.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kosta.web.mvc.board.dto.ElectronicsDTO;

public interface BoardDAO {
	/**
	 * ���ڵ� ��ü �˻�
	 */
	List<ElectronicsDTO> selectAll();

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	 */
	ElectronicsDTO selectByModelNum(String modelNum);

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ��ȸ�� �����ϱ�
	 */
	int readnumUpdate(String modelNum);

	/**
	 * ���ڵ� ����
	 */
	int insert(ElectronicsDTO electronics);

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	 */
	int delete(String modelNum, String password, String savePath);

	/**
	 * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	 */
	int update(ElectronicsDTO electronics);

}
