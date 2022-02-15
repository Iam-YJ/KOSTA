class Parent
{
	/*
	Parent(){
		System.out.println(1);
	}
*/
	Parent(int i){
		System.out.println(2);
	}

	Parent(String str){
		System.out.println(3);
	}
	
}
/////////////////////////////////
class Child extends Parent{ // Child is a Parent. > 다형성

	Child(){
		this(4); //현재 객체의 int형 받는 생성자 호출 
		System.out.println(4);
	}

	Child(int i){
		super("hi");
		System.out.println(5);
	}

	Child(boolean b){
		super(1);
		System.out.println(6);
	}

}


class SuperConstructureExam {
	public static void main(String[] args) {
		//new Child(); // 1 4
		//new Child(20); //1 5
		
		//new Child("안녕"); //Child() 생성자에 String 받는 것이 없어서 오류
		//new Child(true); // 1 6

		//===============================
		//만약 부모의 생성자가 한개도 없다면 (1,2,3 없다)
		//new Child(); //문제없다 - 생성자를 작성핮 ㅣ않으면 기본생성자가 자동삽입됨

		//===============================
		//만약 부모의 생성자중에 1은 없고 2,3번만 존재한다면?
		// -> 컴파일 오류 

		new Child();



	}
}
