package kosta.test.advice;

import org.aspectj.lang.annotation.Pointcut;

public class pointCutClass {

	@Pointcut("execution(* kosta.test.audio.*Impl.*(..)) ||execution(* kosta.test.tv.*Impl.*(..)) ")

	public void aa() {

	}

	/**
	 * 로그 pointCut
	 */

	/**
	 * 세션체크 pointCut
	 */

	/**
	 * transaction pointCut
	 */

}
