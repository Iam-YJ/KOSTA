import java.util.Scanner;//���� ����Ϸ��� Ŭ������ � ����(package)�� �ִ��� ����.

public class Exercise07{
	public static void main(String [] ags){
		boolean run =true;

		int balance =0;
		//Ű���� �Է¹ޱ� ���� �غ�
		Scanner sc = new Scanner(System.in);//�޼ҵ� ����

		while(run){
			System.out.println("-----------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("-----------------------------------");
			System.out.print("����> ");
			int no = sc.nextInt();
			if(no==1){
			System.out.print("���ݾ�> ");
			int inp = sc.nextInt();
			}else if(no==2){
			System.out.print("��ݾ�> ");
			int oup = sc.nextInt();
			}else if(no==3){
			System.out.print("�ܰ�> ");
			int bal = sc.nextInt();
			}else break;
		}

		System.out.println("���α׷� ����");
/*
�������ϴ� �׸��� 3�� �����ϰ� �ܰ� �߸� �ٷ� ���ݾ� ��ݾ��� �̸� �־��ٸ� �װ� ������ֱ� �ٶ�µ� 
���� �����ϰ� inp-oup�� �ܰ� ������ �߰� �ϴϱ� �����Ͽ� �����ϳ׿� ������ �˰�ͽ��ϴ�.
*/
	}
}