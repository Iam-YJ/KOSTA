class CastingExam{
	public static void main(String []args){
		byte b1;
		byte b2,b3; 
		int i1=7;
		System.out.println("int i1="+i1);

		b1=(byte)i1 ; //int를 byte에 저장할 수 없음. 캐스팅연산자가 필요함
		System.out.println("byte b1="+b1);

		b2=20;
		System.out.println("byte b2="+b2);
		
	   	b3=(byte)(b2+b1); //b2가 위에서 int로 되어있어서 캐스팅 필요함
		//연산기호를 만나면 최소한 4byte의 공간이 필요하다

		System.out.println("byte b3="+b3);
		
		long lo=56897L;
		System.out.println("long lo="+lo);

		int i4=(int)lo+i1; //서로 다른 타입을 연산하면 결과는 큰타입으로 long타입을 캐스팅 해야됨
		System.out.println("int i4="+i4);
		
		boolean boo; //boolean은 true, false만 필요함
		 boo=false; 
		
		System.out.println("boolean boo="+boo);

		double d=4.67e-3;
		System.out.println("double d="+d);

		float f1=lo;
		System.out.println("float f1="+f1);
				
		
	    float f2=(float)d; //float에 double 담을 수 없음. 캐스팅 필요함
		System.out.println("float f2="+f2);

		char c1,c2, c3;
		c1='\u0167';
		System.out.println("char c1="+c1);

		 b2=(byte)c1; //byte로..
		System.out.println("byte b2="+b2);
		
		c2='가';
		System.out.println("char c2="+c2);
		
		
		c3=(char)(c2+2); //char로,+를 만나면 4byte가 되어서 묶어서 해야한다
		System.out.println("char c3="+c3);
		
		
	}

}