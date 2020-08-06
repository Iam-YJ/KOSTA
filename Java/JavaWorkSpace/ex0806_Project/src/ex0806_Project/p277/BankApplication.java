package ex0806_Project.p277;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean run = true;

		while (run) {
			System.out.println("=====================");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("=====================");
			System.out.println("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}
		}

		System.out.println("프로그램 종료");

	}

	// ano 계좌번호(s) / owner 주인(s) / balance 금액(i)

	// 계좌생성
	private static void createAccount() {
		for (int i = 0; i < count + 1; i++) {
			System.out.println("=====================");
			System.out.println("계좌생성");
			System.out.println("=====================");

			System.out.print("계좌번호 : ");
			String a = scanner.next();
			accountArray[i].setAno(a);

			System.out.print("계좌주 : ");
			String o = scanner.next();
			accountArray[i].setOwner(o);

			System.out.print("계좌번호 : ");
			int b = scanner.nextInt();
			accountArray[i].setBalance(b);
		}

	}

	// 계좌목록보기
	private static void accountList() {
		System.out.println("=====================");
		System.out.println("계좌목록");
		System.out.println("=====================");

	}

	// 예금
	private static void deposit() {
		System.out.println("=====================");
		System.out.println("예금");
		System.out.println("=====================");

	}

	// 출금
	private static void withdraw() {
		System.out.println("=====================");
		System.out.println("출금");
		System.out.println("=====================");

	}

	// account 배열에서 ano와 동일한 account 객체 찾기
	private static Account findAccount(String ano) {
		for (int i = 0; i < accountArray.length; i++) {
			if (ano.equals(accountArray[i].getAno())) {
				return accountArray[i];
			}
		}

	}

}
