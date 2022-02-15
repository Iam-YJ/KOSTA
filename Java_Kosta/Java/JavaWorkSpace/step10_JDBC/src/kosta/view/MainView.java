package kosta.view;

import kosta.dao.PrepareSqlQueryDAO;
import kosta.dao.SqlQueryDAO;
import kosta.vo.Emp;

public class MainView {

	public static void main(String[] args) {

		System.out.println("1. 전체 사원이름 검색하기");
		// SqlQueryDAO dao = new SqlQueryDAO();
		// dao.selectEname();
		PrepareSqlQueryDAO sdao = new PrepareSqlQueryDAO();
		sdao.selectEname();
		System.out.println();

		System.out.println("2. 사원번호, 이름, job, hiredate 검색하기");
		// dao.selectAll();
		// new MenuExam();

		sdao.selectAll();
		System.out.println();

		// 3. empno를 인수로 받아 empno에 해당하는 사원 삭제하기
		System.out.println("3. empno를 인수로 받아 empno에 해당하는 사원 삭제하기");
		// dao.delete(7900);
		// dao.delete(9000);

		sdao.delete(7566);
		sdao.delete(9000);
		System.out.println();

		// 4. empno에 해당하는 사원의 ename, job, sal 변경하기
		// 인수 : empno, ename, job, sal 받는다
		System.out.println("4. empno에 해당하는 사원의 ename, job, sal 변경하기");
		// dao.update(new Emp(7566,"희정","백조",3000, null));
		// dao.update(new Emp(1111,"희정","백조",3000, null));

		sdao.update(new Emp(7654, "유진", "공주", 3000, null));
		sdao.update(new Emp(1000, "명진", "공주", 3000, null));
		System.out.println();

		// 5. empno에 해당하는 사원 검색하기
		System.out.println("5. empno에 해당하는 사원 검색하기");
		// dao.selectByEmpno(7566);
		// dao.selectByEmpno(1111);

		// 6. emp 테이블에 레코드 추가하기
		// 추가정보 : empno, enmae, job, sal, hiredate
		// * hiredate는 현재날짜 등록
		System.out.println("6. emp 테이블에 레코드 추가하기");
		// dao.insert(new Emp(1111,"희정","백조",3000, null));

	}

}
