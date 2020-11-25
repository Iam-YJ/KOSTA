package kosta.mvc.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //이것은 생성
public class SuggestDaoImpl implements SuggestDao {
	
	//이것은 주입
	@Autowired //myBatis-context.xml에 설정한 SqlSession을 주입한다 
				// 세션이 계속 공유되지 않고 그떄그때 생성됨.
	private SqlSession session;

	@Override
	public List<String> suggestSelect(String keyWord) {
		//SqlSession session = null; 과정을 이제는 이렇게 한다
		List<String> list = session.selectList("suggestMapper.select",keyWord);
		//close 할 필요도 없다. 알아서 자기가 close 해준다 
		
		return list;
	}

}
