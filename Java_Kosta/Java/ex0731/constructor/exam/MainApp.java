import java.util.Scanner;

class MainApp 
{
	public static void main(String[] args) 
	{  

		StudentService ss = new StudentService();

		Scanner scan = new Scanner(System.in);

		System.out.println("======================");
		System.out.println("1. ");
		System.out.println("======================");



		//�л� ������ �߰�
		ss.insert();
	
		//�л� ��ü �˻�
		ss.selectAll();

		//�̸����� �л� �˻�
		ss.searchBy("����0");
		ss.searchBy("����10");
		
	}
}
