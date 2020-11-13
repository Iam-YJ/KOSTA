package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample02.MemberService;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("sample03/springDIConstructor.xml");
			// 객체만 만들어도 생성자 호출됨 
		
		BookController controller = context.getBean("controller", BookController.class);
		controller.bookInsert();
	}

}
