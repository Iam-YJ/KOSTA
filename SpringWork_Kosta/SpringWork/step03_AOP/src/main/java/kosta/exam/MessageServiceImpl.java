package kosta.exam;

import org.springframework.stereotype.Service;

@Service("target") //id = "messageServiceImpl"
public class MessageServiceImpl implements MessageService {

	@Override
	public void korHello() {
		System.out.println("MessageServiceImpl의 korHello() 메소드의 핵심 기능입니다");

		try {

			Thread.sleep(1000);

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		System.out.println("korHello 안에서 engHello 호출해보기 ----------------");
		//engHello()를 호출해본다
		//this.engHello();
		//여기서 직접 호출하면 AOP가 인식을 못함. (타겟대상이 타겟대상을 직접 호출시 불가능)
		//이럴 때에는 현재 AOP proxy Server에서 직접 호출을 요청한다 
		
		//MessageService service = (MessageService)AopContext.currentProxy(); //AopContext.currentProxy()를 통해 호출해야함 -> 다운캐스팅 
		//service.engHello();
		
	}

	@Override
	public void engHello() {
		System.out.println("MessageServiceImpl의 engHello() 메소드의 핵심 기능입니다");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public String hello() {
		System.out.println("MessageServiceImpl의 String hello() 메소드의 핵심 기능입니다");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return "안냥";
	}

	@Override
	public int hello(String name) {
		System.out.println("MessageServiceImpl의 int hello() 메소드의 핵심 기능입니다");
		System.out.println(name);
		try {
			Thread.sleep(9000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return 5;
	}

}
