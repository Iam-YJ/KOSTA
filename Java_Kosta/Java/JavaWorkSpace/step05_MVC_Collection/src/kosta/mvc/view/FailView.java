package kosta.mvc.view;
/**
 * 결과가 실패했을 때, 예외가 발생했을때
 * 오류메세지 출력
 */
public class FailView {
	
	public FailView() {
		
	}
	
	public static void errorMessage(String message) {
		System.out.println(message);
	}

}
