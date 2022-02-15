package ch07;


//1 - 1
//2 - 2
//3 - 1
//4 - 4

public class Child extends Parent{
	private int studentNo;
	
	
	public Child(String name, int studentNo) {
		super(name);
		this.studentNo = studentNo;
	}

	//super 클래스의 생성자를 호출해준다 
	//부모가 생성자를 만들었기 때문에 super로 호출해줘야한다 
	
	
}
