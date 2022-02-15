package sample11;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {

	public BookDAOImpl() {

	}

	@Override
	public void save(EmailSender emailSender, MessageSender messageSender, BookDTO book1, BookDTO book2) {
		System.out.println("bookDTO = " + book1);
		System.out.println("bookDTO = " + book2);
	}

}
