package kosta.repository;

import java.util.Arrays;
import java.util.List;

import kosta.dto.ProductList;


public class ProductMainView {
  public static void main(String[] args) {
	  
	  List<ProductList> list = null;
	  
	  /**
	   * [1]. 레코드 삽입
	   * */
	  System.out.println("********** [1] 상품 등록하기 ******************");
	  
	  
	  /**
	   * [2].   ex) select * from productList
	   *         ex)  select * from productList where 검색필드 like  검색단어
	   *          ex) select *from productList order by 정렬대상
	   *          ex) select * from productList where 검색필드 like  검색단어  order by 정렬대상
	   * */
	  System.out.println("********** [2] 모든 게시물 검색 또는 조건에 따른 검색 및 정렬 ******************");
		/*
		 * NAME, PRICE
		 * 
		 * code VARCHAR2(50) PRIMARY KEY, name VARCHAR2(50), qty INT, price INT, detail
		 * VARCHAR2(100)
		 */
		
		
		/*
		 * list = ProductDAO.ifTest(null); EndView.selectPrint(list);
		 * 
		 * list = ProductDAO.ifTest(new ProductList(null, "새우깡",0, 0, null));
		 * EndView.selectPrint(list);
		 * 
		 * list = ProductDAO.ifTest(new ProductList(null, null,0, 1000, null));
		 * EndView.selectPrint(list);
		 * 
		 * list = ProductDAO.ifTest(new ProductList(null, "감자깡",0, 100, null));
		 * EndView.selectPrint(list);
		 */
		 
	  
	  
	  /**
	   * [3].  parameter 정보에 따라 레코드 수정한다.
	   *     상품코드에 해당하는 상품의 
	   *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정하데 
	   *     parameter 의 정보가 있는 데이터만 수정한다.
	   * 
	   * */
	  System.out.println("********** [3] 상품 수정하기 ******************");
	  boolean result = false;
	  
		/*
		 * result = ProductDAO.updateTest(new ProductList("A01", "깡깡깡",10, 10, "깡깡쓰"));
		 * 
		 * if(result) { EndView.message("수정 성공"); }else { EndView.message("수정 실패"); }
		 */
	  
		/*
		 * result = ProductDAO.updateTest(new ProductList("A01", null,10, 10, "깡깡쓰"));
		 * 
		 * if(result) { EndView.message("수정 성공"); }else { EndView.message("수정 실패"); }
		 */
	  
	  /**
	   * [4].상품코드에 해당하는 레코드 삭제
	   * */
	  System.out.println("********** [4] 상품 삭제하기 ******************");
		/*
		 * result = ProductDAO.deleteTest(new ProductList("A07", null,0, 0, null));
		 * 
		 * if(result) { EndView.message("삭제 성공"); }else { EndView.message("삭제 실패"); }
		 */
	  
		
		/*
		 * result = ProductDAO.deleteTest(new ProductList("A01", null,0, 0, null));
		 * 
		 * if(result) { EndView.message("삭제 성공"); }else { EndView.message("삭제 실패"); }
		 */
		 
	  
	  
	 /**
	  * [5]. 모든 상품의 개수를 출력한다.

		  select sum(p_qty) from product -- 모든상품의 qty의총합계
	  * */
	  System.out.println("********** [5] 등록된 총 상품 개수 ******************");
	  int sum = 0;
	  
		/*
		 * sum = ProductDAO.sumTest(new ProductList(null, null,1, 0, null));
		 * 
		 * System.out.println("총 상품 개수는 : "+sum);
		 */
	  


	  /**
	   * [6]. parameter의 상품코드에 해당하는 레코드 검색
	   * ex)select * from productList where in 상품코드 in (?,?,...)
	   * */
	  System.out.println("********** [6] 상품코드에 해당하는 레코드 검색 ******************");
	  
	  	list = ProductDAO.forEachTest(Arrays.asList("A02","A09"));
	  	EndView.selectPrint(list);

}
}







