package ex0812;

public class VariableArgsExam {

	public void test(Object... i) {
		// ... �� �μ��� �ȵ��͵� ~ ���Ѵ������ ����
		// �μ��� 0�� �̻� ��� ����
		System.out.println("ȣ���");

		for (int index = 0; index < i.length; index++) {
			System.out.print(i[index] + "\t");
		}
		System.out.println();
		// ����� �迭ó�� �ϸ� �ȴ�
	}

	public void test2(String s, int ...i) {
		System.out.println("test2 ȣ���");
		
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
