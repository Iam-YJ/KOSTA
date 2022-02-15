package kosta.web.mvc.board.repository;

import java.io.File;
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

		BoardMapper mapper = session.getMapper(BoardMapper.class);
		List<ElectronicsDTO> dbDTO = mapper.selectAll();
		
		return dbDTO;
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ElectronicsDTO dbDTO = mapper.selectByModelNum(modelNum);
		
		return dbDTO;
	}

	@Override
	public int readnumUpdate(String modelNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ElectronicsDTO electronics) {
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.insert(electronics);
		
		return result;
	}

	@Override
	public int delete(String modelNum, String password, String savePath) {
		// TODO Auto-generated method stub
		

		return 0;
	}

	@Override
	public int update(ElectronicsDTO electronics) {
		// TODO Auto-generated method stub
		return 0;
	}

}
