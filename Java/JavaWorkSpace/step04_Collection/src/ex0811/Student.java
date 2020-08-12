package ex0811;

public class Student {

	private String id; // Áßº¹¾ÈµÊ
	private String name;
	private int age;
	private String addr;

	public Student() {

	}

	public Student(String id, int age, String addr) {
		super();
		this.id = id;
		this.age = age;
		this.addr = addr;
	}

	public Student(String id, String name, int age, String addr) {
		this(id, age, addr);
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id + " | ");
		builder.append(name + " | ");
		builder.append(age + " | ");
		builder.append(addr + " | ");
		return builder.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
