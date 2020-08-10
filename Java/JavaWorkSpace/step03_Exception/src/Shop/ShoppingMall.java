package Shop;

public class ShoppingMall {

	private int age;

	public void ageCheck(int age) throws ExceptionExam {
		System.out.print("나이\t" + age + "\t");
		if (age < 18) {
			// 예외를 발생시킨다
			ExceptionExam ee = new ExceptionExam("애들은 가라");
			throw ee; // 에러 발생하면 -> ExceptionExam으로 던져!
			// throw new ExceptionExam("애들은 가라"); - 한문장 축약

		} else {
			System.out.println("입장하신걸 환영합니다");
		}
	}
}
