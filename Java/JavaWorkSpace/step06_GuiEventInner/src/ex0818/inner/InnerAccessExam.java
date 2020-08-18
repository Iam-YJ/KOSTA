package ex0818.inner;

/**
 * Inner Class 정리 - 선언 위치에 따라 3가지 형태 1) 인스턴스 멤버 클래스 2) 정적(static) 멤버 클래스 3)
 * 로컬(메소드 내부에 선언) 클래스
 */
class Test {
	int a = 50;
	static int b = 10;

	public void testMethod() {
	}

	public static void testMethod2() {
	}

	/**
	 * 1)인스턴스 멤버 클래스 : inner 클래스 내부에 static 변수, 메소드 선언 불가 : Outer 쪽에 있는 static,
	 * non-static 모두 접근(호출) 가능하다. : inner 클래스 앞에 public, protected, 생략, private 올 수
	 * 있다.
	 */
	class InstanceInner {
		int a = 100;

		// static int b = 50;
		public void aa() {
			System.out.println(a);
			System.out.println(this.a);
			System.out.println(Test.this.a); // Outer 클래스 쪽의 변수를 불러오고 싶을 때
			System.out.println(b);

			testMethod();
			testMethod2();

		}
		// public static void bb() {}
	}

	/**
	 * 2) 정적(static) 멤버클래스 : static, non-static 모두 선언 가능. : Outer쪽의 non-static
	 * 접근(호출) 불가.
	 */
	static class StaticInner {
		int a = 40;
		static String name = "희정";

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
	 * 3) 로컬이너클래스 : static 선언 불가 : 제한자(접근제한자, static, final, abstract) 올 수 없다. :
	 * 로컬이너클래스는 반드시 메소드가 호출되고 그 메소드 안에서 이너클래스를 호출해야한다.
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

		}// 로컬이너클래스 끝
		LocalClass lc = new LocalClass();
		lc.aa();
	}// 메소드 끝

}// Outer 끝

public class InnerAccessExam {

	public static void main(String[] args) {

//		Test t = new Test();
//		Test.InstanceInner instanceInner = t.new InstanceInner();
//		instanceInner.aa();

		// 2. static 멤버 이너클래스 호출
//		Test.StaticInner stInner = new Test.StaticInner();
//		stInner.aa();

		// 3. Local 클래스 호출하기
		Test t = new Test();
		t.outerMethod();

	}

}
