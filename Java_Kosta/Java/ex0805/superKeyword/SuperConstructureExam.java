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
class Child extends Parent{ // Child is a Parent. > ������

	Child(){
		this(4); //���� ��ü�� int�� �޴� ������ ȣ�� 
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
		
		//new Child("�ȳ�"); //Child() �����ڿ� String �޴� ���� ��� ����
		//new Child(true); // 1 6

		//===============================
		//���� �θ��� �����ڰ� �Ѱ��� ���ٸ� (1,2,3 ����)
		//new Child(); //�������� - �����ڸ� �ۼ��F �Ӿ����� �⺻�����ڰ� �ڵ����Ե�

		//===============================
		//���� �θ��� �������߿� 1�� ���� 2,3���� �����Ѵٸ�?
		// -> ������ ���� 

		new Child();



	}
}
