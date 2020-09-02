package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;


public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO = new BoardDAOImpl();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		List<BoardDTO> boardDTO = boardDAO.boardSelectAll();
		if (boardDTO == null) {
			throw new SQLException("전체에서 게시물이 존재하지 않습니다.");
		}
		return boardDTO;
				
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> boardDTO = boardDAO.boardSelectBySubject(keyWord);
		if (boardDTO == null) {
			throw new SQLException("전체에서 게시물이 존재하지 않습니다.");
		}
		return boardDTO;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		// TODO Auto-generated method stub

	}

}
