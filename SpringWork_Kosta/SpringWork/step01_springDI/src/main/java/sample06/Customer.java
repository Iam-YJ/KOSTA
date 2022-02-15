package sample06;

public class Customer {

	private String id;
	private int age;
	private String addr;

	public Customer() {
		System.out.println("customer의 기본 생성자");
	}

	public Customer(String id) {
		System.out.println("Customer(String id) 생성자");
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		System.out.println("setId");
		System.out.println("id = " + id);
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge");
		System.out.println("age = "+age);
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		System.out.println("setAddr");
		System.out.println("addr = "+addr);
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
	

}
