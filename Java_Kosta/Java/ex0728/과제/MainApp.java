import java.util.Scanner;

class Score {

	private int sum(int kor, int eng, int math) {
		int sum = kor + eng + math;

		return sum;

	}

	private int average(int sum, int num) {
		int avg = sum / num;

		return avg;
	}

	private String grade(int avg) {
		// switch ���
		String grade = "";
		switch (avg/10) {
		case 10:
			grade = "A";
			break;
		case 9:
			grade = "A";
			break;

		case 8:
			grade = "B";
			break;

		case 7:
			grade = "C";
			break;

		case 6:
			grade = "D";
			break;

		default:
			grade = "F";

		}
		return grade;

	}

	public String show(String name, int kor, int eng, int math) {
		// ���ѷ��� + 2�� ������ ����

		int s = sum(kor, eng, math);
		int a = average(s, 3);

		System.out.println("name" + "�� ����ǥ");
		System.out.println("���� : " + sum(kor, eng, math));
		System.out.println("��� : " + average(s, 3));
		System.out.println("��� : " + grade(a));

		return null;

	}

}

class MainApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean b = true;
		Score s = new Score();

		System.out.println("������� �Է����ּ��� : ");
		int kor = scan.nextInt();
		System.out.println("������� �Է����ּ��� : ");
		int eng = scan.nextInt();
		System.out.println("���м����� �Է����ּ��� : ");
		int math = scan.nextInt();
		System.out.println("�̸��� �Է����ּ��� : ");
		String name = scan.next();

		while (b) {
			System.out.println("------------------------");
			System.out.println("1. ����ǥ | 2. ���� ");
			System.out.println("------------------------");
			System.out.print("����> ");
			int num = scan.nextInt();

			switch (num) {
			case 1:
				String str = s.show(name, kor, eng, math);
				break;
			case 2:
				b = false;
				System.out.println("�ȳ��� �輼��");
				break;
			default:
				System.out.println("�߸��� �Է�");
			}

		}

	}

}