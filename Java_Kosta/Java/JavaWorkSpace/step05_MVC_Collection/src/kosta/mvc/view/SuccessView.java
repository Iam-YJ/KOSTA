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
	 * �Խ��� ������ �ش��ϴ� �Խù� ����ϱ�
	 */
	public static void printBoardByKind(String id, Map<String, Board> kindMap) {
		for (String kindKey : kindMap.keySet()) {
			System.out.println("----------" + kindKey + " ���� �Խù� LIST ----------");
			for (String keyNo : kindMap.keySet()) {
				Board board = kindMap.get(keyNo);
				System.out.println("key : " + keyNo + "\t");
				System.out.println("[ " + board + "]");
			}
		}
	}

	/**
	 *�Խ��� ������ �ִ� �۹�ȣ�� �ش��ϴ� �Խù� �˻� 
	 */
	public static void printBoardByNo(Board board) {
		
		System.out.println(board);

	}

	public static void printMessage(String message) {
		System.out.println(message);

	}

}
