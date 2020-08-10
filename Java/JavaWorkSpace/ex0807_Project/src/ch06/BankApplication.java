package ch06;

import java.util.Scanner;

public class BankApplication {
	private static AccountNew[] accountArray = new AccountNew[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------");
			System.out.println("선택>");

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
		System.out.println("프로그램종료");
	}

	private static void createAccount() {
		System.out.println("-------");
		System.out.println("계좌생성");
		System.out.println("-------");
		System.out.print("계좌번호 : ");
		String ano = scanner.next();
		System.out.print("계좌주 : ");
		String owner = scanner.next();
		System.out.print("초기입금액 : ");
		int balance = scanner.nextInt();

		AccountNew account = new AccountNew(ano, owner, balance);

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = account;
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
		}
	}

	private static void accountList() {
		System.out.println("-------");
		System.out.println("계좌목록");
		System.out.println("-------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			} else {
				System.out.println(accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t"
						+ accountArray[i].getBalance());

			}
		}

	}

	private static void deposit() {
		System.out.println("-------");
		System.out.println("예금");
		System.out.println("-------");
		System.out.print("계좌번호");
		String ano = scanner.next();
		System.out.print("예금액");
		int balance = scanner.nextInt();
		AccountNew account = findAccount(ano);
		if (account == null) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		} else {
			account.setBalance(account.getBalance() + balance);
			System.out.println("예금이 성공되었습니다.");
		}

	}

	private static void withdraw() {
		System.out.println("-------");
		System.out.println("출금");
		System.out.println("-------");
		System.out.print("계좌번호");
		String ano = scanner.next();
		System.out.print("출금액");
		int balance = scanner.nextInt();

		AccountNew account = findAccount(ano);
		if (account == null) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		} else {
			account.setBalance(account.getBalance() - balance);
			System.out.println("출금이 성공되었습니다.");
		}
	}

	// Account배열에서 ano와 동일한 Account객체 찾기
	private static AccountNew findAccount(String ano) {
		AccountNew account = null;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				if (ano.equals(accountArray[i].getAno())) {
					account = accountArray[i];
					break;
				}
			}

		}
		return account;
	}
}
