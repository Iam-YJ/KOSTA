package sample08;

public class BookController {
	private BookDTO book1;
	private BookDTO book2;
	private BookService bookService;

	public BookController() {
		System.out.println("BookController() 생성자 호출");

	}

	public BookController(BookService bookService, BookDTO book1, BookDTO book2) {
		System.out.println(" BookController(BookService bookService, BookDTO book1, BookDTO book2) 생성자 호출");
		this.bookService = bookService;
		this.book1 = book1;
		this.book2 = book2;
		invoker();
	}

	public void invoker() {
		//main -> invoke -> service -> dao
		bookService.save(book1, book2);

	}

}
