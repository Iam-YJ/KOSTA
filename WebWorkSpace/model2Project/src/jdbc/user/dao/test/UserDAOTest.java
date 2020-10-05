package jdbc.user.dao.test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import jdbc.user.dao.UserDAO;

public class UserDAOTest {
	
	UserDAO dao;
	
	
	@Before //@Test가 호출되기 전에 먼저 실행됨 
	public void init() {
		dao = new UserDAO();
	}
	
	
	//Test메서드는 반드시 public void 시작해야함
	//@Test 어노테이션을 반드시 선언해 주어야 한다 
	@Test
	public void delete() {
		int cnt = dao.deleteUser("test2");
		assertEquals(1,cnt);
	}

}
