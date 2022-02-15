package sample01;

public class MessageBeanKoImpl implements MessageBean {

	
	public MessageBeanKoImpl() {
		System.out.println("MessageBeanKoImpl 생성자");
	}
	
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " 반가워용");
	}

}
