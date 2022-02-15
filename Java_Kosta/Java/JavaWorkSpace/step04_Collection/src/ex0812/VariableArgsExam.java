package ex0812;

public class VariableArgsExam {

	public void test(Object... i) {
		// ... 은 인수가 안들어와도 ~ 무한대까지의 범위
		// 인수를 0개 이상 허용 가능
		System.out.println("호출됨");

		for (int index = 0; index < i.length; index++) {
			System.out.print(i[index] + "\t");
		}
		System.out.println();
		// 사용은 배열처럼 하면 된다
	}

	public void test2(String s, int ...i) {
		System.out.println("test2 호출됨");
		
		for(int index = 0; index < i.length; index++) {
			System.out.print(i[index] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VariableArgsExam va = new VariableArgsExam();
		va.test(3);
		va.test();
		va.test(2, 4, 3);
		va.test(3, 1, 5, 3, 67, 2);
		va.test("1", "ddd", "333", "Asdf");
		System.out.println();
		
		va.test2("w", 1,2,3,4,3);
		

	}

}
