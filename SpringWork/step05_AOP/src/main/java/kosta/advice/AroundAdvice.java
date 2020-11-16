package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * 
 * 사전, 사후 처리 담당
 *
 */
@Service("arAdvice")
@Aspect
public class AroundAdvice {

	@Around("pointCutClass.aa()") //pointCutClass에 있는 aa()를 잡는다
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("around의 사전 처리 중입니다");
		Object obj = joinPoint.proceed();

		System.out.println("around의 사후 처리 중입니다.");

		return obj;
	}

}
