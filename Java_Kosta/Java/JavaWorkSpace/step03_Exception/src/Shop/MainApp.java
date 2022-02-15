package Shop;

import java.util.Random;

public class MainApp {

	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***** Shop Open *****");

		ShoppingMall sm = new ShoppingMall();
		Random r = new Random();

		for (int i = 0; i < 10; i++) {

			// r.nextInt(55) // 0~54 사이의 난수 발생

			try {
				sm.ageCheck(r.nextInt(56) + 1);
			} catch (ExceptionExam e) {
				// TODO Auto-generated catch block
				count++;
				System.out.println(e.getMessage());

			}
		}
		System.out.println();
		System.out.println("총 예외 갯수\t" + count);

		System.out.println("***** Shop Close *****");
	}

}
