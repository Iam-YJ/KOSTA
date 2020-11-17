package kosta.mvc.model.dto;

public class Member {
	private String id;
	private String name;
	private int age;
	private String addr;

	public Member() {
		System.out.println("Member의 기본 생성자 call");
	}

	public Member(String id, String name, int age, String addr) {
		System.out.println("Member(String id, String name, int age, String addr)의 생성자 call");
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId(String id) 호출");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) 호출");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge(int age) 호출");
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr(String addr) 호출");
		this.addr = addr;
	}

}
