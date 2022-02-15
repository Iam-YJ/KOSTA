package kosta.repository;

import kosta.dto.EmpDTO;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("1.  ename 정보 test ==============");
		//EmpDAO.selectEname();

		System.out.println("2.  등록하기 TEST ==============");
		//EmpDAO.insert(new EmpDTO(9897, "박박이", "박박", 9000, null));
		
		System.out.println("3.  삭제하기 TEST ==============");
		//EmpDAO.delete(9898);
		
		System.out.println("4.  수정하기 TEST ==============");
		//EmpDAO.update(new EmpDTO(9897, "진진이","진진",8000,null));
		
		
		System.out.println("5.  전체검색 TEST ==============");
		EmpDAO.selectAll();
		//dto와 oracle 사이에 칭하는 이름이 달라서 null이 나오는 것은
		// 1. sql 문에서 as ㅇㅇㅇ 으로 바꾸거나
		// 2. resultMap을 사용한다 
		
		/*
		 * System.out.println("6.  번호로 전체 검색 TEST ==============");
		 * EmpDAO.selectByEmpno(1111);
		 * 
		 * 
		 * System.out.println("7.  전달된 급여보다 적게 받는 사람 검색 TEST ==============");
		 * EmpDAO.selectBySal(5000);
		 * 
		 * System.out.println("8.  최소 ~ 최대 월급 전체 검색 TEST ==============");
		 * EmpDAO.selectByMinMax(1000,3000);
		 * 
		 * System.out.println("9.  정렬 컬럼을 받아서 전체 검색 TEST ==============");
		 * EmpDAO.selectByKeyField("ename","a");
		 * 
		 * System.out.println("9.  다른 컬럼에서 불러오기 TEST ==============");
		 * EmpDAO.selectByJob("진진");
		 */
		
		System.out.println("10. TEST ==============");
		EmpDAO.test();	
		
		}

}
