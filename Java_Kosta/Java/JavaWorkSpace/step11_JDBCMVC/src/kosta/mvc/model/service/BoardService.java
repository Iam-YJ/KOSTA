package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public interface BoardService {
	/**
	 * 모든 레코드 검색
	 */
	List<BoardDTO> boardSelectAll() throws SQLException;

	/**
	 * 제목에 특정문자열 포함한 레코드 검색
	 */
	List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;

	/**
	 * 글번호에 해당하는 레코드 검색
	 */
	BoardDTO boardSelectByNo(int boardNo) throws SQLException;

	/**
	 * 게시물 등록
	 */
	// sequence 썼기 때문에 글번호 중복될 일 x

	void boardInsert(BoardDTO boardDTO) throws SQLException;

	/**
	 * 게시물 수정
	 */
	void boardUpdate(BoardDTO boardDTO) throws SQLException;

	/**
	 * 게시물 삭제
	 */
	void boardDelete(int boardNo) throws SQLException;

	/**
	 * 글번호에 해당하는 댓글 정보 가져오기
	 */
	BoardDTO replySelectByNo(int boardNo) throws SQLException;
}
