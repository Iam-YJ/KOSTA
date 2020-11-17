package kosta.mvc.model.dto;

public class Member {
	private String id;
	private String name;
	private int age;
	private String addr;

	public Member() {
		System.out.println("Member�� �⺻ ������ call");
	}

	public Member(String id, String name, int age, String addr) {
		System.out.println("Member(String id, String name, int age, String addr)�� ������ call");
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId(String id) ȣ��");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name) ȣ��");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge(int age) ȣ��");
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr(String addr) ȣ��");
		this.addr = addr;
	}

}
