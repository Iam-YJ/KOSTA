package kosta.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kosta.exam.MemberService;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/advice/applicationContext.xml");
		
		MemberService service = context.getBean("target",MemberService.class);
		/*
		 * System.out.println("---------- insert 시작 -----------------");
		 * service.insert();
		 * System.out.println("---------- insert 끝 -----------------");
		 * System.out.println("\n");
		 */	
		System.out.println("---------- select 시작 -----------------");
		service.select(10);
		System.out.println("---------- select 끝 -----------------");
		System.out.println();
		
		/*
		 * System.out.println("---------- update 시작 -----------------");
		 * service.update("하잉");
		 * System.out.println("---------- update 끝 -----------------");
		 */
	

	}

}
