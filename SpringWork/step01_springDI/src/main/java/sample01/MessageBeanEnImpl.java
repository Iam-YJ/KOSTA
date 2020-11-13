package sample01;

public class MessageBeanEnImpl implements MessageBean {
	
	public MessageBeanEnImpl() {
		System.out.println("MessageBeanEnImpl 생성자");
	}

	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+" nice to meet you and you?");
	}

}
