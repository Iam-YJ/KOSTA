/**
	�����̸� : ������
	��¥ : 2020-07-24
	���� : Dowhile ���� 1

	3. DoWhileExam01.java�����.
	1) 1 ~ 100���� ���� ���
	2) A ~ Z���� ���� ���
	3) 1~ 100���� 10�� 10�� ���(do_while�ȿ� if���̿�)
*/

class DoWhileExam01
{
	public static void main(String [] args)
	{
		// 1) 1 ~ 100���� ���� ���
		System.out.println("Problem01 : 1 ~ 100���� ���� ��� ");
		int i = 1; //�ʱ�ȭ
		do
		{
			System.out.print(i + "\t"); //���๮��
			i += 1; // ������
		}
		while (i <= 100);
	
		
System.out.println("\n-------------------------------------------");


		// 2) A ~ Z���� ���� ���
		System.out.println("Problem02 : A ~ Z���� ���� ��� ");
		char ch = 'A'; // �ʱ�ȭ
		do
		{
			System.out.print(ch + "\t"); // ���๮��
			ch += 1; // ������  ch++;   ch=ch+1;
		}
		while (ch <= 'Z');


		System.out.println("\n-------------------------------------------");


		// 3) 1~ 100���� 10�� 10�� ���(while�ȿ� if���̿�)
		System.out.println("Problem03 : 1~ 100���� 10�� 10�� ���(do_while�ȿ� if���̿�) ");
		i = 1; // �ʱ�ȭ
		do
		{
			System.out.print(i + "\t"); 
			if (i%10 == 0) System.out.println(); // ���๮���� 1���̹Ƿ� {} ����
			i += 1; // ������
		}
		while (i <= 100);
		System.out.println("-------------------------------------------");

		int _a=10;

		byte byteValue=10;
		char charValue='A';

		//short a = charValue;

		char var3=' ';
        String str="";

		float var5=10;

	}
}
