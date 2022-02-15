package kosta.mvc.model.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //�̰��� ����
public class SuggestDaoImpl implements SuggestDao {
	
	//�̰��� ����
	@Autowired //myBatis-context.xml�� ������ SqlSession�� �����Ѵ� 
				// ������ ��� �������� �ʰ� �׋��׶� ������.
	private SqlSession session;

	@Override
	public List<String> suggestSelect(String keyWord) {
		//SqlSession session = null; ������ ������ �̷��� �Ѵ�
		List<String> list = session.selectList("suggestMapper.select",keyWord);
		//close �� �ʿ䵵 ����. �˾Ƽ� �ڱⰡ close ���ش� 
		
		return list;
	}

}
