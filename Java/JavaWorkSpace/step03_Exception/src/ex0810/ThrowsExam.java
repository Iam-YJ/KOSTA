package ex0810;

class Test {
	public void aa(int i) throws ArithmeticException {
		System.out.println("aa() 메소드 호출됨");
		try {
			this.bb(i);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage() + "발생했어요");
		}
		System.out.println("aa() 메소드 호출 끝");
	}

	public void bb(int i) {
		System.out.println("bb() 메소드 호출됨");
		try {
			int result = 100 / i;
			System.out.println("나눈 결과 : " + result);
		} finally {
			System.out.println("bb() 메소드 호출 끝");
		}
	}
}

public class ThrowsExam {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("***** 메인 시작함 *****");
		Test t = new Test();
		try {
			t.aa(0);
		} catch (ArithmeticException | NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("***** 메인 종료함 *****");
	}

}
