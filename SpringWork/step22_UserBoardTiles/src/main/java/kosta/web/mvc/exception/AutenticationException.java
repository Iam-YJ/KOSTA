package kosta.web.mvc.exception;

/**
 * 인증(로그인)에 실패 했을 때
 *
 */
public class AutenticationException extends RuntimeException {
	
	public AutenticationException() {
		
	}
	
	public AutenticationException(String message) {
		super(message);
	}
	

}
