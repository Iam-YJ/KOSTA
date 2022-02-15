package ch09;

//import ch09.A1.B;

public class A {
	/*
	 * A() { System.out.println("A 按眉啊 积己凳"); }
	 * 
	 * class B { B() { System.out.println("B 按眉啊 积己凳"); }
	 * 
	 * int field1;
	 * 
	 * // static int field2 void method1() {
	 * 
	 * } // static void method2(){} }
	 * 
	 * static class C { C() { System.out.println("C 按眉啊 积己凳"); }
	 * 
	 * int field1;
	 * 
	 * static int field2;
	 * 
	 * void method1() { }
	 * 
	 * static void method2() {
	 * 
	 * } }
	 * 
	 * void method() { class D { D() { System.out.println("D 按眉啊 积己凳"); }
	 * 
	 * int field1;
	 * 
	 * // static int field2; void method1() {
	 * 
	 * }
	 * 
	 * // static void method2(){}
	 * 
	 * }
	 * 
	 * D d = new D(); d.field1 = 3; d.method1(); }
	 */

	// p396
	/*
	 * B field1 = new B(); C field2 = new C();
	 * 
	 * void method1() { B var1 = new B(); C var2 = new C();
	 * 
	 * }
	 * 
	 * // static B field3 = new B(); static C field4 = new C();
	 * 
	 * static void method2() { // B var1 = new B(); C var2 = new C(); }
	 * 
	 * class B {
	 * 
	 * }
	 * 
	 * static class C {
	 * 
	 * }
	 */

	// p397
	int field1;

	void method1() {

	}

	static int field2;

	static void method2() {

	}

	class B {
		void method() {

			field1 = 10;
			method1();

			field2 = 10;
			method2();
		}
	}

	static class C {
		void method() {

			// field1 = 10;
			// method1();

			field2 = 10;
			method2();
		}
	}
}
