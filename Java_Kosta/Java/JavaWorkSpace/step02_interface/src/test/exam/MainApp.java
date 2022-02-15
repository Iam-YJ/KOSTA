package test.exam;

public class MainApp {

	public static void main(String[] args) {
		// Tv 2대 , Audio 2대 저장하고 그 정보를 출력한다.
		ElecFunction elec[] = new ElecFunction[5];

		elec[0] = new Tv("A01", 500000, 12);
		elec[1] = new Tv("A02", 2500, 20);
		elec[2] = new Tv("A03", 3000, 30);

		elec[3] = new Audio("A04", 8500, 200);
		elec[4] = new Audio("A05", 700, 100);

		for (ElecFunction e : elec) { //다형성 
			 e.start();
			 //interface를 통해서 기능 호출 
			 //-> 실제 구현되어있는 sub class 에서 알아서 호출됨
			 //다운캐스팅 하지 않아도 됨 
			 
			 //interface를 통해 접근하면 알아서 그 아래 class의 method 불러줌
			System.out.println(e);
		}

	}
}
