import java.util.Scanner;

class MainApp{
	public static void main(String [] args){
		

		Scanner scan = new Scanner(System.in);
		Score se = new Score();

		boolean menu = true;
		
		while(true){
			System.out.println("=====�޴� ����======");
			System.out.println("1. ����ǥ ���ϱ�	2. �����ϱ�");
			System.out.println("====================");

			System.out.print("���� > ");
			int menu = scan.nextInt();
			
			switch(menu){
				case 1 :
					System.out.println("�̸��� ? ");
					String name = scan.next();
					System.out.println("�������� ? ");
					int kor = scan.nextInt();
					System.out.println("�������� ? ");
					int math = scan.nextInt();
					System.out.println("�������� ? ");
					int eng = scan.nextInt();
					
					se.print(name, kor, eng, math);

					break;

				case 2 :
					System.out.println("���α׷� �����մϴ�");
					System.exit(0);
					break;

				default:
					System.out.println("�޴��� 1~2�� �����մϴ�");
			
			}
		}

		
	
		
	}
}