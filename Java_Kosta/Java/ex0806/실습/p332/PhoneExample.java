package p332;

public class PhoneExample {

	public static void main(String[] args) {
		//abstract class는 생성해서 사용하지 못하므로
		//Phone phone=new Phone();이 불가하다.
		
		SmartPhone smartPhone=new SmartPhone("홍길동");
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
		

	}

}
