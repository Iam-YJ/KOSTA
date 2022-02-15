package kosta.mvc.test;

import java.sql.Connection;
import java.util.Properties;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.util.DbUtil;

public class TestMain {

	public static void main(String[] args) throws Exception {
		//로드와 연결이 되었는지 test 시도
		System.out.println("Connection Test");
		Connection con = DbUtil.getConnection();
		System.out.println("con = "+ con);
		
		Properties proFile = DbUtil.getProFile();	
		System.out.println(proFile);
		
		
		//daoTest
		BoardDAO dao = new BoardDAOImpl();
		
		System.out.println("테스트 시작");
		dao.boardSelectAll();
		System.out.println("1 끝");
		
		dao.boardSelectBySubject("db수업");
		System.out.println("2 끝");
		
		dao.boardSelectByNo(1);
		System.out.println("3 끝");
		
		BoardDTO boardDTO;
		dao.boardInsert(new BoardDTO(2, "공주", "유진","유진공주", null));
		dao.boardSelectAll();
		System.out.println("4 끝");
		
		
		dao.boardSelectByNo(1);
		System.out.println("5 끝");
		
		
		dao.boardSelectByNo(1);
		System.out.println("6 끝");
		
		
		
		

	}

}
