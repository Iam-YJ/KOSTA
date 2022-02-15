package kosta.mvc.view;

import java.util.Map;
import java.util.TreeMap;

import kosta.mvc.model.dto.Board;
import kosta.mvc.model.service.BoardServiceImpl;

public class SuccessView {
	Map<String, Map<String, Board>> allMap = new TreeMap<String, Map<String, Board>>();

	public SuccessView() {

	}

	public static void printBoard(Map<String, Map<String, Board>> allMap) {
		for (String kindKey : allMap.keySet()) {
			System.out.println("****" + kindKey + "Board LIST ***************");
			Map<String, Board> kindMap = allMap.get(kindKey);
			for (String keyNo : kindMap.keySet()) {
				Board board = kindMap.get(keyNo);
				System.out.print("key : " + keyNo + "\t");
				System.out.println("[ " + board + "]");
			}
			System.out.println();
		}

	}

	/**
	 * 게시판 유형에 해당하는 게시물 출력하기
	 */
	public static void printBoardByKind(String id, Map<String, Board> kindMap) {
		for (String kindKey : kindMap.keySet()) {
			System.out.println("----------" + kindKey + " 유형 게시물 LIST ----------");
			for (String keyNo : kindMap.keySet()) {
				Board board = kindMap.get(keyNo);
				System.out.println("key : " + keyNo + "\t");
				System.out.println("[ " + board + "]");
			}
		}
	}

	/**
	 *게시판 유형에 있는 글번호에 해당하는 게시물 검색 
	 */
	public static void printBoardByNo(Board board) {
		
		System.out.println(board);

	}

	public static void printMessage(String message) {
		System.out.println(message);

	}

}
