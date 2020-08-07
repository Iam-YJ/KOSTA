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
			System.out.println("1.°èÁÂ»ý¼º | 2.°èÁÂ¸ñ·Ï | 3.¿¹±Ý | 4.Ãâ±Ý | 5.Á¾·á");
			System.out.println("=====================");
			System.out.println("¼±ÅÃ> ");

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

		System.out.println("ÇÁ·Î±×·¥ Á¾·á");

	}

	// ano °èÁÂ¹øÈ£(s) / owner ÁÖÀÎ(s) / balance ±Ý¾×(i)

	// °èÁÂ»ý¼º
	private static void createAccount() {
		for (int i = 0; i < count + 1; i++) {
			System.out.println("=====================");
			System.out.println("°èÁÂ»ý¼º");
			System.out.println("=====================");

			System.out.print("°èÁÂ¹øÈ£ : ");
			String a = scanner.next();
			accountArray[i].setAno(a);

			System.out.print("°èÁÂÁÖ : ");
			String o = scanner.next();
			accountArray[i].setOwner(o);

			System.out.print("°èÁÂ¹øÈ£ : ");
			int b = scanner.nextInt();
			accountArray[i].setBalance(b);
		}

	}

	// °èÁÂ¸ñ·Ïº¸±â
	private static void accountList() {
		System.out.println("=====================");
		System.out.println("°èÁÂ¸ñ·Ï");
		System.out.println("=====================");

	}

	// ¿¹±Ý
	private static void deposit() {
		System.out.println("=====================");
		System.out.println("¿¹±Ý");
		System.out.println("=====================");

	}

	// Ãâ±Ý
	private static void withdraw() {
		System.out.println("=====================");
		System.out.println("Ãâ±Ý");
		System.out.println("=====================");

	}



}
