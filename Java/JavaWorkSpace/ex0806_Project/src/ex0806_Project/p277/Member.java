package ex0806_Project.p277;

public class Member {

	// 13, 14
	private String name;
	private String id;
	private String password;
	private int age;

	Member() {
	}

	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}

	Member(String name, String id, String password, int age) {
		this(name, id);
		this.password = password;
		this.age = age;
	}

}
