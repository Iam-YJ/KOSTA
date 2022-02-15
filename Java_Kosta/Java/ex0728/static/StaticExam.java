class Test{
	int a = 5;//�ν��Ͻ� ������� 
	static int b = 10; //static�� ������������ �ȵ� 


	//non static method(�Ϲ�) �ȿ����� static, non-static ��� ���� ����, this ��� �����ϴ� 
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

	//static �޼ҵ� �ȿ����� static�� ���� �����ϰ�, this Ű���� ���Ұ� 
	public static void cc(){
		//System.out.println(a); x - a�� static�� �ƴ�
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

		System.out.println("===== non-static ���� �����ϱ� =====");
		System.out.println("t1.a="+t1.a);
		System.out.println("t2.a="+t2.a);
		System.out.println("t3.a="+t3.a);

		//������
		System.out.println("===== non-static ������ ���� �� �����ϱ� =====");
		t2.a = 50;
		System.out.println("t1.a="+t1.a);
		System.out.println("t2.a="+t2.a);
		System.out.println("t3.a="+t3.a);

		System.out.println("===== static ���� �����ϱ� =====");
		System.out.println("t1.b="+t1.b);
		System.out.println("t2.b="+t2.b);
		System.out.println("t3.b="+t3.b);

		//������
		System.out.println("===== static ������ ���� �� �����ϱ� =====");
		t2.b = 500;
		System.out.println("t1.b="+t1.b);
		System.out.println("t2.b="+t2.b);
		System.out.println("t3.b="+t3.b);
	
	}

}