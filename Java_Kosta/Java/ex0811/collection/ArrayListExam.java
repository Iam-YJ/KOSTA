 import java.util.ArrayList;
class ArrayListExam extends ArrayList{

	//���� Variable
	//Object Ÿ��1��, int Ÿ�� 1��;
	

	//Constractor
	public ArrayListExam(){
			//�ʱ� �뷮 5�� ����
		
			
	}

	//method
	//method�̸�			����Ÿ��		�μ�						
	
	/*addInt				����			����(int)1��				
	�ϴ��� : �μ��� ���� ������ ��ü�� ����� list�� �߰�.*/
		
		
	
	
	/*addFloat				����			�Ǽ�(float)1��			
		�ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� list�� �߰�.*/
		
	
	
	/*addString			����			String ���ڿ�1��		
		�ϴ��� : �μ��� ���� String �� list�� �߰�.*/
		
	
	
	
	/*printList		����			����			
		������ ���������� ���� list�� ����ִ� ��ü�� ���� �Է��� �� �������� ���.
		List�� ����� �� ��ü�� �ɹ������� �������� ���*/
		
		

	public static void main(String args[]){
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");		 
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

/*������

list�� ����ִ� ��ü�� �� ������=3
5
5.5
newString

Normal Termination
��� �Ϸ� (0�� ���).
*/