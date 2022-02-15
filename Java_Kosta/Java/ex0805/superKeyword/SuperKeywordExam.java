class Super
{
	int a = 5;
	int b = 10;
	public void aa(){System.out.println("Super의 aa() 호출됨");}
	public void bb(){System.out.println("Super의 bb() 호출됨");}

}


class Sub extends Super // Sub is a Super
{
	int a = 20;
	int c = 40;

	@Override
	public void aa(){
		System.out.println("Sub의 aa() 호출됨");
		/*
		System.out.println(a); //20
		System.out.println(this.a); //20
		System.out.println(super.a); //5

		System.out.println("=================================");
		System.out.println(b); //10
		System.out.println(this.b); //10
		System.out.println(super.b); //10

		System.out.println("=================================");
		System.out.println(c); //40
		System.out.println(this.c); //40
		//System.out.println(super.c); //자신안에 있는 변수를 super로 접근 불가 

		*/
	}
	
	public void cc(){
		aa(); //sub
		this.aa(); //sub
		super.aa(); //sub

		System.out.println("===================");
		bb(); //super
		this.bb(); //super
		super.bb(); //super

		System.out.println("===================");
		dd(); //sub
		this.dd(); //sub
		//super.dd(); //자신안에 있는 변수를 super로 접근 불가  

	}

	public void dd(){
		System.out.println("Sub의 dd() 호출됨");
	
	}
}

class SuperKeywordExam 
{
	public static void main(String[] args) 
	{
		/*
		Sub s = new Sub();
		s.aa();
		*/

		//new Sub().cc();

		Sub s1 = new Sub();
		System.out.println(s1.a); //20
		System.out.println(s1.b); //10
		System.out.println(s1.c); //40
		System.out.println("====================");
		s1.aa(); //sub
		s1.bb(); //super
		s1.dd(); //sub
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	


		Super s2 = new Sub();
		System.out.println(s2.a); //20
		System.out.println(s2.b); //10
		//System.out.println(s2.c); //sub에 있어서 안됨
		System.out.println("====================");
		s2.aa(); //재정의된 메소드는 부모타입이더라도 반드시 재정의된 메소드가 호출된다.
		s2.bb(); //super
		//s2.dd(); //sub에 있어서 안됨



		System.out.println("캐스팅 전 s2 주소 : "+s2);
		//ObjectDownCasting을 이용해서 자식부분에 접근하도록 한다.
		if(s2 instanceof Sub){
			Sub s3 = (Sub)s2;

			System.out.println("캐스팅 후 s3 주소 : "+s3);
			System.out.println(s3.c);
			s3.dd();
			
		}
	}
}
