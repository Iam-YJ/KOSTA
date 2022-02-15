package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.Reply;

public class SuccessView {

	public SuccessView() {
	}

	/**
	 * ��üȭ�鿡 ���ڵ� ����ϱ�
	 */
	public static void selectPrint(List<BoardDTO> boardDTO) {
		System.out.println("selectPrint �Լ� ��");

		for (BoardDTO d : boardDTO) {
			System.out.println(d);
		}

	}

	public static void selectByNoPrint(BoardDTO boardDTO) {
		System.out.println("selectByNoPrint �Լ� ��");
		System.out.println(boardDTO);

	}

	/**
	 * ����, ����, ���, ���� �޼��� ���
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	/**
	 * ��� ���� ����ϱ�
	 */
	public static void printReplyBoard(BoardDTO boardDTO) {
		System.out.println(boardDTO);

		for (Reply reply : boardDTO.getReplyList()) {
			System.out.println("\t ��" + reply);
		}

	}

}
