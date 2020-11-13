package sample11;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Resource
	private BookDAO bookDao;
	@Resource
	private EmailSender emailSender;

	@Resource(name = "message")
	// 메세지센더와 이름 같게 하려고
	private MessageSender messageSender;

	public BookServiceImpl() {

	}

	@Override
	public void save(BookDTO book1, BookDTO book2) {
		// TODO Auto-generated method stub
		bookDao.save(emailSender, messageSender, book1, book2);

	}

}
