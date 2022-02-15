class Puppy3{
	/*String Ÿ�� ���� ���� ����
		int Ÿ�� ���� ���� ����*/
		private String s;
		private int i;
		
	
	/*�μ��� ���� �������ۼ�
		String Ÿ�� ���������� "�޸�" �Ҵ�
		"puplic Puppy3()ȣ��Ǿ����ϴ�"���
		�������� ���
	*/		
	public Puppy3(){
		this.s = "�޸�";
		System.out.println("puplic Puppy3()ȣ��Ǿ����ϴ�");
		System.out.println("�������� String : "+s +", �������� int : " + i);
	}
	
	
	/*String Ÿ���� �μ� 1���� �޴� �������ۼ�
		String Ÿ�� ���������� �μ� �Ҵ�
		"puplic Puppy3()ȣ��Ǿ����ϴ�"���
		�������� ���
	*/		
	public Puppy3(String s){
		this.s = s;
		System.out.println("puplic Puppy3(String s)ȣ��Ǿ����ϴ�");
		System.out.println("�������� String : "+s +", �������� int : " + i);
	}
		
	
	/*String Ÿ���� �μ� 2���� �޴� �������ۼ�
		�μ�2���� �ϳ��� String���� �����
		String Ÿ���� �μ� 1���� �޴� �����ڿ��� �μ��� �ָ� ȣ��
		"puplic Puppy3()ȣ��Ǿ����ϴ�"���
	*/		
	public Puppy3(String a, String b){
		this(((String)(a+b)));	
		System.out.println("puplic Puppy3(String a, String b)ȣ��Ǿ����ϴ�");
	}
		
	
	
	/*boolean Ÿ���� �μ� 1���� �޴� �������ۼ�
		�μ��� "��"�� �ٿ� �ϳ��� String���� �����
		String Ÿ���� �μ� 1���� �޴� �����ڿ��� �μ��� �ָ� ȣ��
		"puplic Puppy3()ȣ��Ǿ����ϴ�"  ���
	*/					
	public Puppy3(boolean b){
		this((Boolean.toString(b)+"��"));
		System.out.println("puplic Puppy3(boolean b)ȣ��Ǿ����ϴ�");
	}
	
	
	/*char Ÿ���� �μ� 1���� �޴� �������ۼ�
			�μ��� ���� �����ڸ� ȣ���ϰ�
			�μ��� ���� data�� intŸ�� ���������� �Ҵ�	
			"puplic Puppy3()ȣ��Ǿ����ϴ�"���
			int�� �����������
	*/			
	public Puppy3(char c){
		this();
		this.i = (int)c;
		System.out.println("puplic Puppy3(char c)ȣ��Ǿ����ϴ�");
		System.out.println("�������� int : "+i);
	}
	
	
	/*�޼ҵ� printMemberVariable
	���� ����
	���������� ���
	*/	

	public void printMemberVariable(){
		System.out.println("String : "+s +", int : " + i);
	}
		
}


class ConstructorOverloadingExam{
		//���θ޼ҵ忡��
		public static void main(String [] args){
			//Puppy3 Ŭ������ �� �����ڸ� �ѹ��� �̿��� ��ü 5�� ����
			Puppy3 p1 = new Puppy3();
			Puppy3 p2 = new Puppy3("��");
			Puppy3 p3 = new Puppy3("��","��");
			Puppy3 p4 = new Puppy3(true);
			Puppy3 p5 = new Puppy3('A');
		
		//�� ��ü�� printMemberVariable�޼ҵ带 �ѹ��� ȣ��
			p1.printMemberVariable();
			p2.printMemberVariable();
			p3.printMemberVariable();
			p4.printMemberVariable();
			p5.printMemberVariable();
			
	}
}