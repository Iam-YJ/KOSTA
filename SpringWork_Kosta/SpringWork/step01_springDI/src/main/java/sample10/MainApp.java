package sample10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample10/applicationContext.xml");
		
		BoardController board = context.getBean("boardController", BoardController.class);
		
		board.test();
	}

}
