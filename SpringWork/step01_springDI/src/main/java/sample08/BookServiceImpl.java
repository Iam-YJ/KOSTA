package sample08;

public class BookServiceImpl implements BookService {
	private BookDAO bookDao;
	private MessageSender messageSender;
	private EmailSender emailSender;

	public BookServiceImpl() {
		System.out.println("BookServiceImpl()의 기본 생성자");
	}

	public BookServiceImpl(BookDAO bookDao) {
		System.out.println("BookServiceImpl(BookDAO bookDao) 의 기본 생성자");
		this.bookDao = bookDao;

	}

	public void setEmailSender(EmailSender esend) {

	}

	public void setMessageSender(MessageSender msend) {

	}

	@Override
	public void save(BookDTO book1, BookDTO book2) {
		System.out.println("BookService의 save(BookDTO book1, BookDTO book2) 호출");
		bookDao.save(emailSender, messageSender, book1, book2);

	}

}
