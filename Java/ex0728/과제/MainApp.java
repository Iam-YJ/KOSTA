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
		// switch 사용
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
		// 무한루프 + 2번 누르면 종료

		int s = sum(kor, eng, math);
		int a = average(s, 3);

		System.out.println("name" + "의 성적표");
		System.out.println("총점 : " + sum(kor, eng, math));
		System.out.println("평균 : " + average(s, 3));
		System.out.println("등급 : " + grade(a));

		return null;

	}

}

class MainApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean b = true;
		Score s = new Score();

		System.out.println("국어성적을 입력해주세요 : ");
		int kor = scan.nextInt();
		System.out.println("영어성적을 입력해주세요 : ");
		int eng = scan.nextInt();
		System.out.println("수학성적을 입력해주세요 : ");
		int math = scan.nextInt();
		System.out.println("이름을 입력해주세요 : ");
		String name = scan.next();

		while (b) {
			System.out.println("------------------------");
			System.out.println("1. 성적표 | 2. 종료 ");
			System.out.println("------------------------");
			System.out.print("선택> ");
			int num = scan.nextInt();

			switch (num) {
			case 1:
				String str = s.show(name, kor, eng, math);
				break;
			case 2:
				b = false;
				System.out.println("안녕히 계세요");
				break;
			default:
				System.out.println("잘못된 입력");
			}

		}

	}

}