package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public class SuccessView {

	public SuccessView() {
	}

	public static void selectPrint(List<BoardDTO> boardDTO) {
		System.out.println("selectPrint 함수 안");
		
		for(BoardDTO d :  boardDTO) {
			System.out.println(d);
		}
		
	}
	
	public static void selectByNoPrint(BoardDTO boardDTO) {
		System.out.println("selectByNoPrint 함수 안");
		System.out.println(boardDTO);
		
	}
	
	public void messagePrint(String message) {
		System.out.println(message);
	}
	
	
}
