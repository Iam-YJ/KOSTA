class ArrayExam{
	
	//��int,double,char,boolean ,String type���� �� 5���� �����ϴ�  �迭�� �����ϼ���
	int [] arr1 = new int [5];
	double [] arr2 = new double [5];
	char [] arr3 = new char [5];
	boolean [] arr4 = new boolean [5];
	String [] arr5 = new String [5];

	
	


	//�޼ҵ� : printArrayValue01	
	//���� �迭�鿡 �ڵ����� �ʱ�ȭ �Ȱ��� ����ϼ���


	public void printArrayValue01(){
		System.out.println("============1��==========");
		for(int i=0; i<5; i++){
			System.out.print(arr1[i]+"\t");
		}
		System.out.println();
		for(int i=0; i<5; i++){
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		for(int i=0; i<5; i++){
			System.out.print(arr3[i]+"\t");
		}
		System.out.println();
		for(int i=0; i<5; i++){
			System.out.print(arr4[i]+"\t");
		}
		System.out.println();
		for(int i=0; i<5; i++){
			System.out.print(arr5[i]+"\t");
		}
		System.out.println();
	
	}
	

	//�޼ҵ� : printArrayValue02	
	//���� 5���� �迭���� ���� ������ ������ data�� �Ҵ��ϼ���.

	int [] num = {1,2,3,4,5};
	boolean [] boo = {true, true, true, false, false};
	String [] str = {"h","e","l","l","o"};

	public void printArrayValue02(){
		System.out.println("============2��==========");
		for (int i = 0 ; i<arr1.length ; i++ ){
			arr1[i] = num[i];
			arr2[i] = (double)num[i]; //d c b s
			arr3[i] = (char)num[i];
			arr4[i] = boo[i];
			arr5[i] = str[i];


		}
	
	}
	
	//�޼ҵ� : printArrayValue03	
	//���Ӱ� �Ҵ�Ȱ��� ����ϼ���
	
	public void printArrayValue03(){
		System.out.println("============3��==========");
		this.printArrayValue01();
	}

	
	
	//���θ޼ҵ忡��
	//ArrayExam�� �޼ҵ���� ������� ȣ���ϼ���.

	public static void main(String [] args){
		ArrayExam ae = new ArrayExam(); //�������� �ʱ�ȭ 
		ae.printArrayValue01();
		ae.printArrayValue02();
		ae.printArrayValue03();
	}
	
}