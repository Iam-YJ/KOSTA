class VariableExam{
	public static void  main(String [] args){

		Test t = new Test();

		System.out.println("t.i = " + t.i);
		System.out.println("t.str = " + t.str);

		//�Ӽ��� �������ϱ�
		System.out.println("�Ӽ��� �� �����ϱ�");
		t.i = 50;
		t.str = "����";

		System.out.println("t.i = " + t.i);
		System.out.println("t.str = " + t.str);

		System.out.println("�޼ҵ� ȣ���غ��� ");
		t.aa();
		System.out.println("t.i = " + t.i);
		System.out.println("t.str = " + t.str);

		
	
	
	}

}


class Test{
	//�������� �տ��� ������ ��밡��
	int i; // �������� = field = �Ӽ� = ������� 0���� �ʱ�ȭ
	String str; //null�� �ʱ�ȭ 

	public void aa(){

		//�������� �տ��� ������ ���Ұ�(public, protected..)
		int i=100; // �������� ����
		String name = "ȿ��";
		System.out.println("�������� : " + i); // ����������  �ʱ�ȭ�� �� �ʿ��� 
		System.out.println("�������� this.i : " + this.i);

		System.out.println("�������� this.str: " + this.str); 
		System.out.println("�������� this.str : " + str);

		System.out.println("�������� name : " + name);
		//System.out.println("�������� this.name : " + name); // ���������� this ��� �Ұ�


	public void bb(){
		System.out.println("�������� : " + i); // ����������  �ʱ�ȭ�� �� �ʿ��� 
		System.out.println("�������� this.i : " + this.i);

		System.out.println("�������� this.str: " + this.str); 
		System.out.println("�������� this.str : " + str);

	
	}


	
	}

	public void bb(){
		
	
	}
}