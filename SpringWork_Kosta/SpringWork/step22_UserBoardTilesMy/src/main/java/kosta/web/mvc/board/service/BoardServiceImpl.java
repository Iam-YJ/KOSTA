package kosta.web.mvc.board.service;

import java.util.List;

import javax.management.RuntimeErrorException;

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
		List<ElectronicsDTO> list = boardDAO.selectAll();
		return list;
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		
		if(state) {
			int result = boardDAO.readnumUpdate(modelNum);
			if(result==0) throw new RuntimeException("오류입니다");
		}
		
		ElectronicsDTO elec = boardDAO.selectByModelNum(modelNum);
		
		return elec;
	}

	@Override
	public int insert(ElectronicsDTO electronics) {
		int result = boardDAO.insert(electronics);
		if(result ==0 )throw new RuntimeException("등록되지 않았습니다");
		return result;
	}

	@Override
	public int delete(String modelNum, String password, String savePath) {
		// TODO Auto-generated method stub
		
		//삭제완료 후.. 파일이 있는 경우의 레코드라면 폴더에서 파일도 삭제한다
//		파일 삭제하는 것 
//		if(dbElec.getFname()!=null) {
//			File file = new File(savePath+"/"+dbElec.getFname());
//			file.delete();
//		}
		
		return 0;
	}

	@Override
	public int update(ElectronicsDTO electronics) {
		// TODO Auto-generated method stub
		return 0;
	}

}
