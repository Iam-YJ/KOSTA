package sample11;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private BookDTO book1;
	@Autowired
	private BookDTO book2;

	public BookController() {

	}

	public void invoker() {
		System.out.println("BookController의 invoker");
		bookService.save(book1, book2);
		

	}

}
