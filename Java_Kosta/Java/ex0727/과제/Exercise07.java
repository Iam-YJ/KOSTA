import java.util.Scanner;

public class Exercise07 {
	public static void main(String [] args){
		//������

		boolean run = true;

		int balance = 0;

		Scanner scan = new Scanner(System.in);

		while(run){
			System.out.println("------------------------");
			System.out.println("1. ���� | 2. ��� | 3. �ܰ� | 4. ����");
			System.out.println("------------------------");
			System.out.print("����> ");

			int num = scan.nextInt();

			if(num == 1){
				System.out.print("���ݾ�> ");
				int money = scan.nextInt();
				balance += money;
			}else if(num == 2){
				System.out.print("��ݾ�> ");
				int money = scan.nextInt();
				balance -= money;
			}else if(num == 3){
				System.out.println("�ܰ�> "+balance);

			}else if(num ==4){
				break;
			}
			



		
		}

		System.out.println("���α׷� ����");
	
	
	}




}