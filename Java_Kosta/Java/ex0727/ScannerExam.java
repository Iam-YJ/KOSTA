import java.util.Scanner; 
// ���� ����Ϸ��� Ŭ������ � ������ �ִ��� ����

class ScannerExam{

	public static void main(String [] args){
		//Ű���� �Է¹ޱ� ���� �غ�
		Scanner sc = new Scanner(System.in);

		//Ű���� �Է� �ޱ�
		System.out.print("���� �Է� : ");
		int kor = sc.nextInt();

		System.out.print("���� �Է� : ");
		int eng = sc.nextInt();

		System.out.print("�̸� �Է� : ");
		String name = sc.next();

		System.out.println("***����ǥ***");
		System.out.println(name+"�� ������" + (kor+eng));
	
	}



}