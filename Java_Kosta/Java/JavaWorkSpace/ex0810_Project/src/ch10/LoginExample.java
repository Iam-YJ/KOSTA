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
		// id�� blue�� �ƴ϶�� NotExistIDException �߻���Ŵ
		if (!id.equals("blue")) {
			NotExistIDException n = new NotExistIDException("���̵� �������� �ʽ��ϴ�");
			throw n;

		} else {
			System.out.println("���̵� ��ġ�մϴ�");
		}

		// password�� 12345�� �ƴ϶�� WrongPasswordException �߻���Ŵ
		if (!password.equals(12345)) {
			throw new WrongPasswordException("�н����尡 Ʋ���ϴ�");

		} else {
			System.out.println("�н����尡 ��ġ�մϴ�");
		}
	}

}
