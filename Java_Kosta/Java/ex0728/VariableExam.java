class VariableExam{
	public static void  main(String [] args){

		Test t = new Test();

		System.out.println("t.i = " + t.i);
		System.out.println("t.str = " + t.str);

		//속성의 값변경하기
		System.out.println("속성의 값 변경하기");
		t.i = 50;
		t.str = "희정";

		System.out.println("t.i = " + t.i);
		System.out.println("t.str = " + t.str);

		System.out.println("메소드 호출해보자 ");
		t.aa();
		System.out.println("t.i = " + t.i);
		System.out.println("t.str = " + t.str);

		
	
	
	}

}


class Test{
	//전역변수 앞에는 제한자 사용가능
	int i; // 전역변수 = field = 속성 = 멤버변수 0으로 초기화
	String str; //null로 초기화 

	public void aa(){

		//지역변수 앞에는 제한자 사용불가(public, protected..)
		int i=100; // 지역변수 선언
		String name = "효리";
		System.out.println("지역변수 : " + i); // 지역변수는  초기화가 꼭 필요함 
		System.out.println("전역변수 this.i : " + this.i);

		System.out.println("지역변수 this.str: " + this.str); 
		System.out.println("전역변수 this.str : " + str);

		System.out.println("전역변수 name : " + name);
		//System.out.println("지역변수 this.name : " + name); // 지역변수에 this 사용 불가


	public void bb(){
		System.out.println("전역변수 : " + i); // 지역변수는  초기화가 꼭 필요함 
		System.out.println("전역변수 this.i : " + this.i);

		System.out.println("전역변수 this.str: " + this.str); 
		System.out.println("전역변수 this.str : " + str);

	
	}


	
	}

	public void bb(){
		
	
	}
}