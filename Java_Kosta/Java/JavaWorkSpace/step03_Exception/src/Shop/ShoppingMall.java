package Shop;

public class ShoppingMall {

	private int age;

	public void ageCheck(int age) throws ExceptionExam {
		System.out.print("����\t" + age + "\t");
		if (age < 18) {
			// ���ܸ� �߻���Ų��
			ExceptionExam ee = new ExceptionExam("�ֵ��� ����");
			throw ee;
		
			//����
			// ���� �߻��ϸ� -> ExceptionExam���� ����!
			// throw new ExceptionExam("�ֵ��� ����"); - �ѹ��� ���

		} else {
			System.out.println("�����ϽŰ� ȯ���մϴ�");
		}
	}
}
