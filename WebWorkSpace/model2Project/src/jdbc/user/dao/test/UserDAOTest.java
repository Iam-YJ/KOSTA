package jdbc.user.dao.test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import jdbc.user.dao.UserDAO;

public class UserDAOTest {
	
	UserDAO dao;
	
	
	@Before //@Test�� ȣ��Ǳ� ���� ���� ����� 
	public void init() {
		dao = new UserDAO();
	}
	
	
	//Test�޼���� �ݵ�� public void �����ؾ���
	//@Test ������̼��� �ݵ�� ������ �־�� �Ѵ� 
	@Test
	public void delete() {
		int cnt = dao.deleteUser("test2");
		assertEquals(1,cnt);
	}

}
