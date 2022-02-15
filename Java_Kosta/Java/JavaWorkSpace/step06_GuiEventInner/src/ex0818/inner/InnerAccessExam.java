package ex0818.inner;

/**
 * Inner Class ���� - ���� ��ġ�� ���� 3���� ���� 1) �ν��Ͻ� ��� Ŭ���� 2) ����(static) ��� Ŭ���� 3)
 * ����(�޼ҵ� ���ο� ����) Ŭ����
 */
class Test {
	int a = 50;
	static int b = 10;

	public void testMethod() {
	}

	public static void testMethod2() {
	}

	/**
	 * 1)�ν��Ͻ� ��� Ŭ���� : inner Ŭ���� ���ο� static ����, �޼ҵ� ���� �Ұ� : Outer �ʿ� �ִ� static,
	 * non-static ��� ����(ȣ��) �����ϴ�. : inner Ŭ���� �տ� public, protected, ����, private �� ��
	 * �ִ�.
	 */
	class InstanceInner {
		int a = 100;

		// static int b = 50;
		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(Test.this.a); // Outer Ŭ���� ���� ������ �ҷ����� ���� ��
			System.out.println(b);

			testMethod();
			testMethod2();

		}
		// public static void bb() {}
	}

	/**
	 * 2) ����(static) ���Ŭ���� : static, non-static ��� ���� ����. : Outer���� non-static
	 * ����(ȣ��) �Ұ�.
	 */
	static class StaticInner {
		int a = 40;
		static String name = "����";

		public void aa() {

			System.out.println(a);
			System.out.println(this.a);
			//System.out.println(Test.this.a);
			System.out.println(b);
			System.out.println(name);

			// testMethod1();
			testMethod2();

		}

		public static void bb() {
		}

	}

	/**
	 * 3) �����̳�Ŭ���� : static ���� �Ұ� : ������(����������, static, final, abstract) �� �� ����. :
	 * �����̳�Ŭ������ �ݵ�� �޼ҵ尡 ȣ��ǰ� �� �޼ҵ� �ȿ��� �̳�Ŭ������ ȣ���ؾ��Ѵ�.
	 */
	public void outerMethod() {
		class LocalClass {
			int a = 12;

			// static int b = 3;
			public void aa() {
				System.out.println(a);
				System.out.println(b);

			}
			// public static void bb() {}

		}// �����̳�Ŭ���� ��
		LocalClass lc = new LocalClass();
		lc.aa();
	}// �޼ҵ� ��

}// Outer ��

public class InnerAccessExam {

	public static void main(String[] args) {

//		Test t = new Test();
//		Test.InstanceInner instanceInner = t.new InstanceInner();
//		instanceInner.aa();

		// 2. static ��� �̳�Ŭ���� ȣ��
//		Test.StaticInner stInner = new Test.StaticInner();
//		stInner.aa();

		// 3. Local Ŭ���� ȣ���ϱ�
		Test t = new Test();
		t.outerMethod();

	}

}
