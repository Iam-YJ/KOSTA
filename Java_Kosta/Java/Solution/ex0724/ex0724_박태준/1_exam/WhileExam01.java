/**
	�����̸� : ������
	��¥ : 2020-07-24
	���� : while ���� 1

	1. WileExam01.java�� �����.
	1) 1 ~ 100���� ���� ���
	2) A ~ Z���� ���� ���
	3) 1~ 100���� 10�� 10�� ���(while�ȿ� if���̿�)
*/

class WhileExam01
{
	public static void main(String [] args)
	{
		// 1) 1 ~ 100���� ���� ���
		System.out.println("Problem01 : 1 ~ 100���� ���� ��� ");
		int i = 1; //�ʱ�ȭ
		while (i <= 100) // ���ǽ�
		{
			System.out.print(i + "\t"); //���๮��
			i += 1; // ������
		}
		System.out.println("\n-------------------------------------------");


		// 2) A ~ Z���� ���� ���
		System.out.println("Problem02 : A ~ Z���� ���� ��� ");
		char ch = 'A'; // �ʱ�ȭ
		while (ch <= 'Z') // ���ǽ�
		{
			System.out.print(ch + "\t"); // ���๮��
			ch += 1; // ������
		}
		System.out.println("\n-------------------------------------------");


		// 3) 1~ 100���� 10�� 10�� ���(while�ȿ� if���̿�)
		System.out.println("Problem03 : 1~ 100���� 10�� 10�� ���(while�ȿ� if���̿�) ");
		i = 1; // �ʱ�ȭ
		while (i <= 100) // ���ǽ�
		{
			// ���๮��
			System.out.print(i + "\t"); 
			if (i%10 == 0) System.out.println(); // ���๮���� 1���̹Ƿ� {} ����
			i += 1; // ������
		}
		System.out.println("-------------------------------------------");

	}
}
