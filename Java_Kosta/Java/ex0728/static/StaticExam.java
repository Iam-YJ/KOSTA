class Test{
	int a = 5;//인스턴스 멤버변수 
	static int b = 10; //static은 지역변수에는 안됨 


	//non static method(일반) 안에서는 static, non-static 모두 접근 가능, this 사용 가능하다 
	public void aa(){
		System.out.println(a);
		System.out.println(b);

		System.out.println(this.a);
		System.out.println(this.b);
	}
	public void bb(){
		aa(); 
		this.aa(); 

		cc();
		this.cc(); 
	}

	//static 메소드 안에서는 static만 접근 가능하고, this 키워드 사용불가 
	public static void cc(){
		//System.out.println(a); x - a는 static이 아님
		System.out.println(b); //o

		//System.out.println(this.a); x - this
		//System.out.println(this.b); x
	}
	public static void dd(){
		//aa(); //x
		//this.aa(); //x 

		cc(); //o
		// this.cc(); //x 
	}
}


public class StaticExam{
	public static void main(String [] args){

		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();

		System.out.println("===== non-static 변수 접근하기 =====");
		System.out.println("t1.a="+t1.a);
		System.out.println("t2.a="+t2.a);
		System.out.println("t3.a="+t3.a);

		//값변경
		System.out.println("===== non-static 변수값 변경 후 접근하기 =====");
		t2.a = 50;
		System.out.println("t1.a="+t1.a);
		System.out.println("t2.a="+t2.a);
		System.out.println("t3.a="+t3.a);

		System.out.println("===== static 변수 접근하기 =====");
		System.out.println("t1.b="+t1.b);
		System.out.println("t2.b="+t2.b);
		System.out.println("t3.b="+t3.b);

		//값변경
		System.out.println("===== static 변수값 변경 후 접근하기 =====");
		t2.b = 500;
		System.out.println("t1.b="+t1.b);
		System.out.println("t2.b="+t2.b);
		System.out.println("t3.b="+t3.b);
	
	}

}