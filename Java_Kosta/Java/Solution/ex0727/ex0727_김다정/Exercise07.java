/*�����̸�:�����
  ��¥: 20.07.27
  ���� : �̰��� �ڹٴ� 7�� ����  */
import java.util.Scanner;

public class Exercise07{
	public static void main(String [] args){
		boolean run = true;
		//�ܾ�
		int balance = 0;
		
		Scanner sc = new Scanner(System.in);

		while(run){
			System.out.println("----------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("----------------------------------");
			System.out.print("����>");
			
			int menu = sc.nextInt();// 1 2 3 4
			//select ������ 1�� ������ ���ݾ� �Է°��� ���� deposit�� ����
			switch(menu){
				case 1 : 
					System.out.print("���ݾ�>");
					balance += sc.nextInt();
					break;
				case 2 : 
					System.out.print("��ݾ�>");
					balance -= sc.nextInt();
					break;
				case 3 : 
					 System.out.println("�ܰ�>" + balance );
					break;
				case 4 : 
					System.out.println("���α׷� ����");
					System.exit(0);//���α׷� ����
				default : 
					System.out.println("�޴��� 1 ~ 4 ���̸� �Է����ּ���^^");
			}//switch����

	  }//while����
	  
	
  }//���θ޼ҵ峡
}//Ŭ������