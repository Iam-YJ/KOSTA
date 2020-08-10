package ch07;

public class SnowTireExample {
	public static void main(String [] args) {
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		// snowtire 
		// 생성자가 아니라 method 이기 때문에
		// super() 가 생략된 것이 아니다.
		
		
		tire.run();
		// snowtire
		// 재정의된 메소드는 부모타입이여도 자식타입이 호출된다.
		
		
	}

}

//8-2
