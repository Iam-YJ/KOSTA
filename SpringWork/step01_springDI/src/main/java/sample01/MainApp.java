package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1. 기존 방식
		/*
		 * MessageBean bean = new MessageBeanEnImpl(); bean.sayHello("yujin");
		 * 
		 * bean = new MessageBeanKoImpl(); bean.sayHello("유지닝");
		 */
		
		//2. spring container 이용(IoC 개념 적용)
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("sample01/applicationContext.xml");
		 * 
		 * MessageBean bean = context.getBean("en", MessageBean.class);
		 * bean.sayHello("park");
		 * 
		 * bean = context.getBean("ko", MessageBean.class); bean.sayHello("융징이");
		 * 
		 * System.out.println("------------------");
		 * 
		 * MessageBean bean2 = context.getBean("ko",MessageBean.class);
		 * System.out.println("bean = "+bean); System.out.println("bean2 = "+bean2);
		 */
		
		
		//applicationContext.xml에서 scope를 prototype으로 바꿈
		/**
		 * ApplicationContext 
		 *  : BeanFactory(객체 생성 + 소멸)의 확장개념(다국어 지원, 메세지 처리)
		 *  : 객체를 사전 초기화(미리 메모리에 할당한다 <- scope = "singleton"
		 *  : 만약, 지연초기화(필요할 때마다 새롭게 생성) <- scope = "prototype" 변경
		 *  	이렇게 설정하면 getBean을 요청할 때마다 새로운 객체를 생성해준다.
		 */
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("sample01/applicationContext.xml"); //진짜 실행되는 파일 기준
				new FileSystemXmlApplicationContext("src/main/java/sample01/applicationContext.xml"); //프로젝트 기준
				
		MessageBean bean = context.getBean("en", MessageBean.class);
		
		  bean.sayHello("park");
		  
		  bean = context.getBean("ko", MessageBean.class); 
		  bean.sayHello("융징이");
		  
		 
		 
		
		
	}

}
