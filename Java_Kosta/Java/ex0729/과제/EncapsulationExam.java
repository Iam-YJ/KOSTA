import java.util.Scanner;

class EncapsulationExam {

	private int weight = 0;
	private int password = 0;

	
	private void getWeight(int p) {
		if (isPassword(p) == true) {
			System.out.println("몸무게는 " + weight + "입니다");
		} else {
			System.out.println("비밀번호 불일치");
		}

	}

	private int setWeight(int cw, int p) {
		if (isPassword(p) == true) {
			weight = cw;

		}
		return weight;
	}

	private int getPassword(int current_password, int cp) {
		if (isPassword(current_password) == true) {
			password = cp;

		}
		return password;
	}

	private boolean isPassword(int p) {

		if (p == password) {
			return true;

		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		EncapsulationExam ee = new EncapsulationExam();

		System.out.println("초기 비밀번호를 입력하세요 : ");
		int inputPassword = scan.nextInt();
		System.out.println("초기 무게를 입력하세요 : ");
		int inputWeight = scan.nextInt();

		int realP = ee.getPassword(0, inputPassword);
		System.out.println(realP);
		int realW = ee.setWeight(inputWeight, realP);
		ee.getWeight(realP);
		System.out.println("비밀번호 : " + realP + " 몸무게" + realW);

	}

}