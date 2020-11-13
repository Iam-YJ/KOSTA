package sample10;

import org.springframework.stereotype.Repository;

//@Component // id="boardDAOImpl"
@Repository //id="boardDAOImpl"
public class BoardDAOImpl implements BoardDAO {

	public BoardDAOImpl() {

	}

	@Override
	public void select() {
		System.out.println("BoardDAOImpl의 select() 호출됨");

	}

}
