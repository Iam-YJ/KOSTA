/**
	�����̸� : ������
	��¥ : 2020-07-24
	���� : Dowhile ���� 2

	4. DoWhileExam02.java�����.
	1) 1~ 100���� �� 10�� 10�� ��� ����(do_while�� �ȿ� do_while�� )
	2) �������� ���
	3) 2)�� �������� ������� 5�� ���� ���
*/

class DoWhileExam02
{
	public static void main(String [] args)
	{
		// 1) 1~ 100���� �� 10�� 10�� ��� ����(do_while�� �ȿ� do_while�� )
		System.out.println("1~ 100���� �� 10�� 10�� ��� ����(do_while�� �ȿ� do_while��)");
		System.out.println("---------------------------------------");
		int i = 1; //�ʱ�ȭ
		int sum = 0; 
		
		do
		{
			int j = 1; //�ʱ�ȭ
			do
			{
				System.out.print(++sum + "\t");	//���๮
				j += 1; // ������
			}
			while (j <= 10);
			
			System.out.println(); //���๮��
			i += 1; // ������
		}
		while (i <= 10);



		System.out.println("---------------------------------------");


		// 2) �������� ���
		System.out.println("\nProblem02 : �������� ���");
		System.out.println("--------------------------------------------------------------");
		i = 1; //�ʱ�ȭ 
		
		do
		{
			int j = 2;
			do
			{
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//���๮
				j += 1; // ������
			}
			while (j <= 9);

			System.out.println(); //���๮��
			i += 1; // ������
		}
		while (i <= 9);


		System.out.println("--------------------------------------------------------------");


		// 3) 2)�� �������� ������� 5�� ���� ���

		System.out.println("\nProblem03 : 2)�� �������� ������� 5�� ���� ���");
		System.out.println("------------------------------");
		
		i = 1; //�ʱ�ȭ 
		do
		{
			int j = 2;
			do
			{
				if (j==6) break;
				System.out.print(j + "*" + i + "=" + (j*i) + "\t" );	//���๮
				j += 1; // ������
			}
			while (j <= 9);

			System.out.println(); //���๮��
			i += 1; // ������
		}
		while (i <= 9);

		System.out.println("------------------------------");




	}
}
