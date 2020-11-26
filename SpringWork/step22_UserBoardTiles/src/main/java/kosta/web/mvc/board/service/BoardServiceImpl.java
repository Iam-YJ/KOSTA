package kosta.web.mvc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.web.mvc.board.dto.ElectronicsDTO;
import kosta.web.mvc.board.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		// TODO Auto-generated method stub
		return null;
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
