package kosta.mvc.test;

import java.sql.Connection;
import java.util.Properties;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.util.DbUtil;

public class TestMain {

	public static void main(String[] args) throws Exception {
		//�ε�� ������ �Ǿ����� test �õ�
		System.out.println("Connection Test");
		Connection con = DbUtil.getConnection();
		System.out.println("con = "+ con);
		
		Properties proFile = DbUtil.getProFile();	
		System.out.println(proFile);
		
		
		//daoTest
		BoardDAO dao = new BoardDAOImpl();
		
		System.out.println("�׽�Ʈ ����");
		dao.boardSelectAll();
		System.out.println("1 ��");
		
		dao.boardSelectBySubject("db����");
		System.out.println("2 ��");
		
		dao.boardSelectByNo(1);
		System.out.println("3 ��");
		
		BoardDTO boardDTO;
		dao.boardInsert(new BoardDTO(2, "����", "����","��������", null));
		dao.boardSelectAll();
		System.out.println("4 ��");
		
		
		dao.boardSelectByNo(1);
		System.out.println("5 ��");
		
		
		dao.boardSelectByNo(1);
		System.out.println("6 ��");
		
		
		
		

	}

}
