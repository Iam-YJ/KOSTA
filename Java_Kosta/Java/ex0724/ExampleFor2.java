class ExampleFor2{

	//����for�� ���� 

	public static void main(String [] args){
		//1. 3�� 3���� ������� "����" ���� ����ϱ�
		//2. 1~100���� ����ϴµ� 10�� 10���� ������� (���� for�� �̿��ؼ�)
	

	//1

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print("����\t");
			
			}System.out.println();
		}
		System.out.println("-----------------");
	

	//2
		int num = 0;
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				num++;
				System.out.print(num+"\t");
			
			}System.out.println();
		
		}
		System.out.println("-----------------");n

	//2-1
		for(int i=0; i<10; i++){
			for(int j=1; j<=10; j++){
				System.out.print((i*10)+(j)+"\t");
			
			}System.out.println();
		
 		}


	}
}





