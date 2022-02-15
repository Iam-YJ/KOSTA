package sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample06/springDIList02.xml");
		
		//sample 06 예제 check
		// 1. 외부 properties 파일 위치 설정하고 사용하는 방법
		// 2. xml 문서 여러개 만들어서 import하는 방법
		// 3. collection 형태 주입하는 방법
		// 4. namespace 중 context, p 알아보기

	}

}
