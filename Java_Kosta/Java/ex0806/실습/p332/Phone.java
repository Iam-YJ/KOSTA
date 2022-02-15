package p332;

public abstract class Phone {
	public String owner;

	public Phone(String owner) {
		super();
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("폰전원을켭니다.");
	}
	public void turnOff() {
		System.out.println("폰전원을끕니다.");
	}
	

}
