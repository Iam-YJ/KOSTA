package ex1023.log.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log = LogFactory.getLog(getClass());
	
	public void test() {
		//로그 기록 
		log.trace("trace에 관련된 메세지 입니다.");
		log.debug("debug에 관련된 메세지 입니다.");
		log.info("info에 관련된 메세지 입니다.");
		log.warn("warn에 관련된 메세지 입니다.");
		log.error("error에 관련된 메세지 입니다.");
		log.fatal("fatal에 관련된 메세지 입니다.");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("시작");
		LogTest t = new LogTest();
		t.test();
		System.out.println("끝");
	}

}
