package Shop;

/*
 * 사용자 정의 Exceptioin
 *  : 사용자가 만든 클래스가 예{외의 종류가 되기 위해서 반드시 
 *  	XxxException 객체 중의 하나를 상속받는다.
 *  
 *  : 예외 종류
 *  	1) 체크 Exception
 *  	2) 비체크 Exception - RuntimeException 하위 클래스 (실행도중 발생)
 *  
 * */

public class ExceptionExam extends Exception {

	public ExceptionExam() {
	}

	public ExceptionExam(String s) {
		super(s);
	}

}
