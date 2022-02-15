package ex0819;

import java.io.Serializable;

/**
 * Student 객체를 파일에 저장 - 직렬화 필수 ! (Serializable 구현)
 * 
 * 직렬화대상 제외 : static 변수, transient, 생성자, 메소드 
 *
 */
public class Student implements Serializable {
	private String name;
	private int age;
	private transient String addr;

	public Student() {

	}

	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
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

	@Override
	public String toString() {
		return name + " | " + age + " | " + addr;
	}

}
