package sample03;

public class BookController {

	private BookDAO bookdao;
	private BookVo bookvo;

	public BookController() {

	}

	public BookController(BookDAO bookdao, BookVo bookvo) {
		// 생성자임
		// 생성자는 들어오는 값들을 초기화 하는 역할을 함

		// System.out.println("BookController(BookDAO bookdao, BookVo bookvo)의 생성자");
		this.bookdao = bookdao;
		this.bookvo = bookvo;

	}

	public void bookInsert() {
		bookdao.insert(bookvo);
	}

}
