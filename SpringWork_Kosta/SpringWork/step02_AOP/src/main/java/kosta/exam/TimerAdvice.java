package kosta.exam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * around 방식
 * - 사전 : 현재 시간 구하기
 * - 사후 : 현재 시간 구하기, (사후시간 - 사전시간 = 총 소요 시간)
 *
 * - joinPoint : 기본 메소드에 대한 시그니처 정보를 제공한다 (타겟대상의 메소드에 대한 정보)
 * 					(modifier, 리턴타입, 메소드이름, 인수 ... 정보제공)
 * - ProceedingJoinPoint : joinPoint를 확장한 개념으로 실제 joinPoint를 호출 할 수 있는 메소드를 제공한다 
 * 
 * 즉, around 방식을 사용할 때는 ProceedingJoinPorint를 이용해서 타겟대상 호출 필요
 * 
 * 리턴타입 : Object -> proceed() 메소드를 호출한 후 그 메소드가 리턴한 값을 받아서 다시 리턴해준다.
 */
public class TimerAdvice {

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//사전 처리
		
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG] "+methodName+"호출되기 전 사전처리");
		
		StopWatch sw = new StopWatch();
		sw.start();

		
		// 타겟 대상인 메소드(joinPoint)를 호출한다
		Object obj = joinPoint.proceed(); //이것은 serviceImpl에 있는 메소드들의 리턴 타입을 받음. 그래서 object로 받는다
		
		
		//사후 처리
		sw.stop();
		System.out.println("[LOG] "+methodName+"호출된 후 사후처리");
		System.out.println("[LOG] "+methodName+"의 리턴값 obj "+obj);
		System.out.println("[LOG] "+methodName+"의 총 실행 시간 "+ sw.getTotalTimeMillis()+" ms");
		
		return obj;
		
		
	}
}


