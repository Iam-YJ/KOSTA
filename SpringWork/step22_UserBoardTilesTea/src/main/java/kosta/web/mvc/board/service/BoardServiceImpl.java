package kosta.web.mvc.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.web.mvc.board.dto.ElectronicsDTO;
import kosta.web.mvc.board.repository.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		return boardDAO.selectAll();
	}//selectAll


	@Override
	public int insert(ElectronicsDTO electronics) {
		int result = boardDAO.insert(electronics);
		if(result==0) throw new RuntimeException("등록되지 않았습니다...");
		return result;
	}//insert


	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		if(state) {
			int result = boardDAO.readnumUpdate(modelNum);
			if(result==0)throw new RuntimeException("조회수 증가에 오류가 발생했습니다.");
		}
		
		ElectronicsDTO electroincs =boardDAO.selectByModelNum(modelNum);
		if(electroincs==null) throw new RuntimeException(modelNum+"에 대한 정보검색에 오류가 있습니다.");
		
		return electroincs;
	}

	

	@Override
	public int delete(String modelNum, String password, String savePath) {
		//비밀번호 체크
		ElectronicsDTO dbElec = boardDAO.selectByModelNum(modelNum);
		
		if(!dbElec.getPassword().equals(password.trim())) {
			throw new RuntimeException("비밀번호 오류입니다...");
		}
		
		int result = boardDAO.delete(modelNum, password);		
		if(result==0)throw new RuntimeException("삭제되지 않았습니다.");
		
		//삭제완료후... 파일이 있는경우의 레코드라면 폴더에서 파일도 삭제한다.
		if(dbElec.getFname()!=null) {
			//폴더에서 삭제한다.
			File file = new File(savePath +"/"+dbElec.getFname());
			file.delete();
		}
		
		return result;
	}

	@Override
	public int update(ElectronicsDTO electronics) {
		//비밀번호 같은지 체크...
		ElectronicsDTO dbElec=
			boardDAO.selectByModelNum(electronics.getModelNum());
		if(!dbElec.getPassword().equals(electronics.getPassword())){
			throw new RuntimeException("비밀번호 오류입니다.");
		}
		
		int re = boardDAO.update(electronics);
		if(re==0)throw new RuntimeException("수정되지 않았습니다.");
		
		return re;
	}

}//BoardServiceImpl