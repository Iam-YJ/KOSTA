package ch10;

public class LoginExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			login("white", "12345");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			login("blue", "54321");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void login(String id, String password) throws NotExistIDException, WrongPasswordException {
		// id가 blue가 아니라면 NotExistIDException 발생시킴
		if (!id.equals("blue")) {
			NotExistIDException n = new NotExistIDException("아이디가 존재하지 않습니다");
			throw n;

		} else {
			System.out.println("아이디가 일치합니다");
		}

		// password가 12345가 아니라면 WrongPasswordException 발생시킴
		if (!password.equals(12345)) {
			throw new WrongPasswordException("패스워드가 틀립니다");

		} else {
			System.out.println("패스워드가 일치합니다");
		}
	}

}
