package kosta.test.advice;

import java.io.File;
import java.io.FileWriter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service("logAdvice")
@Aspect
public class LogAdvice {
	File file = new File("log.txt");

	public LogAdvice() {

	}
	@Around("execution(* kosta..*Impl.*(..))") 
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();

		StopWatch sw = new StopWatch();
		sw.start();

		// 타겟 대상인 메소드(joinPoint)를 호출한다
		Object obj = joinPoint.proceed(); // 이것은 serviceImpl에 있는 메소드들의 리턴 타입을 받음. 그래서 object로 받는다
		Object[] params = joinPoint.getArgs();

		// 사후 처리
		sw.stop();
		try {
			FileWriter fw = new FileWriter(file,true);
			fw.write(methodName + "호출 / 인수 개수 : " + params.length + " / 리턴값 : " + obj + "/ 총 실행 시간"
					+ sw.getTotalTimeMillis() + "ms");
			fw.write("\n");
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * System.out.println(methodName + "호출 / 인수 개수 : " + params.length + " / 리턴값 : "
		 * + obj + "/ 총 실행 시간" + sw.getTotalTimeMillis() + "ms"); System.out.println();
		 */
		return obj;
	}

}
