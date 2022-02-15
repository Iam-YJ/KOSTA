package kosta.main;

import java.util.List;

import kosta.dto.EmpDTO;

public class EndView {
	/**
	 * 전체 검색 또는 조건 검색에 출력하기
	 */
	public static void selectPrint(List<EmpDTO> list) {
		for(EmpDTO emp : list) {
			System.out.println(emp);
		}
		System.out.println();
	}
	
	
	/**
	 * 메세지 출력
	 */
	public static void message(String msg) {
		System.out.println(msg);
	}

}
