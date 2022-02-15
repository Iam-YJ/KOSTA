package ch07;

public class Child1 extends Parent1 {

	private String name;

	public Child1() {
		this("ȫ�浿");
		System.out.println("Child() call");
	}

	public Child1(String name) {
		this.name = name;
		System.out.println("Child(String name) call");
	}

}
