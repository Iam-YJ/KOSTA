package ch07;

public class SnowTireExample {
	public static void main(String [] args) {
		
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;
		
		snowTire.run();
		// snowtire 
		// �����ڰ� �ƴ϶� method �̱� ������
		// super() �� ������ ���� �ƴϴ�.
		
		
		tire.run();
		// snowtire
		// �����ǵ� �޼ҵ�� �θ�Ÿ���̿��� �ڽ�Ÿ���� ȣ��ȴ�.
		
		
	}

}

//8-2
