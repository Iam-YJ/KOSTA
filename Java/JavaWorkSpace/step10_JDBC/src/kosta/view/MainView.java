package kosta.view;

import kosta.dao.SqlQueryDAO;
import kosta.frame.MenuExam;

public class MainView {

	public static void main(String[] args) {
		System.out.println("1. 전체 사원이름 검색하기");
		SqlQueryDAO dao = new SqlQueryDAO();
		dao.selectEname();
		
		System.out.println("2. 사원번호, 이름, job, hiredate 검색하기");
		dao.selectEname();
		new MenuExam();
		
		// 1. empno를 인수로 받아 empno에 해당하는 사원 삭제하기
		// 2. empno에 해당하는 사원의 ename, job, sal 변경하기
		//		인수 : empno, ename, job, sal 받는다
		// 3. empno에 해당하는 사원 검색하기
		// 4. emp 테이블에 레코드 추가하기
		//		추가정보 : empno, enmae, job, sal, hiredate
		//		* hiredate는 현재날짜 등록 
		
	}

}
