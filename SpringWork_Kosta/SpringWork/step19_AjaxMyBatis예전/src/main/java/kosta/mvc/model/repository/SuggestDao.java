package kosta.mvc.model.repository;

import java.util.List;

public interface SuggestDao {
	
	/**
	 * ���޵� �ܾ�� �����ϴ� ���ڵ� �˻�
	 */
	
	List<String> suggestSelect(String keyWord);

}
