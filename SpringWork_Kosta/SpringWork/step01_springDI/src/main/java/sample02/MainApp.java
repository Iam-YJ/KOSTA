package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// service의 insert를 호출해서 그 결과를 확인한다
		// 1. 기존방식 
		/*
		 * MemberDAO memberDAO = new MemberDAO(); Member member = new Member("jang",
		 * "11", 20, "서울"); MemberService service = new MemberService(memberDAO,
		 * member); service.insert();
		 */	
			
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sample02/springDIConstructor.xml");
			// 객체만 만들어도 생성자 호출됨 
		
		System.out.println("---------------------------------");
		
		MemberService service = context.getBean("service", MemberService.class);
		service.insert();
	
	}

}
