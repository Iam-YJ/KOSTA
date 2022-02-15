package sample10;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component // id="boardServiceImpl"
@Service 
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardDAOImpl")
	
	//@Autowire 못쓴다
	//왜냐면 1. byType 먼저 하는데 이 때는 dao가 2개 생성해서 안됨
	// 그 다음에는 2. byName 하는데 이 때는 name이 안맞아서 (dao id와 안맞아서) 안됨
	private BoardDAO boardDao;

	@Resource(name = "mybatisDao")
	private BoardDAO boardMyBatisDao;

	public BoardServiceImpl() {

	}

	@Override
	public void select() {
		System.out.println("BoardServiceImpl의 select 호출됨");

		boardDao.select();
		boardMyBatisDao.select();

	}

}
