package p277;

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
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("=====================");
			System.out.println("����> ");

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

		System.out.println("���α׷� ����");

	}

	// ano ���¹�ȣ(s) / owner ����(s) / balance �ݾ�(i)

	// ���»���
	private static void createAccount() {
		for (int i = 0; i < count + 1; i++) {
			System.out.println("=====================");
			System.out.println("���»���");
			System.out.println("=====================");

			System.out.print("���¹�ȣ : ");
			String a = scanner.next();
			accountArray[i].setAno(a);

			System.out.print("������ : ");
			String o = scanner.next();
			accountArray[i].setOwner(o);

			System.out.print("���¹�ȣ : ");
			int b = scanner.nextInt();
			accountArray[i].setBalance(b);
		}

	}

	// ���¸�Ϻ���
	private static void accountList() {
		System.out.println("=====================");
		System.out.println("���¸��");
		System.out.println("=====================");

	}

	// ����
	private static void deposit() {
		System.out.println("=====================");
		System.out.println("����");
		System.out.println("=====================");

	}

	// ���
	private static void withdraw() {
		System.out.println("=====================");
		System.out.println("���");
		System.out.println("=====================");

	}



}
