package ex1021.dto;

public class Member {

	private String id;
	private String name;
	private int age;
	private String addr;

	public Member() {

	}

	public Member(String id, String name, int age, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}


}
