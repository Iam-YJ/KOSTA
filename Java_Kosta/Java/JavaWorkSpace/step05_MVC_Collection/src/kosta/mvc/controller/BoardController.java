package kosta.mvc.controller;

import java.util.Map;

import kosta.mvc.model.dto.Board;
import kosta.mvc.model.exception.InexistentException;
import kosta.mvc.model.service.BoardService;
import kosta.mvc.model.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardController {
	private static BoardService boardService = BoardServiceImpl.getInstance();

	public BoardController() {

	}

	public static void getAllBoard() {
		try {
			Map<String, Map<String, Board>> allBoardList = boardService.getBoardList();
			SuccessView.printBoard(allBoardList);
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void getBoardByKind(String kind) {
		try {
			Map<String, Board> KindMap = boardService.getBoardByKind(kind);
			SuccessView.printBoardByKind(kind, KindMap);
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	public static void getBoardByno(String kind, int no) {
		try {
			Board board = boardService.getBoardByNo(kind, no);
			SuccessView.printBoardByNo(board);
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void insertBoard(String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);
			// void - ��ȯ�ϴ� ����� ����
			// ���ܰ� �߻����� ������ �ƹ��� ������ ���ٴ� ��
			SuccessView.printMessage("��ϵǾ����ϴ�.");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void deleteBoard(String kind, int no) {
		try {
			boardService.deleteBoard(kind, no);
			SuccessView.printMessage("�����Ǿ����ϴ�.");
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	
	public static void updateBoard(Board board, String kind) {
		try {
			boardService.updateBoard(board, kind);
			SuccessView.printMessage("�����Ǿ����ϴ�.");
		} catch (InexistentException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

}
