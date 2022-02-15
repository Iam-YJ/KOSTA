class Super
{
	int a = 5;
	int b = 10;
	public void aa(){System.out.println("Super�� aa() ȣ���");}
	public void bb(){System.out.println("Super�� bb() ȣ���");}

}


class Sub extends Super // Sub is a Super
{
	int a = 20;
	int c = 40;

	@Override
	public void aa(){
		System.out.println("Sub�� aa() ȣ���");
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
		//System.out.println(super.c); //�ڽžȿ� �ִ� ������ super�� ���� �Ұ� 

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
		//super.dd(); //�ڽžȿ� �ִ� ������ super�� ���� �Ұ�  

	}

	public void dd(){
		System.out.println("Sub�� dd() ȣ���");
	
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
		//System.out.println(s2.c); //sub�� �־ �ȵ�
		System.out.println("====================");
		s2.aa(); //�����ǵ� �޼ҵ�� �θ�Ÿ���̴��� �ݵ�� �����ǵ� �޼ҵ尡 ȣ��ȴ�.
		s2.bb(); //super
		//s2.dd(); //sub�� �־ �ȵ�



		System.out.println("ĳ���� �� s2 �ּ� : "+s2);
		//ObjectDownCasting�� �̿��ؼ� �ڽĺκп� �����ϵ��� �Ѵ�.
		if(s2 instanceof Sub){
			Sub s3 = (Sub)s2;

			System.out.println("ĳ���� �� s3 �ּ� : "+s3);
			System.out.println(s3.c);
			s3.dd();
			
		}
	}
}
