package ex1023.log.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
	Log log = LogFactory.getLog(getClass());
	
	public void test() {
		//�α� ��� 
		log.trace("trace�� ���õ� �޼��� �Դϴ�.");
		log.debug("debug�� ���õ� �޼��� �Դϴ�.");
		log.info("info�� ���õ� �޼��� �Դϴ�.");
		log.warn("warn�� ���õ� �޼��� �Դϴ�.");
		log.error("error�� ���õ� �޼��� �Դϴ�.");
		log.fatal("fatal�� ���õ� �޼��� �Դϴ�.");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����");
		LogTest t = new LogTest();
		t.test();
		System.out.println("��");
	}

}
