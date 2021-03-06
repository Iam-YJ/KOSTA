package sample02;

public class Member {

	private String id;
	private String pwd;
	private int age;
	private String addr;

	public Member() {
		System.out.println("Member의 기본 생성자");
	}

	public Member(String id) {
		System.out.println("Member(String id)의 생성자 id = " + id);
		this.id = id;
	}

	public Member(String id, String pwd) {
		System.out.println("Member(String id, String pwd)의 생성자 id = " + id + " pwd = " + pwd);
		this.id = id;
		this.pwd = pwd;
	}

	public Member(String id, int age) {
		System.out.println("Member(String id, int age)의 생성자 id = " + id + " age = " + age);
		this.id = id;
		this.pwd = pwd;
	}
	
	public Member(String id,  String pwd,int age ) {
		System.out.println("Member(String id, String pwd, int age)의 생성자 id = " + id + " pwd = " + pwd + " age = " + age);
		this.id = id;
		this.pwd = pwd;
		this.age = age;
	}

	public Member(String id, int age, String addr) {
		System.out.println(
				"Member(String id, int age, String addr)의 생성자 id = " + id + " age = " + age + " addr = " + addr);
		this.id = id;
		this.age = age;
		this.addr = addr;
	}

	public Member(String id, String pwd, int age, String addr) {
		System.out.println("Member(String id, String pwd, int age, String addr)의 생성자 id = " + id + " pwd = " + pwd
				+ " age = " + age + " addr = " + addr);
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.addr = addr;
	}

	@Override
	public String toString() {

		return id + " | " + pwd + " | " + age + " | " + addr;
	}

}
