package kosta.exam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("kosta/exam/applicationContext.xml");
		MessageService message = context.getBean("target",MessageService.class);
		message.engHello();
		System.out.println("=============================");
		message.korHello();
		System.out.println("=============================");
		message.hello();
		System.out.println("=============================");
		message.hello("박박이");
		
		
		
		System.out.println("========== User Service 시작 ===========");
		System.out.println("========================================");
		UserService uservice = context.getBean("target2",UserService.class);
		uservice.testHello();
		System.out.println("===============");
		uservice.insertHello(1, 2);
		
	}

}
