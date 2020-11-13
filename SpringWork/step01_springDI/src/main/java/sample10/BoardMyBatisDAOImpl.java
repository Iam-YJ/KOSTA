package sample10;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("mybatisDao") //id="mybatisDao"
@Repository("mynatisDao")
public class BoardMyBatisDAOImpl implements BoardDAO {

	public BoardMyBatisDAOImpl() {
	}

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("BoardMyBatisDAOImpl의 select() 호출됨");

	}

}
