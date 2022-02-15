package kosta.repository;

import java.util.List;

import kosta.dto.ProductList;

public class EndView {
	/**
	 * 전체 검색 또는 조건 검색에 출력하기
	 */
	public static void selectPrint(List<ProductList> list) {
		for(ProductList pro : list) {
			System.out.println(pro);
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
