package ex1107.dao;

import java.util.List;

import ex1107.dto.CustomerDTO;

public interface CustomerDAO {
	/**
	 * ���̵� �ߺ�üũ
	 * */
	boolean idCheck(String id);
	
	/**
	 * Customer ����ϱ�
	 * */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * ��ü Customer �˻��ϱ�
	 * */
	List<CustomerDTO> selectAll();
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	int delete(String id);
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	int update(CustomerDTO customerDTO);

}
