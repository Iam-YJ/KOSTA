package p332;

public class Dog extends Animal {//생성불가 상속가능
	public  Dog() {
		this.kind="포유류";
	}

	@Override
	public void sound() {
		System.out.println("멍멍");

	}

}
