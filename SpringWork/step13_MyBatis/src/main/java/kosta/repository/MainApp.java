package kosta.repository;

import kosta.dto.EmpDTO;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("1.  ename 정보 test ==============");
		EmpDAO.selectEname();

		System.out.println("2.  등록하기 TEST ==============");
		EmpDAO.insert(new EmpDTO(9897, "박박이", "박박", 9000, null));
		
		System.out.println("3.  삭제하기 TEST ==============");
		//EmpDAO.delete(9898);
		
		System.out.println("4.  수정하기 TEST ==============");
		EmpDAO.update(new EmpDTO(9897, "진진이","진진",8000,null));
		
		
		
		

	}

}
