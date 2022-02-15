package ex0810;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****���� ����*****");
		try {
			String data = args[0];
			System.out.println("data = " + data);

			int no = Integer.parseInt(data);
			System.out.println("��ȯ�� : " + no);

			int result = 100 / no;
			System.out.println("���� ��� : " + result);

			// catch �� ������ �ۼ��� �� �ݵ�� ���� class ���� �ۼ��Ѵ�

		} catch (ArrayIndexOutOfBoundsException e) {
			// ���ܹ߻� ���� �� �ؾ��� �� �ۼ�
			System.out.println("�μ��� �� �־��ּ��� : " + e);
			// e -> e�� �ּҰ��� �ƴ� � Ŭ�������� ���� ������ ������ ����
			// �� ������ ���� ������ ���´�
			

		} catch (NumberFormatException e) {
			System.out.println("�ݵ�� ���ڸ� �Է����ּ��� : " + e.getMessage());
			// �����鿡�� � ������ ������ �޼��� ���� �� �����
		} catch (Exception e) { // ������ �̿�
			System.out.println("���ܰ� �߻��߽��ϴ�. ");

			e.printStackTrace();
			// sysout �ʿ����
			// ���� ������ ���� detail�ϰ� stack�� �׾Ƶξ��ٰ� �ѹ��� ���

		} finally {
			System.out.println("���ܹ߻����ο� ������� �� ������ �����Ѵ�.");
		}

		System.out.println("*****���� ��*****");

	}

}
