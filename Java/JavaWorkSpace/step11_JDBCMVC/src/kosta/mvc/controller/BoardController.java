package kosta.mvc.controller;

import java.sql.SQLException;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.service.BoardService;
import kosta.mvc.model.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardController {

	static BoardService boardService = new BoardServiceImpl();
	static BoardDTO boardDTO = new BoardDTO();

	public BoardController() {
	}

	public static void boardSelectByAll() {

		try {
			SuccessView.selectPrint(boardService.boardSelectAll());
		} catch (Exception e) {
			// e.printStackTrace(); //개발 단계에서 진짜 오류가 났을 때 이유를 자세하게 알 수 있다.
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardSelectBySubject(String str) {
		try {
			SuccessView.selectPrint(boardService.boardSelectBySubject(str));
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	// public static void selectByNoPrint(BoardDTO boardDTO)

	public static void boardSelectByNo(int i) {

		try {
			SuccessView.selectByNoPrint(boardService.boardSelectByNo(i));
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardInsert(BoardDTO board) {
		try {
			boardService.boardInsert(board);
			SuccessView.messagePrint("등록되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardUpdate(BoardDTO b) {
		try {
			boardService.boardUpdate(b);
			SuccessView.messagePrint("업데이트 되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardDelete(int i) {
		try {
			boardService.boardDelete(i);
			SuccessView.messagePrint("삭제되었습니다.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	/**
	 * 댓글 정보 가져오기
	 */
	public static void replySelectByNo(int boardNo) {

		try {
			BoardDTO boardDTO = boardService.replySelectByNo(boardNo);
			SuccessView.printReplyBoard(boardDTO);
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}
