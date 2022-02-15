package sample08;

public class BookDAOImpl implements BookDAO {
	private DbUtil dbUtil;

	public BookDAOImpl() {
		System.out.println("BookDAO()의 기본 생성자");
	}

	public BookDAOImpl(DbUtil dbUtil) {
		this.dbUtil = dbUtil;
		System.out.println("BookDAOImpl(DbUtil dbUtil) 호출");
	}

	@Override
	public void save(EmailSender emailSender, MessageSender messageSender, BookDTO book1, BookDTO book2) {
		// TODO Auto-generated method stub
		System.out.println("emailSender : "+emailSender);
		System.out.println("MessageSender : "+messageSender);
		System.out.println("bookDTO : "+book1);
		System.out.println("bookDTO : "+book2);

	}

}
