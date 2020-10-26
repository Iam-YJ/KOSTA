package kosta.dao;

import java.util.List;

import kosta.dto.Member;

/**
 * ȸ������
 */
public interface MemberDAO {
	
	/*
	 * ��ü�˻�
	 */
	List<Member> selectAll();
	
	/*
	 * ���ǰ˻�(�˻��ʵ�� �˻��ܾ �ش��ϴ� ���ڵ� �˻�)
	 */
	List<Member> searchByKeyWord(String keyField, String keyWord);
	
	/*
	 * ����ϱ�
	 */
	int insert(Member member);
	
	
	/*
	 * ID �ߺ�üũ�ϱ�
	 * @return : true �̸� ������, false �̸� �������� ���� 
	 */
	boolean idCheck(String id);
	
	/*
	 * ID ���� �ϱ�
	 */
	int deleteId(String id);
	
	
}
