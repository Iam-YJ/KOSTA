package kosta.web.mvc.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.web.mvc.board.dto.ElectronicsDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<ElectronicsDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int readnumUpdate(String modelNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ElectronicsDTO electronics) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String modelNum, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ElectronicsDTO electronics) {
		// TODO Auto-generated method stub
		return 0;
	}

}
