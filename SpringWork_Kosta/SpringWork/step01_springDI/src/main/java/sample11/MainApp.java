package sample11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample10.BoardController;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample11/applicationContext.xml");
		BookController book = context.getBean("bookController",BookController.class);
		book.invoker();
		
		
		////////////////////////
		BookDTO dto = new BookDTO("hi", "하이", 12341, "1235월");
		dto.getPrice();
	}

}
