package ch07;

public class SnowTireExample {
	public static void main(String [] args) {
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		// tire -> snowtire 
		tire.run();
		//tire
		
		//둘 다 오답인데 이유가 뭐지..?
	}

}

//8-2
