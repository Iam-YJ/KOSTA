package kosta.main;

import java.util.Arrays;
import java.util.List;

import kosta.dto.EmpDTO;
import kosta.repository.EmpDAO;

public class MainApp {

	public static void main(String[] args) {
		
		List<EmpDTO> list = null;
		
		
		//System.out.println("1. if문 동적 쿼리 ================");
		
		/*
		 * list = EmpDAO.ifTest(null); // null 넣으면 전체검색 EndView.selectPrint(list);
		 * 
		 */
		
		/*
		 * list = EmpDAO.ifTest(new EmpDTO(0, "진진이",null,0,null)); //ename만 검색
		 * EndView.selectPrint(list);
		 * 
		 */
			
		/*
		 * list = EmpDAO.ifTest(new EmpDTO(0,null,"MANAGER",0,null)); //job만 검색
		 * EndView.selectPrint(list);
		 */
		  
		/*
		 * list = EmpDAO.ifTest(new EmpDTO(0,"진진이","진진",0,null)); //ename and job 검색
		 * EndView.selectPrint(list);
		 */
		 
		
/*		System.out.println("2. update문 동적 쿼리 ================");
		boolean result = false;
//		result = EmpDAO.updateTest(new EmpDTO(9897,"진박이",null,0,null));
		
//		result = EmpDAO.updateTest(new EmpDTO(9897,null,"진박이",0,null));
//
//		result = EmpDAO.updateTest(new EmpDTO(9897,null,null,9000,null));
//
		result = EmpDAO.updateTest(new EmpDTO(9897,"진진이","진진",6000,null));
		if(result) {
			EndView.message("수정되었습니다");
		}else {
			EndView.message("수정되지않았습니다");
		}*/
		
		
		System.out.println("3. forEach Test 쿼리 ================");
		

		list = EmpDAO.forEachTest(Arrays.asList(1111,9897,9999));
		EndView.selectPrint(list);

	}

}
