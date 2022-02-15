package kosta.advice;

import org.aspectj.lang.JoinPoint;

public class SampleAdvice {

	/**
	 * Before : 사전처리
	 */

	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] params = joinPoint.getArgs();

		System.out.println(methodName + "의 매개변수 개수 : " + params.length);
		if (params.length >= 0) {
			for (Object obj : params) {
				System.out.println(methodName + "의 인수 " + obj);
			}
		}
		System.out.println(methodName + "가 호출되기전 Before ");
		System.out.println("=====================================");
	}

	/**
	 * After : 사후처리 (예외발생 여부 상관없이 무조건)
	 */

	public void afterFinally() {
		System.out.println("after 예외발생여부 상관없이 실행됩니다");
		System.out.println("=====================================");

	}

	/**
	 * After-returning : 사후처리 (예외없이 정상동작 했을 떄)
	 * 
	 * 인수 Object는 joinPoint 대상이 실행된 후 리턴한 값을 받는 매개변수
	 * 	인수의 obj 이름은 xml의 설정의 returning="obj"와 동일해야한다
	 */

	public void afterReturning(JoinPoint point, Object obj) {
		String methodName = point.getSignature().getName();
		System.out.println(methodName + "이 리턴한 값은 " + obj);
		System.out.println("예외없이 정상적으로 동작했을 때 afterReturning ");

		System.out.println("=====================================");
	}

	/**
	 * After-throwing : 사후처리 (예외가 발생했을 때)
	 * 
	 * 인수 Throwable 은 예외에 대한 정보를 매개변수로 전달 받는다
	 * 	인수 e는 xml의 설정 throwing="e"와 동일
	 */

	public void afterThrowing(Throwable e) {

		System.out.println("예외가 발생했을 때 afterThrowing ");
		System.out.println("예외 = " + e);

		System.out.println("=====================================");

	}
}
