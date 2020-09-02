package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.service.BoardService;
import kosta.mvc.model.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;

public class BoardController {
	
	static BoardService bs = new BoardServiceImpl();
	static 	BoardDTO boardDTO = new BoardDTO(); 

	public BoardController() {
	}

	public static void boardSelectByAll() {
		
		try {
			SuccessView.selectPrint(bs.boardSelectAll());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardSelectBySubject(String str) {
		try {
			SuccessView.selectPrint(bs.boardSelectAll());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	//public static void selectByNoPrint(BoardDTO boardDTO)
	
	public static void boardSelectByNo(int i) {
	
		try {
			SuccessView.selectByNoPrint(boardDTO);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardInsert(BoardDTO boardDto) {
		try {
			SuccessView.selectPrint(bs.boardSelectAll());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardUpdate(BoardDTO b) {
		try {
			SuccessView.selectPrint(bs.boardSelectAll());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

	public static void boardDelete(int i) {
		try {
			SuccessView.selectPrint(bs.boardSelectAll());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}
