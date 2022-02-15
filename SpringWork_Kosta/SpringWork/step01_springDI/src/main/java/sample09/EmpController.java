package sample09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {

	@Autowired // byType으로 주입되고 안되면 byName으로 주입
	private EmpDTO dto;
	
	@Autowired
	@Qualifier("aa")
	private EmpDTO dto2;
	
	@Autowired
	private EmpService service;

	public void test() {
		System.out.println("EmpController의 test() 호출됨");
		System.out.println("dto : " + dto + ", " + dto.getName());
		System.out.println("dto2 : " + dto2 + ", " + dto2.getName());

		service.test();
	}

}
