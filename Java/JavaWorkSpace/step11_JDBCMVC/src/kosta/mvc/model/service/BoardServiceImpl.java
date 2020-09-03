
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
		if (boardDTO.size() == 0) {
			throw new SQLException("검색된 레코드가 없습니다 ");
		}
		return boardDTO;

	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> boardDTO = boardDAO.boardSelectBySubject(keyWord);
		if (boardDTO == null) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return boardDTO;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		if (boardDTO == null) {
			throw new SQLException("검색된 레코드가 없습니다.");
		}
		return boardDTO;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		if (boardDAO.boardInsert(boardDTO) == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		if (boardDAO.boardUpdate(boardDTO) == 0) {
			throw new SQLException("등록되지 않았습니다.");
		}

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		if (boardDAO.boardDelete(boardNo) == 0) {
			throw new SQLException("삭제되지 않았습니다.");
		}

	}

	/**
	 * 댓글 가져오기
	 */
	@Override
	public BoardDTO replySelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.replySelectByNo(boardNo);
		if(boardDTO == null) {
			throw new SQLException(boardNo+"는 글번호 잘못되었습니다.");
		}else if(boardDTO.getReplyList().size() == 0) {
			throw new SQLException(boardNo+"는 댓글이 없습니다.");
		}
		
		return boardDTO;
	}

}

