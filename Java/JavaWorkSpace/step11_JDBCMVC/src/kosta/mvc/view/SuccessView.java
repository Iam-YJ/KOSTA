package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.Reply;

public class SuccessView {

	public SuccessView() {
	}

	/**
	 * 전체화면에 레코드 출력하기
	 */
	public static void selectPrint(List<BoardDTO> boardDTO) {
		System.out.println("selectPrint 함수 안");

		for (BoardDTO d : boardDTO) {
			System.out.println(d);
		}

	}

	public static void selectByNoPrint(BoardDTO boardDTO) {
		System.out.println("selectByNoPrint 함수 안");
		System.out.println(boardDTO);

	}

	/**
	 * 수정, 삭제, 등록, 성공 메세지 출력
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	/**
	 * 댓글 정보 출력하기
	 */
	public static void printReplyBoard(BoardDTO boardDTO) {
		System.out.println(boardDTO);

		for (Reply reply : boardDTO.getReplyList()) {
			System.out.println("\t ㄴ" + reply);
		}

	}

}
