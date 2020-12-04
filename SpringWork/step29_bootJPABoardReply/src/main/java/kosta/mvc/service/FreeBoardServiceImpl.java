package kosta.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kosta.mvc.domain.FreeBoard;
import kosta.mvc.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional //이 안에 들어오는 모든 것들에 대해서 트렌젝션 처리중 
public class FreeBoardServiceImpl implements FreeBoardService {
	
	private final BoardRepository boardRepo;

	@Override
	public List<FreeBoard> selectAll() {
		List<FreeBoard> list = boardRepo.findAll();
		return list;
	}

	@Override
	public Page<FreeBoard> selectAll(Pageable page) {
		
		return boardRepo.findAll(page);
	}

	@Override
	public void insert(FreeBoard board) {
		boardRepo.save(board);

	}

	@Override
	public FreeBoard selectBy(Long bno, boolean state) {

		if(state) {
			//조회수 증가 - update call
			boardRepo.readnumUpdate(bno); //readnumUpdate는 내가 BoardRepository에서 새로 만듦
		}
		return boardRepo.findById(bno).orElse(null);
		

	}

	@Override
	public void update(FreeBoard board) {
		FreeBoard dbBoard = boardRepo.findById(board.getBno()).orElse(null);
		if(dbBoard == null || !dbBoard.getPassword().equals(board.getPassword())) {
			throw new RuntimeException("비밀번호나 글번호 오류로 수정 실패 ");
		}
		
		dbBoard.setSubject(board.getSubject());
		dbBoard.setContent(board.getContent());
	}

	@Override
	public void delete(Long bno, String password) {
		FreeBoard dbBoard = boardRepo.findById(bno).orElse(null);
		if(dbBoard == null || !dbBoard.getPassword().equals(password)) {
			throw new RuntimeException("비밀번호나 글번호 오류로 수정 실패 ");
		}
		
		boardRepo.deleteById(bno);
		
	}

}
