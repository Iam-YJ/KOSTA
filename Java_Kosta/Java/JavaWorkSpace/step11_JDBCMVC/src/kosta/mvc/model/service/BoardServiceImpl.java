
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
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ� ");
		}
		return boardDTO;

	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> boardDTO = boardDAO.boardSelectBySubject(keyWord);
		if (boardDTO == null) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return boardDTO;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
		if (boardDTO == null) {
			throw new SQLException("�˻��� ���ڵ尡 �����ϴ�.");
		}
		return boardDTO;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		if (boardDAO.boardInsert(boardDTO) == 0) {
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		}
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		if (boardDAO.boardUpdate(boardDTO) == 0) {
			throw new SQLException("��ϵ��� �ʾҽ��ϴ�.");
		}

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		if (boardDAO.boardDelete(boardNo) == 0) {
			throw new SQLException("�������� �ʾҽ��ϴ�.");
		}

	}

	/**
	 * ��� ��������
	 */
	@Override
	public BoardDTO replySelectByNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.replySelectByNo(boardNo);
		if(boardDTO == null) {
			throw new SQLException(boardNo+"�� �۹�ȣ �߸��Ǿ����ϴ�.");
		}else if(boardDTO.getReplyList().size() == 0) {
			throw new SQLException(boardNo+"�� ����� �����ϴ�.");
		}
		
		return boardDTO;
	}

}

