package sample09;

import javax.annotation.Resource;

public class ResourceBean {

	@Resource(name = "dto")
	private EmpDTO emp1;

	@Resource(name = "empDTO")
	private EmpDTO emp2;

	@Resource(name = "service")
	private EmpService service;

	@Resource(name = "controller")
	private EmpController empController;

	public void test() {
		System.out.println("emp1 = " + emp1);
		System.out.println("emp2 = " + emp2);
		System.out.println("service = " + service);
		System.out.println("controller = " + empController);
	}

}
