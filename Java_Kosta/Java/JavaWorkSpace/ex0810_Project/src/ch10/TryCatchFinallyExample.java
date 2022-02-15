package ch10;

public class TryCatchFinallyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�ε����� �ʰ�����");
			}
			catch (NumberFormatException e) {
				System.out.println("���ڷ� ��ȯ�� �� ����");
			} 
			finally {
				System.out.println(value);
			}
		} //i=0 // 10 
		// i =1 // ���ڷκ�ȯ�� �� ���� -> 10 
		// i =2 // �ε����� �ʰ����� -> 10

	}

}
