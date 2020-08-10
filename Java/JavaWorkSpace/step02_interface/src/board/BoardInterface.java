package board;

/*
 *  interface
 *  : 여러 사람들이 작업할 때 공통의 규격서를 제공하고자 함 
 *  
 * */

public interface BoardInterface {
	
	//등록
	boolean insert(Board board);
	
	//글번호에 해당하는 레코드 검색하기
	Board selectByNo(int no);
	
	
	/*
	 * java 1.8 version 추가 - interface 영역에
	 * 
	 * 1) default 메소드
	 *    기능구현 가능
	 *    반드시 구현객체가 있어야만 접근 가능
	 *    
	 *  2)기능구현 가능
	 *    기능구현 가능
	 *    구현객체 없이 interface 이름.메소드이름() 접근
	 *    
	 *  *추가된 이유
	 *   : 이미 개발된 상태에서 유지보수 할 때 특정 구현객체에만 필요한 
	 *   	메소드를 정의하고 싶을 때 static or default 메소드를 이용하면 
	 *    	모든 구현객체가 재정의할 필요없이 필요한 곳에서만 재정의 하거나
	 *    	그 기능을 그냥 사용하면 된다.
	 *  
	 *  	 * */
	
	//삭제
	default boolean delete(int no) {
		System.out.println("BoardInterface의 delete(int no) 호출됨");
		return false;
	}
	//수정 
	static boolean update(Board board) {
		System.out.println("BoardInterface의 update() 호출됨");
		return true;
	}
}
